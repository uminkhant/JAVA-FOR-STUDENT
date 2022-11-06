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
	<c:import url="/utility/header.jsp"></c:import>
	<c:url var="member" value="/member"></c:url>
	<c:url var="admin" value="/admin"></c:url>
	<c:url var="logout" value="/logout"></c:url>

	<div class="container mt-4">
		<h1>Security Demo</h1>
	
		
		<div>

			<c:choose>
				<c:when test="${not empty loginUser }">
					<a href="${member }" class="btn btn-primary">Member Page</a>&nbsp;
					
					<c:if test="${isAdmin }">
						<a href="${admin }" class="btn btn-primary">Admin Page</a>&nbsp;
					</c:if>

					<a href="${logout }" class="btn btn-primary">Logout</a>
				</c:when>
				<c:otherwise>

					<a href="${member }" class="btn btn-primary">Member Page</a>&nbsp; 
					<a href="${admin }" class="btn btn-primary">Admin Page</a>



				</c:otherwise>
			</c:choose>


		</div>
	</div>
	<c:import url="/utility/footer.jsp"></c:import>
</body>
</html>