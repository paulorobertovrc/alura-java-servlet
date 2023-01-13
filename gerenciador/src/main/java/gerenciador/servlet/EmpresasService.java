package gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import gerenciador.modelo.Banco;
import gerenciador.modelo.Empresa;

/**
 * Servlet implementation class EmpresasService
 */
@WebServlet("/empresas")
public class EmpresasService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Empresa> empresas = new Banco().getEmpresas();
		
		String contentType = request.getHeader("Accept");
		
		if (contentType.contains("xml")) {
			contentType = "xml";
		} else {
			contentType = "json";
		}
		System.out.println(contentType);
		
		String jsonOrXmlResponse = "";
		
		switch (contentType) {
		
			case "json": {
				Gson gson = new Gson();
				jsonOrXmlResponse = gson.toJson(empresas);
				break;
			}
			
			case "xml": {
				XStream xstream = new XStream();
				xstream.alias("empresa", Empresa.class);
				jsonOrXmlResponse= xstream.toXML(empresas);
				break;
			}
			
			default:
				throw new IllegalArgumentException("Unexpected value: " + contentType);
				
		}
		
		response.setContentType("application/" + contentType);
		response.getWriter().print(jsonOrXmlResponse);
	}

}
