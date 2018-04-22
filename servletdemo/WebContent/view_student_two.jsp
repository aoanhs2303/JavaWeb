<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>Name</th>
			<th>Age</th>
			<th>Email</th>
		</tr>
	<c:forEach var="tempStudent" items="${student_list}">
		<tr>
			<td>${tempStudent.name}</td>
			<td>${tempStudent.age}</td>
			<td>${tempStudent.email}</td>
		</tr>
	</c:forEach>
	</table>	
</body>
</html>