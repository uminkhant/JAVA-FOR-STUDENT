<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<body>

	<c:url var="addCourse" value="/admin/add-course"></c:url>
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
					<th>Fees</th>
					<th>Description</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td>JavaBasic</td>
					<td>600000</td>
					<td></td>
					<td>
						<div class="d-flex justify-content-end mb-2">
							<button class="btn btn-style me-2">edit</button>
							<button class="btn btn-style">delete</button>
						</div>
					</td>

				</tr>
			</tbody>
		</table>


	</div>
</body>
</html>