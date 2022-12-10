
<form class="form" action="redirect" method="post">

	<div class="form-group">
		<label for="">Name :</label><input type="text" class="form-control"
			name="name" />
	</div>

	<div class="form-group">
		<label for="">Age</label><input type="number" class="form-control"
			name="age" />
	</div>
	<br />
	<button type="submit" class="btn btn-primary">Send</button>
</form>

<% String customer=(String)request.getAttribute("customer"); %>
<% if(null!=customer){ %>

<p class="text-success"><%=customer %></p>
<%} %>