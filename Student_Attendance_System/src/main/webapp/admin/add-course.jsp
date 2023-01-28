<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>
	<c:url var="saveCourse" value="/admin/save-course"></c:url>
	<c:url var="updateCourse" value="/admin/update-course"></c:url>

	<div class="container mt-2 p-2 w-50">
		<div class="card ">
			<div class="card-header  txt-body-style ">
				<div class="card-title">
					<h3>
						<i class="bi bi-pencil-square"></i>&nbsp; Add Course
					</h3>
				</div>
			</div>
			<div class="card-body txt-style">
				<c:choose>
					<c:when test="${course != null }">
						<form action="${updateCourse }" class="form" method="post">
						
							<input type="text" value="${course.getId() }" name ="id"/>
						
							<div class="form-group mb-3">
								<label class="txt-body-style" for="course">Course Name :</label>
								<input id="course" type="text" class="form-control" name="name" value=${course.getName() } />
							</div>


							<div class="form-floating mb-3">
								<textarea name="des" class="form-control"
									placeholder="Leave a comment here" id="des"
									style="height: 100px" value = "${course.getDescription() }"></textarea>
								<label class="txt-body-style" for="des">Description</label>
							</div>


							<button class="btn w-100 mt-2 btn-style ">
								<i class="bi bi-save-fill"></i>&nbsp;Update Course
							</button>
						</form>
					</c:when>
					<c:otherwise>

						<form action="${saveCourse }" class="form" method="post">
							<div class="form-group mb-3">
								<label class="txt-body-style" for="course">Course Name :</label>
								<input id="course" type="text" class="form-control" name="name" />
							</div>


							<div class="form-floating mb-3">
								<textarea name="des" class="form-control"
									placeholder="Leave a comment here" id="des"
									style="height: 100px"></textarea>
								<label class="txt-body-style" for="des">Description</label>
							</div>


							<button class="btn w-100 mt-2 btn-style ">
								<i class="bi bi-save-fill"></i>&nbsp;Save Course
							</button>
						</form>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>




</body>
