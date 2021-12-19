<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Unos novog glumca</title>
</head>
<body>
<jsp:useBean id="predBean" class="beans.PredstaveBean" scope="session"></jsp:useBean>
	<form action="/PozoristeWEB/UnosGlumcaServlet" method="post">
		Unesite ime glumca: <input type="text" name="ime"/>
		<br><br>
		Unesite prezime glumca: <input type="text" name="prezime"/>
		<br><br>
		<input type="submit" value="Unesi">
	</form>
	${poruka}
	<br><br>
	<form action="/PozoristeWEB/PrikazUlogaServlet" method="get">
		Predstava: <select name="idPred">
			<c:forEach var="item" items="${predBean.p}">
				<option value="${item.idPredstava}">${item.naziv}</option>
			</c:forEach>
		</select>
		<input type="submit" value="Prikaz uloga">
	</form>
	
	<c:if test="${!empty uloge}">
		<form action="/PozoristeWEB/SacuvajUloguGlumcaServlet" method="post">
			Uloge u predstavi: <select name="idUlog">
				<c:forEach var="item" items="${uloge}">
					<option value="${item.idUloga}">${item.naziv}</option>
				</c:forEach>	
			</select>
			<input type="submit" value="Sacuvaj">
		</form>
	
	</c:if>
	
	${porukica}
	<br><br>
	<c:if test="${!empty glumi}">
		Naziv uloge: ${glumi.uloga.naziv}
		Predstava: ${glumi.uloga.predstava.naziv}
		Glumac: ${glumi.glumac.ime} ${glumi.glumac.prezime} <br>
	</c:if>
	
	
</body>
</html>