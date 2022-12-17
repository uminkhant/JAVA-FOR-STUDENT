<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Course</title>
</head>
<body>
	<div class="container mt-4">
		<div class="card">
			<div class="card-header">
				<div class="card-title">
					<h3>Add Course</h3>
				</div>
			</div>
			<div class="card-body">
				<form action="#" class="form" method="post">
				
				<div class="form-group">
				<label for="course">Course Name :</label>
				<input id="course" type="text" class="form-control" name="cName"/>
				</div>
				<div class="form-group">
				<label for="fees">Fees :</label>
				<input id="fees" type="number" class="form-control"name="fees"  />
				
				</div>
				<div class="form-group">
				<label for="du">Durations :</label>
				<input id="du" type="text" class="form-control" name="durations"/></div>
				
				<button class="btn btn-primary w-100 mt-2">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>