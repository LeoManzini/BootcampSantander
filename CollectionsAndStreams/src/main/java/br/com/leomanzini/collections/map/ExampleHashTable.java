package br.com.leomanzini.collections.map;

import java.util.Hashtable;
import java.util.Map.Entry;

public class ExampleHashTable {

	public static void main(String[] args) {
		
		Hashtable<String, Integer> students = new Hashtable<>();
		
		students.put("Carlos", 21);
		students.put("Mariana", 33);
		students.put("Rafaela", 18);
		students.put("Pedro", 44);
		
		System.out.println(students);
		
		students.put("Pedro", 55);
		
		System.out.println(students);
		
		students.remove("Pedro");
		
		System.out.println(students);
		
		int studentAge = students.get("Mariana");
		
		System.out.println(studentAge);
		
		System.out.println(students.size());
		
		for(Entry<String, Integer> entry : students.entrySet()) {
			System.out.println("Key: " + entry.getKey() + ", value: " + entry.getValue());
		}
		
		for(String key : students.keySet()) {
			System.out.println("Key: " + key + ", value: " + students.get(key));
		}
	}
}
