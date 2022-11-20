<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Category</title>
</head>
<body>
	<c:url var="head" value="../general/header.jsp"></c:url>
	<c:url var="foot" value="../general/footer.jsp"></c:url>

	<c:import url="${head }"></c:import>

	<div class="form-outer ">

		<form action="" class="form-inner">
			<div>
				<p class="txt-color fs-2">Category Form</p>
			</div>

			<div class="input-group mb-3">
				<button class="btn btn-outline-secondary dropdown-toggle"
					type="button" data-bs-toggle="dropdown" aria-expanded="false">Dropdown</button>
				<ul class="dropdown-menu">
					<li><a class="dropdown-item" href="#">Action</a></li>
					<li><a class="dropdown-item" href="#">Another action</a></li>
					<li><a class="dropdown-item" href="#">Something else here</a></li>
					<li><hr class="dropdown-divider"></li>
					<li><a class="dropdown-item" href="#">Separated link</a></li>
				</ul>
				<input type="text" class="form-control"
					aria-label="Text input with dropdown button">
			</div>
			<div class="mb-3">
				<label for="cat" class="form-label">Category Name</label> <input
					id="cat" type="text" class="form-control" name="catName"
					aria-describedby="catName" />
				<div id="catName" class="form-text">Please fill up not more
					than 20 character!</div>
			</div>
			<div>

				<select class="form-select mb-2">
					<option selected>Please select size</option>

					<c:forEach var="s" items="${categories_size }">

						<option value="${s }">${s }</option>
					</c:forEach>
				</select>
			</div>
			<div>
				<select class="form-select mb-2">
					<option selected>Please select sex</option>

					<c:forEach var="s" items="${categories_sex }">

						<option value="${s }">${s }</option>

					</c:forEach>
				</select>
			</div>
			<div>
				<button class="button-color mr-2">Save</button>
				<button class="button-color">cancel</button>
			</div>
		</form>
	</div>

	<c:import url="${foot }"></c:import>
</body>
</html>