package com.gridgain.model;

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
public class Invoice {
	@QuerySqlField
	private Integer invoiceId;
	@QuerySqlField
	private Integer customerId;
	@QuerySqlField
	private Date invoiceDate;
	@QuerySqlField
	private String billingAddress;
	@QuerySqlField
	private String billingCity;
	@QuerySqlField
	private String billingState;
	@QuerySqlField
	private String billingCountry;
	@QuerySqlField
	private String billingPostalCode;
	@QuerySqlField
	private Double total;

}
