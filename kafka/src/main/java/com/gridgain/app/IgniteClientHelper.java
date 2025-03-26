package com.gridgain.app;

import static org.apache.ignite.cluster.ClusterState.ACTIVE;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.IgniteConfiguration;

import com.gridgain.server.AppConfiguration;

public class IgniteClientHelper implements AutoCloseable {

	public static final String SQL_SCHEMA = "PUBLIC";

	private final Ignite ignite;

	public static void main(String args[]) throws Exception {
		try (IgniteClientHelper ich = new IgniteClientHelper()) {
			System.out.println("IgniteClientHelper");
		}
	}

	public IgniteClientHelper() throws Exception {
		this(true);
	}

	public IgniteClientHelper(boolean destroyCaches) throws Exception {
		System.setProperty("IGNITE_QUIET", "true");

		IgniteConfiguration cfg = new AppConfiguration();
		cfg.setClientMode(true);

		ignite = Ignition.start(cfg);
		ignite.cluster().state(ACTIVE);
		ignite.cluster().tag("Demo Cluster");
	}
	
	public Ignite getIgnite() {
		return ignite;
	}

	@Override
	public void close() throws Exception {
		ignite.close();
	}


}
