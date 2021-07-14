package br.com.leomanzini.threads.house.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {

	private static final ExecutorService threadPool = Executors.newFixedThreadPool(3);
	
	public static void main(String[] args) {
		
		House house = new House(new Bedroom());
		house.obtainHouseTodo().forEach(activity -> threadPool.execute(() -> activity.realize()));
		
		threadPool.shutdown();
	}
}
