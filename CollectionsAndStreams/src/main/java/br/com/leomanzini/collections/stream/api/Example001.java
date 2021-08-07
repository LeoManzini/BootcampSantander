package br.com.leomanzini.collections.stream.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Example001 {

	public static void main(String[] args) {
		
		List<String> students = new ArrayList<>();
		
		students.add("Pedro");
		students.add("Thayse");
		students.add("Marcelo");
		students.add("Carla");
		students.add("Juliana");
		students.add("Thiago");
		students.add("Rafael");
		
		// Returns the element count
		System.out.println("Count: " + students.stream().count());
		
		// Returns the element with the most quantity of letters
		System.out.println("Higher letter number: " + students.stream().max(Comparator.comparingInt(String::length)));

		// Returns the element with the min quantity of letters
		System.out.println("Higher letter number: " + students.stream().min(Comparator.comparingInt(String::length)));
		
		// Returns all the elements that have the letter "R" at the name
		System.out.println("With letter r at the name: " + students.stream().filter((student) -> 
			student.toLowerCase().contains("r")).collect(Collectors.toList()));
		
		// Returns a new collection, with the names mixed  with the letter quantity of each name
		System.out.println("Returns a new collection with the quantity of letters: " + students.stream().map(student ->
				student.concat("-").concat(String.valueOf(student.length()))).collect(Collectors.toList()));
		
		// Returns just tree first elements at collection
		System.out.println("Return the tree first elements: " + students.stream().limit(3).collect(Collectors.toList()));
		
		// Show each element at console, after returns the same collection
		System.out.println("Return elements: " + students.stream().peek(System.out::println).collect(Collectors.toList()));
		
		// Show each element at console, but without return nothing
		System.out.println("Return the elements again: ");
		students.stream().forEach(System.out::println);
		
		// Return true case each element have the letter "W" at the name
		System.out.println("Have any element with W at the name? " + students.stream().allMatch((element) -> element.contains("W")));
		
		// Returns true if any element have a lower case at the name
		System.out.println("Do you have a lower case letter? " + students.stream().anyMatch((element) -> element.contains("a")));
		
		// Returns true if any no one element have a lower case at the name
		System.out.println("Do you have a lower case letter? " + students.stream().noneMatch((element) -> element.contains("a")));
		
		// Returns the first collection element
		System.out.println("Returns the first collection element: ");
		students.stream().findFirst().ifPresent(System.out::println);
		
		// Nested operation example
		System.out.println("Nested operation: ");
		System.out.println(students.stream().peek(System.out::println).map(student -> student.concat(" - ").concat(String.valueOf(student.length()))).peek(System.out::println)
				.filter((student) -> student.toLowerCase().contains("r")).collect(Collectors.toList()));
	}
}
