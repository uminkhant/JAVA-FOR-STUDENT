<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<style><%@include file="/resources/style.css" %></style>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css"
	integrity="sha384-b6lVK+yci+bfDmaY1u0zE8YYJt0TZxLEAFyYSLHId4xoVvsrQu3INevFKo+Xir8e"
	crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@1,300&display=swap"
	rel="stylesheet">
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

<c:url var="students" value="/list-students"></c:url>
<c:url var="courses" value="/list-courses"></c:url>
<c:url var="classroom" value="/list-classrooms"></c:url>
<c:url var="members" value="/list-members"></c:url>

<c:url var="attendance" value="/add-attendance"></c:url>
<c:url var="home" value="/home"></c:url>

<body>
	<nav class="navbar navbar-expand-lg background-color  ">
		<div class="container ">

			<a href="${home }" class="navbar-brand  txt-header-style"><i
				class="bi bi-house-gear-fill"></i>&nbsp; JDC</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#myNav">
				<span> <i class="bi bi-columns-gap txt-header-style"></i></span>
			</button>
			<div class="collapse navbar-collapse justify-content-between "
				id="myNav">
				<ul class="navbar-nav ">
				<li class="nav-item"><a href="${attendance }"
						class="nav-link txt-header-style"><span
							class="txt-header-style">Attendance</span></a></li>
					<li class="nav-item"><a href="${students }" class="nav-link "><span
							class="txt-header-style">Students</span></a></li>
					<li class="nav-item"><a href="${courses }" class="nav-link "><span
							class="txt-header-style">Courses </span> </a></li>
							<li class="nav-item"><a href="${classroom }" class="nav-link "><span
							class="txt-header-style">Classroom </span> </a></li>
					
					<li class="nav-item"><a href="${members }" class="nav-link "><span
							class="txt-header-style"> Members</span> </a></li>
				</ul>
				<ul class="navbar-nav ">

					<li class="nav-item"><a href="#" class="nav-link "><span
							class="txt-header-style"><i class="bi bi-person-fill"></i>
								<c:if test="${ not empty userName  }">
								<c:out value="${userName }"></c:out>
								</c:if>
								
								
								</span> </a></li>
				</ul>
			</div>
		</div>
	</nav>



</body>
</html>