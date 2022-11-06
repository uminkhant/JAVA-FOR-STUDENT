<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>
</head>
<body>

	<c:import url="/utility/header.jsp"></c:import>
	

	<c:url var="login" value="/login"></c:url>

	<div class="d-flex  p-2 justify-content-center align-middle">
		<form action="${login }" method="post" >

			<div class="form-group">
				<label for="user" class="form-label text-info fs-2">User
					Name</label> <input id="user" type="text" class="form-control" name="user" />
			</div>
			<div class="form-group">
				<label for="pass" class="form-label text-info fs-2">User
					Name</label> <input id="pass" type="password" class="form-control" name="pass" />
			</div>
			<br />
			<button class="btn btn-primary" type="submit">Submit</button>
		</form>
	</div>
	<c:import url="/utility/footer.jsp"></c:import>
</body>
</html>