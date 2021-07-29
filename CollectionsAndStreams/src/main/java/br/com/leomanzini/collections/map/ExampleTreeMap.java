package br.com.leomanzini.collections.map;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class ExampleTreeMap {

	public static void main(String[] args) {
		
		TreeMap<String, String> treeCapitals = new TreeMap<>();
		
		// Mount a tree with the capitals
		treeCapitals.put("RS", "Porto Alegre");
		treeCapitals.put("SC", "Florianópolis");
		treeCapitals.put("PR", "Curitiba");
		treeCapitals.put("SP", "São Paulo");
		treeCapitals.put("RJ", "Rio de Janeiro");
		treeCapitals.put("MG", "Belo Horizonte");
		
		System.out.println(treeCapitals);
		
		// Returns the first capital at the tree top
		System.out.println(treeCapitals.firstKey());
		
		// Returns the last capital at the tree top
		System.out.println(treeCapitals.lastKey());
		
		// Returns the first capital bellow at tree from the parametrized capital
		System.out.println(treeCapitals.lowerKey("SC"));
		
		System.out.println(treeCapitals.higherKey("SC"));
		
		System.out.println("Key: " + treeCapitals.firstEntry().getKey() + ", value: " + treeCapitals.firstEntry().getValue());
		
		System.out.println("Key: " + treeCapitals.lastEntry().getKey() + ", value: " + treeCapitals.lastEntry().getValue());
		
		System.out.println("Key: " + treeCapitals.lowerEntry("SC").getKey() + ", value: " + treeCapitals.lowerEntry("SC").getValue());
		
		System.out.println("Key: " + treeCapitals.higherEntry("SC").getKey() + ", value: " + treeCapitals.higherEntry("SC").getValue());
		
		// Remove the first and last entry
		Map.Entry<String, String> firstEntry = treeCapitals.pollFirstEntry();
		Map.Entry<String, String> lastEntry = treeCapitals.pollLastEntry();
		
		System.out.println(firstEntry);
		
		System.out.println(lastEntry);
		
		// Navigate at all the tree keys
		Iterator<String> iterator = treeCapitals.keySet().iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		for(String capital : treeCapitals.keySet()) {
			System.out.println("Capital: " + capital + ", state: " + treeCapitals.get(capital));
		}
		
		for(Map.Entry<String, String> capital : treeCapitals.entrySet()) {
			System.out.println("Capital: " + capital.getKey() + ", state: " + capital.getValue());
		}
	}
}
