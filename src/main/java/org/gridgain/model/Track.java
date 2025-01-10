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

package org.gridgain.model;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Track {

	@QuerySqlField(index = true)
	private Integer trackId;
	@QuerySqlField
	private String name;
	@QuerySqlField
	private Integer AlbumId;
	@QuerySqlField
	private Integer ArtistId;
	@QuerySqlField
	private Integer MediaTypeId;
	@QuerySqlField
	private Integer GenreId;
	@QuerySqlField
	private String Composer;
	@QuerySqlField
	private Integer Milliseconds;
	@QuerySqlField
	private Integer Bytes;
	@QuerySqlField
	private Double UnitPrice;

}
