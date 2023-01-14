<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<body>
	<div class="container mt-4">

		<div class="card">
			<div class="card-header txt-body-style">
				<div class="card-title "><h3><i class="bi bi-pencil-square"></i>&nbsp;Attendance </h3></div>
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
			<div class="col-md-4 ">
			<div class="d-flex justify-content-end">
				<label class="txt-body-style" for="de">Date :&nbsp;</label> <input
					class="date-picker" id="de" type="date" name="date" />
			</div>
			</div>
		</div>

		<form action="#" class="form" method="post">

			<table class="table table-stripped">
				<thead>
					<tr>
						<th>No.</th>
						<th>Name</th>
						<th>Class Room</th>
						<th>Present</th>
						<th>Absent</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td>
						<td>Aung Aung</td>
						<td>bootcamp-3</td>
						<td><input class="mx-4" type="radio" name="attend"
							value="1" /></td>
						<td><input class="mx-4" type="radio" name="attend"
							value="0" /></td>
					</tr>
				</tbody>
			</table>
			<div class="d-flex justify-content-end mb-2">
				<button class="btn btn-style">Save Attendance</button>
			</div>
		</form>
	</div>
</body>
</html>