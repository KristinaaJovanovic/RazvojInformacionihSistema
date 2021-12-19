<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Unos novog posetioca</title>
</head>
<body>
	<form action="/PozoristeWEB/UnosPosetiocaServlet" method="post">
		Unesite ime: <input type="text" name="ime"/>
		<br><br>
		Unesite prezime: <input type="text" name="prezime">
		<br><br>
		<input type="submit" value="Unesi">
	</form>
	
	${poruka}
</body>
</html>