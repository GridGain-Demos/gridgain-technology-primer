package com.gridgain.app;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.internal.inject.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

import com.gridgain.kafka.KafkaCacheHelper;

public class ApiServer {

	// Base URI the Grizzly HTTP server will listen on
	public static final String BASE_URI = "http://localhost:8080/";

	public static HttpServer startServer() {
		// create a resource config that scans for JAX-RS resources and providers
		final ResourceConfig rc = new ResourceConfig().packages("com.gridgain.kafka.rest");
		rc.register(new IgniteBinder());

		return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
	}

	public static void main(String[] args) throws IOException {
		System.setProperty("IGNITE_QUIET", "true");
		System.setProperty("java.net.preferIPv4Stack", "true");

		startServer();
		System.out.println(String
				.format("Jersey app started with endpoints available at " + "%s%nHit Ctrl-C to stop it...", BASE_URI));
		System.in.read();
	}

	public static class IgniteBinder extends AbstractBinder {

		@Override
		protected void configure() {
			try {
				IgniteClientHelper igniteClientHelper = new IgniteClientHelper(false);
				bind(igniteClientHelper).to(IgniteClientHelper.class);
				bind(new KafkaCacheHelper(igniteClientHelper.getIgnite(), false)).to(KafkaCacheHelper.class);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}

