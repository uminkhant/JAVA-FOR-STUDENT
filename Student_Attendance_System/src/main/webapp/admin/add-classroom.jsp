<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<body>
	<c:url var="saveClassroom" value="/admin/save-classroom"></c:url>
	<div class="container mt-4 p-2 w-50">
		<div class="card ">
			<div class="card-header background-color txt-header-style ">
				<div class="card-title">
					<h3>
						<i class="bi bi-pencil-square"></i>&nbsp; Add Classroom
					</h3>
				</div>
			</div>
			<div class="card-body txt-style">
				<c:choose>
					<c:when test="${classroom != null }">
						<form action="${saveClassroom }" class="form" method="post">
							<input type="text" value="${classroom.getId() }" name="id" />
							<div class="d-flex justify-content-end">
								<label class="txt-body-style " for="de">Date from
									:&nbsp;</label> <input class="date-picker " id="de" type="date"
									name="start_date" value="${classroom.getStartDate() }" /> <label
									class="txt-body-style mr-2" for="de"> &nbsp;To :&nbsp;</label>
								<input class="date-picker" id="de" type="date" name="end_date"
									value="${classroom.getEndDate() }" />
							</div>


							<div class="form-group mb-3">
								<label for="room">Room Name :</label> <input id="room"
									type="text" class="form-control" name="room"
									value="${classroom.getName() }" />
							</div>

							<div class="form-group mb-3">
								<label for="fe">Fees :</label> <input id="fe" type="text"
									class="form-control" name="fee"
									value="${classroom.getFees() }" />
							</div>
							<div class="form-group mb-3">
								<label for="du">Durations :</label> <input id="du" type="text"
									class="form-control" name="durations"
									value="${classroom.getDurations() }" />
							</div>

							<button class="btn w-100 mt-2 btn-style ">
								<i class="bi bi-save-fill"></i>&nbsp;Update Class Room
							</button>
						</form>
					</c:when>
					<c:otherwise>
						<form action="${saveClassroom }" class="form" method="post">
							<div class="d-flex justify-content-end">
								<label class="txt-body-style " for="de">Date from
									:&nbsp;</label> <input class="date-picker " id="de" type="date"
									name="start_date" /> <label class="txt-body-style mr-2"
									for="de"> &nbsp;To :&nbsp;</label> <input class="date-picker"
									id="de" type="date" name="end_date" />
							</div>


							<div class="form-group mb-3">
								<label for="room">Room Name :</label> <input id="room"
									type="text" class="form-control" name="room" />
							</div>

							<div class="form-group mb-3">
								<label for="fe">Fees :</label> <input id="fe" type="text"
									class="form-control" name="fee" />
							</div>
							<div class="form-group mb-3">
								<label for="du">Durations :</label> <input id="du" type="text"
									class="form-control" name="durations" />
							</div>

							<button class="btn w-100 mt-2 btn-style ">
								<i class="bi bi-save-fill"></i>&nbsp;Save Class Room
							</button>
						</form>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
</body>
</html>