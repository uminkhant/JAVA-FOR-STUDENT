<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<body>

	<c:url var="addStudent" value="/add-student"></c:url>
	<div class="container mt-4">

		<div class="card">
			<div class="card-header txt-body-style">
				<div class="card-title ">
					<div class="row">
						<div class="col-md-9 ">
							<h3>
								Student List
							</h3>
						</div>
						<div class="col-md-3 mt-2 nav-item">
						<a class="txt-body-style nav-link " href="${addStudent }"><i class="bi bi-pencil-square"></i>&nbsp;Add New Student</a>
						</div>
					</div>

				</div>

			</div>
		</div>

		<div class="row mt-2 mb-2">

			<div class="col-md-8">
				<div class="btn-group">
					<button class="btn   btn-style" type="button">Class Room</button>
					<button type="button"
						class="btn btn-style dropdown-toggle dropdown-toggle-split"
						data-bs-toggle="dropdown" aria-expanded="false">
						<span class="visually-hidden">Toggle Dropdown</span>
					</button>
					<ul class="dropdown-menu">
						<li><a href="#">Hello</a></li>
					</ul>
				</div>

			</div>

		</div>



		<table class="table table-stripped">
			<thead>
				<tr>
					<th>No.</th>
					<th>Name</th>
					<th>Class Room</th>
					<th>Email</th>
					<th>Contact</th>
					<th>Street</th>
					<th>City</th>
					<th>Township</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td>Aung Aung</td>
					<td>bootcamp-3</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</tbody>
		</table>
		<div class="justify-content-end mb-2">
			<button class="btn btn-style">Save Attendance</button>
		</div>

	</div>
</body>
</html>