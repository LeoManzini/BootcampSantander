package br.com.leomanzini.predicate;

import java.util.function.Predicate;

public class Predicados {

	public static void main(String[] args) {
		
		Predicate<String> isVoid = text -> text.isEmpty();
		
		System.out.println(isVoid.test(""));
		System.out.println(isVoid.test("Not void"));
	}
}
