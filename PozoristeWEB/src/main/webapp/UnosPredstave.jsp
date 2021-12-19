<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Unos nove predstave</title>
</head>
<body>
<form action="/PozoristeWEB/UnosPredstaveServlet" method="post">
	Unesite naziv predstave: <input type="text" name="nazivPredstave"/><br><br>
	<input type="submit" value="Unesi"/>
</form>
	${poruka}
	<br>
	<c:if test="${!empty  izvodjenja}">
		<table border="1">
			<tr>
				<th>Datum izvodjenja</th>
				<th>Naziv predstave</th>
				<th>Trajanje predstave</th>
				<th>Naziv scene</th>
				<th>Rezervacija</th>
			</tr>
			
			<c:forEach var="izv" items="${izvodjenja}">
				<tr>
					<td>${izv.datum}</td> 
					<td>${izv.predstava.naziv}</td> 
					<td>${izv.predstava.trajanje}</td> 
					<td>${izv.scena.naziv}</td>
					<td>
						<a href="/PozoristeWEB/VratiSlobodnaMServlet?id=${izv.idIzvodjenje}">Rezervisi</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		
	</c:if>

</body>
</html>