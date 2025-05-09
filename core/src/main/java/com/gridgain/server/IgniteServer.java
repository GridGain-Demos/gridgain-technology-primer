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
package com.gridgain.server;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteException;
import org.apache.ignite.Ignition;
import org.apache.ignite.lifecycle.LifecycleAware;

public class IgniteServer implements LifecycleAware {

	private static Ignite ignite;

	public static void main(String[] args) {
		System.setProperty("IGNITE_QUIET", "true");
		System.setProperty("java.net.preferIPv4Stack", "true");
		new IgniteServer().start();
	}

	@Override
	public void start() throws IgniteException {
		try {
			AppConfiguration cfg = new AppConfiguration();
			ignite = Ignition.start(cfg);
		} catch (Exception e) {
			throw new IgniteException(e);
		}
	}

	@Override
	public void stop() throws IgniteException {
		ignite.close();
	}
}
