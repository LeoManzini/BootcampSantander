package br.com.leomanzini.solid.principles.ocp.solution;

public class DescontoLivroAcao implements DescontoLivro {

	@Override
	public double valorDesconto() {
		return 0.2;
	}
}
