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
	
	private String query = " SELECT             "
			+ " student_id     AS id,           "
			+ " student_name   AS name,         " 
			+ " student_email  AS email,        "
			+ " active         AS active,       " 
			+ " creation_date  AS creation_date "
			+ " FROM students                   "
			+ " WHERE student_id = ?            ";
	
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

				aluno.setId(rs.getInt("id"));
				aluno.setName(rs.getString("name"));
				aluno.setEmail(rs.getString("email"));
				aluno.setActive(rs.getBoolean("active"));
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
