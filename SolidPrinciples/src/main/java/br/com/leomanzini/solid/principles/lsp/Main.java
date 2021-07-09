package br.com.leomanzini.solid.principles.lsp;

public class Main {
	public static void main(String[] args) {
		
		/*
		 * Liskov Substitution Principle
		 * 
		 * Derived classes must be substitutable for their base classes
		 * Classes derivadas devem ser substituiveis por suas classes base
		 * */
		
		Retangulo retangulo = new Quadrado();
		
		retangulo.setAltura(10);
		retangulo.setLargura(5);
		
		System.out.println("Area: " + retangulo.getArea());
	}
}
