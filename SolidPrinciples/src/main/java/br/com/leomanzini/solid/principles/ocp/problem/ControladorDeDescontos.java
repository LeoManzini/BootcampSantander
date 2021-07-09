package br.com.leomanzini.solid.principles.ocp.problem;

public class ControladorDeDescontos {
	
	/*
	 * Open-Closed Principle
	 * 
	 * You should be able to extend a class behavior, without modifying it
	 * Voce deve poder estender um comportamento de classe, sem modifica lo
	 * 
	 * Objetos devem estar abertos a extensao, mas fechados para modificacao
	 * 
	 * Quando novos comportamentos precisam ser adicionados no software, 
	 * devemos estender e nao alterar o codigo fonte original
	 *
	 * */
	
	public void adicionaDescontoLivroinfantil(DescontoLivroInfantil descontoLivroInfantil) {
		descontoLivroInfantil.valorDescontoLivroInfantil();
	}
	
	public void adicionaDescontoLivroAutoAjuda(DescontoLivroAutoAjuda descontoLivroAutoAjuda) {
		descontoLivroAutoAjuda.valorDescontoLivroAutoAjuda();
	}
	
	// Se tiver que adicionar um novo desconto de livro temos que mexer na classe e adicionar um novo metodo
	public void adicionaDescontoLivroAcao(DescontoLivroAcao descontoLivroAcao) {
		descontoLivroAcao.valorDescontoLivroAcao();
	}
}
