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
public class Customer {
	@QuerySqlField(index = true)
	private Integer customerId;
	@QuerySqlField
	private String firstName;
	@QuerySqlField
	private String lastName;
	@QuerySqlField
	private String company;
	@QuerySqlField
	private String address;
	@QuerySqlField
	private String city;
	@QuerySqlField
	private String state;
	@QuerySqlField
	private String country;
	@QuerySqlField
	private String postalCode;
	@QuerySqlField
	private String phone;
	@QuerySqlField
	private String fax;
	@QuerySqlField
	private String email;
	@QuerySqlField
	private Integer supportRepId;
}
