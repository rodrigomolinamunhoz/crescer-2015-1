package filmator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.FilmeDao;
import filmator.model.Genero;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		FilmeDao dao = new FilmeDao();
		model.addAttribute("mensagem", "fulano de tal");
		model.addAttribute("millisegundos", System.currentTimeMillis());
		model.addAttribute("filmes", dao.buscaTodosFilmes());
		return "nomeDoArquivo";
	}
	
	@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
	public String cadastroFilme(Model model) {
		model.addAttribute("genero", Genero.values());
		return "cadastroFilme";
	}


}
