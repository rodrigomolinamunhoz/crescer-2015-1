package filmator.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import filmator.model.Usuarios;


@Component
public class UsuariosDao {

	@Inject
	private JdbcTemplate jdbcTemplate;
	
	public List<Usuarios> validaLogin(String login, String senha) {
		return jdbcTemplate.query("SELECT login, senha FROM usuarios WHERE login = (?) AND senha = (?)", new RowMapper<Usuarios>() {
					public Usuarios mapRow(ResultSet rs, int arg1) throws SQLException {
						Usuarios usuario = new Usuarios();
						usuario.setLoginUsuario(rs.getString("loginUsuario"));
						usuario.setSenhaUsuario(rs.getString("senhaUsuario"));
						return usuario;
					}
				}, login, senha );

	}

}
