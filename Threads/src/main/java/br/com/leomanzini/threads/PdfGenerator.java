package br.com.leomanzini.threads;

public class PdfGenerator extends Thread {

	@Override
	public void run() {
		super.run();
		
		System.out.println("Starting PDF generation...");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("PDF file generated...");
	}
}
