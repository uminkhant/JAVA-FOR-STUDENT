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
	<div class="container mt-4 ">

		<h1>Category</h1>
		<table class="table">
			<thead>
				<tr>
					<th class="col">No</th>
					<th class="col">Name</th>
					<th class="col">Size</th>
					<th class="col">Sex</th>
					<th class="col">Edit</th>

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
							<a href="" class="btn btn-danger mr-2">Delete</a> 
							<a href="" class="btn btn-warning mr-2">Edit</a>
						</div>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<c:import url="${foot }"></c:import>
</body>
</html>