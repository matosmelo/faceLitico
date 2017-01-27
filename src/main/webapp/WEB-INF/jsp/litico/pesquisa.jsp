<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
</head>

<body>
	<ul>
		<li><a href="<c:url value="/liticos/lista"/>">Lista liticos</a></li>
		<li><a href="<c:url value="/liticos"/>">Home</a></li>
	</ul>
	<form action="<c:url value="/liticos/busca"/>">

		<input type="text" name="nome">
		<button type="submit" name="action">Pesquisar</button>
	</form>
</body>
</html>
