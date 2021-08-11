package br.com.leomanzini.jdbc.utils;

import java.io.FileInputStream;
import java.util.Properties;

public abstract class PropertiesLoader {
	
	private static final String DB_URL_DRIVER = "jdbc.base.driver";
	private static final String DB_URL_ADRESS = "jdbc.base.adress";
	private static final String DB_URL_PORT = "jdbc.base.port";
	private static final String DB_URL_NAME = "jdbc.base.name";
	
	private static final String DB_USER = "jdbc.user.name";
	private static final String DB_PASSWORD = "jdbc.user.password";
	
	private static String dbUrlDriver;
	private static String dbUrlAdress;
	private static String dbUrlPort;
	private static String dbUrlName;
	public static StringBuilder dbUrl;
	public static String dbUser;
	public static String dbPassword;
	
	public static void loadProperties(String propertiesPath) {
		
		Properties props = new Properties();
		
		try {
			props.load(new FileInputStream(propertiesPath));
			
			dbUrlDriver = props.getProperty(DB_URL_DRIVER);
			dbUrlAdress = props.getProperty(DB_URL_ADRESS);
			dbUrlPort = props.getProperty(DB_URL_PORT);
			dbUrlName = props.getProperty(DB_URL_NAME);
			
			dbUrl = new StringBuilder("jdbc:")
					.append(dbUrlDriver).append("://")
					.append(dbUrlAdress).append(":").append(dbUrlPort).append("/")
					.append(dbUrlName);
			
			dbUser = props.getProperty(DB_USER);
			dbPassword = props.getProperty(DB_PASSWORD);
			
		} catch (Exception e) {
			
		}
	}
}
