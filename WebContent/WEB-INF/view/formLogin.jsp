<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="entrada" var="entrada"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h1>Login</h1>
	<hr>
	<form action="${entrada }" method="post">
		Login: <input type="text" name="login"> <br>
		Senha: <input type="password" name="senha"> <br>
		<input type="hidden" name="acao" value="Login">
		<input type="submit">
	</form>
</body>
</html>