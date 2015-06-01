package filmator.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import filmator.dao.AvaliacaoDao;
import filmator.model.Avaliacao;
import filmator.model.Usuarios;

@Controller
public class AvaliacaoController {

	@Inject
	AvaliacaoDao dao;

	@RequestMapping(value = "/avaliacaoFilme", method = RequestMethod.POST)
	public String avaliarFilme(HttpSession session, int idFilme, double nota) {
		Usuarios usuarioAdmin = (Usuarios) session.getAttribute("usuarioAdmin");
		Usuarios usuarioNormal = (Usuarios) session.getAttribute("usuarioNormal");
		if (usuarioAdmin != null) {
			return "listagemFilmes";
		} else if (usuarioNormal != null) {
			Avaliacao avaliacao = new Avaliacao(idFilme, nota, usuarioNormal.getCodigoUsuario());
			dao.inserirAvaliacao(avaliacao);
			return "listagemFilmesNormal";
		} else {
			return "telaLogin";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/mediaAvaliacao", method = RequestMethod.GET)
	public List<Avaliacao> mediaFilme(int idFilme) {
			return dao.mediaVotoAvaliacao(idFilme);
	}
}
