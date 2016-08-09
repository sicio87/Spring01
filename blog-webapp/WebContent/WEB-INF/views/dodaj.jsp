<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Dodaj artykuł</title>
	</head>
	<body>
		<a href="lista">Powrót do listy artykułów</a><br />
		<form:form method="POST" modelAttribute="articleDto">
			<table border="1">
				<tbody>
					<tr>
						<th>Tytuł</th>
						<td><form:input type="text" path="title" /><c:if test="${pageContext.request.method=='POST'}"><form:errors path="title" /></c:if></td>
					</tr>
					<tr>
						<th>Data publikacji</th>
						<td><form:input type="text" path="publicationDate" /><c:if test="${pageContext.request.method=='POST'}"><form:errors path="publicationDate" /></c:if></td>
					</tr>
					<tr>
						<th>Kategoria</th>
						<td><form:input type="text" path="category" /><c:if test="${pageContext.request.method=='POST'}"><form:errors path="category" /></c:if></td>
					</tr>
					<tr>
						<th>Autor</th>
						<td><form:input type="text" path="author" /><c:if test="${pageContext.request.method=='POST'}"><form:errors path="author" /></c:if></td>
					</tr>
					<tr>
						<td colspan="2" align="right"><input type="submit" value="Dodaj!" /></td>
					</tr>
				</tbody>
			</table>
		</form:form>
		<br />
		<hr />
		Uwaga! W kontekście użycia HTML oraz sposobu budowania stron, te rozwiązania są bardziej antyprzykładem niż materiałem do nauki!<br />
		Jeśli chciałabyś także tworzyć same widoki i pisac poprawny, dobrze skonstruowany kod HTML, zachęcamy do zapoznania się np. z frameworkiem <a href="http://getbootstrap.com" target="_blank">Bootstrap</a>.
	</body>
</html>