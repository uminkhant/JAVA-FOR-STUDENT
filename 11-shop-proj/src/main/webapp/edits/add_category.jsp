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
	<c:url var="addCat" value="/add_category"></c:url>

	<c:import url="${head }"></c:import>

	<div class="form-outer ">



		<form action="${addCat }" class="form-inner" method="post">
			<div>
				<p class="txt-color fs-2"><i class="bi bi-tags"></i>&nbsp;Category Form</p>
			</div>


			<div class="mb-3">
				<label for="cat" class="form-label">Category Name</label> <input
					id="cat" type="text" class="form-control" name="catName"
					aria-describedby="catName" />
				<div id="catName" class="form-text">Please fill up not more
					than 20 character!</div>
			</div>
			<div>

				<select class="form-select mb-2" name="size">
					<option selected>Please select size</option>

					<c:forEach var="s" items="${categories_size }">

						<option value="${s }">${s }</option>
					</c:forEach>
				</select>
			</div>
			<div>
				<select class="form-select mb-2" name="sex">
					<option selected>Please select sex</option>

					<c:forEach var="s" items="${categories_sex }">

						<option value="${s }">${s }</option>

					</c:forEach>
				</select>
			</div>
			<div>
				<button class="button-color  mr-2" type="submit">Save</button>
				<button class="button-color " type="reset">cancel</button>
			</div>
			<c:if test="${not empty message and message!=null }">
				<p class="txt-color">${message }</p>
			</c:if>
		</form>
	</div>

	<c:import url="${foot }"></c:import>
</body>
</html>