package br.com.leomanzini.pure.functions;

import java.util.function.BiPredicate;

public class BiPredicateUse {

	public static void main(String[] args) {
		
		BiPredicate<Integer, Integer> higherValue = (parameter, compareValue) -> parameter > compareValue;
		
		System.out.println(higherValue.test(10, 11));
		System.out.println(higherValue.test(13, 12));
	}
}
