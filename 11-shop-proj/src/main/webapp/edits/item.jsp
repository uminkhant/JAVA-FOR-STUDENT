<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:url var="head" value="../general/header.jsp"></c:url>
	<c:url var="foot" value="../general/footer.jsp"></c:url>

	<c:import url="${head }"></c:import>

	<div class="form-outer ">

		<form action="" class="form-inner">
			<div>
				<p class="txt-color fs-2">Item Form</p>
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
				
					<c:forEach var="s" items="${categories_size }">
						
						<option value="${s }">${s }</option>
					</c:forEach>
				</select>
			</div>
			<div>
				<select class="form-select mb-2">
					<option selected>Please select sex</option>
					
					<c:forEach var="s" items="${categories_sex }">
						<option value="${s }">${s}</option>
						
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