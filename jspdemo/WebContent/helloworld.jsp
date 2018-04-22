<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hoc Java</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<h3>Hello World of Java</h3>
	The time on the server is <%= new java.util.Date() %>
	
	Converting a string to upper case <%= new String("Hello World").toUpperCase() %>
	
	25*4 = <%= 25*4 %>
	
	<% 
		for(int i = 1; i < 5; i++) {
			out.println("<br> Java:" + i);
		}
	%>
	
	<%! 
		String makeItLower(String data) {
			return data.toLowerCase();
		}
	%>
	
	Lower case Hello World: <%= makeItLower("Hello World") %>
	<br>
	Class call: <%= com.luv2code.jsp.FunUtils.makeItLower("Tran Nhu Luc") %>
	<br>
	Request user: <%= request.getHeader("User-Agent") %>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>