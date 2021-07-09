package br.com.leomanzini.functional.interfaces;

public class UsingAnonymousFunction {

	public static void main(String[] args) {
		
		GenerateAbstractFunction insertSr = new GenerateAbstractFunction() {
			
			@Override
			public String generate(String value) {
				return "Sr. " + value;
			}
		};
		
		System.out.println(insertSr.generate("Leonardo"));
	}
}
