<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member</title>
</head>
<body>
	<c:url var="head" value="../general/header.jsp"></c:url>
	<c:url var="foot" value="../general/footer.jsp"></c:url>


	<c:import url="${head }"></c:import>

	<div class="container mt-4">
		<table class="table">
			<thead>
				<tr>
					<th class="col text-secondary">No</th>
					<th class="col text-secondary">Login</th>
					<th class="col text-secondary">Password</th>
					<th class="col text-secondary">Phone 1</th>
					<th class="col text-secondary">Phone 2</th>
					<th class="col text-secondary">City</th>
					<th class="col text-secondary">Township</th>
					<th class="col text-secondary">Street</th>
					<th class="col text-secondary">Edit</th>

				</tr>
			</thead>

			<tbody>
				<c:forEach var="m" items="${members }" varStatus="loop">

					<tr>
						<td class="col">${loop.index+1}</td>
						<td class="col">${m.name() }</td>
						<td class="col">${m.password() }</td>
						<td class="col">${m.phoneOne() }</td>
						<td class="col">${m.phoneTwo() }</td>
						<td class="col">${m.address().city() }</td>
						<td class="col">${m.address().township() }</td>
						<td class="col">${m.address().street() }</td>

						<td class="col"><c:url var="updateMember"
								value="/update-members">
								<c:param name="Memberid" value="${m.id() }"></c:param>
							</c:url> <a href="${updateMember }" class="btn btn-outline-warning mr-2">Edit</a>

						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<c:import url="${foot }"></c:import>
</body>
</html>