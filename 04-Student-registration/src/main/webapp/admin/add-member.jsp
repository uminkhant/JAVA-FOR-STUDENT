<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<body>
	<c:url var="saveMember" value="/save-member"></c:url>
	<div class="container mt-4 p-5">
		<div class="card ">
			<div class="card-header background-color txt-header-style ">
				<div class="card-title">
					<h3>
						<i class="bi bi-pencil-square"></i>&nbsp; Add Member
					</h3>
				</div>
			</div>
			<div class="card-body txt-style">
				<form action="${saveMember }" class="form" method="post">

					<div class="form-group mb-3">
						<label for="mName">Member Name :</label> <input id="mName"
							type="text" class="form-control" name="mName" />
					</div>
					<div class="form-group mb-3">
						<label for="mPass">Password :</label> <input id="mPass"
							type="text" class="form-control" name="pass" />
					</div>

					<div class="form-group mb-3">
						<label for="role">Role :</label> <select class="form-select"
							name="role" id="role">
							<option >Select Role</option>
							<option value="admin">Admin</option>
							<option value="member">Member</option>
							 
						</select>
					</div>
					

					<button class="btn w-100 mt-2 btn-style ">
						<i class="bi bi-save-fill"></i>&nbsp;Save Member
					</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>