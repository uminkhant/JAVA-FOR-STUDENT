<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>
</head>
<body>
	<c:url var="head" value="../general/header.jsp"></c:url>
	<c:url var="foot" value="../general/footer.jsp"></c:url>
	<c:url var="signUp" value="/signUp"></c:url>

	<c:import url="${head }"></c:import>

	<c:choose>
		<c:when test="${members!=null }">
			<div class="form-outer ">
				<form action="${signUp }" method="post"
					class="form-inner card-style">
					<div class="form-group">
						 <input id="id" type="text" class="form-control d-none"
							name="id" value="${members.get(0).id() }" />
					</div>

					<div class="form-group">
						<label for="user" class="form-label txt-color fs-4">User
							Name</label> <input id="user" type="text" class="form-control"
							name="user" value="${members.get(0).name() }" />
					</div>
					<div class="form-group">
						<label for="pass" class="form-label txt-color fs-4">Password
						</label> <input id="pass" type="password" class="form-control" name="pass"
							value="${members.get(0).password() }" />
					</div>

					<div class="form-group ">
						<label for="role" class="form-label txt-color fs-4">Role</label> <select
							name="role" id="role" class="form-select mb-2">
							<option selected>Please select One</option>
							<option value="ADMIN">Admin</option>
							<option value="MEMBER">Member</option>
						</select>
					</div>

					<br />
					<fieldset>
						<legend class="txt-color">Contact Number</legend>
						<div class="row">

							<div class="col">
								<input type="text" class="form-control"
									placeholder="Phone Number 1" aria-label="Phone number 1"
									name="ph1" value="${members.get(0).phoneOne() }">
							</div>
							<div class="col">
								<input type="text" class="form-control"
									placeholder="Phone Number 2" aria-label="Phone number 2"
									name="ph2" value="${members.get(0).phoneTwo() }">
							</div>
						</div>
					</fieldset>
					<br />
					<fieldset>
						<legend class="txt-color">Address</legend>
						<div class="row g-3">
							<div class="col-sm">
								<input type="text" class="form-control" placeholder="City"
									aria-label="City" name="city"
									value="${members.get(0).address().city() }">
							</div>
							<div class="col-sm">
								<input type="text" class="form-control" placeholder="township"
									aria-label="State" name="township"
									value="${members.get(0).address().township() }">
							</div>
							<div class="col-sm-7">
								<input type="text" class="form-control" placeholder="Street"
									aria-label="Address" name="street"
									value="${members.get(0).address().street() }">
							</div>
						</div>
					</fieldset>
					<br />
					<div>
						<button class="button-color anchor-link mr-1" type="submit">Submit</button>
						<button class="button-color anchor-link mr-1" type="reset">Cancel</button>
						
					</div>

					<c:if test="${not empty message and message!=null }">
						<p class="txt-color">${message }</p>
					</c:if>
				</form>

			</div>
		</c:when>
		<c:otherwise>

			<div class="form-outer ">
				<form action="${signUp }" method="post"
					class="form-inner card-style">

					<div class="form-group">
						<label for="user" class="form-label txt-color fs-4">User
							Name</label> <input id="user" type="text" class="form-control"
							name="user" />
					</div>
					<div class="form-group">
						<label for="pass" class="form-label txt-color fs-4">Password
						</label> <input id="pass" type="password" class="form-control" name="pass" />
					</div>

					<br />
					<fieldset>
						<legend class="txt-color">Contact Number</legend>
						<div class="row">

							<div class="col">
								<input type="text" class="form-control"
									placeholder="Phone Number 1" aria-label="Phone number 1"
									name="ph1">
							</div>
							<div class="col">
								<input type="text" class="form-control"
									placeholder="Phone Number 2" aria-label="Phone number 2"
									name="ph2">
							</div>
						</div>
					</fieldset>
					<br />
					<fieldset>
						<legend class="txt-color">Address</legend>
						<div class="row g-3">
							<div class="col-sm">
								<input type="text" class="form-control" placeholder="City"
									aria-label="City" name="city">
							</div>
							<div class="col-sm">
								<input type="text" class="form-control" placeholder="township"
									aria-label="State" name="township">
							</div>
							<div class="col-sm-7">
								<input type="text" class="form-control" placeholder="Street"
									aria-label="Address" name="street">
							</div>
						</div>
					</fieldset>
					<br />
					<div>
						<button class="button-color anchor-link mr-1" type="submit">Submit</button>
						<button class="button-color anchor-link" type="submit">Cancel</button>
					</div>

					<c:if test="${not empty message and message!=null }">
						<p class="txt-color">${message }</p>
					</c:if>
				</form>

			</div>
		</c:otherwise>
	</c:choose>



	<c:import url="${foot }"></c:import>
</body>
</html>