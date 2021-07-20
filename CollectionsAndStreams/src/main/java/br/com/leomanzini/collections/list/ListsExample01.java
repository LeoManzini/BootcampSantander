package br.com.leomanzini.collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListsExample01 {

	public static void main(String[] args) {

		List<String> names = new ArrayList<>();

		names.add("Giovanna");
		names.add("Henrique");
		names.add("Manzini");
		names.add("Maria");
		names.add("João");

		names.set(1, "Leonardo");
		System.out.println("Printing ArrayList: " + names);

		// Order your list
		Collections.sort(names);

		names.set(2, "Henrique");
		System.out.println("Printing ordered ArrayList: " + names);

		names.remove(1);
		System.out.println("Printing after remove by index: " + names);

		names.remove("Maria");
		System.out.println("Printing after remove by object: " + names);
		
		String name = names.get(0);
		System.out.println("Getting name from names list: " + name);
		
		for(String namesLine : names) {
			System.out.println("Name: " + namesLine);
		}
		
		Iterator<String> iterator = names.iterator();
		
		while(iterator.hasNext()) {
			System.out.println("Element value: " + iterator.next());
		}
		
		int size = names.size();
		System.out.println("Names list size: " + size);
		
		System.out.println("There is a Giovanna at this list? " + names.contains("Giovanna"));
		System.out.println("Where is Giovanna? " + names.indexOf("Giovanna"));
		
		System.out.println("There is a Roberval at this list? " + names.contains("Roberval"));
				
		System.out.println("This list is empty? " + names.isEmpty());
		
		names.clear();
		System.out.println("And now, is this empty? " + names.isEmpty());
	}
}
