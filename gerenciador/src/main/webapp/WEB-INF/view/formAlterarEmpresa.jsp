<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url value="servletGateway?action=AlterarEmpresa" var="linkServletNovaEmpresa"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nova Empresa</title>
</head>
<body>
	<form action="${linkServletNovaEmpresa}" method="post">
		<input type="hidden" name="id" value="${empresa.id}">
		Nome: <input type="text" name="nome" value="${empresa.nome}">
		Data de abertura: <input type="text" name="data" value="<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>">
		<input type="submit">
	</form>
</body>
</html>