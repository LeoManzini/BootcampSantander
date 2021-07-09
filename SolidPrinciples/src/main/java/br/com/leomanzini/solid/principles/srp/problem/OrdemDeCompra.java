package br.com.leomanzini.solid.principles.srp.problem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrdemDeCompra {
	
	/*
	 * Single Responsibility Principle
	 * 
	 * A class should have one, and only one, reason to change
	 * Uma classe deve ter um, e somente um, motivo para mudar
	 * 
	 * A classe deve possuir uma única responsabilidade dentro do software
	 * */
	
	private List<Produto> produtos = new ArrayList<>();
	
	public void adicionarProduto(Produto produto) {
		produtos.add(produto);
	}
	
	public void removerProduto(Produto produto) {
		produtos.remove(produto);
	}
	
	public BigDecimal calcularTotal() {
		return produtos.stream().map(Produto::getValor).reduce(BigDecimal.ZERO, BigDecimal::add);
	}
	
	public List<OrdemDeCompra> buscarOrdemDeCompra() {
		// retorna a lista de ordens de compra do banco de dados
		return new ArrayList<>();
	}
	
	public void salvarOrdemCompra() {
		// salva a lista de produtos na base de dados
	}
	
	public void enviarEmail(String email) {
		// envia email de ordem de compra
	}
	
	public void imprimirOrdemDeCompra () {
		// imprime a ordem de compra
	}
}
