package org.gridgain.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.ignite.IgniteServer;
import org.apache.ignite.InitParameters;

public class EmbeddedServer {

	public static final String WORK_DIR = "work";
	public static final String CONFIG_FILE = "gridgain-config.conf";
	public static final int NODES = 2;

	public static void main(String[] args) throws IOException {
		new EmbeddedServer();
	}

	public EmbeddedServer() throws IOException {
		Path workPath = FileSystems.getDefault().getPath(WORK_DIR);
		if (!workPath.toFile().isDirectory())
			Files.createDirectory(workPath);
		buildConfigs();

		ServerNode nodes[] = new ServerNode[NODES];
		String slist[] = new String[NODES];
		for (int i = 1; i <= NODES; i++) {
			nodes[i - 1] = new ServerNode(i);
			slist[i - 1] = "node" + i;
		}
		String license = getLicenseFile();
		
		InitParameters initParameters = InitParameters.builder().metaStorageNodeNames("node1", "node2").clusterName("embedded_cluster")
				.clusterConfiguration(license).build();

		nodes[0].node().initCluster(initParameters);
	}

	public class ServerNode {
		private IgniteServer node;

		public ServerNode(int id) throws IOException {
			Path workDir = FileSystems.getDefault().getPath(WORK_DIR.toString(), "/node" + id);

			Path nodeConfig = FileSystems.getDefault().getPath(workDir.toString(), CONFIG_FILE);
			node = IgniteServer.start("node" + id, nodeConfig, workDir);
		}

		public IgniteServer node() {
			return node;
		}

		public void stop() {
			node.shutdown();
		}

	}

	private void buildConfigs() throws IOException {
		for (int i = 0; i < NODES; i++) {
			File wdf = new File(WORK_DIR + "/node" + (i + 1) + "/");
			if (!wdf.exists()) {
				wdf.mkdir();
			}

			Path nodeConfig = FileSystems.getDefault().getPath(wdf.getAbsolutePath(), CONFIG_FILE);
			if (!Files.exists(nodeConfig)) {
				BufferedWriter bw = new BufferedWriter(new FileWriter(nodeConfig.toFile()));
				bw.write("ignite {\n");
				bw.write("	clientConnector {\n");
				bw.write("	    port=" + (10800 + i) + "\n");
				bw.write("	}\n");
				bw.write("	rest {\n");
				bw.write("        port=" + (10300 + i) + "\n");
				bw.write("	}\n");
				bw.write("	network {        \n");
				bw.write("		port = " + (3344 + i) + "\n");
				bw.write("		nodeFinder.netClusterNodes = [\n");
				for (int j = 0; j < NODES - 1; j++) {
					bw.write("			\"127.0.0.1:" + (3344 + j) + "\",\n");
				}
				bw.write("			\"127.0.0.1:" + (3344 + NODES - 1) + "\"\n");
				bw.write("	    ]\n");
				bw.write("	}\n");
				bw.write("}");

				bw.close();
			}
		}
	}

	public static String getLicenseFile() throws IOException {
		Path licenseFile = FileSystems.getDefault().getPath(WORK_DIR, "gridgain-license.conf");
		try (BufferedReader fr = new BufferedReader(new FileReader(licenseFile.toFile()))) {
			StringBuffer license = new StringBuffer();
			String line;
			while ((line = fr.readLine()) != null) {
				license.append(line);
			}
			return license.toString();
		}

	}
}
