package br.com.leomanzini.threads;

public class LoadingBar implements Runnable {

	@Override
	public void run() {
		System.out.println("Loading...");
	}
}
