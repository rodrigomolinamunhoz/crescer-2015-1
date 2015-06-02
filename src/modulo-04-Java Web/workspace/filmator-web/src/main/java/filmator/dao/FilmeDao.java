package filmator.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import filmator.model.Filme;
import filmator.model.Genero;

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
		return jdbcTemplate
				.query("SELECT f.idfilme, f.nome, f.genero, f.faixaetaria, f.anolancamento, f.sinopse, f.imagem, (SELECT CONVERT(AVG(nota), DECIMAL(20,2)) FROM avaliacao a WHERE a.idfilme = f.idfilme) AS media FROM filme f",
						new RowMapper<Filme>() {
							public Filme mapRow(ResultSet rs, int arg1)
									throws SQLException {
								Filme filme2 = new Filme();
								filme2.setIdFilme(rs.getInt("idFilme"));
								filme2.setNome(rs.getString("nome"));
								filme2.setAnoLancamento(rs.getString("anoLancamento"));
								filme2.setFaixaEtaria(rs.getString("faixaEtaria"));
								filme2.setGenero(Genero.valueOf(rs.getString("genero")));
								filme2.setSinopse(rs.getString("sinopse"));
								filme2.setImagem(rs.getString("imagem"));
								filme2.setMedia(rs.getDouble("media"));
								return filme2;
							}

						});
	}

	public List<Filme> buscaFilmePorNome(String nomeFilme) {
		return jdbcTemplate.query("SELECT idFilme, nome, genero, anoLancamento, faixaEtaria, sinopse, imagem FROM Filme WHERE nome like ?",
				new RowMapper<Filme>() {
					public Filme mapRow(ResultSet rs, int arg1)
							throws SQLException {
						Filme filme2 = new Filme();
						filme2.setIdFilme(rs.getInt("idFilme"));
						filme2.setNome(rs.getString("nome"));
						filme2.setAnoLancamento(rs.getString("anoLancamento"));
						filme2.setFaixaEtaria(rs.getString("faixaEtaria"));
						filme2.setGenero(Genero.valueOf(rs.getString("genero")));
						filme2.setSinopse(rs.getString("sinopse"));
						filme2.setImagem(rs.getString("imagem"));
						return filme2;
					}
				}, "%" + nomeFilme + "%" );

	}
	
	public void excluirFilme(int idFilme) {
		jdbcTemplate.update("DELETE FROM filme WHERE idFilme = ?", idFilme);
	}

}
