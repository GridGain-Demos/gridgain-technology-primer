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

import static org.gridgain.app.DataLoader.ARTIST;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.affinity.Affinity;
import org.apache.ignite.cluster.ClusterNode;
import org.gridgain.model.Artist;

public class KeyValueApp {

	public static void main(String[] args) throws Exception {
		System.setProperty("IGNITE_QUIET", "true");
		System.setProperty("java.net.preferIPv4Stack", "true");
		new KeyValueApp();
	}

	public KeyValueApp() throws Exception {
		AppConfiguration cfg = new AppConfiguration(true);

		try (Ignite ignite = Ignition.start(cfg)) {
			DataLoader.dropTables(ignite);
			DataLoader.createTables(ignite);
			DataLoader.populateTables(ignite);
			IgniteCache<Integer, Artist> artistCache = ignite.cache(ARTIST);
			artistCache.enableStatistics(true);

			getArtistsDistribution(ignite);
		}
	}

	private static void getArtistsDistribution(Ignite ignite) {

		IgniteCache<Integer, Artist> artistCache = ignite.cache(ARTIST);
		//CacheMetrics cm = artistCache.metrics();

		for (int artistKey = 1; artistKey < 100; artistKey++) {
			Artist artist = artistCache.get(artistKey);
			Affinity<Object> affinity = ignite.affinity(ARTIST);
			int partition = affinity.partition(artist);
			ClusterNode node = affinity.mapPartitionToNode(partition);

			System.out.printf("%s - P#%d - Node(%s)\n", artist, partition, node.id());
		}
	}

}
