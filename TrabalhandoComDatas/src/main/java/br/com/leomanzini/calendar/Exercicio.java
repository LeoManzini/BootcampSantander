package br.com.leomanzini.calendar;

import java.util.Calendar;

/*
 * Pega a data de hoje como se fosse o vencimento de uma conta, o tempo para pagar essa conta vencida e de 10 dias
 * se o dia 10 for sabado ou domingo pode pagar ate segunda
 * */
public class Exercicio {

	public static void main(String[] args) {
		
		Calendar dataVencimento = Calendar.getInstance();
		
		dataVencimento.add(Calendar.DAY_OF_MONTH, 10);
		
		if(dataVencimento.get(Calendar.DAY_OF_WEEK) == 1 || dataVencimento.get(Calendar.DAY_OF_WEEK) == 7) {
			dataVencimento.set(Calendar.DAY_OF_WEEK, 2);
		}
		
		System.out.println(dataVencimento.getTime());
	}
}
