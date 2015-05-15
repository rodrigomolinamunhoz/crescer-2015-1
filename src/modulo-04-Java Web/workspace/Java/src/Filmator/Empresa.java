package Filmator;

import java.util.*;

public class Empresa {
	ArrayList<Filme> ListaAcervoFilmes = new ArrayList<Filme>();
	HashMap<Genero, ArrayList<Filme>> ListaReproduzidos = new HashMap<Genero, ArrayList<Filme>>();
	
	public void adicionarAoAcervo(Filme filme){
		ListaAcervoFilmes.add(filme);
	}
	
	public void reproduzirFilme(Filme filme){
		if(ListaAcervoFilmes.contains(filme)){
			if (ListaReproduzidos.containsKey(filme.getGenero())) {
                ListaReproduzidos.get(filme.getGenero()).add(filme) ;
            } else {
                ListaReproduzidos.put(filme.getGenero(), new ArrayList<>(Arrays.asList(filme)));
            }
		}	
	}

	public String gerarRelatorio(){
		StringBuilder relatorio = new StringBuilder();
		for (Map.Entry<Genero, ArrayList<Filme>> parChaveValor : ListaReproduzidos.entrySet()) {
		    System.out.println(parChaveValor.getKey() + " - " + parChaveValor.getValue().size());
		    relatorio.append(parChaveValor.getKey() + " - " + parChaveValor.getValue().size());
		}
		return relatorio.toString();
    }
	
	public ArrayList<Filme> getListaAcervoFilmes(){
		return this.ListaAcervoFilmes;
	}
	public HashMap< Genero, ArrayList<Filme>> getListaReproduzidos(){
		return this.ListaReproduzidos;
	}
		
}
