<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Prikaz zanrova</title>
</head>
<body>
<jsp:useBean id="zBean" class="beans.ZanrBean" scope="session"></jsp:useBean>
<form action="/PozorWEB/PrikazPredstavaZaZanrServlet" method="get">
	Zanrovi: <select name="idZ">
				<c:forEach var="item" items="${zBean.z}">
					<option value="${item.idZanr}">${item.naziv}</option>
				</c:forEach>
	</select>
	
	<br/><br/>
		<input type="submit" value="Prikazi">
</form>
Predstave za odabrani zanr: ${odabraniZanr.naziv}
	<c:if test="${!empty predstave}">
	<table border="1">
		<tr>
			<th>Naziv</th>
			<th>Trajanje</th>
			<th>Opis</th>
			<th>Ime rezisera</th>
			<th>Prezime rezisera</th>
			<th>Uloge</th>
		</tr>
		<c:forEach var="item" items="${predstave}">
			<tr>
				<td>${item.naziv}</td>
				<td>${item.trajanje}</td>
				<td>${item.opis}</td>
				<td>${item.reziser.ime}</td>
				<td>${item.reziser.prezime}</td>
				<td>
					<a href="/PozorWEB/PrikazGlumacaServlet?idP=${item.idPredstava}">uloge</a>
				</td>
			</tr>
		</c:forEach>
		</table>
	</c:if>
</body>
</html>