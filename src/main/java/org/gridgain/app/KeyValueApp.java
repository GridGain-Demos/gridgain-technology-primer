/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gridgain.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.affinity.Affinity;
import org.apache.ignite.cache.query.SqlFieldsQuery;
import org.apache.ignite.cluster.ClusterNode;
import org.gridgain.model.Artist;

/**
 * The application reads Artists from the cluster using key-value requests.
 * Complete the TODO item to see how Ignite distributes records across
 * partitions and nodes.
 */
public class KeyValueApp {

	public final static String ALBUM = "Album";
	public final static String ARTIST = "Artist";
	public final static String CUSTOMER = "Customer";
	public final static String EMPLOYEE = "Employee";
	public final static String GENRE = "Genre";
	public final static String INVOICE = "Invoice";
	public final static String INVOICELINE = "InvoiceLine";
	public final static String MEDIATYPE = "MediaType";
	public final static String PLAYLIST = "PlayList";
	public final static String PLAYLISTTRACK = "PlayListTrack";
	public final static String TRACK = "Track";

	public static void main(String[] args) throws Exception {
		System.setProperty("IGNITE_QUIET", "true");
		System.setProperty("java.net.preferIPv4Stack", "true");
		new KeyValueApp();
	}

	public KeyValueApp() throws Exception {
		AppConfiguration cfg = new AppConfiguration(true);

		try (Ignite ignite = Ignition.start(cfg)) {
			dropTables(ignite);
			createTablesSql(ignite);
			populateTablesSql(ignite);

			getArtistsDistribution(ignite);
		}
	}

	private static void getArtistsDistribution(Ignite ignite) {

		IgniteCache<Integer, Artist> artistCache = ignite.cache(ARTIST);

		for (int artistKey = 1; artistKey < 100; artistKey++) {
			Artist artist = artistCache.get(artistKey);

			/**
			 * TODO #1: print partitions and nodes every artistKey is mapped to. Hint, use
			 * ignite.affinity(...).partition(...) and .mapPartitionToNode(...) methods.
			 */
			Affinity<Object> affinity = ignite.affinity(ARTIST);
			int partition = affinity.partition(artist);
			ClusterNode node = affinity.mapPartitionToNode(partition);

			System.out.printf("%s - P#%d - Node(%s)\n", artist, partition, node.id());
		}

	}

	private void populateTablesSql(Ignite ignite) throws IOException {
		System.out.println("Loading table data via SQL script ...");

		String filePath = "sql/media_store_populate.sql";
		sqlScript(filePath, ignite);
	}

	private void createTablesSql(Ignite ignite) throws IOException {
		System.out.println("Creating tables via SQL script ...");
		String filePath = "sql/media_store_create.sql";
		sqlScript(filePath, ignite);
	}

	private static void sqlScript(String filePath, Ignite ignite) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		StringBuilder query = new StringBuilder();
		String line;

		while ((line = br.readLine()) != null) {

			if (line.trim().startsWith("-- ")) {
				continue;
			}

			query.append(line).append(" ");

			if (line.trim().endsWith(";")) {
				System.out.println(query.toString().trim());
				ignite.getOrCreateCache(ALBUM).query(new SqlFieldsQuery(query.toString().trim()));
				query = new StringBuilder();
			}
		}
		br.close();

	}

	private void dropTables(Ignite ignite) {
		String[] names = { ALBUM, "Artist", CUSTOMER, EMPLOYEE, GENRE, INVOICE, INVOICELINE, MEDIATYPE, PLAYLIST,
				PLAYLISTTRACK, TRACK };

		ignite.destroyCaches(Arrays.asList(names));
	}

}
