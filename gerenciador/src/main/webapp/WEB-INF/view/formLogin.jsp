<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="servletGateway?action=Login" var="linkServletLogin"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<form action="${linkServletLogin}" method="post">
		Login: <input type="text" name="login">
		Senha: <input type="password" name="senha">
		<input type="submit">
	</form>
</body>
</html>