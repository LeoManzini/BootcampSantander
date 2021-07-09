package br.com.leomanzini.sample.multiplication;

import java.util.Scanner;
import java.util.function.UnaryOperator;

public class MultiplicationTablesLambda {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter with a number to the multiplication tables: ");
		int numberChoice = sc.nextInt();
		
		UnaryOperator<Integer> timeTables = value -> value * numberChoice;
		
		for(int i = 1; i <= 10; i++) {
			System.out.printf("%d x %d = %d\n", numberChoice, i, timeTables.apply(i));
		}
		
		sc.close();
	}
}
