<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Brisanje clana</title>
</head>
<body>
	<form action="/BibliotekaWeb/BrisanjeClanaServlet" method="post">
		Clanski broj: <input type="text" name="clanskiBr">
		<input type="submit" value="Obrisi">
	</form>
	${poruka}
</body>
</html>