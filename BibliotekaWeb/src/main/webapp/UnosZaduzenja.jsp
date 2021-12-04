<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Unos novog zaduzenja</title>
</head>
<body>
<form action="/BibliotekaWeb/UnosZaduzenjaServlet" method="post">
	Clanski broj: <input type="text" name="clanskiBroj"/><br><br>
	Inventarni broj: <input type="text" name="invBroj"/><br><br>
	<input type="submit" value="Sacuvaj"/>
</form>

</body>
</html>