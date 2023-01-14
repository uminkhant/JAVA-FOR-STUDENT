<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<body>
	<c:url var="login" value="/login"></c:url>
	<div class="container mt-4 w-50 mb-3">
		<fieldset class="border rounded-3 p-3">
			<legend  class="float-none w-auto px-3"><span
							class="txt-body-style"><i class="bi bi-person-fill"></i>
								Login </span> </a></li> </legend>


			<form action="${login }" class="form" method="post">

				<div class="form-group mb-3">
					<label for="login">Login Id :</label> <input id="login" type="text"
						class="form-control" name="loginId" />
				</div>

				<div class="form-group mb-3">
					<label for="pass">Password :</label> <input id="pass" type="text"
						class="form-control" name="password" />
				</div>

				<button class="btn w-100 mt-2 btn-style " type="submit">
					<i class="bi bi-save-fill"></i>&nbsp;Enter
				</button>
			</form>

		</fieldset>
	</div>
</body>
</html>