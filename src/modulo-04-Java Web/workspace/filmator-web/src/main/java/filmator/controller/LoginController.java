package filmator.controller;

import javax.inject.Inject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;

import filmator.dao.UsuariosDao;
import filmator.model.Usuarios;

@Controller
public class LoginController {
	@Inject
	UsuariosDao dao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String telaLogin(@RequestParam("redir_url") String redirectUrl, HttpServletRequest request, HttpSession session) {
		if (request.getSession().getAttribute("usuarioLogado") != null) {
			return "redirect:" + redirectUrl;
		} else {
			return "telaLogin";
		}
	}

	@RequestMapping(value = "/cadastroFilme", method = RequestMethod.GET)
	public String telaCadastroFilme() {
		return "cadastroFilme";
	}

	@RequestMapping(value = "/listagemFilmes", method = RequestMethod.GET)
	public String telaListagemFilme() {
		return "listagemFilmes";
	}

	@RequestMapping(value = "/validaLogin", method = RequestMethod.POST)
	public String validar(Model model, HttpSession session, Usuarios usuario) {
		Usuarios usuarioExiste = dao.validaLogin(usuario.getLoginUsuario(),
				usuario.getSenhaUsuario());
		if (usuarioExiste != null) {
			if (usuarioExiste.getAdminSistema() == 1) {
				session.setAttribute("usuarioLogado", usuario);
				return "redirect:/cadastroFilme";
			} else {
				session.setAttribute("usuarioLogado", usuario);
				return "redirect:/listagemFilmes";
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
