<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Add Student</h1>
	<form action="StudentControllerServlet" method="GET">
		<input type="hidden" name="command" value="ADD" />
		<input type="text" name="firstName" placeholder="Enter first name" /> <br>
		<input type="text" name="lastName" placeholder="Enter last name" /> <br>
		<input type="text" name="email" placeholder="Enter email" /> <br>
		<input type="submit" value="SAVE">
	</form>
	<a href="StudentControllerServlet">Back to List</a>
</body>
</html>