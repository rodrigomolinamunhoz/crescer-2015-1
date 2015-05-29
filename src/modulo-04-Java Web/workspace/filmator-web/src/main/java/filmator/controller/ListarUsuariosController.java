package filmator.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.UsuariosDao;
import filmator.model.Usuarios;

@Controller
public class ListarUsuariosController {

	@Inject
	UsuariosDao dao;
	
	@RequestMapping(value = "/buscarTodosUsuarios", method = RequestMethod.GET)
	public String listarUsuarios(HttpSession session, Model model) {
		Usuarios usuarioAdmin = (Usuarios) session.getAttribute("usuarioAdmin");
		Usuarios usuarioNormal = (Usuarios) session.getAttribute("usuarioNormal");
		if (usuarioAdmin != null) {
			model.addAttribute("usuarios", dao.buscaTodosUsuarios());
			return "listagemUsuarios";
		} else if (usuarioNormal != null ) {
			return "indexUsuario";
		} else {
			return "telaLogin";
		}
	}
	
	@RequestMapping(value = "/listagemUsuarios", method = RequestMethod.GET)
	public String listaUsuarios(HttpSession session, Model model){
		Usuarios usuarioAdmin = (Usuarios) session.getAttribute("usuarioAdmin");
		Usuarios usuarioNormal = (Usuarios) session.getAttribute("usuarioNormal");
		if (usuarioAdmin != null) {
			model.addAttribute("usuarios", dao.buscaTodosUsuarios());
			return "listagemUsuarios";
		} else if (usuarioNormal != null ) {
			return "indexUsuario";
		} else {
			return "telaLogin";
		}
	}
	
	@RequestMapping(value = "/deletarUsuario", method = RequestMethod.GET)
	public String deletaFilme(HttpSession session, int codigoUsuario, Model model) {
		Usuarios usuarioAdmin = (Usuarios) session.getAttribute("usuarioAdmin");
		Usuarios usuarioNormal = (Usuarios) session.getAttribute("usuarioNormal");
		if (usuarioAdmin != null) {
			dao.excluirUsuario(codigoUsuario);
			return "redirect:/listagemUsuarios";
		} else if (usuarioNormal != null ) {
			return "indexUsuario";
		} else {
			return "telaLogin";
		}
	}
}
