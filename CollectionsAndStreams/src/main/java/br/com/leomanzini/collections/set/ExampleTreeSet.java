package br.com.leomanzini.collections.set;

import java.util.Iterator;
import java.util.TreeSet;

public class ExampleTreeSet {

	public static void main(String[] args) {
		
		TreeSet<String> treeCapitals = new TreeSet<>();
		
		// Mount tree with some capitals
		treeCapitals.add("Porto Alegre");
		treeCapitals.add("Florianópolis");
		treeCapitals.add("Curitiba");
		treeCapitals.add("São Paulo");
		treeCapitals.add("Rio de Janeiro");
		treeCapitals.add("Belo Horizonte");
		
		System.out.println(treeCapitals);
		
		// Returns the first capital at the tree
		System.out.println(treeCapitals.first());
		
		// Returns the last capital at the tree
		System.out.println(treeCapitals.last());
		
		// Returns the first capital bellow the specific tree element
		System.out.println(treeCapitals.lower("Florianópolis"));
		
		// Returns the last capital above the specific tree element
		System.out.println(treeCapitals.higher("Florianópolis"));
		
		// Returns the first capital at the tree top, removing from set
		System.out.println(treeCapitals.pollFirst());
		
		// Show all the tree items
		System.out.println(treeCapitals);
		
		// Returns the last capital at the tree end, removing from set
		System.out.println(treeCapitals.pollLast());
		
		// Show all the tree items
		System.out.println(treeCapitals);
		
		Iterator<String> iterator = treeCapitals.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		for(String leaf : treeCapitals) {
			System.out.println(leaf);
		}
	}
}
