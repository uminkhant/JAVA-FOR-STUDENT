<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:url var="head" value="../general/header.jsp"></c:url>
	<c:url var="foot" value="../general/footer.jsp"></c:url>
	<c:url var="signUp" value="/signUp"></c:url>

	<c:import url="${head }"></c:import>

	<div class="form-outer ">
		<form action="${signUp }" method="post" class="form-inner card-style">

			<div class="form-group">
				<label for="user" class="form-label txt-color fs-4">User Name</label> <input id="user" type="text"
					class="form-control" name="user" />
			</div>
			<div class="form-group">
				<label for="pass" class="form-label txt-color fs-4">Password </label> <input id="pass" type="password"
					class="form-control" name="pass" />
			</div>
			<br />
			<fieldset>
				<legend class="txt-color">Contact Number</legend>
				<div class="row">

					<div class="col">
						<input type="text" class="form-control"
							placeholder="Phone Number 1" aria-label="First name">
					</div>
					<div class="col">
						<input type="text" class="form-control"
							placeholder="Phone Number 2" aria-label="Last name">
					</div>
				</div>
			</fieldset>
			<br />
			<fieldset>
				<legend class="txt-color">Address</legend>
				<div class="row g-3">
					<div class="col-sm">
						<input type="text" class="form-control" placeholder="City"
							aria-label="City">
					</div>
					<div class="col-sm">
						<input type="text" class="form-control" placeholder="State"
							aria-label="State">
					</div>
					<div class="col-sm-7">
						<input type="text" class="form-control" placeholder="Address"
							aria-label="Address">
					</div>
				</div>
			</fieldset>
			<br />
			<div>
				<button class="button-color mr-1" type="submit">Submit</button>
				<button class="button-color" type="submit">Cancel</button>
			</div>
		</form>
	</div>
	<c:import url="${foot }"></c:import>
</body>
</html>