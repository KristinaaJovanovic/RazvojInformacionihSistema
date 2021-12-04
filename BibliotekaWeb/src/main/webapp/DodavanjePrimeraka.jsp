<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dodavanje primeraka</title>
</head>
<body>
	${porukaKnjiga}<br>
	<c:if test="${!empty knjiga}">
		<form action="/BibliotekaWeb/DodavanjePrimerakaServlet" method="post">
			Broj primeraka: <input type="text" name="brPrimeraka"><br>
			<input type="submit" value="Sacuvaj">
		</form>
	</c:if>
	${porukaPrim}
	<br>
	
	<c:if test="${!empty invBrojevi }">
		<c:forEach var="br" items="${ invBrojevi}">
			${br}
		</c:forEach>
	</c:if>
</body>
</html>