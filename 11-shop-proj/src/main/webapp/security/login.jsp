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

	<c:url var="head" value="../general/header.jsp"></c:url>
	<c:url var="foot" value="../general/footer.jsp"></c:url>
	<c:url var="login" value="/login"></c:url>

	<c:import url="${head }"></c:import>

	<div class="form-outer ">
		<form action="${login }" method="post" class="form-inner card-style">

			<div class="form-group">
				<label for="user" class="form-label txt-color fs-2">User
					Name</label> <input id="user" type="text" class="form-control" name="user" />
			</div>
			<div class="form-group">
				<label for="pass" class="form-label txt-color fs-2">Password
				</label> <input id="pass" type="password" class="form-control" name="pass" />
			</div>
			<br />
			<div>
				<button class="button-color anchor-link mr-1" type="submit">Submit</button>
				<button class="button-color anchor-link" type="submit">Cancel</button>
			</div>
		</form>
	</div>
	<c:import url="${foot }"></c:import>
</body>
</html>