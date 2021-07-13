package br.com.leomanzini.funcao.alta.ordem;

public class SumFunction {
	
	// Recebendo um comportamento e retornando o resultado do mesmo
	public static int executeOperation(CalculateInterface calculate, int x, int y) {
		return calculate.calculate(x, y);
	}
	
	public static void main(String[] args) {
		
		// Definindo um comportamento
		CalculateInterface sum = (x, y) -> x + y;
		CalculateInterface subtraction = (x, y) -> x - y;
		CalculateInterface multiplication = (x, y) -> x * y;
		CalculateInterface division = (x, y) -> x / y;
		
		/*
		 * A funcao aceita o tipo da interface, possibilitando passar todas as lambdas,
		 * a lambda passada como parametro determina o comportamento do retorno 
		 * */
		System.out.println(executeOperation(sum, 5, 10));
		System.out.println(executeOperation(subtraction, 15, 10));
		System.out.println(executeOperation(multiplication, 5, 10));
		System.out.println(executeOperation(division, 50, 10));
	}
}
