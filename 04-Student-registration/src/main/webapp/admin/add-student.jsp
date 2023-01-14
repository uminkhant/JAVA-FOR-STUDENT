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
					<h3>
						<i class="bi bi-pencil-square"></i>&nbsp; Add Student
					</h3>
				</div>
			</div>
			<div class="card-body txt-style">
				<form action="${saveStudent }" class="form" method="post">

					<div class="form-group mb-3">
						<label for="stName">Student Name :</label> <input id="stName"
							type="text" class="form-control" name="stName" />
					</div>
					<div class="form-group mb-3">
						<label for="phone">Phone :</label> <input id="phone" type="text"
							class="form-control" name="phone" />
					</div>
					<div class="form-group mb-3">
						<label for="email">Email :</label> <input id="email" type="email"
							class="form-control" name="email" />
					</div>


						<fieldset class="border rounded-3 p-3">
							<legend class="float-none w-auto px-3">Address</legend>
							<label for="phone">Street :</label> <input id="street" type="text"
							class="form-control" name="street" />
							<label for="town">township :</label> <input id="town" type="text"
							class="form-control" name="township" />
							<label for="city">city :</label> <input id="city" type="text"
							class="form-control" name="city" />
						</fieldset>
				

					<button class="btn w-100 mt-2 btn-style ">
						<i class="bi bi-save-fill"></i>&nbsp;Save Student
					</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>