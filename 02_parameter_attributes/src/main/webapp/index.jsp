<%@page import="com.jdc.mkt.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<title>Parameter and attributes</title>
</head>

<% Student stu=(Student) session.getAttribute("student"); %>

<body>

	<div class="container mt-4">
		<p class="text-danger fs-3">Hello Servlet</p>
		<form action="student" class="form" method="post">
			<div class="form-group mb-2">
				<label for="">Student Name :</label> <input type="text"
					class="form-control" name="st_name" />
			</div>
			<div class="form-group mb-2">
				<label for="">Student Age:</label> 
				<input type="text" class="form-control" name="st_age" />
			</div>
			<div class="mb-2">
			<button type="submit" class="btn btn-primary">Send</button>
			</div>
		</form>
		
		<% if(null != stu) {%>
		
			<div class="mt-2">
				<p class="text-success">Name :<%=stu.getName() %></p>
				<p class="text-success">Age :<%=stu.getAge() %></p>
			</div>
		<%} %>
	</div>
</body>
</html>