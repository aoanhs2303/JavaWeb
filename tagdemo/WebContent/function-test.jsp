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
	<c:set var="data" value="trannhuluc"></c:set>
	Length of the string <b>${data}</b>: ${fn:length(data)}
	Upper case: ${fn:toUpperCase(data)}
	
	<c:set var="data" value="HaNoi,HoChiMinh,Hue"></c:set>
	<h3>Split Demo</h3>
	<c:set var="citiesArray" value="${fn:split(data,',')}"></c:set>
	<c:forEach var="city" items="${citiesArray}">
		${city} <br>
	</c:forEach>
	
</body>
</html>