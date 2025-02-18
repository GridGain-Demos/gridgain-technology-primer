package org.gridgain.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import org.apache.ignite.Ignite;
import org.apache.ignite.cache.query.SqlFieldsQuery;

public class DataLoader {
	
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

	public DataLoader(Ignite ignite) throws IOException {
		dropTables(ignite);
		createTables(ignite);
		populateTables(ignite);
	}
	
	public static void createTables(Ignite ignite) throws IOException {
		System.out.println("Creating tables via SQL script ...");
		String filePath = "sql/media_store_create.sql";
		sqlScript(filePath, ignite);
	}
	public static void populateTables(Ignite ignite) throws IOException {
		System.out.println("Loading table data via SQL script ...");

		String filePath = "sql/media_store_populate.sql";
		sqlScript(filePath, ignite);
	}

	public static void dropTables(Ignite ignite) {
		String[] names = { ALBUM, ARTIST, CUSTOMER, EMPLOYEE, GENRE, INVOICE, INVOICELINE, MEDIATYPE, PLAYLIST,
				PLAYLISTTRACK, TRACK };
		
		ignite.destroyCaches(Arrays.asList(names));
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
				//System.out.println(query.toString().trim());
				ignite.getOrCreateCache(ALBUM).query(new SqlFieldsQuery(query.toString().trim()));
				query = new StringBuilder();
			}
		}
		br.close();
		
	}
	
}
