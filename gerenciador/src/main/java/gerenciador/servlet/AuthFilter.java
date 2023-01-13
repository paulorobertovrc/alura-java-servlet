package gerenciador.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthFilter
 */
@WebFilter("/servletGateway")
public class AuthFilter extends HttpFilter implements Filter {
       
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

		System.out.println("AuthFilter");
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String paramAction = request.getParameter("action");
		
		HttpSession session = request.getSession();
		boolean usuarioNaoEstaLogado = session.getAttribute("usuarioLogado") == null;
		boolean rotaNaoProtegida = !(paramAction.equals("Login") ||
				paramAction.equals("LoginForm"));
		
		if (usuarioNaoEstaLogado && rotaNaoProtegida) {
			response.sendRedirect("servletGateway?action=LoginForm");
			return;
		}

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

}
