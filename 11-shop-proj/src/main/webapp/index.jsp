<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<style>
.txt-color {
	color: #e2592a;
}


</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:url var="head" value="general/header.jsp"></c:url>
	<c:url var="foot" value="general/footer.jsp"></c:url>
	<c:url var="image" value="images"></c:url>

	<c:import url="${head }"></c:import>


	<div class="container mt-4">
		<div>
			<h1>Welcome</h1>
		</div>
		<div class="card border-success mb-3" style="max-width: 100%;">
			<div class="row g-0">
				<div class="col-md-4">
					<img src="${image }/hot-item.png" class="img-fluid rounded-start"
						alt="...">
				</div>
				<div class="col-md-8">
					<div class="card-body">
						<h5 class="card-title">Apple</h5>
						<p class="card-text">
							This is a wider card with supporting text below as a natural
							lead-in to additional content. This content is a little bit
							longer. <a href="#" class="card-link">More info ...</a>
						</p>
						<button type="button" class="btn btn-outline-success">Add To Cart</button>
						
					</div>
				</div>
			</div>
		</div>
		<br />
		<div class="card border-success mb-3" style="max-width: 100%;">
			<div class="row g-0">
				<div class="col-md-4">
					<img src="${image }/hot-item.png" class="img-fluid rounded-start"
						alt="...">
				</div>
				<div class="col-md-8">
					<div class="card-body">
						<h5 class="card-title">Orange</h5>
						<p class="card-text">This is a wider card with supporting text
							below as a natural lead-in to additional content. This content is
							a little bit longer. <a href="#" class="card-link">More info ...</a></p>
						<button type="button" class="btn btn-outline-success">Add To Cart</button>
					</div>
				</div>
			</div>
		</div>
		<br />
		<div class="card border-success mb-3" style="max-width: 100%;">
			<div class="row g-0">
				<div class="col-md-4">
					<img src="${image }/hot-item.png" class="img-fluid rounded-start"
						alt="...">
				</div>
				<div class="col-md-8">
					<div class="card-body">
						<h5 class="card-title">Orange</h5>
						<p class="card-text">This is a wider card with supporting text
							below as a natural lead-in to additional content. This content is
							a little bit longer. <a href="#" class="card-link">More info ...</a></p>
						<button type="button" class="btn btn-outline-success">Add To Cart</button>
					</div>
				</div>
			</div>
		</div>
		<c:import url="${foot }"></c:import>
</body>
</html>