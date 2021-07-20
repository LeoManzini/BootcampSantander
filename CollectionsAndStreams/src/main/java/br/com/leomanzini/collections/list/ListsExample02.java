package br.com.leomanzini.collections.list;

import java.util.List;
import java.util.Vector;

public class ListsExample02 {

	public static void main(String[] args) {
		
		List<String> sports = new Vector<>();
		
		// add four sports to the sports list
		sports.add("Football");
		sports.add("Basketball");
		sports.add("Handball");
		sports.add("Soccer");
		
		// modify the value at the vector second position
		sports.set(0, "Ping-Pong");
		
		// remove the sport at the third position
		sports.remove(2);
		
		// remove soccer from the array
		sports.remove("Soccer");
		
		// return the first sports array value
		System.out.println(sports.get(0));
		
		// navigate at sports
		for(String sport : sports) {
			System.out.println(sport);
		}
	}
}
