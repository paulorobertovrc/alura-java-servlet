package gerenciador.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NovaEmpresaForm implements Action {
	public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		return "forward:formNovaEmpresa.jsp";
	}
}
