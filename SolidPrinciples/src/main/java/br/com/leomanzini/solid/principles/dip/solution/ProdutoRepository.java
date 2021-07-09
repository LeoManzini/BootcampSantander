package br.com.leomanzini.solid.principles.dip.solution;

import java.util.ArrayList;
import java.util.List;

import br.com.leomanzini.solid.principles.srp.problem.Produto;

public class ProdutoRepository {
	
	@SuppressWarnings("unused")
	private DbConnection dbConnection;
	
	public ProdutoRepository(DbConnection dbConnection) {
		this.dbConnection = dbConnection;
	}
	
	public List<Produto> buscarProdutos() {
		// retorna a lista de produtos do banco de dados
		return new ArrayList<>();
	}
	
	public void salvarProduto(Produto produto) {
		// salva lista de produtos no banco de dados
	}
}
