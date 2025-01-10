package org.gridgain.model;

import java.sql.Date;

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
public class Employee {

	@QuerySqlField
	private Integer employeeId;
	@QuerySqlField
	private String lastName;
	@QuerySqlField
	private String firstName;
	@QuerySqlField
	private String title;
	@QuerySqlField
	private Integer reportsTo;
	@QuerySqlField
	private Date birthDate;
	@QuerySqlField
	private Date hireDate;
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

}
