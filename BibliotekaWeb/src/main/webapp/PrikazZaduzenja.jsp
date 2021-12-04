<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Prikaz zaduzenja</title>
</head>
<body>
	${poruka}
	<c:if test="${!empty zaduzenje}">
		Zaduzen clan je ${zaduzenje.clan.ime} ${zaduzenje.clan.prezime}, ${zaduzenje.clan.clanskibroj}<br>
		Zaduzen je primerak ${zaduzenje.primerak.knjiga.naslov}, inventarni broj: ${zaduzenje.primerak.invBroj}
		<br><br>
		<a href="/BibliotekaWeb/VratiZaduzenjaServlet?clanskibroj=${zaduzenje.clan.clanskibroj}">Prikaz svih zaduzenja</a>
	</c:if>
	
	<c:if test="${!empty zaduzenja}">
		<table border="1">
			<tr>
				<th>Naslov</th>
				<th>Autor</th>
				<th>Izdavac</th>
				<th>Godina izdanja</th>
				<th>Inventarni broj</th>
				<th>Datum zaduzenja</th>
				<th>Razduzenje</th>
			</tr>
			
			<c:forEach var="z" items="${zaduzenja}">
				<tr>
					<td>${z.primerak.knjiga.naslov}</td>
					<td>${z.primerak.knjiga.autor}</td>
					<td>${z.primerak.knjiga.izdavac}</td>
					<td>${z.primerak.knjiga.godinaIzdanja}</td>
					<td>${z.primerak.invBroj}</td>
					<td>${z.datumZaduzenja}</td>
					<td>
						<c:if test="${empty z.datumVracanja}">
							<a href="/BibliotekaWeb/RazduziServlet?id=${z.id}">Razduzi</a>
						</c:if>
						<c:if test="${!empty z.datumVracanja}">${z.datumVracanja}</c:if>
					</td>
					
				</tr>
			</c:forEach>
			
		</table>
	</c:if>
</body>
</html>