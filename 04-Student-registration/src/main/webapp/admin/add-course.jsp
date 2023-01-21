<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>
	<c:url var="saveCourse" value="/save-course"></c:url>
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
				<form action="${saveCourse }" class="form" method="post">

					 
					<div class="form-group mb-3">
						<label class="txt-body-style" for="course">Course Name :</label> <input id="course"
							type="text" class="form-control" name="cName" />
					</div>
					<div class="form-group mb-3">
						<label class="txt-body-style" for="fees">Fees :</label> <input id="fees" type="number"
							class="form-control" name="fees" />

					</div>

					<div class="form-floating mb-3">
						<textarea class="form-control" placeholder="Leave a comment here"
							id="des" style="height: 100px"></textarea>
						<label class="txt-body-style" for="des">Description</label>
					</div>
					

					<button class="btn w-100 mt-2 btn-style ">
						<i class="bi bi-save-fill"></i>&nbsp;Save Course
					</button>
				</form>
			</div>
		</div>
	</div>


	

</body>
