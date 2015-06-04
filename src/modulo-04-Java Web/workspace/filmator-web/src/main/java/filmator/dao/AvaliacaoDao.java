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
	
	public void inserirAvaliacao(int idFilme, int idUsuario, double nota){
		List<Avaliacao> avaliacoes =  verificaVoto(idFilme, idUsuario, nota);
		if (avaliacoes.size() == 0) {
			jdbcTemplate.update( "INSERT INTO avaliacao (idfilme, cod_usuario, nota) VALUES (?, ?, ?)",
					idFilme, idUsuario, nota);
		} else {
			jdbcTemplate.update("UPDATE avaliacao SET nota = ? WHERE idfilme = ? AND cod_usuario = ?",
					nota, idFilme, idUsuario);
		}
	}
	
	public List<Avaliacao> verificaVoto(int idFilme, int idUsuario, double nota) {
		List<Avaliacao> avaliacoes =  jdbcTemplate.query("SELECT * FROM avaliacao WHERE idfilme = ? AND cod_usuario = ?", new RowMapper<Avaliacao>(){
			@Override
			public Avaliacao mapRow(ResultSet rs, int arg1) throws SQLException{
				Avaliacao avaliacao = new Avaliacao();
				avaliacao.setIdFilme(rs.getInt("idfilme"));
				avaliacao.setCodigoUsuario(rs.getInt("cod_usuario"));
				avaliacao.setNota(rs.getDouble("nota"));
				avaliacao.setIdAvaliacao(rs.getInt("id_avaliacao"));
				return avaliacao; 	
			}
		},idFilme,idUsuario);
		
		return avaliacoes;
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
