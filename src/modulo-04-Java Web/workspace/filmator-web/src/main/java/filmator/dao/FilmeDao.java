package filmator.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import filmator.model.Filme;

@Component
public class FilmeDao {

	@Inject
	private JdbcTemplate jdbcTemplate;

	public void inserir(Filme filme) {
		jdbcTemplate
				.update("INSERT INTO Filme (nome, genero, faixaEtaria, anoLancamento, sinopse, imagem) VALUES (?,?,?,?,?,?)",
						filme.getNome(), filme.getGenero().name(),
						filme.getFaixaEtaria(), filme.getAnoLancamento(),
						filme.getSinopse(), filme.getImagem());
	}

	public List<Filme> buscaTodosFilmesJava8() {
		return jdbcTemplate.query("SELECT * FROM Filme", (ResultSet rs,
				int rowNum) -> {
			Filme filme = new Filme(
					rs.getString("nome"),
					rs.getString("genero"),
					rs.getString("faixaEtaria"), 
					rs.getString("anoLancamento"),
					rs.getString("sinopse"),
					rs.getString("imagem")
					);
			return filme;
		});
	}

	// List<Filme> listaDeFilmes = new ArrayList<Filme>();
	//
	// public List<Filme> buscaTodosFilmes() {
	// return listaDeFilmes;
	// }
	//
	// public void salvar(Filme filme) {
	// listaDeFilmes.add(filme);
	// }
	//
	// public Filme buscaFilmePeloNome(String nomeFilme) {
	// for (Filme filmeAtual : this.listaDeFilmes) {
	// if (filmeAtual.getNome().equals(nomeFilme)) {
	// return filmeAtual;
	// }
	// }
	// throw new FilmeNaoEncontradoException(nomeFilme);
	// }
}
