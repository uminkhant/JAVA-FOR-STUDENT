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
	<c:url var="addItem" value="/add_item"></c:url>
	<c:import url="${head }"></c:import>

	<div class="form-outer ">

		<form action="${addItem }" class="form-inner" method="post">
			<div>
				<p class="txt-color fs-2">Item Form</p>
			</div>
			<div class="mb-3">
				<label for="item" class="form-label">Item Name</label> <input
					id="item" type="text" class="form-control" name="itemName"
					/>
				<div id="itemName" class="form-text">Please fill up not more
					than 20 character!</div>
			</div>
			
			
			<div class="mb-3">
				<label for="price" class="form-label">Price </label> <input
					id="price" type="text" class="form-control" name="price"
					/>
				
			</div>
			
			<div class="mb-3">
				<label for="img" class="form-label">Image </label> <input
					id="img" type="text" class="form-control" name="img"
					 />
				
			</div>
			
			<div class="mb-3">
				<label for="desc" class="form-label">Description </label> <input
					id="desc" type="text" class="form-control" name="desc"
					 />
				
			</div>
				<div>

				<select class="form-select mb-2" name="category">
				
					<c:forEach var="s" items="${categories_name }">
						
						<option value="${s }">${s }</option>
					</c:forEach>
				</select>
			</div>
			<div>

				<select class="form-select mb-2" name="size">
				
					<c:forEach var="s" items="${categories_size }">
						
						<option value="${s }">${s }</option>
					</c:forEach>
				</select>
			</div>
			<div>
				<select class="form-select mb-2" name="sex">
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
			<c:if test="${not empty message and message!=null }">
				<p class="txt-color">${message }</p>
			</c:if>
		</form>
	</div>

	<c:import url="${foot }"></c:import>
</body>
</html>