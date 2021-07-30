package br.com.leomanzini.collections.optional;

import java.util.Optional;

public class ExampleStates {

	public static void main(String[] args) {
		
		Optional<String> optionalString = Optional.of("There is a value");
		
		System.out.println("Optional value that is present");
		optionalString.ifPresentOrElse(System.out::println, () -> System.out.println("There is no present"));
		
		Optional<String> optionalNull = Optional.ofNullable(null);
		
		System.out.println("Optional null value that is not present");
		optionalNull.ifPresentOrElse(System.out::println, () -> System.out.println("null = there is no present"));
		
		Optional<String> optionalEmpty = Optional.empty();
		
		System.out.println("Optional empty value that is not present");
		optionalEmpty.ifPresentOrElse(System.out::println, () -> System.out.println("empty = there is no present"));
		
		Optional<String> optionalNullError = Optional.of(null);
		
		System.out.println("Optional null error value that is not present");
		optionalNullError.ifPresentOrElse(System.out::println, () -> System.out.println("error = there is no present"));
	}
}
