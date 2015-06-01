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
public class LoginController {
	@Inject
	UsuariosDao dao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String telaLogin(HttpSession session) {
		Usuarios usuarioAdmin = (Usuarios) session.getAttribute("usuarioAdmin");
		Usuarios usuarioNormal = (Usuarios) session.getAttribute("usuarioNormal");
		if (usuarioAdmin != null) {
			return "indexAdmin";
		} else if (usuarioNormal != null ) {
			return "indexUsuario";
		} else {
			return "telaLogin";
		}
	}
	
	@RequestMapping(value = "/indexAdmin", method = RequestMethod.GET)
	public String telaCadastroFilme() {
		return "indexAdmin";
	}

	@RequestMapping(value = "/telaCadastroUsuarioLogin", method = RequestMethod.GET)
	public String telaUsuarioLogin() {
		return "telaCadastroUsuarioLogin";
	}

	@RequestMapping(value = "/indexUsuario", method = RequestMethod.GET)
	public String telaListagemFilme(HttpSession session) {
		Usuarios usuarioAdmin = (Usuarios) session.getAttribute("usuarioAdmin");
		Usuarios usuarioNormal = (Usuarios) session.getAttribute("usuarioNormal");
		if (usuarioAdmin != null) {
			return "indexAdmin";
		} else if (usuarioNormal != null ) {
			return "indexUsuario";
		} else {
			return "telaLogin";
		}
	}

	@RequestMapping(value = "/validaLogin", method = RequestMethod.POST)
	public String validar(Model model, HttpSession session, Usuarios usuario) {
		Usuarios usuarioExiste = dao.validaLogin(usuario.getLoginUsuario(), usuario.getSenhaUsuario());
		if (usuarioExiste != null) {
			if (usuarioExiste.getAdminSistema() == 1) {
				session.setAttribute("usuarioAdmin", usuarioExiste);
				return "redirect:/indexAdmin";
			} else {
				session.setAttribute("usuarioNormal", usuarioExiste);
				return "redirect:/indexUsuario";
			}
		} else {
			return "telaLogin";
		}
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "/";
	}
}
