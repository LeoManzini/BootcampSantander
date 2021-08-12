package br.com.leomanzini.jdbc.connections;

import java.sql.Connection;

public interface DbConnector {
	
	public Connection startConnection() throws Exception;
}
