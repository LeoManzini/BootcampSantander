package br.com.leomanzini.jdbc.executors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.leomanzini.jdbc.dao.StudentsUpdateDao;
import br.com.leomanzini.jdbc.dto.StudentsDto;
import br.com.leomanzini.jdbc.utils.PropertiesLoader;

public class ExecuteSelect implements Executors {

	private static final Logger LOG = LogManager.getLogger(ExecuteSelect.class);
	
	@Override
	public void execute(String propertiesPath) {
		
		PropertiesLoader.loadProperties(propertiesPath);
		//StudentsSelectDao databaseExtraction = new StudentsSelectDao();
		StudentsUpdateDao databaseExtraction = new StudentsUpdateDao();
		
		try {
			//List<StudentsDto> alunos = databaseExtraction.queryExecution(null);
			
			//alunos.stream().forEach(aluno -> LOG.info(aluno.toString()));
			StudentsDto student = new StudentsDto();
			student.setId(1);
			student.setName("Joao Pedro Manzini");
			student.setEmail("jp@manzini.com");
			
			databaseExtraction.queryExecution(student);
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error("ERROR: Unexpected error trying to execute dao class.");

			System.exit(-4);
		}
	}
}
