package filmator.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
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
	public String telaLogin(HttpServletRequest request, HttpSession session) {
		if (request.getSession().getAttribute("usuarioLogado") != null) {
			return "indexAdmin";
		} else {
			return "telaLogin";
		}
	}
	
	@RequestMapping(value = "/indexAdmin", method = RequestMethod.GET)
	public String telaCadastroFilme() {
		return "indexAdmin";
	}

	@RequestMapping(value = "/cadastroUsuarioLogin", method = RequestMethod.GET)
	public String telaoUsuarioLogin() {
		return "telaCadastroUsuarioLogin";
	}

	@RequestMapping(value = "/indexUsuario", method = RequestMethod.GET)
	public String telaListagemFilme() {
		return "indexUsuario";
	}

	@RequestMapping(value = "/validaLogin", method = RequestMethod.POST)
	public String validar(Model model, HttpSession session, Usuarios usuario) {
		Usuarios usuarioExiste = dao.validaLogin(usuario.getLoginUsuario(),
				usuario.getSenhaUsuario());
		if (usuarioExiste != null) {
			if (usuarioExiste.getAdminSistema() == 1) {
				session.setAttribute("usuarioLogado", usuario);
				//Usuarios usuarioLogado = (Usuarios) session.getAttribute("usuarioLogado");
				return "redirect:/indexAdmin";
			} else {
				session.setAttribute("usuarioLogado", usuario);
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
	
//	@RequestMapping(value = "/avaliar", method = RequestMethod.POST)
//	public String avaliar @RequestParam (int id_filme, int nota){
//		dao.atualiza no banco.
//		
//		
//	}
//	
//	$.ajax(){
//		url + $('#nota').val()
//		type: post
//	}

}
