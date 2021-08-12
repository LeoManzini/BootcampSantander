package br.com.leomanzini.jdbc.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.leomanzini.jdbc.dto.AlunoDto;

public interface InterfaceDao {
	
	public List<AlunoDto> queryExecution() throws SQLException;
}
