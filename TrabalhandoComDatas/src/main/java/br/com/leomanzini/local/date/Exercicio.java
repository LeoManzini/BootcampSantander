package br.com.leomanzini.local.date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Exercicio {

	public static void main(String[] args) {
		
		// Assim tambem funciona igual abaixo
		// LocalDateTime dataEspecificada = LocalDateTime.of(2010, Month.MAY, 15, 10, 0);
		LocalDateTime dataEspecificada = LocalDateTime.parse("2010-05-15 10:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		
		LocalDateTime futuro = dataEspecificada.plusYears(4).plusMonths(6).plusHours(13);
		
		System.out.println(dataEspecificada);
		System.out.println(futuro);
	}
}
