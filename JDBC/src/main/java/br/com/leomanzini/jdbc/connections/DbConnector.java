package br.com.leomanzini.jdbc.connections;

import java.sql.Connection;

public interface DbConnector {
	
	public Connection startConnection(String propertiesPath) throws Exception;
}
