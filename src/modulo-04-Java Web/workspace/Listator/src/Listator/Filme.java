package Listator;

import java.util.*;

public class Filme {
	private String nome;
	ArrayList<Ator> listaAtores = new ArrayList<Ator>();  
	
	public Filme(String nome){
        this.nome = nome;  
    }
	
	public void inserirAtor(String ator){
		Ator t = new Ator("ator");
		this.listaAtores.add(t);
	}
	
	public static void main(String[] args) {
		
	}
	
    public Ator listarAtores(String nome) {
        for(Ator atual: this.listaAtores){
            if(atual.getNome().contains(nome)){
            	return nome; 
            } 
        } 
    }
}
