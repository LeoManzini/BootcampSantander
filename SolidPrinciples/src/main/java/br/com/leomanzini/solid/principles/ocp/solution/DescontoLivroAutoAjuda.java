package br.com.leomanzini.solid.principles.ocp.solution;

public class DescontoLivroAutoAjuda implements DescontoLivro {

	@Override
	public double valorDesconto() {
		return 0.3;
	}
}
