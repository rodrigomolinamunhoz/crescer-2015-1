package filmator.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.FilmeDao;
import filmator.model.Genero;
import filmator.model.Usuarios;

@Controller
public class CadastroFilmeController {
	//Injeção de dependência
	@Inject
	FilmeDao dao;
	
	@RequestMapping(value = "/formularioCadastro", method = RequestMethod.GET)
	public String homeFilme(HttpSession session, Model model) {
		Usuarios usuarioAdmin = (Usuarios) session.getAttribute("usuarioAdmin");
		Usuarios usuarioNormal = (Usuarios) session.getAttribute("usuarioNormal");
		if (usuarioAdmin != null) {
			model.addAttribute("generos", Genero.values());
			return "cadastroFilme";
		} else if (usuarioNormal != null ) {
			return "indexUsuario";
		} else {
			return "telaLogin";
		}
	}
}