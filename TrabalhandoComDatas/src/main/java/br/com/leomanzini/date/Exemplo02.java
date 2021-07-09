package br.com.leomanzini.date;

import java.util.Date;

public class Exemplo02 {
	
	public static void main(String[] args) {
		
		Long currentTimeMillis = System.currentTimeMillis();
		
		System.out.println(currentTimeMillis);
		
		Date newDate = new Date(currentTimeMillis);
		
		System.out.println(newDate);
		// data mais perto da atual
	}
}
