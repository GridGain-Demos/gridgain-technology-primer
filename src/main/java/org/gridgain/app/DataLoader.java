package org.gridgain.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.apache.ignite.client.IgniteClient;

public class DataLoader {
	
	public static void main(String args[]) throws IOException {
		new DataLoader();
	}
	
	public DataLoader() throws IOException {
		try (IgniteClient client = IgniteClient.builder()
				  .addresses("127.0.0.1:10800")
				  .build()) {
		createTables(client);
		populateTables(client);
		}
	}
	
	public static void createTables(IgniteClient client) throws IOException {
		System.out.println("Creating tables via SQL script ...");
		String filePath = "sql/media_store_create.sql";
		sqlScript(filePath, client);
	}
	public static void populateTables(IgniteClient client) throws IOException {
		System.out.println("Loading table data via SQL script ...");

		String filePath = "sql/media_store_populate.sql";
		sqlScript(filePath, client);
	}


	private static void sqlScript(String filePath, IgniteClient client) throws IOException {
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
				client.sql().execute(null, query.toString().trim());
			}
		}
		br.close();
		
	}
	
}
