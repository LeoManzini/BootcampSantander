package br.com.leomanzini.solid.principles.srp.solution;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.leomanzini.solid.principles.srp.problem.Produto;

public class OrdemDeCompra {
	
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
}
