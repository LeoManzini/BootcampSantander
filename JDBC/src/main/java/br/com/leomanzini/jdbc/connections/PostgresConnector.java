package br.com.leomanzini.jdbc.connections;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.leomanzini.jdbc.utils.PropertiesLoader;

public class PostgresConnector implements DbConnector {

	private static final Logger LOG = LogManager.getLogger(PostgresConnector.class);

	private Connection connection;

	@Override
	public Connection startConnection(String propertiesPath) throws Exception {

		PropertiesLoader.loadProperties(propertiesPath);

		try {

			this.connection = DriverManager.getConnection(PropertiesLoader.getDbUrl().toString(),
					PropertiesLoader.getDbUser(), PropertiesLoader.getDbPassword());
			LOG.info("Connection completed with sucess.");

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("ERROR: Unexpected error trying connect to database.");

			System.exit(-2);
		}
		return connection;
	}
}
