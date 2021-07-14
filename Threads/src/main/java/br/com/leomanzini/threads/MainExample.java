package br.com.leomanzini.threads;

public class MainExample {

	public static void main(String[] args) {
		
		SecondLoadBar secondLoadBar = new SecondLoadBar();
		SecondLoadBar secondLoadBar2 = new SecondLoadBar();
		
		// Executed in two different threads, independent of sleep, execute both variables
		secondLoadBar.start();
		secondLoadBar2.start();
		
		Thread loadingBar1 = new Thread (new LoadBar());
		Thread loadingBar2 = new Thread (new LoadBar());
		
		loadingBar1.start();
		loadingBar2.start();
		
		System.out.println("Thread loading bar one name: " + loadingBar1.getName());
		System.out.println("Thread loading bar two name: " + loadingBar2.getName());
	}
}
