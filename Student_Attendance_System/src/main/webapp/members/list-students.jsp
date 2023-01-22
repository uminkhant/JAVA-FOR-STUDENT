<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<body>

	<c:url var="addStudent" value="/admin/add-student"></c:url>
	<div class="container mt-4">

		<div class="card">
			<div class="card-header txt-body-style">
				<div class="card-title d-flex justify-content-between ">
					<div class="mt-2">
						<h5>Student List</h5>
					</div>
					<div>
						<a class="txt-body-style nav-link " href="${addStudent }"><i
							class="bi bi-pencil-square"></i>&nbsp;Add New Student</a>
					</div>
				</div>

			</div>


		</div>

		<div class=" mt-2 mb-2">

			<c:if  test="${classrooms !=null }">

				<select name="room" class="btn btn-style p-2">

					<c:forEach var="cr" items="${classrooms }">
						<option>${cr.getName() }</option>
					</c:forEach>
				</select>

			</c:if>
		</div>

		<table class="table table-stripped">
			<thead>
				<tr>
					<th>No.</th>
					<th>Name</th>
					<th>Class Room</th>				
					<th>Contact</th>
					<th>Email</th>
					<th>City</th>
					<th>Township</th>
					<th>Street</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${ students !=null}">

						<c:forEach var="s" items="${students }" varStatus="loop">
							<tr>
								<td>${loop.index+1 }</td>
								<td>${s.getName() }</td>
								<td>${s.getClassRoom().getName() }</td>
								<td>${s.getPhone() }</td>
								<td>${s.getEmail() }</td>
								<td>${s.getAddress().getCity() }</td>
								<td>${s.getAddress().getTownship() }</td>
								<td>${s.getAddress().getStreet() }</td>
								<td>
									<div class="d-flex justify-content-end mb-2">
										<button class="btn btn-style me-2">edit</button>
										<button class="btn btn-style">delete</button>
									</div>
								</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<p class="txt-body-style">There is no students</p>
					</c:otherwise>
				</c:choose>

			</tbody>
		</table>


	</div>
</body>
</html>