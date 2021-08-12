package br.com.leomanzini.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.leomanzini.jdbc.connections.DbConnector;
import br.com.leomanzini.jdbc.connections.PostgresConnector;
import br.com.leomanzini.jdbc.dto.StudentsDto;

public class StudentsInsertDao {
	
	private static final Logger LOG = LogManager.getLogger(StudentsInsertDao.class);
	private DbConnector connectionFactory = new PostgresConnector();
	
	private String query = " INSERT INTO               "
			+ " students(student_name, student_email)  "
			+ " VALUES ( ? , ? )                       ";
	
	public void queryExecution(StudentsDto student) throws SQLException {
		try (Connection connection = connectionFactory.startConnection()) {

			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, "Giovanna Oliveira");
			statement.setString(2, "gigi_oliveira@queen.com");

			int rowsAffected = statement.executeUpdate();

			LOG.info("Rows affected: " + rowsAffected);

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("ERROR: Unexpected error trying to execute query.");

			System.exit(-6);
		}
	}
}
