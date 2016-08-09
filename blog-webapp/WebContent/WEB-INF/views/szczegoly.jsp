<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Szczegóły artykułu</title>
	</head>
	<body>
		<a href="lista">Powrót do listy artykułów</a><br />
		<table border="1">
			<tbody>
				<tr>
					<th>Tytuł</th>
					<td>${article.title}</td>
				</tr>
				<tr>
					<th>Data publikacji</th>
					<td><fmt:formatDate pattern="dd.MM.yyyy" value="${article.publicationDate}" /></td>
				</tr>
				<tr>
					<th>Kategoria</th>
					<td>${article.category}</td>
				</tr>
				<tr>
					<th>Autor</th>
					<td>${article.author}</td>
				</tr>
			</tbody>
		</table>
		<br />
		<hr />
		Uwaga! W kontekście użycia HTML oraz sposobu budowania stron, te rozwiązania są bardziej antyprzykładem niż materiałem do nauki!<br />
		Jeśli chciałabyś także tworzyć same widoki i pisac poprawny, dobrze skonstruowany kod HTML, zachęcamy do zapoznania się np. z frameworkiem <a href="http://getbootstrap.com" target="_blank">Bootstrap</a>.
	</body>
</html>