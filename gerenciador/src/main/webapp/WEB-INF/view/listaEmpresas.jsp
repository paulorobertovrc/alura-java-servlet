<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, gerenciador.modelo.Empresa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java Standard Tag Library</title>
</head>
<body>
	Usuário logado: ${usuarioLogado.login}
	
	<br>
	<br>

	Lista de empresas: <br />

	<ul>
		<c:forEach items="${empresas}" var="empresa">
			<li>
				${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>
				<a href="/gerenciador/servletGateway?action=MostrarEmpresa&id=${empresa.id}">editar</a>
				<a href="/gerenciador/servletGateway?action=RemoverEmpresa&id=${empresa.id}">remover</a>
			</li>
		</c:forEach>
	</ul>
<a href="/gerenciador/servletGateway?action=NovaEmpresaForm">cadastrar</a>
<a href="/gerenciador/servletGateway?action=Logout">sair</a>
</body>
</html>
