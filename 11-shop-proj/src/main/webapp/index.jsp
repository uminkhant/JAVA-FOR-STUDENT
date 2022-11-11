<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:url var="head" value="general/header.jsp"></c:url>
	<c:url var="foot" value="general/footer.jsp"></c:url>
	
	
	<c:import url="${head }"></c:import>
	
	<h1>Welcome</h1>
	
	<c:import url="${foot }"></c:import>
</body>
</html>