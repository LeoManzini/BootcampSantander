package br.com.leomanzini.date;

import java.util.Date;

public class Exercicio {
	
	public static void main(String[] args) {
		
		Long bornTimeMillis = 945741600000L;
		Long quinzeMaio = 1273892400000L;
		
		Date minhaDataNascimento = new Date(bornTimeMillis);
		Date quinzeDeMaio = new Date(quinzeMaio);
		
		System.out.println(minhaDataNascimento.after(quinzeDeMaio));
		System.out.println(minhaDataNascimento.before(quinzeDeMaio));
	}
}
