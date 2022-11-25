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


<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css"
	integrity="sha384-xeJqLiuOvjUBq3iGOjvSQSIlwrpqjSHXpduPd6rQpuiM3f5/ijby8pCsnbu5S81n"
	crossorigin="anonymous">

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js"
	integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk"
	crossorigin="anonymous"></script>



<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
	crossorigin="anonymous"></script>

<style>
body {
	font-family: "Goudy Bookletter 1911", ui-monospace !important;
}

.button-color {
	background-color: inherit;
	border: 1px solid #EB6440;
	border-radius: 10px;
	padding: 6px;
	color: #EB6440;
	width: 6em;
}

.anchor-link {
	text-decoration: none;
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

	<c:url var="editCategory" value="/editcategory"></c:url>
	<c:url var="editItem" value="/edititem"></c:url>
	<c:url var="addcategory" value="/add-category"></c:url>
	<c:url var="additem" value="/add-item"></c:url>
	<c:url var="member" value="/member"></c:url>

	<c:url var="cart" value="/cart-orders"></c:url>
	<c:url var="orderdetails" value="/order-detail-list"></c:url>
	<c:url var="home" value="/"></c:url>
	<c:url var="signup" value="/signUp"></c:url>
	<c:url var="signin" value="/login"></c:url>
	<c:url var="logout" value="/logout"></c:url>


	<nav class="navbar  navbar-expand-lg bg-light ">
		<div class="container-fluid">
			<a href="${home }" class="navbar-brand txt-color"><i
				class="bi bi-shop"></i>&nbsp;OnlineShop.mm</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#shopsupprotcontent"
				aria-controls="shopsupprotcontent" aria-expanded="false"
				aria-label="OnlineShop Myanmar">
				<span class="navbar-toggler-icon "></span>
			</button>

			<div class="collapse navbar-collapse" id="shopsupprotcontent">


				<c:choose>
					<c:when
						test="${not empty loginUser and loginUser.role().name() eq 'ADMIN'}">
						<ul class="navbar-nav me-auto mb-2 mb-lg-0 ">

							<li class="nav-item"><a href="${member }"
								class="nav-link txt-color">Member</a></li>

							<li class="nav-item dropdown "><a
								class="nav-link dropdown-toggle txt-color" href="#"
								role="button" data-bs-toggle="dropdown" aria-expanded="false">
									Category </a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link txt-color "
										href="${editCategory }">Edit Category</a></li>
									<li class="nav-item"><a class="nav-link txt-color "
										href="${addcategory }">Add Category</a></li>
								</ul></li>


							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle txt-color" href="#"
								role="button" data-bs-toggle="dropdown" aria-expanded="false">
									Item </a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link txt-color "
										href="${editItem }">Edit Item</a></li>
									<li class="nav-item"><a class="nav-link txt-color "
										href="${additem }">Add Item</a></li>
								</ul></li>

							<li class="nav-item"><a href="${orderdetails }"
								class="nav-link txt-color">Order Details</a></li>




						</ul>
					</c:when>

					<c:otherwise>
						<ul class="navbar-nav me-auto mb-2 mb-lg-0 ">
							<li class="nav-item"><a class="nav-link txt-color "
								href="${signup }"><i class="bi bi-person"></i>&nbsp;Sign Up</a></li>
							<li class="nav-item"><a class="nav-link txt-color "
								href="${signin }"><i class="bi bi-person-check"></i>&nbsp;Sign
									In</a></li>
						</ul>

					</c:otherwise>
				</c:choose>

				<div class="d-flex mx-3">
					<a class="nav-link txt-color mx-3" href="#" data-bs-toggle="modal"
						data-bs-target="#staticBackdrop"> <i
						class="bi bi-person-circle"></i>&nbsp;Login By :${loginUser.name()}
					</a> &nbsp;&nbsp; <a class="nav-link txt-color " href="${cart }"><i
						class="bi bi-cart-plus-fill">Cart</i> <c:if
							test="${orderDetailList.size()>0 }">
							<span class=" translate-middle badge rounded-pill bg-danger">&nbsp;+${orderDetailList.size() }
							</span>
						</c:if> </a>
				</div>

			</div>


		</div>
	</nav>


	<!-- Modal -->
	<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static"
		data-bs-keyboard="false" tabindex="-1"
		aria-labelledby="staticBackdropLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="txt-color" id="staticBackdropLabel">Logout Member</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				</div>
				<div class="modal-body">Do You Want To Logout From This
					Application</div>
				<div class="modal-footer">
					<a class="button-color anchor-link" data-bs-dismiss="modal">Cancel</a>
					<a class="button-color anchor-link" href="${logout }">Logout</a>
				</div>
			</div>
		</div>
	</div>



</body>
</html>