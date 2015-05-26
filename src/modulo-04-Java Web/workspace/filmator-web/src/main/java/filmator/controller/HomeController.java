package filmator.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.FilmeDao;
import filmator.dao.FilmeNaoEncontradoException;
import filmator.model.Filme;
import filmator.model.Genero;

@Controller
public class HomeController {
	//Injeção de dependência
	@Inject
	FilmeDao dao = new FilmeDao();
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String telaLogin() {
		return "telaLogin";
	}

	@RequestMapping(value = "/formularioCadastro", method = RequestMethod.GET)
	public String homeFilme(Model model) {
		model.addAttribute("generos", Genero.values());
		return "cadastroFilme";
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String salvar(Filme filme, Model model) {
		dao.inserir(filme);
		model.addAttribute("filmes", dao.buscaTodosFilmesJava8());
		return "listagemFilmes";
	}

	@RequestMapping(value = "/telaBusca", method = RequestMethod.GET)
	public String telaBuscar() {
		return "buscarFilme";
	}

	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public String buscar(String nome, Model model) {
		model.addAttribute("filmes", dao.buscaFilmePorNome(nome));
		return "listagemFilmes";
	}

	@ExceptionHandler()
	public String iHandleExceptions(HttpServletRequest request, FilmeNaoEncontradoException e) {
		request.setAttribute("exception", e);
		return "erroBuscaFilme";
	}

}
