package br.com.leomanzini.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.leomanzini.jdbc.connections.DbConnector;
import br.com.leomanzini.jdbc.connections.PostgresConnector;
import br.com.leomanzini.jdbc.dto.StudentsDto;

public class StudentsSelectDao {

	private static final Logger LOG = LogManager.getLogger(StudentsSelectDao.class);
	private DbConnector connectionFactory = new PostgresConnector();

	private String query = " SELECT             " 
			+ " student_id     AS id,           "
			+ " student_name   AS name,         " 
			+ " student_email  AS email,        "
			+ " active         AS active,       " 
			+ " creation_date  AS creation_date "
			+ " FROM students                   ";

	private String deleteQuery = " DELETE           "
							   + " FROM cliente     "
							   + " WHERE numero = ? ";

	private String updateQuery = " UPDATE                      "
							   + " cliente SET (ativo = false) "
							   + " WHERE numero = ?            ";
	
	public List<StudentsDto> queryExecution() throws SQLException {

		List<StudentsDto> alunos = new ArrayList<>();

		try (Connection connection = connectionFactory.startConnection()) {

			PreparedStatement statement = connection.prepareStatement(query);
			// Used executeQuery because this method is just a database consult
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				StudentsDto aluno = new StudentsDto();

				aluno.setNumber(rs.getInt("id"));
				aluno.setName(rs.getString("name"));
				aluno.setEmail(rs.getString("email"));
				aluno.setActive(rs.getBoolean("active"));
				aluno.setCreationDate(rs.getString("creation_date"));

				alunos.add(aluno);
			}

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("ERROR: Unexpected error trying to execute SELECT query.");

			System.exit(-3);
		}

		return alunos;
	}

	// Database delete
	public void delete(String propertiesPath) {
		try (Connection connection = connectionFactory.startConnection()) {

			PreparedStatement statement = connection.prepareStatement(deleteQuery);
			statement.setInt(1, 501);

			int rowsAffected = statement.executeUpdate();

			LOG.info("Rows affected: " + rowsAffected);

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("ERROR: Unexpected error trying to execute query.");

			System.exit(-3);
		}
	}
	
	// Updating database
	public void update(String propertiesPath, StudentsDto aluno) {
		try (Connection connection = connectionFactory.startConnection()) {

			PreparedStatement statement = connection.prepareStatement(updateQuery);
			statement.setInt(1, aluno.getNumber());

			int rowsAffected = statement.executeUpdate();

			LOG.info("Rows affected: " + rowsAffected);

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("ERROR: Unexpected error trying to execute query.");

			System.exit(-3);
		}
	}
}
