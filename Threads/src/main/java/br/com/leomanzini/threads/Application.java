package br.com.leomanzini.threads;

public class Application {

	public static void main(String[] args) {
		
		SecondLoadingBar secondLoadBar = new SecondLoadingBar();
		SecondLoadingBar secondLoadBar2 = new SecondLoadingBar();
		
		// Executed in two different threads, independent of sleep, execute both variables
		secondLoadBar.start();
		secondLoadBar2.start();
		
		Thread loadingBar1 = new Thread (new LoadingBar());
		Thread loadingBar2 = new Thread (new LoadingBar());
		
		loadingBar1.start();
		loadingBar2.start();
		
		System.out.println("Thread loading bar one name: " + loadingBar1.getName());
		System.out.println("Thread loading bar two name: " + loadingBar2.getName());
	}
}
