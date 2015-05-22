package mestre.cuca;

import java.io.File;
import java.io.IOException;
import java.util.*;
import org.codehaus.jackson.map.*;

public class LivroReceitasJson implements LivroReceitas {
	
	public LivroReceitasJson(String caminho) throws IOException {
	    carregaReceitasDeArquivoJson(caminho);
	}

	private void carregaReceitasDeArquivoJson(String caminho) throws IOException{
	    File arquivo = new File(caminho);
	    if(arquivo.exists()){
	        receitas =  mapper.readValue(arquivo, List.class);
	    }
	}
	
	LivroReceitasJson livro = new LivroReceitasJson("/Users/Rodrigo/Documents/Projeto Crescer/Git/crescer-2015-1/src/modulo-04-Java Web/Arquivos JSON/receitas.json");

	@Override
	public void inserir(Receita receita) {
	}

	@Override
	public void atualizar(String nomeReceita, Receita receitaAtualizada) {
	}

	@Override
	public void excluir(String nomeReceita) {
	}

	@Override
	public List<Receita> getTodasReceitas() {
		return null;
	}

	@Override
	public Receita buscaReceitaPeloNome(String nomeReceita) {
		return null;
	}

}
