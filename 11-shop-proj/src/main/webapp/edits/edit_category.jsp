<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>edit category</title>
</head>
<body>
	<c:url var="head" value="../general/header.jsp"></c:url>
	<c:url var="foot" value="../general/footer.jsp"></c:url>


	<c:import url="${head }"></c:import>
	<div class="container mt-4 ">

		<h3 class="txt-color">
			<i class="bi bi-tags"></i>&nbsp;CATEGORY
		</h3>
		<table class="table">
			<thead>
				<tr>
					<th class="col text-secondary">No</th>
					<th class="col text-secondary">Name</th>
					<th class="col text-secondary">Size</th>
					<th class="col text-secondary">Sex</th>
					<th class="col text-secondary">Edit</th>

				</tr>
			</thead>

			<c:forEach var="c" items="${categories }" varStatus="loop">

				<tr>
					<td class="col">${loop.index+1}</td>
					<td class="col">${c.name() }</td>
					<td class="col">${c.size() }</td>
					<td class="col">${c.sex() }</td>
					<td class="col">
						<div class="">
							<c:url var="deleteCat" value="/delete_category">
								<c:param name="cat_id" value="${c.id() }"></c:param>
							</c:url>
							<a href="${deleteCat }" class="btn btn-outline-danger mr-2">Delete</a>
							
							<c:url var="updateCat" value="/update_category">
								<c:param name="cat_id" value="${c.id() }"></c:param>
							</c:url>
							<a href="${updateCat }" class="btn btn-outline-warning mr-2">Edit</a>
						</div>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<c:import url="${foot }"></c:import>
</body>
</html>