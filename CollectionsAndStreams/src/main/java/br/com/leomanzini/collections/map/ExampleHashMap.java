package br.com.leomanzini.collections.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ExampleHashMap {

	public static void main(String[] args) {
		
		Map<String, Integer> fifaChampions = new HashMap<>();
		
		// Add some fifa champions to the map
		fifaChampions.put("Brasil", 5);
		fifaChampions.put("Alemanha", 4);
		fifaChampions.put("Itália", 4);
		fifaChampions.put("Uruguai", 2);
		fifaChampions.put("Argentina", 2);
		fifaChampions.put("França", 2);
		fifaChampions.put("Inglaterra", 1);
		fifaChampions.put("Espanha", 1);
		
		System.out.println(fifaChampions);
		
		// Att the brazil value
		fifaChampions.put("Brasil", 6);
		
		System.out.println(fifaChampions);
		
		// Returns data for Argentina
		System.out.println(fifaChampions.get("Argentina"));
		
		// Verify if have França at the map
		System.out.println(fifaChampions.containsKey("França"));
		
		// Remove an index called by França
		fifaChampions.remove("França");
		
		// Verify if have França at the map
		System.out.println(fifaChampions.containsKey("França"));
		
		// Verify if have an value six
		System.out.println(fifaChampions.containsValue(6));
		
		// Returns the map size
		System.out.println(fifaChampions.size());
		
		System.out.println(fifaChampions);
		
		// Run over the map
		for(Map.Entry<String, Integer> entry : fifaChampions.entrySet()) {
			System.out.println("Key: " + entry.getKey() + ", value: " + entry.getValue());
		}
		
		for(String key: fifaChampions.keySet()) {
			System.out.println(key);
		}
		
		fifaChampions.clear();
	}
}
