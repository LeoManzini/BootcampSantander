package br.com.leomanzini.jdbc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.leomanzini.jdbc.executors.ExecuteSelect;
import br.com.leomanzini.jdbc.executors.Executors;

public class Application {
	
	private static final Logger LOG = LogManager.getLogger(Application.class);

	public static void main(String[] args) {
		
		String propertiesPath = (args.length > 0) ? args[0] : "src/main/resources/Application.properties";
		Executors executor = new ExecuteSelect();
		
		try {
			executor.execute(propertiesPath);
			
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("ERROR: Unexpected error executing executor class.");

			System.exit(-4);
		}
	}
}
