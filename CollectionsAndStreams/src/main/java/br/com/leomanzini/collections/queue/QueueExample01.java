package br.com.leomanzini.collections.queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class QueueExample01 {

	public static void main(String[] args) {
		
		Queue<String> bankQueue = new LinkedList<>();
		
		bankQueue.add("Patrícia");
		bankQueue.add("Roberto");
		bankQueue.add("Flávio");
		bankQueue.add("Pamela");
		bankQueue.add("Anderson");
		
		System.out.println(bankQueue);
		
		String clientAtended = bankQueue.poll();
		System.out.println("Next client to be atended: " + clientAtended);
		System.out.println(bankQueue);
		
		String nextClient = bankQueue.peek();
		System.out.println("Next client at the queue: " + nextClient);
		System.out.println(bankQueue);
		
		// If we doesn't have elements at this queue, it throws an exception
		// Works with loaders process and so on, where an empty queue is an error
		
		//bankQueue.clear();
		
		nextClient = bankQueue.peek();
		System.out.println(nextClient);
		
		String nextClientOrError = bankQueue.element();
		System.out.println(nextClientOrError);
		System.out.println(bankQueue);
		
		for(String client : bankQueue) {
			System.out.println("Client: " + client);
		}
		
		Iterator<String> bankQueueIterator = bankQueue.iterator();
		
		while(bankQueueIterator.hasNext()) {
			System.out.println("Next client: " + bankQueueIterator.next());
		}
		
		System.out.println("Current queue size: " + bankQueue.size());
		
		System.out.println("This queue is empty? " + bankQueue.isEmpty());
		
		bankQueue.add("Wesley");
		
		System.out.println("Wesley added to the end: " + bankQueue);
	}
}
