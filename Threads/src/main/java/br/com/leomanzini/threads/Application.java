package br.com.leomanzini.threads;

public class Application {

	public static void main(String[] args) {
		
		PdfGenerator generate = new PdfGenerator();
		LoadBar load = new LoadBar(generate);
		
		generate.start();
		load.start();
	}
}
