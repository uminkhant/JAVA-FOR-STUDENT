
<body>
	<c:url var="saveCourse" value="/save-course"></c:url>
	<div class="container mt-4 p-5">
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

					<div class="d-flex justify-content-end mb-3">
						<div class="me-3">
							<label class="txt-body-style" for="ds">Course Duration from :</label> <input id="ds"
								type="date" name="startDt" class="date-picker" />

						</div>
						<div>
							<label class="txt-body-style" for="de">to :</label> <input class="date-picker" id="de"
								type="date" name="endDt" />
						</div>
					</div>
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
					<button type="button" class="btn w-100 mt-2 btn-style"
						data-bs-toggle="modal" data-bs-target="#exampleModal">Add
						Course Content</button>

					<button class="btn w-100 mt-2 btn-style ">
						<i class="bi bi-save-fill"></i>&nbsp;Save
					</button>
				</form>
			</div>
		</div>
	</div>


	<!--Add Course Contents -->


	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Add Course
						Content</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">...</div>
				<div class="modal-footer">
					<button type="reset" class="btn btn-secondary"
						data-bs-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">Save
						Contents</button>
				</div>
			</div>
		</div>
	</div>

</body>
