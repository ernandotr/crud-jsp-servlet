<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="entrada" var="entrada"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Empresa</title>
</head>
<body>
	<c:import url="logout-parcial.jsp"></c:import>
	<h1>Cadastro de Empresa</h1>
	<hr>
	<form action="${entrada }" method="post">
		Nome: <input type="text" name="nome"> <br>
		Data Cria��o: <input type="text" name="data">
		<input type="hidden" name="acao" value="NovaEmpresa">
		<input type="submit">
	</form>
</body>
</html>