<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Unos rezervacije</title>
</head>
<body>
<form action="/PozoristeWEB/RezervacijeServlet" method="post">
	Id posetioca: <input type="text" name="idP"><br><br>
	<input type="submit" value="Sacuvaj">
</form>

${poruka}

</body>
</html>