package br.com.leomanzini.solid.principles.isp.problem;

public interface Ave {
	
	/*
	 * Interface Segregation Principle
	 * 
	 * Make fine grained interfaces that are client specific
	 * Faca interfaces refinadas que sao especificas do cliente
	 * 
	 * Uma classe nao deve ser forcada a implementar interfaces e metodos que nao serao utilizados
	 * 
	 * E melhor criar interfaces mais especificas ao inves de termos uma unica interface generica
	 * */
	
	void bicar();
	
	void chocarOvos();
	
	void voar();
}
