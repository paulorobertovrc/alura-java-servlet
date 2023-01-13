package gerenciador.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gerenciador.modelo.Banco;

public class RemoverEmpresa implements Action {
	public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("removendo empresa");
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Banco banco = new Banco();
		banco.remover(id);
		
		return "redirect:servletGateway?action=ListarEmpresas";
	}
}
