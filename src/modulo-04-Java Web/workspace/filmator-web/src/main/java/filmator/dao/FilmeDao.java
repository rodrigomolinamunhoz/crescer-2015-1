package filmator.dao;

import java.util.ArrayList;

import java.util.List;

import filmator.model.Filme;

public class FilmeDao {
	List<Filme> listaDeFilmes = new ArrayList<Filme>();

	public List<Filme> buscaTodosFilmes() {
		return listaDeFilmes;
	}

	public void salvar(Filme filme) {
		listaDeFilmes.add(filme);
	}

	public Filme buscaFilmePeloNome(String nomeFilme) {
		for (Filme filmeAtual : this.listaDeFilmes) {
			if (filmeAtual.getNome().equals(nomeFilme)) {
				return filmeAtual;
			}
		}
		throw new NullPointerException();
	}
}
