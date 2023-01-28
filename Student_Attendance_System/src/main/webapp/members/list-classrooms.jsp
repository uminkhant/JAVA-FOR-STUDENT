<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<body>

	<c:url var="addClassroom" value="/admin/add-classroom"></c:url>
	<c:url var="editClassroom" value="/admin/edit-classroom"></c:url>
	<c:url var="deleteClassroom" value="/admin/delete-classroom"></c:url>
	
	<div class="container mt-4">

		<div class="card">
			<div class="card-header txt-body-style">
				<div class="card-title d-flex justify-content-between ">
					<div class="mt-2">
						<h5>Classroom List</h5>
					</div>
					<div>
						<a class="txt-body-style nav-link " href="${addClassroom }"><i
							class="bi bi-pencil-square"></i>&nbsp;Add New Classroom</a>
					</div>
				</div>



			</div>
		</div>


		<table class="table table-stripped">
			<thead>
				<tr>
					<th>No.</th>
					<th>Room Name</th>
					<th>Fees</th>
					<th>Durations</th>
					<th>Start Date</th>
					<th>End Date</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${classrooms!=null }">
						<c:forEach var="l" items="${classrooms }" varStatus="loop">
							<tr>
								<td>${loop.index+1 }</td>
								<td>${l.getName() }</td>
								<td>${l.getFees() }</td>
								<td>${l.getDurations() }</td>
								<td>${l.getStartDate() }</td>
								<td>${l.getEndDate() }</td>
								<td>
									<div class="d-flex justify-content-end mb-2">
										<a class="btn btn-style me-2" href="${editClassroom }?id=${l.getId()}">edit</a>
										<a class="btn btn-style" href="${deleteClassroom }?id=${l.getId()}">delete</a>
									</div>
								</td>
							</tr>
						</c:forEach>

					</c:when>
					<c:otherwise>
						<p class="txt-body-style">There is no classrooms</p>
					</c:otherwise>
				</c:choose>

			</tbody>
		</table>


	</div>
</body>
</html>