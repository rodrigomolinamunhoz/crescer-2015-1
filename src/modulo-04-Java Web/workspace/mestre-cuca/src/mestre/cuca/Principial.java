package mestre.cuca;

import java.util.*;



public class Principial implements LivroReceitas {
	private List<Receita> receita = new ArrayList<Receita>();
	UnidadeMedida unidadeMedida;

	
	
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
		int flag = 0;
		for (Receita receitaAtual : this.receita) {
			for (Ingrediente ingredienteAtual : listaIngrediente) {
				if (receitaAtual.getListaIngredientes().contains(
						ingredienteAtual)) {
					flag++;
				} else {
					novaLista.add(receitaAtual);
				}
				flag = 0;
			}
		}
		return novaLista;
	}
	
	//(200 exp) Lista de compras: faça um método que receba uma lista de receitas e retorne uma "lista de compras",
	//agrupando todos os ingredientes que possuem o mesmo nome e unidade de medida.
	public List<Ingrediente> listaDeCompras(List<Receita> listaReceita){
		List<Ingrediente> listaFinal = new ArrayList<Ingrediente>();
			for (Receita receitaAtual : listaReceita) {
				for (Ingrediente ingrediente : receitaAtual.listaIngredientes) {
					if(!listaFinal.isEmpty()){
						//Continuar
					}else{
						listaFinal.add(ingrediente);
					}
				}
			}
		return listaFinal;
	} 
}
