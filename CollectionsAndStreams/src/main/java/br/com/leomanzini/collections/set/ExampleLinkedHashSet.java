package br.com.leomanzini.collections.set;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class ExampleLinkedHashSet {

	public static void main(String[] args) {
		
		LinkedHashSet<Integer> numericSequence = new LinkedHashSet<>();
		
		// Adding some numbers to set
		numericSequence.add(1);
		numericSequence.add(2);
		numericSequence.add(4);
		numericSequence.add(8);
		numericSequence.add(16);
		
		System.out.println(numericSequence);
		
		// Remove a number from set
		numericSequence.remove(4);
		
		System.out.println(numericSequence);
		
		// Returns the set size
		System.out.println(numericSequence.size());
		
		Iterator<Integer> iterator = numericSequence.iterator();
		
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		for(Integer number : numericSequence) {
			System.out.println(number);
		}
		
		// Return if the set is empty
		System.out.println(numericSequence.isEmpty());
	}
}
