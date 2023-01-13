package gerenciador.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gerenciador.modelo.Banco;
import gerenciador.modelo.Usuario;

public class Login implements Action {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		System.out.println("Logando " + login);
		
		Banco banco = new Banco();
		Usuario usuario = banco.usuarioExiste(login, senha);
		
		if (usuario != null) {
			System.out.println("Usuário existe");
			
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogado", usuario);
			
			return "redirect:servletGateway?action=ListarEmpresas";
		} else {
			System.out.println("Usuário não existe ou senha incorreta");
			return "redirect:servletGateway?action=LoginForm";
		}
	}
	
}
