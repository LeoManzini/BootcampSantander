package br.com.leomanzini.consumer;

import java.util.function.Consumer;

public class UsingConsumerInterface {

	public static void main(String[] args) {
		
		/*
		 * Interface Funcional Consumer
		 * 
		 * Se comporta igual a lambda que o chama, sem retorno, so executa a lambda atraves do metodo accept
		 * */
		Consumer<String> printPhrase = System.out::println;
		Consumer<String> printPhrase2 = phrase -> System.out.println(phrase);
		
		printPhrase.accept("Hello World!");
		printPhrase2.accept("Hello Gigi Queen!!");
	}
}
