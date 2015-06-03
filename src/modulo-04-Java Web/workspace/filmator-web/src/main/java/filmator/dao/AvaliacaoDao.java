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
	
	public List<Avaliacao> verificaVoto(int idFilme, int idUsuario, double nota) {
		return jdbcTemplate.query("SELECT idfilme, cod_usuario, nota FROM avaliacao WHERE idfilme = ? AND cod_usuario = ?", new RowMapper<Avaliacao>(){
			@Override
			public Avaliacao mapRow(ResultSet rs, int arg1) throws SQLException{
				Avaliacao avaliacao = new Avaliacao();
				avaliacao.setIdFilme(rs.getInt("idfilme"));
				avaliacao.setCodigoUsuario(rs.getInt("cod_usuario"));
				avaliacao.setNota(rs.getDouble("nota"));
				return avaliacao; 	
			}
		}, idUsuario, idFilme);
	}
	
	public void atualizaVoto(int idFilme, int idUsuario, double nota){
		jdbcTemplate.update("UPDATE avaliacao SET nota = ? WHERE idfilme = ? AND cod_usuario = ?",
		idFilme, idUsuario, nota);
	}

	public List<Avaliacao> mediaVotoAvaliacao(int idFilme) {
		return jdbcTemplate.query("SELECT idfilme, sum(nota), count(*)  FROM avaliacao WHERE idfilme = ?",
				new RowMapper<Avaliacao>() {
					public Avaliacao mapRow(ResultSet rs, int arg1)	throws SQLException {
						Avaliacao media = new Avaliacao();
						media.setIdFilme(rs.getInt("idfilme"));
						double soma = rs.getInt("sum(nota)");
						double count = rs.getInt("count(*)");
						media.setMedia(soma/count);			
						return media;
					}
				}, idFilme);
	}
}
