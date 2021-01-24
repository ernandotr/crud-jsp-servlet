<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="novaEmpresa" var="novaEmpresa"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Empresa</title>
</head>
<body>
	<h1>Cadastro de Empresa</h1>
	<hr>
	<form action="${novaEmpresa }" method="post">
		Nome: <input type="text" name="nome"> <br>
		Data Criação: <input type="text" name="data">
		<input type="submit">
	</form>
</body>
</html>