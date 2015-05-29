package filmator.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.UsuariosDao;

@Controller
public class ListarUsuariosController {

	@Inject
	UsuariosDao dao;
	
	@RequestMapping(value = "/buscarTodosUsuarios", method = RequestMethod.GET)
	public String listarUsuarios(Model model) {
		model.addAttribute("usuarios", dao.buscaTodosUsuarios());
		return "listagemUsuarios";
	}
}
