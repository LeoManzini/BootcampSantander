package br.com.leomanzini.threads;

public class GeneratePDF extends Thread {

	@Override
	public void run() {
		super.run();
		System.out.println("Generating PDF file...");
	}
}
