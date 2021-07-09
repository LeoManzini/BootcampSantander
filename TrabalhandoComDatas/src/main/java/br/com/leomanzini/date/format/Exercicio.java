package br.com.leomanzini.date.format;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Exercicio {

	public static void main(String[] args) {
		
		SimpleDateFormat dateMask = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date dataHoje = new Date();
		
		System.out.println(dateMask.format(dataHoje));
	}
}
