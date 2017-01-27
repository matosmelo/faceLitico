<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Busca</title>
</head>
<body>
	<h3>Resultados da busca pelo nome</h3>
	<!-- 	Mostra valores da pagina lista  -->
	<%-- 	<%@ include file="lista.jsp"%> --%>
	<ul>
		<li><a href="<c:url value="/liticos/lista"/>">Lista liticos</a></li>
		<li><a href="<c:url value="/liticos/pesquisa"/>">Pesquisar</a></li>
		<li><a href="<c:url value="/liticos"/>">Home</a></li>
	</ul>
	<div id="resultadoBusca">
		<table>
			<tr>
				<th>Nome</th>
				<th>Partido</th>
			</tr>
			<c:forEach items="${liticoList}" var="litico">
				<tr>
					<td>${litico.nome}</td>
					<td>${litico.partido}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>