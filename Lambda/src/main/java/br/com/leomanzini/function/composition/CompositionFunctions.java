package br.com.leomanzini.function.composition;

import java.util.Arrays;

public class CompositionFunctions {

	public static void main(String[] args) {
		
		int[] values = {0, 1, 2, 3, 4};
		
		// Functional
		Arrays.stream(values)
			  .filter(number -> number % 2 == 0)
			  .map(number -> number * 2)
			  .filter(number -> number != 0)
			  .forEach(number -> System.out.println(number));
		
		// Imperatives
		for(int i = 0; i < values.length; i++) {
			int value = 0;
			
			if(values[i] % 2 == 0) {
				value = values[i] * 2;
				
				if(value != 0) {
					System.out.println(value);
				}
			}
		}
	}
}
