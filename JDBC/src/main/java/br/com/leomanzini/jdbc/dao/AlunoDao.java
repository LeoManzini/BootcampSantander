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
import br.com.leomanzini.jdbc.dto.AlunoDto;

public class AlunoDao implements InterfaceDao {

	private static final Logger LOG = LogManager.getLogger(AlunoDao.class);
	private DbConnector connectionFactory = new PostgresConnector();

	private String query = " SELECT                    " + " numero       AS client_number,         "
			+ " nome         AS client_name,           " + " email        AS client_email,          "
			+ " ativo        AS client_active,         " + " data_criacao AS creation_date          "
			+ " FROM CLIENTE WHERE nome LIKE 'Alzira%' ";

	private String secondQuery = " SELECT              " + " numero       AS client_number,         "
			+ " nome         AS client_name,           " + " email        AS client_email,          "
			+ " ativo        AS client_active,         " + " data_criacao AS creation_date          "
			+ " FROM CLIENTE WHERE nome = ?            ";

	private String insertQuery = " INSERT INTO                     "
			+ " cliente(numero, nome, email, ativo, data_criacao)  "
			+ " VALUES ( ? , ? , ? , ? , ? )                       ";

	// Database consult
	@Override
	public List<AlunoDto> queryExecution(String propertiesPath) throws SQLException {

		List<AlunoDto> alunos = new ArrayList<>();

		try (Connection connection = connectionFactory.startConnection(propertiesPath)) {

			PreparedStatement statement = connection.prepareStatement(query);
			// Used executeQuery because this method is just a database consult
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				AlunoDto aluno = new AlunoDto();

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

			System.exit(-3);
		}

		return alunos;
	}

	// Database consult with filter
	public List<AlunoDto> querySubstituteParameter(String propertiesPath, String parameter) throws SQLException {

		List<AlunoDto> alunos = new ArrayList<>();

		try (Connection connection = connectionFactory.startConnection(propertiesPath)) {

			// if you want to use an parameter, just put a ? at the query and the clause
			// bellow
			// according with the types
			// statement.setInt(1, clientId);
			PreparedStatement statement = connection.prepareStatement(secondQuery);
			statement.setString(1, parameter);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				AlunoDto aluno = new AlunoDto();

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

			System.exit(-3);
		}
		return alunos;
	}

	// Database insert
	public void create(String propertiesPath, AlunoDto aluno) {
		try (Connection connection = connectionFactory.startConnection(propertiesPath)) {

			PreparedStatement statement = connection.prepareStatement(insertQuery);
			statement.setInt(1, 501);
			statement.setString(2, "Giovanna Oliveira");
			statement.setString(3, "gigi_oliveira@queen.com");
			statement.setString(4, "true");
			statement.setString(5, "2021-08-11 20:41:35.516367");
			
			int rowsAffected = statement.executeUpdate();
			
			LOG.info("Rows affected: " + rowsAffected);

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("ERROR: Unexpected error trying to execute query.");

			System.exit(-3);
		}
	}
}
