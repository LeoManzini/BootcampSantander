package br.com.leomanzini.functional.interfaces;

public class UsingLambda {

	public static void main(String[] args) {
		
		GenerateAbstractFunction insertSr = value -> "Sr. " + value;
		
		System.out.println(insertSr.generate("Leonardo"));
	}
}
