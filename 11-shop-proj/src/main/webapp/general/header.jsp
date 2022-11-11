<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
	crossorigin="anonymous"></script>



<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.0/css/fontawesome.min.css"></link>

<style>
.txt-color {
	color: #e2592a;
}
.txt-danger{
	color:#e2592a;
}
</style>
<title></title>
</head>
<body>

<c:url var="cat_edit" value="/edit_category"></c:url>
<c:url var="item_edit" value="/edit_item"></c:url>
<c:url var="sale" value="/sale"></c:url>

	<nav class="navbar navbar-expand-lg navbar-light bg-light ">
		<div class="container-fluid">
			<a href="#" class="navbar-brand txt-color">Shop.mm</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#shopsupprotcontent"
				aria-controls="shopsupprotcontent" aria-expanded="false"
				aria-label="Shop Myanmar">
				<span class="navbar-toggler-icon "><span
					class="visually-hidden">unread messages</span></span>
			</button>



			<div class="collapse navbar-collapse" id="shopsupprotcontent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link txt-color " href="${cat_edit }">Category</a></li>

					<li class="nav-item"><a class="nav-link txt-color" href="${item_edit }">Item<span
							class=" top-1  translate-middle badge rounded-pill bg-secondary">+99

						</span></a></li>
					<li class="nav-item"><a class="nav-link txt-color" href="${sale }"><i
							class="fa fa-shopping-cart"></i>Sale<span
							class=" top-1 translate-middle badge rounded-pill bg-secondary">+99

						</span></a></li>

				</ul>

			</div>


		</div>
	</nav>


</body>
</html>