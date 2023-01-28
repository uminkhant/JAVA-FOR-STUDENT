<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<body>

	<c:url var="addCourse" value="/admin/add-course"></c:url>
	<c:url var="editCourse" value="/admin/edit-course"></c:url>
	<c:url var="deleteCourse" value="/admin/delete-course"></c:url>
	<div class="container mt-4">

		<div class="card">
			<div class="card-header txt-body-style">
				<div class="card-title d-flex justify-content-between">
					<div class="mt-2">
						<h5>Course List</h5>
					</div>
					<div>
						<a class="txt-body-style nav-link " href="${addCourse }"><i
							class="bi bi-pencil-square"></i>&nbsp;Add New Course</a>
					</div>
				</div>
			</div>
		</div>




		<table class="table table-stripped">
			<thead>
				<tr>
					<th>No.</th>
					<th>Course</th>
					<th>Description</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:choose>

					<c:when test="${courses !=null }">


						<c:forEach var="co" items="${courses }" varStatus="l">
							<tr>
								<td>${l.index+1 }</td>
								<td>${co.getName() }</td>
								<td>${co.getDescription() }</td>
								<td>
									<div class="d-flex justify-content-end mb-2">
										<a class="btn btn-style me-2" href="${editCourse }?id=${co.getId()}">Edit</a>
										 <a class="btn btn-style me-2" href="${deleteCourse }?id=${co.getId()}">Delete</a>

									</div>
								</td>
							</tr>
						</c:forEach>

					</c:when>

					<c:otherwise>
						<p class="txt-body-style">There is no courses</p>
					</c:otherwise>

				</c:choose>
			</tbody>
		</table>


	</div>
</body>
</html>