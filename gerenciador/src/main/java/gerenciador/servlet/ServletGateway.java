package gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gerenciador.action.Action;


@WebServlet("/servletGateway")
public class ServletGateway extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramAction = request.getParameter("action");

//		HttpSession session = request.getSession();
//		boolean usuarioNaoEstaLogado = session.getAttribute("usuarioLogado") == null;
//		boolean rotaNaoProtegida = !(paramAction.equals("Login") ||
//				paramAction.equals("LoginForm"));
//		
//		if (usuarioNaoEstaLogado && rotaNaoProtegida) {
//			response.sendRedirect("servletGateway?action=LoginForm");
//			return;
//		}
		
//		String nomeClasse = "gerenciador.action." + paramAction;
//		
//		Class classe = null;
//		String nomeJsp = null;
//		
//		try {
//			classe = Class.forName(nomeClasse);
//			Action action = (Action) classe.newInstance();
//			nomeJsp = action.executar(request, response);
//		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
//			throw new ServletException();
//		}
//		
//		String[] tipoRetorno = nomeJsp.split(":");
//		if (tipoRetorno[0].equals("forward")) {
//			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoRetorno[1]);
//			rd.forward(request, response);			
//		} else {
//			response.sendRedirect(tipoRetorno[1]);
//		}
	}
	
}
