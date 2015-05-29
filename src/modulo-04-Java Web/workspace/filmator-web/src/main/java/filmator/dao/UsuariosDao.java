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

	public Usuarios validaLogin(String loginUsuario, String senhaUsuario) {
		List<Usuarios> usuarioExistente = jdbcTemplate.query("select login, senha, admin_sist from usuarios where login = ? and senha = ?", new RowMapper<Usuarios>() {
							@Override
							public Usuarios mapRow(ResultSet rs, int arg1) throws SQLException {
								Usuarios usuario = new Usuarios();
								usuario.setLoginUsuario(rs.getString("login"));
								usuario.setSenhaUsuario(rs.getString("senha"));
								usuario.setAdminSistema(rs.getInt("admin_sist"));
								return usuario;
							}
						}, loginUsuario, senhaUsuario);
		
		return usuarioExistente.isEmpty() ? null : usuarioExistente.get(0);
	}

	public void inserirUsuariologin(Usuarios usuario) {
		jdbcTemplate
				.update("INSERT INTO usuarios (nome_usuario, login, senha, admin_sist) VALUES (?,?,?, 0)",
						usuario.getNomeUsuario(),
						usuario.getLoginUsuario(),
						usuario.getSenhaUsuario());
	}

	public List<Usuarios> buscaTodosUsuarios() {
		return jdbcTemplate
				.query("SELECT cod_usuario, nome_usuario, login, senha, admin_sist FROM usuarios",
						new RowMapper<Usuarios>() {
							public Usuarios mapRow(ResultSet rs, int arg1)
									throws SQLException {
								Usuarios usuario = new Usuarios();
								usuario.setCodigoUsuario(rs.getInt("cod_usuario"));
								usuario.setNomeUsuario(rs.getString("nome_usuario"));
								usuario.setLoginUsuario(rs.getString("login"));
								usuario.setSenhaUsuario(rs.getString("senha"));
								usuario.setAdminSistema(rs.getInt("admin_sist"));
								return usuario;
							}

						});
	}
	
}
