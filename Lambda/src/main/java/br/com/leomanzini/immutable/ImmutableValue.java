package br.com.leomanzini.immutable;

import java.util.function.UnaryOperator;

public class ImmutableValue {

	public static void main(String[] args) {
		
		int values = 20;
		
		UnaryOperator<Integer> multiply = value -> value * 2;
		
		System.out.println(multiply.apply(values));
		System.out.println(values);
		// Value is a immutable value used inside of lambda
	}
}
