<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="entrada" var="entrada"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Empresa</title>
</head>
<body>
	<h1>Cadastro de Empresa</h1>
	<hr>
	<form action="${entrada }" method="post">
		<input type="hidden" name="id" value="${empresa.id }">
		<input type="hidden" name="acao" value="AlteraEmpresa">
		Nome: <input type="text" name="nome" value="${empresa.nome }"> <br>
		Data Criação: <input type="text" name="data" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${empresa.dataAbertura}" />">
		<input type="submit">
	</form>
</body>
</html>