package br.com.leomanzini.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class NumberArrays {

	public static void main(String[] args) {
		
		Integer[] numbers = {2, 4, 6, 8, 10};
		
		Stream.of(numbers).map(number -> number * 2).forEach(System.out::println);
		
		List<String> professions = new ArrayList<>();
		
		professions.add("Java Developer");
		professions.add("Python Developer");
		professions.add("Csharp Developer");
		professions.add("Tester");
		professions.add("Manager");
		
		professions.stream().filter(profession -> profession.endsWith("Developer")).forEach(System.out::println);
	}
}
