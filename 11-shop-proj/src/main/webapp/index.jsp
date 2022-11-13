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

.img-size {
	width: 300px;
	hight: 300px;
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
		<div class="row">
			<div class="col-9">

				<div class="card border-success mb-3" style="max-width: 100%;">
					<div class="row g-0">
						<div class="col-md-4">
							<img src="${image }/sh1.jpg"
								class="img-fluid rounded-start img-size" alt="...">
						</div>
						<div class="col-md-8">
							<div class="card-body">
								<h5 class="card-title txt-color">Shirt</h5>
								<p class="card-text txt-color">
									This is a wider card with supporting text below as a natural
									lead-in to additional content. This content is a little bit
									longer. <a href="#" class="card-link ">More info ...</a>
								</p>
								<button type="button" class="btn btn-outline-info txt-color">Add
									To Cart</button>

							</div>
						</div>
					</div>
				</div>

				<div class="card border-success mb-3" style="max-width: 100%;">
					<div class="row g-0">
						<div class="col-md-4">
							<img src="${image }/so1.jpg"
								class="img-fluid rounded-start img-size" alt="...">
						</div>
						<div class="col-md-8">
							<div class="card-body">
								<h5 class="card-title">Shoes</h5>
								<p class="card-text">
									This is a wider card with supporting text below as a natural
									lead-in to additional content. This content is a little bit
									longer. <a href="#" class="card-link">More info ...</a>
								</p>
								<button type="button" class="btn btn-outline-success">Add
									To Cart</button>
							</div>
						</div>
					</div>
				</div>
				<br />
				<div class="card border-success mb-3" style="max-width: 100%">
					<div class="row g-0">
						<div class="col-md-4">
							<img src="${image }/tr1.jpeg"
								class="img-fluid rounded-start img-size" alt="...">
						</div>
						<div class="col-md-8">
							<div class="card-body">
								<h5 class="card-title">Trousers</h5>
								<p class="card-text">
									This is a wider card with supporting text below as a natural
									lead-in to additional content. This content is a little bit
									longer. <a href="#" class="card-link">More info ...</a>
								</p>
								<button type="button" class="btn btn-outline-success">Add
									To Cart</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col">
				<div class="card border-success">
					<div class="card-body">
						<div class="card-title">Categories</div>
						<form action="#" method="post">
							<c:forEach var="c" items="${categories }">
								<div class="card-text">
									<input id="${c.name() }" type="radio" value="${c.name() }" />
									<label for="${c.name() }">${c.name()}</label>
								</div>
							</c:forEach>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<c:url var="searchCat" value="/searchByCat"></c:url>
	<form action="${searchCat }" class="d-none" method="post"></form>

	<c:import url="${foot }"></c:import>
	<!-- <script type="text/javascript">
		$(() => {
			$(".selectCat").click(() => $("#uploadFile").click());
		})
	</script> -->
</body>
</html>