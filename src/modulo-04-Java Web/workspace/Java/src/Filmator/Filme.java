package Filmator;

import java.util.*;

public class Filme {
	private String nome;
	ArrayList<Ator> listaElenco = new ArrayList<Ator>();
	Genero genero;
	
	public Filme(){
	}
	public Filme(String nome, Genero genero){
		this.nome = nome;
		this.genero = genero;
	}
	
	public ArrayList<Ator> getElenco(){
		return this.listaElenco;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public String toString(){
		return this.nome;
	}
	
	public Genero getGenero(){
		return this.genero;
	}
	
	public void inserirAtor(Ator ator){
		this.listaElenco.add(ator);
	}
	
	public ArrayList<Ator> procuraAtoresElenco(String parteNome){
		ArrayList<Ator> novoElenco = new ArrayList<Ator>();
		
		for (Ator atorAtual : this.listaElenco) {
			if(atorAtual.getNome().contains(parteNome) ){
				novoElenco.add(atorAtual);
			}
		}
		return novoElenco;
	}
}
