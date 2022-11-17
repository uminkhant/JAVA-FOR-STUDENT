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

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css"
	integrity="sha384-xeJqLiuOvjUBq3iGOjvSQSIlwrpqjSHXpduPd6rQpuiM3f5/ijby8pCsnbu5S81n"
	crossorigin="anonymous">

<style>
body {
	font-family: "Goudy Bookletter 1911", ui-monospace !important;
}

.button-color {
	background-color: inherit;
	border-radius: 10px;
	color: #EB6440;
	padding: 5px;
	width: 5rem;
}

.button-color:hover {
	background-color: #EB6440;
	border-color: inherit;
	color: white;
}

.txt-color {
	color: #e2592a;
}

.img-size {
	width: 200px;
	height: 200px;
	padding: 5px;
}

.form-outer {
	display: flex;
	justify-content: center;
	margin: 5rem;
}

.form-inner {
	width: 30rem;
	background-color: #f8f9fa;
	border-radius: 1rem;
	padding: 1rem;
}

.card-style {
	box-shadow: 0 0 5px #666;
}
</style>

<title></title>
</head>
<body>

	<c:url var="category" value="/category"></c:url>
	<c:url var="item" value="/item"></c:url>
	<c:url var="sale" value="/sale"></c:url>
	<c:url var="home" value="/"></c:url>
	<c:url var="signup" value="/signUp"></c:url>
	<c:url var="signin" value="/login"></c:url>


	<nav class="navbar  navbar-expand-lg bg-light ">
		<div class="container-fluid">
			<a href="${home }" class="navbar-brand txt-color"><i
				class="bi bi-shop"></i>&nbsp;OnlineShop.mm</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#shopsupprotcontent"
				aria-controls="shopsupprotcontent" aria-expanded="false"
				aria-label="OnlineShop Myanmar">
				<span class="navbar-toggler-icon "><span
					class="visually-hidden">unread messages</span></span>
			</button>



			<div class="collapse navbar-collapse" id="shopsupprotcontent">


				<c:choose>
					<c:when
						test="${not empty loginUser and loginUser.role().name() eq 'ADMIN'}">
						<ul class="navbar-nav me-auto mb-2 mb-lg-0 ">
							<li class="nav-item"><a class="nav-link txt-color "
								href="${category }">Category</a></li>

							<li class="nav-item"><a class="nav-link txt-color "
								href="${item }">Item</a></li>
							<li class="nav-item"><a class="nav-link txt-color "
								href="${sale }">Sale</a></li>

						</ul>
					</c:when>
					<c:otherwise>
						<ul class="navbar-nav me-auto mb-2 mb-lg-0 ">
							<li class="nav-item"><a class="nav-link txt-color "
								href="${signup }"><i class="bi bi-person"></i>Sign Up</a></li>
							<li class="nav-item"><a class="nav-link txt-color "
								href="${signin }"><i class="bi bi-person-check"></i>Sign In</a></li>
						</ul>

					</c:otherwise>
				</c:choose>

				<div class="d-flex">
					<a class="nav-link txt-color mx-3" href="#"><i
						class="bi bi-person-circle"></i>&nbsp;${loginUser.name()}</a> &nbsp;&nbsp;<a
						class="nav-link txt-color" href="${sale }"><i
						class="bi bi-cart-plus-fill">Cart</i><span
						class=" top-1 translate-middle badge rounded-pill bg-danger">+1

					</span></a>
				</div>

			</div>


		</div>
	</nav>


</body>
</html>