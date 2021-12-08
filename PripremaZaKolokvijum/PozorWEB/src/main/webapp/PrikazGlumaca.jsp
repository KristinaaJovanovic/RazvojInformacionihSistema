<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prikaz glumaca</title>
</head>
<body>
	Naziv predstave: ${predstava.naziv}
	<br><br>
	<c:if test="${!empty uloge}">
	<table border="1">
		<tr>
			<th>Ime glumca</th>
			<th>Prezime glumca</th>
			<th>Naziv uloge</th>
		</tr>
		<c:forEach var="item" items="${uloge}">
			<tr>
				<td>${item.glumac.ime}</td>
				<td>${item.glumac.prezime}</td>
				<td>${item.uloga.naziv}</td>
			</tr>
		</c:forEach>
		</table>
	</c:if>
	
</body>
</html>