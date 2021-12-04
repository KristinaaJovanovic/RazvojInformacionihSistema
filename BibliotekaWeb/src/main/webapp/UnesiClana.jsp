<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Unos novog clana</title>
</head>
<body>
<c:set var="today" value="<%=new Date() %>"/>
<jsp:useBean id="katBean" class="beans.KategorijeBean" scope="session"></jsp:useBean>

<form action="/BibliotekaWeb/UnesiClanaServlet" method="post">
	<select name="idKat">
	<c:forEach var="kat" items="${katBean.k}">
		<option value="${kat.idkategorije}"> ${kat.nazivkategorije} </option>
	</c:forEach>
	</select>
	
	<br>
	Ime: <input type="text" name="ime"><br><br>
	Prezime: <input type="text" name="prezime"><br><br>	
	Adresa: <input type="text" name="adresa"><br><br>
	Datum rodjenja: <input type="date" name="datumRodjenja">(yyyy-MM-dd)<br><br>
	DatumUpisa: <input type="date" name="datumUpisa">(yyyy-MM-dd)<br><br>
	<input type="submit" value="Sacuvaj">
</form>

	${poruka}
	<c:if test="${!empty clan}">
		${clan.clanskibroj}
	</c:if>

</body>
</html>