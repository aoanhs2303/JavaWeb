<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*,com.luv2code.jsp.tagdemo.Student" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	List<Student> data = new ArrayList<>();
	data.add(new Student("Jhson", "Doe", true));
	data.add(new Student("Tran", "Luc", false));
	data.add(new Student("Le", "Loi", true));
	pageContext.setAttribute("myStudents", data);
%>
<table>
	<tr>
		<th>First name</th>
		<th>Last name</th>
		<th>Gold customer</th>
	</tr>
	
	<c:forEach var="tempStudent" items="${myStudents}">
	<c:if test="${tempStudent.goldCustomer}">
		<tr>
			<td>${tempStudent.firstName} </td>
			<td>${tempStudent.lastName}</td>
			<td>${tempStudent.goldCustomer}</td>
		</tr>
	</c:if>
	</c:forEach>
	
</table>

	
	
</body>
</html>