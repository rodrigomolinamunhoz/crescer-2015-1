package filmator.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import filmator.model.FormularioLogin;


@Component
public class UsuariosDao {

	@Inject
	private JdbcTemplate jdbcTemplate;
	
	public List<FormularioLogin> validaLogin(String login, String senha) {
		return jdbcTemplate.query("SELECT login, senha FROM usuarios WHERE login = (?) AND senha = (?)",
				new RowMapper<FormularioLogin>() {
					public FormularioLogin mapRow(ResultSet rs, int arg1)
							throws SQLException {
						FormularioLogin usuario = new FormularioLogin();
						usuario.setLogin(rs.getString("login"));
						usuario.setSenha(rs.getString("senha"));
						return usuario;
					}
				}, login,senha  );

	}

}
