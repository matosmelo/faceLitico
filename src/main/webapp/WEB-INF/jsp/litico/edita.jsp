<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div id="erros">
		<ul>
			<c:forEach items="${errors}" var="error">
				<li>${error.category }-${error.message }</li>
			</c:forEach>
		</ul>
	</div>

	<table>
		<tbody>
			<ul>
				<li><a href="<c:url value="/liticos/lista"/>">Lista liticos</a></li>
				<li><a href="<c:url value="/liticos"/>">Home </a></li>
			</ul>
			<form action="<c:url value="/liticos/${litico.id }"/>" method="POST">
				<fieldset>
					<legend>Editar litico</legend>
					<input type="hidden" name="litico.id" value="${litico.id }" /> <label
						for="nome">Nome:</label> <input id="nome" type="text"
						name="litico.nome" value="${litico.nome} " /> <label
						for="partido">Partido:</label> <input id="partido" type="text"
						name="litico.partido" value="${litico.partido} " />

					<button type="submit" name="_method" value="PUT">Enviar</button>

				</fieldset>
			</form>
		</tbody>
	</table>
</body>
</html>