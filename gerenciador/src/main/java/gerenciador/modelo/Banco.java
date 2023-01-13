package gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {
	
	private static List<Empresa> lista = new ArrayList<>();
	private static List<Usuario> listaUsuarios = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	
	static {
		Empresa empresa1 = new Empresa();
		empresa1.setId(Banco.chaveSequencial++);
		empresa1.setNome("Alura");
	
		Empresa empresa2 = new Empresa();
		empresa2.setNome("Caelum");
		empresa2.setId(Banco.chaveSequencial++);
		
		lista.add(empresa1);
		lista.add(empresa2);
		
		Usuario usr1 = new Usuario();
		usr1.setLogin("paulo");
		usr1.setSenha("1234");
		
		Usuario usr2 = new Usuario();
		usr2.setLogin("nico");
		usr2.setSenha("0000");
		
		listaUsuarios.add(usr1);
		listaUsuarios.add(usr2);
	}
	
	public void adicionar(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		Banco.lista.add(empresa);
	}
	
	public List<Empresa> getEmpresas() {
		return Banco.lista;
	}

	public void remover(Integer id) {
		Iterator<Empresa> iterator = lista.iterator();
		while(iterator.hasNext()) {
			Empresa empresa = iterator.next();
			if (empresa.getId() == id) {
				iterator.remove();
			}
		}
	}

	public Empresa buscarPeloId(Integer id) {
		for (Empresa empresa : lista) {
			if (empresa.getId() == id) {
				return empresa;
			}
		}
		
		return null;
	}

	public Usuario usuarioExiste(String login, String senha) {
		for (Usuario usuario : listaUsuarios) {
			if (usuario.ehIgual(login, senha)) {
				return usuario;
			}
		}
		
		return null;
	}
	
}
