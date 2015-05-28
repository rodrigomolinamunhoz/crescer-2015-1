package filmator.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.UsuariosDao;
import filmator.model.Usuarios;

@Controller
public class CadastroUsuarioLoginController {
	@Inject
	UsuariosDao dao;
	
	@RequestMapping(value = "/cadastroUsuarioLogin", method = RequestMethod.POST)
	public String cadastrarUsuariologin(Usuarios usuario) {
		dao.inserirUsuariologin(usuario);
		return "telaLogin";
	}
}
