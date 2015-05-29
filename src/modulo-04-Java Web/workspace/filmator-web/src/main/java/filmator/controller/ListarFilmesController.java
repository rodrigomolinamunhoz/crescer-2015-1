package filmator.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import filmator.dao.FilmeDao;
import filmator.model.Filme;
import filmator.model.Usuarios;

@Controller
public class ListarFilmesController {

	@Inject
	FilmeDao dao;
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String salvar(HttpSession session, Filme filme, Model model) {
		Usuarios usuarioAdmin = (Usuarios) session.getAttribute("usuarioAdmin");
		Usuarios usuarioNormal = (Usuarios) session.getAttribute("usuarioNormal");
		if (usuarioAdmin != null) {
			dao.inserir(filme);
			model.addAttribute("filmes", dao.buscaTodosFilmesJava8());
			return "listagemFilmes";
		} else if (usuarioNormal != null ) {
			return "indexUsuario";
		} else {
			return "telaLogin";
		}
	}
	
	@RequestMapping(value = "/buscarTodosFilmes", method = RequestMethod.GET)
	public String listarFilmes(HttpSession session, Model model, Usuarios usuario) {
		Usuarios usuarioAdmin = (Usuarios) session.getAttribute("usuarioAdmin");
		Usuarios usuarioNormal = (Usuarios) session.getAttribute("usuarioNormal");
		if (usuarioAdmin != null) {
			model.addAttribute("filmes", dao.buscaTodosFilmesJava8());
			return "listagemFilmes";
		} else if (usuarioNormal != null ) {
			model.addAttribute("filmes", dao.buscaTodosFilmesJava8());
			return "listagemFilmesNormal";
		} else {
			return "telaLogin";
		}
	}
	
//	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
//	public String buscar(HttpSession session, String nome, Model model) {
//		Usuarios usuarioAdmin = (Usuarios) session.getAttribute("usuarioAdmin");
//		Usuarios usuarioNormal = (Usuarios) session.getAttribute("usuarioNormal");
//		if (usuarioAdmin != null) {
//			model.addAttribute("filmes", dao.buscaFilmePorNome(nome));
//			return "listagemFilmes";
//		} else if (usuarioNormal != null ) {
//			model.addAttribute("filmes", dao.buscaFilmePorNome(nome));
//			return "listagemFilmesNormal";
//		} else {
//			return "telaLogin";
//		}
//	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
	public @ResponseBody
	List<Filme> buscar(@RequestParam String nome) {
		return dao.buscaFilmePorNome(nome);
	}
	
	@RequestMapping(value = "/deletarFilme", method = RequestMethod.GET)
	public String deletaFilme(HttpSession session, int idFilme, Model model) {
		Usuarios usuarioAdmin = (Usuarios) session.getAttribute("usuarioAdmin");
		Usuarios usuarioNormal = (Usuarios) session.getAttribute("usuarioNormal");
		if (usuarioAdmin != null) {
			dao.excluirFilme(idFilme);
			model.addAttribute("filmes", dao.buscaTodosFilmesJava8());
			return "listagemFilmes";
		} else if (usuarioNormal != null ) {
			return "indexUsuario";
		} else {
			return "telaLogin";
		}
	}
}
