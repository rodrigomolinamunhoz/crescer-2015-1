package filmator.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.UsuariosDao;


@Controller
public class LoginController {
	@Inject
	UsuariosDao dao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String telaLogin() {
		return "telaLogin";
	}
	
	@RequestMapping(value = "/validaLogin", method = RequestMethod.POST)
	public String validar(Model model, String login, String senha) {
		model.addAttribute("Usuarios", dao.validaLogin(login, senha));
		return "cadastroFilme";
	}
	
	
}
