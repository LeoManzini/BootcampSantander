package br.com.leomanzini.functional.interfaces;

public class UsingLambda {

	public static void main(String[] args) {
		
		// One line logical lambda does not use {} and the returns clause is implicit
		GenerateAbstractFunction insertSr = value -> "Sr. " + value;
		
		System.out.println(insertSr.generate("Leonardo"));
		
		// More than just one line, use {}; to delimit the scope, and have that specify the return clause
		GenerateAbstractFunction insertSrAndDot = value -> {
			String valueSr = "Sr. " + value;
			String valueSrAndDot = valueSr + ".";
			return valueSrAndDot;
		};
		
		System.out.println(insertSrAndDot.generate("Leonardo"));
	}
}
