package br.com.leomanzini.streams;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterNames {

	public static void main(String[] args) {
		
		String[] names = {"Giovanna", "Leonardo", "Ronaldinho"};
		
		String specificName = Stream.of(names).filter(name -> name.equals("Giovanna")).collect(Collectors.joining());
		
		Stream.of(names).forEach(name -> System.out.println(name));
		Stream.of(names).forEach(System.out::println);
		// Same as upside
		
		System.out.println(specificName);
	}
}
