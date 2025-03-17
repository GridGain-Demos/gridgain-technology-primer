package org.gridgain.server;

import static org.apache.ignite.configuration.DeploymentMode.CONTINUOUS;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.plugin.PluginConfiguration;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.vm.TcpDiscoveryVmIpFinder;
import org.apache.ignite.spi.tracing.opencensus.OpenCensusTracingSpi;
import org.gridgain.control.agent.processor.deployment.ManagedDeploymentSpi;

public class AppConfiguration extends IgniteConfiguration {

	public static final String LICENSE_URL = "gridgain-license.xml";

	public AppConfiguration() throws Exception {
		this(false);
	}

	public AppConfiguration(boolean isClient) throws Exception {
		System.setProperty("java.net.preferIPv4Stack", "true");
		setClientMode(isClient);

		setWorkDirectory("/tmp/ignitework");
		setPeerClassLoadingEnabled(true);
		setDeploymentMode(CONTINUOUS);

		TcpDiscoverySpi tcpDiscoverySpi = new TcpDiscoverySpi();
		TcpDiscoveryVmIpFinder tcpDiscoveryVmIpFinder = new TcpDiscoveryVmIpFinder();
		ArrayList<String> list = new ArrayList<String>();
		list.add("127.0.0.1:47500..47510");

		tcpDiscoveryVmIpFinder.setAddresses(list);
		tcpDiscoverySpi.setIpFinder(tcpDiscoveryVmIpFinder);
		setDiscoverySpi(tcpDiscoverySpi);

		setDeploymentSpi(new ManagedDeploymentSpi());

		setTracingSpi(new OpenCensusTracingSpi());

		// Add license file for EE or UE
		try {
			Class<?> ggCfgClass = Class.forName("org.gridgain.grid.configuration.GridGainConfiguration");
			System.out.printf("Adding GridGain licese file [%s]\n", LICENSE_URL);
			Constructor<?> constructor = ggCfgClass.getDeclaredConstructor();
			Object ggCfg = constructor.newInstance();

			Method method = ggCfg.getClass().getDeclaredMethod("setLicenseUrl", String.class);
			method.invoke(ggCfg, "file://" + LICENSE_URL);

			PluginConfiguration[] pc = new PluginConfiguration[1];
			pc[0] = (PluginConfiguration) ggCfg;

			setPluginConfigurations(pc);
		} catch (ClassNotFoundException e) {
			System.out.printf("Using GridGain Community Edition\n");
		}
	}

}
