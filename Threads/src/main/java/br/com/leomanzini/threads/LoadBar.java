package br.com.leomanzini.threads;

public class LoadBar extends Thread {

	@Override
	public void run() {
		super.run();
		System.out.println("Loading...");
	}
}
