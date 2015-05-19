package mestre.cuca;

import java.util.*;

public class Receita {
	private String nomeReceita;
	private List<Ingrediente> listaIngredientes = new ArrayList<>();
	private List<Instrucao> listaIntrucoes = new ArrayList<>();

	public Receita() {
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

}
