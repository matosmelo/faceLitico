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
	<table>
		<tbody>
			<tr>
				<th>Nome</th>
				<th>partido</th>
				<th>Opção</th>
			</tr>
			<c:forEach items="${liticoList}" var="litico">
				<tr>
					<td>${litico.nome }</td>
					<td>${litico.partido }</td>

					<td><a href="<c:url value="/liticos/${litico.id}"/>">
							Editar </a></td>
					<td><form action="<c:url value="/liticos/${litico.id}"/>"
							method="POST">
							<button class="link" name="_method" value="DELETE">
								Remover</button>
						</form></td>
				</tr>
			</c:forEach>
			<div id="menu">
				<ul>
					<li><a href="<c:url value="/liticos/novo"/>"> Novo Litico
					</a></li>
					<li><a href="<c:url value="/liticos"/>"> Voltar </a></li>
				</ul>
			</div>
		</tbody>
	</table>
</body>
</html>