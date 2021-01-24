<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="entrada" var="entrada"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${not empty nomeEmpresa }">
		<p>Empresa ${ nomeEmpresa } cadastrada com sucesso! </p>
	</c:if>
	<h1>Empresas:</h1>
	<hr>
		<ul>
		<c:forEach items="${empresas}" var="empresa">
			<li>
				${empresa.nome} - <fmt:formatDate pattern="dd/MM/yyyy" value="${empresa.dataAbertura}" />
				<a href="${entrada }?acao=MostraEmpresa&id=${empresa.id}">Editar</a>
				<a href="${entrada }?acao=RemoveEmpresa&id=${empresa.id}">Remove</a>
			</li>
		</c:forEach>
	</ul>
</body>
</html>