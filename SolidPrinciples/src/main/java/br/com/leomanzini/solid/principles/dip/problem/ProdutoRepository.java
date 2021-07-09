package br.com.leomanzini.solid.principles.dip.problem;

import java.util.ArrayList;
import java.util.List;

import br.com.leomanzini.solid.principles.srp.problem.Produto;

public class ProdutoRepository {
	
	/*
	 * Dependency Inversion Principle
	 * 
	 * Depend on abstraction, not on concretions
	 * Dependa de abstracoes e nao de implementacoes
	 * 
	 * Um modulo de alto nivel nao deve depender de modulos de baixo nivel
	 * ambos devem depender da abstracao
	 * */
	
	@SuppressWarnings("unused")
	private MySqlConnection mySqlConnection;
	
	public ProdutoRepository(MySqlConnection mySqlConnection) {
		this.mySqlConnection = mySqlConnection;
	}
	
	public List<Produto> buscarProdutos() {
		// retorna a lista de produtos do banco de dados
		return new ArrayList<>();
	}
	
	public void salvarProduto(Produto produto) {
		// salva lista de produtos no banco de dados
	}
}
