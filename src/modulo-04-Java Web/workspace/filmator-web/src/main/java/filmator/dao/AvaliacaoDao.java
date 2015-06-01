package filmator.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import filmator.model.Avaliacao;

@Component
public class AvaliacaoDao {

	@Inject
	private JdbcTemplate jdbcTemplate;
	
	public void inserirAvaliacao(Avaliacao avaliacao){
		jdbcTemplate.update( "INSERT INTO avaliacao (idfilme, nota, cod_usuario) VALUES (?, ?, ?)",
				avaliacao.getIdFilme(),
				avaliacao.getNota(),
				avaliacao.getCodigoUsuario());
	}

	public List<Avaliacao> mediaVotoAvaliacao(int idFilme) {
		return jdbcTemplate.query("SELECT idFilme, sum(nota), count(*)  FROM avaliacao WHERE idfilme = ?",
				new RowMapper<Avaliacao>() {
					public Avaliacao mapRow(ResultSet rs, int arg1)	throws SQLException {
						Avaliacao media = new Avaliacao();
						media.setIdFilme(rs.getInt("idFilme"));
						double soma = rs.getInt("sum(nota)");
						double count = rs.getInt("count(*)");
						media.setMedia(soma/count);			
						return media;
					}
				}, idFilme );
	}
}
