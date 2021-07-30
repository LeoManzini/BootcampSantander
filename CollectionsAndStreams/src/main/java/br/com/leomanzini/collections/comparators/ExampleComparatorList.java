package br.com.leomanzini.collections.comparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExampleComparatorList {

	public static void main(String[] args) {
		
		List<Student> students = new ArrayList<>();
		
		students.add(new Student("Pedro", 19));
		students.add(new Student("Carlos", 23));
		students.add(new Student("Giovanna", 21));
		students.add(new Student("João", 18));
		students.add(new Student("Thiago", 20));
		students.add(new Student("George", 22));
		students.add(new Student("Larissa", 21));
		
		System.out.println("Insertion order: ");
		System.out.println(students);
		
		// Comparacao feita como na classe mas usando lambda
		students.sort((first, second) -> first.getAge() - second.getAge());
		System.out.println("Numeric natural order: ");
		System.out.println(students);
		
		students.sort((first, second) -> second.getAge() - first.getAge());
		System.out.println("Numeric reverse order: ");
		System.out.println(students);
		
		students.sort(Comparator.comparingInt(Student::getAge));
		System.out.println("Numeric natural order (method reference): ");
		System.out.println(students);
		
		students.sort(Comparator.comparingInt(Student::getAge).reversed());
		System.out.println("Numeric reverse order (method reference): ");
		System.out.println(students);
		
		Collections.sort(students);
		System.out.println("Numeric natural order (comparable interface): ");
		System.out.println(students);
		
		Collections.sort(students, new StudentOrderAgeComparator());
		System.out.println("Numeric reverse order (comparable interface): ");
		System.out.println(students);
	}
}
