package filmator.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object controller) throws Exception {

		String uri = request.getRequestURI();
		if (uri.endsWith("/")||
			uri.endsWith("telaCadastroUsuarioLogin")||
			uri.endsWith("cadastroUsuarioLogin")||
			uri.endsWith("validaLogin")||
			uri.endsWith("script")||
			uri.contains("resources")) {
			return true;
		}

		if (request.getSession().getAttribute("usuarioAdmin") != null) {
			return true;
		} else if (request.getSession().getAttribute("usuarioNormal") != null){
			return true;
		}
		
		response.sendRedirect("/");
		return false;
	}
}
