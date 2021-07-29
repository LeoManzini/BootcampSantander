package br.com.leomanzini.collections.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExercises {

	public static void main(String[] args) {
		
		Set<Integer> hashSet = new HashSet<>();
		LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
		TreeSet<Integer> treeSet = new TreeSet<>();
		
		// Adding values to set's
		hashSet.add(3);
		hashSet.add(88);
		hashSet.add(20);
		hashSet.add(44);
		hashSet.add(3);
		
		linkedHashSet.add(3);
		linkedHashSet.add(88);
		linkedHashSet.add(20);
		linkedHashSet.add(44);
		linkedHashSet.add(3);
		
		treeSet.add(3);
		treeSet.add(88);
		treeSet.add(20);
		treeSet.add(44);
		treeSet.add(3);
		
		Iterator<Integer> iteratorHashSet = hashSet.iterator();
		Iterator<Integer> iteratorLinkedHashSet = linkedHashSet.iterator();
		Iterator<Integer> iteratorTreeSet = treeSet.iterator();
		
		while(iteratorHashSet.hasNext()) {
			System.out.println("HashSet: " + iteratorHashSet.next());
		}
		
		while(iteratorLinkedHashSet.hasNext()) {
			System.out.println("LinkedHashSet: " + iteratorLinkedHashSet.next());
		}
		
		while(iteratorTreeSet.hasNext()) {
			System.out.println("TreeSet: " + iteratorTreeSet.next());
		}
		
		hashSet.remove(3);
		linkedHashSet.remove(3);
		treeSet.pollFirst();
		
		System.out.println(hashSet);
		System.out.println(linkedHashSet);
		System.out.println(treeSet);
		
		hashSet.add(23);
		linkedHashSet.add(23);
		treeSet.add(23);
		
		System.out.println(hashSet);
		System.out.println(linkedHashSet);
		System.out.println(treeSet);
		
		System.out.println(hashSet.size());
		System.out.println(linkedHashSet.size());
		System.out.println(treeSet.size());
		
		System.out.println(hashSet.isEmpty());
		System.out.println(linkedHashSet.isEmpty());
		System.out.println(treeSet.isEmpty());
	}
}
