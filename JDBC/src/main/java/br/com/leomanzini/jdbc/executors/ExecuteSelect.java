package br.com.leomanzini.jdbc.executors;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.leomanzini.jdbc.dao.StudentsSelectDao;
import br.com.leomanzini.jdbc.dao.StudentsSelectParametersDao;
import br.com.leomanzini.jdbc.dto.StudentsDto;
import br.com.leomanzini.jdbc.utils.PropertiesLoader;

public class ExecuteSelect implements Executors {

	private static final Logger LOG = LogManager.getLogger(ExecuteSelect.class);
	
	@Override
	public void execute(String propertiesPath) {
		
		PropertiesLoader.loadProperties(propertiesPath);
		//StudentsSelectDao databaseExtraction = new StudentsSelectDao();
		StudentsSelectParametersDao databaseExtraction = new StudentsSelectParametersDao();
		
		try {
			List<StudentsDto> alunos = databaseExtraction.queryExecution(1);
			
			alunos.stream().forEach(aluno -> LOG.info(aluno.toString()));
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error("ERROR: Unexpected error trying to execute dao class.");

			System.exit(-4);
		}
	}
}
