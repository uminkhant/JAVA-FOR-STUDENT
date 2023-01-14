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
						<div class="mt-2" >
							<h5>
								Student List
							</h5>
						</div>
						<div >
						<a class="txt-body-style nav-link " href="${addStudent }"><i class="bi bi-pencil-square"></i>&nbsp;Add New Student</a>
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
					<th>City</th>
					<th>Township</th>
					<th>Street</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td>Aung Aung</td>
					<td>bootcamp-3</td>
					<td>aung@gmail.com</td>
					<td>09-3242242</td>
					<td>MDY</td>
					<td>Maharmyay</td>
					<td>35 street,mahar nwezin yard</td>
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