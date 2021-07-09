package br.com.leomanzini.solid.principles.ocp.solution;

public class DescontoLivroInfantil implements DescontoLivro {

	@Override
	public double valorDesconto() {
		return 0.5;
	}
}
