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

public class StudentsSelectParametersDao {
	
	private static final Logger LOG = LogManager.getLogger(StudentsSelectParametersDao.class);
	private DbConnector connectionFactory = new PostgresConnector();
	
	private String query = " SELECT              "
			+ " student_id     AS client_number, "
			+ " student_name   AS client_name,   " 
			+ " student_email  AS client_email,  "
			+ " active         AS client_active, " 
			+ " creation_date  AS creation_date  "
			+ " FROM CLIENTE                     "
			+ " WHERE student_id = ?             ";
	
	public List<StudentsDto> queryExecution(int parameter) throws SQLException {
		List<StudentsDto> alunos = new ArrayList<>();

		try (Connection connection = connectionFactory.startConnection()) {

			// if you want to use an parameter, just put a ? at the query and the clause
			// bellow
			// according with the types
			// statement.setInt(1, clientId);
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, parameter);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				StudentsDto aluno = new StudentsDto();

				aluno.setNumber(rs.getInt("client_number"));
				aluno.setName(rs.getString("client_name"));
				aluno.setEmail(rs.getString("client_email"));
				aluno.setActive(rs.getBoolean("client_active"));
				aluno.setCreationDate(rs.getString("creation_date"));

				alunos.add(aluno);
			}

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("ERROR: Unexpected error trying to execute query.");

			System.exit(-5);
		}
		return alunos;
	}
}
