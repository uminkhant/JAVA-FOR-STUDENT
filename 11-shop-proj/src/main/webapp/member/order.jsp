<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Form</title>
</head>
<body>
	<c:url var="head" value="../general/header.jsp"></c:url>
	<c:url var="foot" value="../general/footer.jsp"></c:url>
	
	<c:import url="${head }"></c:import>

		<div class="container mt-4 ">

		<h3 class="txt-color">Item</h3>
		<table class="table">
			<thead>
				<tr>
					<th class="col text-secondary">No</th>
					<th class="col text-secondary">Name</th>
					<th class="col text-secondary">Price</th>
					<th class="col text-secondary">Description</th>
					<th class="col text-secondary">Category Name</th>
					<th class="col text-secondary">Category Size</th>
					<th class="col text-secondary">Category Sex</th>
					<th class="col text-secondary">Edit</th>

				</tr>
			</thead>

			<c:forEach var="i" items="${orderList }" varStatus="loop">

				<tr>
					<td class="col">${loop.index+1}</td>
					<td class="col">${i.name() }</td>
					<td class="col">${i.price() }</td>
					<td class="col">${i.desc() }</td>
					<td class="col">${i.cat().name() }</td>
					<td class="col">${i.cat().size() }</td>
					<td class="col">${i.cat().sex() }</td>
					<td class="col">
						<div class="">
							<a href="" class="btn btn-outline-danger mr-2 mb-1">Delete</a> 
							<a href="" class="btn btn-outline-warning mr-2">Edit</a>
						</div>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<c:import url="${foot }"></c:import>
</body>
</html>