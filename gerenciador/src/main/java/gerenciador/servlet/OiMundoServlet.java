package gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/oi")
public class OiMundoServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("Hello, world!");
		
		PrintWriter out;
		try {
			out = resp.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("Hello, world! Você escreveu o seu primeiro servlet.");
			out.println("</html>");
			out.println("</body>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
