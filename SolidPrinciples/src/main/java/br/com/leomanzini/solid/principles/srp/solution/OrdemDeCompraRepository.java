package br.com.leomanzini.solid.principles.srp.solution;

import java.util.ArrayList;
import java.util.List;

import br.com.leomanzini.solid.principles.srp.problem.OrdemDeCompra;

public class OrdemDeCompraRepository {
	
	public List<OrdemDeCompra> buscarOrdemDeCompra() {
		// retorna a lista de ordens de compra do banco de dados
		return new ArrayList<>();
	}
	
	public void salvarOrdemCompra() {
		// salva a lista de produtos na base de dados
	}
}
