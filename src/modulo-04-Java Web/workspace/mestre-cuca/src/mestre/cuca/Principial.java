package mestre.cuca;

import java.util.*;

public class Principial implements LivroReceitas {
	private List<Receita> receita = new ArrayList<Receita>();
	UnidadeMedida unidadeMedida;

	public void inserir(Receita receita) {
		if (receita != null && !receita.getNome().isEmpty()) {
			this.receita.add(receita);
		}
	}

	public void atualizar(String nomeReceita, Receita receitaAtualizada) {
		try {
			if (nomeReceita != null && !nomeReceita.isEmpty()) {
				int indice = receita.indexOf(buscaReceitaPeloNome(nomeReceita));
				receita.set(indice, receitaAtualizada);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void excluir(String nomeReceita) {
		try {
			receita.remove(buscaReceitaPeloNome(nomeReceita));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public List<Receita> getTodasReceitas() {
		return receita;

	}

	public Receita buscaReceitaPeloNome(String nomeReceita) {
		for (Receita atual : this.receita) {
			if (atual.getNome().equals(nomeReceita)) {
				return atual;
			}
		}
		throw new NullPointerException();
	}

}
