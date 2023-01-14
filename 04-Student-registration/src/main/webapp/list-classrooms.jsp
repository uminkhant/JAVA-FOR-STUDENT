<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<body>

	<c:url var="addClassroom" value="/admin/add-classroom"></c:url>
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
				<tr>
					<td>1</td>
					<td>javaBasic(2022-08)</td>
					<td>600000</td>
					<td>4</td>
					<td></td>
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