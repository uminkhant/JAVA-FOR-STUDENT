<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
	

<title>Student Registration</title>
</head>

<c:url var="student" value="/student"></c:url>
<c:url var="course" value="/course"></c:url>

<body>
	<nav class="navbar navbar-expand-lg bg-light text-white">
		<div class="container">
		<a href="#" class="navbar-brand">Home</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#myNav">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="myNav">
			<ul class="navbar-nav">
				<li class="nav-item"><a href="${student }" class="nav-link">Student</a></li>
				<li class="nav-item"><a href="${course }" class="nav-link">Course</a></li>
				<li class="nav-item"><a href="" class="nav-link">Course</a></li>
				<li class="nav-item"><a href="" class="nav-link">About Us</a></li>
			</ul>
		</div>
		</div>
	</nav>
	

	
</body>
</html>