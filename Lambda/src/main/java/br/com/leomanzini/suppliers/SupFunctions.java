package br.com.leomanzini.suppliers;

import java.util.function.Supplier;

public class SupFunctions {

	public static void main(String[] args) {
		
		Supplier<Object> createObject = () -> new Object();
		
		System.out.println(createObject.get());
	}
}
