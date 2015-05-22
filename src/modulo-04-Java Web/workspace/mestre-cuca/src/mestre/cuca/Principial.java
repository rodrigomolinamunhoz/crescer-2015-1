package mestre.cuca;

import java.util.*;

public class Principial implements LivroReceitas {
	private List<Receita> receita = new ArrayList<Receita>();

	public List<Receita> getReceita() {
		return receita;
	}

	public void setReceita(List<Receita> receita) {
		this.receita = receita;
	}

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
			throw new RuntimeException(e);
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
				if (receitaAtual.getListaIngredientes().contains(
						ingredienteAtual)) {
				} else {
					novaLista.add(receitaAtual);
				}
			}
		}
		return novaLista;
	}

	// (200 exp) Lista de compras: faça um método que receba uma lista de
	// receitas e retorne uma "lista de compras",
	// agrupando todos os ingredientes que possuem o mesmo nome e unidade de
	// medida.
	public Map<String, Double> geraListaDeCompras(List<Receita> receitas) {
		Map<String, Double> listaDeCompras = new HashMap<>();
		for (Receita receita : receitas) {
			for (Ingrediente ingrediente : receita.getListaIngredientes()) {
				String chave = ingrediente.getNomeIngrediente();
				double quantidadeAcumulada = listaDeCompras.getOrDefault(chave,
						0.0);
				double quantidadeDoIngrediente = ingrediente.getQuantidade();
				listaDeCompras.put(chave, quantidadeAcumulada
						+ quantidadeDoIngrediente);
			}
		}
		return listaDeCompras;
	}

	// 5KG FEIJAO 1KG QUEIJO E 1 COLHER_SOPA MEL
	// 1KG ARROZ 500G QUEIJO E 1 COLHER_CHA MEL
	// ---------------

	// FEIJAO_KG -> 5
	// QUEIJO_GR -> 100
	// public static void main(String[] args) {
	// Map<String, Double> populacao = new HashMap<String, Double>();
	// populacao.put("RS", 121212.0);
	// populacao.put("SC", 2323232.0);
	// populacao.put("SP", 32.0);
	//
	// // double var = populacao.get("SC");
	// // System.out.println(var);
	// // double var2 = populacao.get("RS");
	// // System.out.println(var2);
	// double var2 = populacao.getOrDefault("SP", 555.0);
	//
	// System.out.println(var2);
	// }

}
