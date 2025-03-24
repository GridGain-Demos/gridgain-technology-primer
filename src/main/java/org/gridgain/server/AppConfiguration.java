package org.gridgain.server;

import static org.apache.ignite.configuration.DeploymentMode.CONTINUOUS;

import java.util.ArrayList;

import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.vm.TcpDiscoveryVmIpFinder;
import org.apache.ignite.spi.tracing.opencensus.OpenCensusTracingSpi;
import org.gridgain.control.agent.processor.deployment.ManagedDeploymentSpi;

public class AppConfiguration extends IgniteConfiguration {
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

	}

}
