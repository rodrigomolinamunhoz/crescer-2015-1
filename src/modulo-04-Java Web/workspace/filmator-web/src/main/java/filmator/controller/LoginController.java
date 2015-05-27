package filmator.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.UsuariosDao;
import filmator.model.Usuarios;

@Controller
public class LoginController {
	@Inject
	UsuariosDao dao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String telaLogin() {
		return "telaLogin";
	}

	@RequestMapping(value = "/validaLogin", method = RequestMethod.POST)
	public String validar(Model model, Usuarios usuario) {
		Usuarios usuarioExiste = dao.validaLogin(usuario.getLoginUsuario(), usuario.getSenhaUsuario());
		if (usuarioExiste != null) {
			if (usuarioExiste.getAdminSistema() == 1) {
				return "cadastroFilme";
			} else {
				return "listagemFilmes";
			}
		} else {	
			return "telaLogin";
		}

	}

}
