package gerenciador.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gerenciador.action.Action;


@WebFilter("/servletGateway")
public class ControladorFilter extends HttpFilter implements Filter {
       
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

		System.out.println("ControladorFilter");
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String paramAction = request.getParameter("action");
		
		String nomeClasse = "gerenciador.action." + paramAction;
		
		Class classe = null;
		String nomeJsp = null;
		
		try {
			classe = Class.forName(nomeClasse);
			Action action = (Action) classe.newInstance();
			nomeJsp = action.executar(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException();
		}
		
		String[] tipoRetorno = nomeJsp.split(":");
		if (tipoRetorno[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoRetorno[1]);
			rd.forward(request, response);			
		} else {
			response.sendRedirect(tipoRetorno[1]);
		}
		
	}

}
