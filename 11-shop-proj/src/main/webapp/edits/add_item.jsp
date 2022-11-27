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

		<c:choose>
			<c:when test="${item!=null }">
				<form action="${addItem }" class="form-inner" method="post"
					enctype="multipart/form-data">
					<div>
						<p class="txt-color fs-2">
							<i class="bi bi-star"></i>&nbsp;Item Form
						</p>
					</div>
					<div class="mb-3">
						<input id="price" type="text" class="form-control d-none " name="item_id"
							value="${item.id() }" />

					</div>
					<div class="mb-3">
						<label for="item" class="form-label">Item Name</label> <input
							id="item" disabled="disabled" type="text" class="form-control"
							name="itemName" value="${item.name() }" />

					</div>


					<div class="mb-3">
						<label for="price" class="form-label">Price </label> <input
							id="price" type="text" class="form-control" name="price"
							value="${item.price() }" />

					</div>

					<div class="mb-3">
						<label for="img" class="form-label">Image </label> <input id="img"
							type="file" accept="image/*" class="form-control"
							name="imageFile" value="${item.img() }" />

					</div>

					<div class="form-outline mb-3">

						<label class="form-label" for="desc">Descriptions</label>
						<textarea class="form-control" id="desc" rows="4" name="desc"
							value="${item.desc() }"></textarea>


					</div>

					<div>
						<button class="button-color  mr-2">Save</button>
						<button class="button-color ">cancel</button>
					</div>

				</form>
			</c:when>
			<c:otherwise>
				<form action="${addItem }" class="form-inner" method="post"
					enctype="multipart/form-data">
					<div>
						<p class="txt-color fs-2">
							<i class="bi bi-star"></i>&nbsp;Item Form
						</p>
					</div>
					<div class="mb-3">
						<label for="item" class="form-label">Item Name</label> <input
							id="item" type="text" class="form-control" name="itemName" />
						<div id="itemName" class="form-text">Please fill up not more
							than 20 character!</div>
					</div>


					<div class="mb-3">
						<label for="price" class="form-label">Price </label> <input
							id="price" type="text" class="form-control" name="price" />

					</div>

					<div class="mb-3">
						<label for="img" class="form-label">Image </label> <input id="img"
							type="file" accept="image/*" class="form-control"
							name="imageFile" />

					</div>

					<div class="form-outline mb-3">

						<label class="form-label" for="desc">Descriptions</label>
						<textarea class="form-control" id="desc" rows="4" name="desc"
							value="${item.desc() }"></textarea>


					</div>
					<div>

						<select class="form-select mb-2" name="category">
							<option value="">Please select category</option>
							<c:forEach var="s" items="${categories_name }">

								<option value="${s }">${s }</option>
							</c:forEach>
						</select>
					</div>
					<div>

						<select class="form-select mb-2" name="size">
							<option value="">Please select size</option>
							<c:forEach var="s" items="${categories_size }">

								<option value="${s }">${s }</option>
							</c:forEach>
						</select>
					</div>
					<div>
						<select class="form-select mb-2" name="sex">
							<option value="">Please select sex</option>

							<c:forEach var="s" items="${categories_sex }">
								<option value="${s }">${s}</option>

							</c:forEach>
						</select>
					</div>
					<div>
						<button class="button-color  mr-2">Save</button>
						<button class="button-color ">cancel</button>
					</div>

				</form>
			</c:otherwise>
		</c:choose>
	</div>

	<c:import url="${foot }"></c:import>
</body>
</html>