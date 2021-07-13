package br.com.leomanzini.funcao.alta.ordem;

public class SumFunction {
	
	// Recebendo um comportamento e retornando o resultado do mesmo
	public static int executeOperation(CalculateInterface calculate, int x, int y) {
		return calculate.calculate(x, y);
	}
	
	public static void main(String[] args) {
		
		// Definindo um comportamento
		CalculateInterface sum = (x, y) -> x + y;
		
		// Chamando a funcao passando a lambda de parametro com os valores (funcao)
		System.out.println(executeOperation(sum, 5, 10));
	}
}
