package mestre.cuca;

import java.util.*;

import Filmator.Ator;

public class Principial implements LivroReceitas {
	private List<Receita> receita = new ArrayList<Receita>();
	UnidadeMedida unidadeMedida;

	public void inserir(Receita receita) {
		if (receita != null && !receita.getNomeReceita().isEmpty()) {
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
			if (atual.getNomeReceita().equals(nomeReceita)) {
				return atual;
			}
		}
		throw new NullPointerException();
	}

	// (80 exp) Crie um método que recebe uma lista de receitas e retorna o
	// valor total de todas as receitas somadas
	public double somaTotasReceitas(List<Receita> listaReceita) {
		double valor = 0;
		for (Receita atual : listaReceita) {
			valor += atual.calculaValorTotalReceita();
		}
		return valor;
	}

	// (120 exp) Proteção aos alérgicos: faça um método que receba uma lista de
	// ingredientes e retorne todas as receitas que não possuem este
	// ingrediente.
	public List<Receita> protecaoAlergicos(List<Ingrediente> listaIngrediente) {
		List<Receita> novaLista = new ArrayList<Receita>();

		for (Receita receitaAtual : this.receita) {
			for (Ingrediente ingredienteAtual : listaIngrediente) {
				if (ingredienteAtual.getNomeIngrediente().contains(listaIngrediente)) {
					novaLista.add(ingredienteAtual);
				}
			}

		}
		return novaLista;
	}

}
