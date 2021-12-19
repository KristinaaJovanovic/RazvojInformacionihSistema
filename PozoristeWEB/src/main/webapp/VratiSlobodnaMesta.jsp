<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spisak slobodnih mesta</title>
</head>
<body>
<form action="/PozoristeWEB/VratiSlobodnaMestaServlet" method="get">
	Unesite naziv predstave: <input type="text" name="nazivPredstave"/>
	<br><br>
	Unesite datumIzvodjenja: <input type="date" name="datumIzvodjenja">(yyyy-MM-dd)
	<br><br>
	<input type="submit" value="Unesi">
</form>
${poruka}
	<c:if test="${!empty slobodnaMesta}">
		<c:forEach var="m" items="${slobodnaMesta}">
			<tr>
				<td>${m.broj}</td> 
				<td>${m.red}</td> 
				<td>${m.sekcija}</td>
			</tr>
		</c:forEach>
	</c:if>
</body>
</html>