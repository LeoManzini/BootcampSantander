package br.com.leomanzini.threads;

public class LoadBar extends Thread {

	private Thread pdfGenerator;

	public LoadBar() {
	}
	
	public LoadBar(Thread pdfGenerator) {
		this.pdfGenerator = pdfGenerator;
	}
	
	@Override
	public void run() {
		super.run();
		
		try {			
			while(true) {
				if(!pdfGenerator.isAlive()) {
					break;
				}
				
				System.out.println("Loading...");
				Thread.sleep(500);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
