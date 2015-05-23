package filmator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.FilmeDao;
import filmator.model.Filme;
import filmator.model.Genero;

@Controller
public class HomeController {
	
	FilmeDao dao = new FilmeDao();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homeFilme(Model model) {
		model.addAttribute("generos", Genero.values());
		model.addAttribute("filmes", dao.buscaTodosFilmes());
		return "cadastroFilme";
	}
	

//	@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
//	public String cadastroFilme(Model model) {
//		model.addAttribute("generos", Genero.values());
//		return "cadastroFilme";
//	}
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String salvar(Filme filme, Model model) {
		//System.out.println(filme.getNome());
		dao.salvar(filme);
		model.addAttribute("generos", Genero.values());
		model.addAttribute("filmes", dao.buscaTodosFilmes());
		return "cadastroFilme";
	}

}
