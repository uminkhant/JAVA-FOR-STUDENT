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
	<c:import url="/utility/header.jsp"></c:import>

	<div class="container mt-4">
		<h1 class="text-primary">Home Page</h1>
		<p class="text-success">Welcome to ${userName }</p>
	</div>

	<c:import url="/utility/footer.jsp"></c:import>
</body>
</html>