<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<body>
	<c:url var="saveStudent" value="/save-student"></c:url>
	<div class="container mt-4 p-5">
		<div class="card ">
			<div class="card-header background-color txt-header-style ">
				<div class="card-title">
					<h3><i class="bi bi-pencil-square"></i>&nbsp; Add Student</h3>
				</div>
			</div>
			<div class="card-body txt-style">
				<form action="${saveStudent }" class="form" method="post">

					<div class="form-group mb-3">
						<label for="course">Course Name :</label> <input id="course"
							type="text" class="form-control" name="cName" />
					</div>
					<div class="form-group mb-3">
						<label for="fees">Fees :</label> <input id="fees" type="number"
							class="form-control" name="fees" />

					</div>
					<div class="form-group mb-3">
						<label for="du">Durations :</label> <input id="du" type="text"
							class="form-control" name="durations" />
					</div>

					<button class="btn w-100 mt-2 btn-style "><i class="bi bi-save-fill"></i>&nbsp;Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>