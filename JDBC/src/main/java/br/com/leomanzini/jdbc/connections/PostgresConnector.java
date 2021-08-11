package br.com.leomanzini.jdbc.connections;

import java.sql.Connection;

public class PostgresConnector implements DbConnector {

	private Connection connection;
	@Override
	public Connection startConnection() throws Exception {
		return connection;
	}

}
