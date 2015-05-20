package mestre.cuca;

import java.util.*;

public class Receita {
	public String nomeReceita;
	public List<Ingrediente> listaIngredientes = new ArrayList<>();
	public List<Instrucao> listaIntrucoes = new ArrayList<>();

	public Receita(String nomeReceita) {
		this.nomeReceita = nomeReceita;
	}

	public String getNomeReceita() {
		return nomeReceita;
	}

	public void setNomeReceita(String nomeReceita) {
		this.nomeReceita = nomeReceita;
	}

	public List<Ingrediente> getListaIngredientes() {
		return listaIngredientes;
	}

	public void setListaIngredientes(List<Ingrediente> listaIngredientes) {
		this.listaIngredientes = listaIngredientes;
	}

	public List<Instrucao> getListaIntrucoes() {
		return listaIntrucoes;
	}

	public void setListaIntrucoes(List<Instrucao> listaIntrucoes) {
		this.listaIntrucoes = listaIntrucoes;
	}

	public void adicionaIngredientesReceita(Ingrediente listaIngredientes) {
		if (listaIngredientes != null
				&& !listaIngredientes.getNomeIngrediente().isEmpty()) {
			this.listaIngredientes.add(listaIngredientes);
		}
	}

	// (50 exp) Crie um método que calcula o valor total de uma
	// receita. O valor total de uma receita é igual a soma do
	// valor de todos os ingredientes da receita.
	public double calculaValorTotalReceita() {
		double valor = 0;
		for (Ingrediente atual : this.listaIngredientes) {
			valor += atual.getValor();
		}
		return valor;
	}

}
