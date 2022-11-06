<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee</title>
</head>
<body>
	<h1>Employee Home</h1>

	<%=session.getAttribute("name")%>
	:
	<%=session.getAttribute("role")%>

	<%
	String home = getServletContext().getContextPath().concat("/logout");
	
	%>
	<a href="<%=home%>">Home</a>
</body>
</html>