<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cookie res</title>
</head>
<body>
	<%
		String favLang = request.getParameter("lang");
		//create cookie
		Cookie cookie = new Cookie("mycookie", favLang);
		cookie.setMaxAge(60*60);
		response.addCookie(cookie);
	%>
	
	Thanks ! we set your favorite language  to: ${param.lang}
	<br>
	<a href="cookie-home.jsp">Return</a>
</body>
</html>