package br.com.leomanzini.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.leomanzini.jdbc.connections.DbConnector;
import br.com.leomanzini.jdbc.connections.PostgresConnector;
import br.com.leomanzini.jdbc.dto.StudentsDto;

public class StudentsDeleteDao {
	
	private static final Logger LOG = LogManager.getLogger(StudentsDeleteDao.class);
	private DbConnector connectionFactory = new PostgresConnector();
	
	private String query = " DELETE     "
			   + " FROM students        "
			   + " WHERE student_id = ? ";
	
	public void queryExecution(StudentsDto student) throws SQLException {
		try (Connection connection = connectionFactory.startConnection()) {

			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, student.getId());

			int rowsAffected = statement.executeUpdate();

			LOG.info("Rows affected: " + rowsAffected);

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("ERROR: Unexpected error trying to execute query.");

			System.exit(-6);
		}
	}
}
