package br.com.leomanzini.threads;

public class LoadingBar extends Thread {

	@Override
	public void run() {
		super.run();
		System.out.println("Loading...");
	}
}
