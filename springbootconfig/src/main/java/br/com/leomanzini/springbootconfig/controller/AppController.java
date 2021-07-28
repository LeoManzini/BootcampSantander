package br.com.leomanzini.springbootconfig.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile-test")
public class AppController {
	
	@Value("${app.message}")
	private String appMessage;
	
	@Value("${ENV_DB_URL:NENHUMA}")
	private String dbEnvironmentVariable;
	
	@GetMapping
	public String getAppMessage() {
		return appMessage;
	}
	
	@GetMapping("/env-variable")
	public String genEnvironmentVariable() {
		return "Environment variable received: " + dbEnvironmentVariable;
	}
}
