package br.com.leomanzini.local.date;

import java.time.LocalTime;

/**
 * Exemplo de como utilizar LocalTime
 */
public class Exemplo03 {

	public static void main(String[] args) {
		
		LocalTime agora = LocalTime.now();

        System.out.println(agora);
        // 23:53:58.421
	}
}
