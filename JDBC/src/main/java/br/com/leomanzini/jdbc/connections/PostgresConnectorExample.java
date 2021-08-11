package br.com.leomanzini.jdbc.connections;

import java.sql.Connection;
import java.sql.DriverManager;

public class PostgresConnectorExample {

	public static void main(String[] args) {
		
		// Step one: download connection jdbc driver for your connection

		/* Step two: mount connection url jdbc:postgresql://127.0.0.1:5432/postgres
		 * jdbc: Connection protocol
		 * postgresql: Connection driver
		 * 127.0.0.1: Host / Adress name
		 * 5432: Port where my database is running
		 * postgres: Database name (Where I want to connect)
		 */
		//String urlConnection = "jdbc:postgresql://127.0.0.1:5432/postgres";
		
		// Step tree: Configure username and password to access the database
		// PS: Not safety use the password hardcoded or via properties, use the same as a hash code
		//String user = "postgres";
		//String password = "281219";
		//Connection connection = null;
		
		// Try with resources, since Java 7, opens the object connection just at the try scope, 
		// dont need to worry with close connection and nothing else more
		//try (Connection connection = DriverManager.getConnection(urlConnection, user, password)) {
		//	System.out.println("Connected with success to PostgreSQL.");
		//} catch (Exception e) {
		//	System.out.println("Could not connect to PostgreSQL.");
		//} 
		
		/*
		// Conventional form
		try {
			// Step four: DriveManager returns the connection to the database, using the url and the credentials
			connection = DriverManager.getConnection(urlConnection, user, password);
			System.out.println("Connected with success to PostgreSQL.");

		} catch (Exception e) {
			System.out.println("Could not connect to PostgreSQL.");
		} 
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		*/
		
		// Using in production (can catch the properties at properties file too)
		// Definning connection parameters
		String driver = "postgresql";
		String databaseAdress = "127.0.0.1";
		String databasePort = "5432";
		String databaseName = "postgres";
		String user = "postgres";
		String password = "281219";
		
		// Mounting databaseUrl
		StringBuilder databaseStringUrl = new StringBuilder("jdbc:")
				.append(driver).append("://")
				.append(databaseAdress).append(":").append(databasePort).append("/")
				.append(databaseName);
		
		System.out.println("Database url: " + databaseStringUrl.toString());
		System.out.println("Database user: " + user);
		System.out.println("Database password: " + password);
		
		try (Connection connection = DriverManager.getConnection(databaseStringUrl.toString(), user, password)) {
			System.out.println("Connected with success to PostgreSQL.");
		} catch (Exception e) {
			System.out.println("Could not connect to PostgreSQL.");
		}
	}
}
