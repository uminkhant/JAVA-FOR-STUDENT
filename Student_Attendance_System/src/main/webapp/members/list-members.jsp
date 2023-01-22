<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<body>

	<c:url var="addMember" value="/admin/add-member"></c:url>
	<div class="container mt-4">

		<div class="card">
			<div class="card-header txt-body-style">
				<div class="card-title d-flex justify-content-between ">
					<div class="mt-2">
						<h5>Member List</h5>
					</div>
					<div>
						<a class="txt-body-style nav-link " href="${addMember }"><i
							class="bi bi-pencil-square"></i>&nbsp;Add New Member</a>
					</div>
				</div>



			</div>
		</div>


		<table class="table table-stripped">
			<thead>
				<tr>
					<th>No.</th>
					<th>Name</th>
					<th>Password</th>
					<th>Role</th>
					<th></th>

				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td>Aung Aung</td>
					<td>bootcamp-3</td>
					<td>Admin</td>
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