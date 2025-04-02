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
package com.gridgain.model;

import java.util.Objects;

import org.apache.ignite.cache.affinity.AffinityKeyMapped;

public class AlbumKey {

	@AffinityKeyMapped
	private Integer ARTISTID;
	private Integer albumId;

	public AlbumKey(Integer albumId, Integer ARTISTID) {
		this.albumId = albumId;
		this.ARTISTID = ARTISTID;
	}

	public Integer getArtistId() {
		return ARTISTID;
	}

	public Integer getAlbumId() {
		return albumId;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlbumKey other = (AlbumKey) obj;
		return Objects.equals(albumId, other.albumId) && Objects.equals(ARTISTID, other.ARTISTID);
	}

	@Override
	public int hashCode() {
		return Objects.hash(albumId, ARTISTID);
	}
}
