<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rezervacija</title>
</head>
<body>
<form action="/PozoristeWEB/RezervisiServlet" method="get">
	<c:if test="${!empty mesta}">
		<tr>
			<th>Broj</th>
			<th>Red</th>
			<th>Sekcija</th>
			<th>Rezervacija</th>
		</tr>
		
		<c:forEach var="item" items="${mesta}">
			<tr>
				<td>${item.broj}</td>
				<td>${item.red}</td>
				<td>${item.sekcija}</td>
				<td>
					<a href="/PozoristeWEB/RezervisiServlet?idM=${item.idMesto}">Rezervisi</a>
				</td>
			</tr>
		</c:forEach>
	</c:if>
</form>
</body>
</html>