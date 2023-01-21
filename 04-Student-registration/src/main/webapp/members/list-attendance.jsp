<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<c:url var="addAttendance" value="/admin/add-attendance"></c:url>
<c:url var="slClassRoom" value=""></c:url>
<body>
	<div class="container mt-4 p-2">

		<div class="card">
			<div class="card-header txt-body-style">
				<div class="card-title d-flex justify-content-between ">
					<div class="mt-2">
						<h5>Attendance List</h5>
					</div>
					<div>
						<a class="txt-body-style nav-link " href="${addAttendance }"><i
							class="bi bi-pencil-square"></i>&nbsp;Add Attendance</a>
					</div>
				</div>



			</div>
		</div>

		<div class="row mt-2 mb-2">

			<div class="col-md-8">
				<c:if test="${classrooms !=null }">

					<select class="btn btn-style p-2"
							onchange="if (this.value) window.location.href=this.value">
							<option value="" selected="selected">Select One</option>
							<c:forEach var="cr" items="${classrooms }">

								<option value="${ slClassRoom}?room=${cr.getName()}">
									${cr.getName() }</option>
							</c:forEach>
						</select>

				</c:if>

			</div>
			<div class="col-md-4 ">
				<div class="d-flex justify-content-end">
					<label class="txt-body-style" for="de">Date :&nbsp;</label> <input
						class="date-picker" id="de" type="date" name="date" />
				</div>
			</div>
		</div>

		<form action="#" class="form" method="post">

			<table class="table table-stripped">
				<thead>
					<tr>
						<th>No.</th>
						<th>Name</th>
						<th>Class Room</th>
						<th>IsAbsent</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${students != null }">
							<c:forEach var="s" items="${students }" varStatus="loop">
								<tr>
									<td>${loop.index+1 }</td>
									<td>${s.getName() }</td>
									<td>${s.getClassRoom().getName() }</td>
									<td>${s.isAbsent()}</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
								<p class="txt-body-style">There is no students </p>
						</c:otherwise>
					</c:choose>

				</tbody>
			</table>
			<div class="d-flex justify-content-end mb-2">
				<button class="btn btn-style">Save Attendance</button>
			</div>
		</form>
	</div>
</body>
</html>