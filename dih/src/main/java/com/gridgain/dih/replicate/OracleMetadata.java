package com.gridgain.dih.replicate;

import java.sql.Connection;

import oracle.jdbc.datasource.impl.OracleDataSource;

public class OracleMetadata extends JdbcMetadata
{

	public static final String DB_HOSTNAME = "localhost";
	public static final int DB_PORT = 1521;
	public static final String DB_DB = "FREE";
	public static final String DB_USERNAME = "system";
	public static final String DB_PASSWORD = "oracle";
	public static final String DB_SCHEMA = "CO";
	
	@Override
	public boolean throwsSqlException() {
		return true;
	}

	@Override
	public Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		OracleDataSource dataSrc = new OracleDataSource();
		dataSrc.setURL(getJdbcUrl());
		return dataSrc.getConnection(DB_USERNAME, DB_PASSWORD);

	}

	@Override
	public DB getDB() {
		return new DB(getJdbcUrl(), DB.DBType.JDBC, "OracleDialect", "OracleDataSource", "oracle.jdbc.datasource.impl"
				+ "", DB_SCHEMA, DB_USERNAME, DB_PASSWORD);
	}

	@Override
	public String getJdbcUrl() {
		String url = String.format("jdbc:oracle:thin:@%s:%d:%s", DB_HOSTNAME, DB_PORT, DB_DB);
		System.out.printf("Oracle url %s\n", url);
		return url;
	}

	@Override
	public String getMetadataForTable() {
		return "TABLE";
	}

}
