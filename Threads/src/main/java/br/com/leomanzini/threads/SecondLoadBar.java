package br.com.leomanzini.threads;

public class SecondLoadBar extends Thread {
	
	@Override
	public void run() {
		super.run();
	
		try {
			Thread.sleep(5000);
			System.out.println("Loaded: " + this.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
