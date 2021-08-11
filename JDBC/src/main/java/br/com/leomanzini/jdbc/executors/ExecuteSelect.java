package br.com.leomanzini.jdbc.executors;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.leomanzini.jdbc.dao.AlunoDao;
import br.com.leomanzini.jdbc.dao.InterfaceDao;
import br.com.leomanzini.jdbc.dto.AlunoDto;

public class ExecuteSelect implements Executors {

	private static final Logger LOG = LogManager.getLogger(ExecuteSelect.class);
	
	@Override
	public void execute(String propertiesPath) {
		
		InterfaceDao databaseExtraction = new AlunoDao();
		
		try {
			List<AlunoDto> alunos = databaseExtraction.queryExecution(propertiesPath);
			
			for(AlunoDto aluno : alunos) {
				LOG.info(aluno.toString());
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			LOG.error("ERROR: Unexpected error trying to execute dao class.");

			System.exit(-4);
		}
	}
}
