<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<style>
body {
	padding: 2em;
}

.card {
	padding: 1.5rem;
	background-color: aqua;
	border-radius: 2px;
	margin-top: 1em;
	margin-right: 1em;
}

.login {
	display: flex;
	
}
</style>
<body>


	<h1>Hello Servlet For Listener and Filter test</h1>

	<a href="hello">Hello message</a>

	<%
	String message = (String) request.getAttribute("message");

	if (message != null) {
	%>



	<div class="card">
		<%=message%>

	</div>
	<%
	}
	%>


	<div class="login">
		<form class="card" action="login" method="post">
			<h3>Employee Form</h3>
			<input type="hidden" name="home" value="employee" />
			<div>
				<label for="user">User Name :</label> <input id="user" type="text"
					name="name" placeholder="User name !" />
			</div>
			<div>
				<label class="role">Role :</label> <select name="role">
					<option value="">Select One</option>
					<option value="manager">Manager</option>
					<option value="cashier">Cashier</option>
				</select>
			</div>
			
			<div>
				<input class="button" type="submit" value="Login" />
			</div>
		</form>
		<form class="card" action="login" method="post">
			<h3>Manager Form</h3>
			<input type="hidden" name="home" value="manager" />
			<div>
				<label for="user">User Name :</label> <input id="user" type="text"
					name="name" placeholder="User name !" />
			</div>
			<div>
				<label class="role">Role :</label> <select name="role">
					<option  value="">Select One</option>
					<option value="manager">Manager</option>
					<option value="cashier">Cashier</option>
				</select>
			</div>
			
			<div>
				<input class="button" type="submit" value="Login" />
			</div>
		</form>

		
	</div>
</body>
</html>