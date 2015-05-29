package filmator.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import filmator.dao.UsuariosDao;
import filmator.model.Usuarios;

@Controller
public class CadastroUsuarioLoginController {
	@Inject
	UsuariosDao dao;
	
//	@RequestMapping(value = "/cadastroUsuarioLogin", method = RequestMethod.POST)
//	public String cadastrarUsuariologin(Usuarios usuario) {
//		dao.inserirUsuariologin(usuario);
//		return "telaLogin";
//	}
	
	// handles person form submit
    @RequestMapping(value="/cadastroUsuarioLogin", method=RequestMethod.POST)
    @ResponseBody
    public Model savePerson(Model model, Usuarios usuario) {
    	dao.inserirUsuariologin(usuario);
        return model.addAttribute("usuario", usuario.getNomeUsuario() + "  cadastrado.");
    }
}
