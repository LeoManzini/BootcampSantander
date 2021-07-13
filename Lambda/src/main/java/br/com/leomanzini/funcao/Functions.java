package br.com.leomanzini.funcao;

import java.util.function.Function;

public class Functions {

	public static void main(String[] args) {
		
		Function<String, String> inverterNome = text -> new StringBuilder(text).reverse().toString();
		
		Function <String, Integer> converteString = text -> Integer.valueOf(text);
		
		System.out.println(inverterNome.apply("Giovanna"));
		System.out.println(converteString.apply("281219"));
	}
}
