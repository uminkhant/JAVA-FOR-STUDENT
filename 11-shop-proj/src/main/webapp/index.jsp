<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<style>
.txt-color {
	color: #e2592a;
}


</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:url var="head" value="general/header.jsp"></c:url>
	<c:url var="foot" value="general/footer.jsp"></c:url>
	<c:url var="image" value="images"></c:url>

	<c:import url="${head }"></c:import>

<!-- Carousel  -->
<div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
     <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="3" aria-label="Slide 4"></button>
  </div>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="${image }/b3.jpg" class="d-block w-100" style="height:550px">
      <div class="carousel-caption d-none d-md-block">
        <h5>First slide label</h5>
        <p>Some representative placeholder content for the first slide.</p>
      </div>
    </div>
    <div class="carousel-item">
      <img src="${image }/b1.jpg" class="d-block w-100 " style="height:550px">
      <div class="carousel-caption d-none d-md-block">
        <h5>Second slide label</h5>
        <p>Some representative placeholder content for the second slide.</p>
      </div>
    </div>
    <div class="carousel-item">
      <img src="${image }/b4.jpg" class="d-block w-100 " style="height:550px">
      <div class="carousel-caption d-none d-md-block">
        <h5>Second slide label</h5>
        <p>Some representative placeholder content for the second slide.</p>
      </div>
    </div>
    <div class="carousel-item">
      <img src="${image }/b2.jpg" class="d-block w-100 " style="height:550px">
      <div class="carousel-caption d-none d-md-block">
        <h5>Third slide label</h5>
        <p>Some representative placeholder content for the third slide.</p>
      </div>
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>

<!-- Carousel  -->


	<div class="container mt-4">
		<div>
			<h1>Welcome</h1>
		</div>
		<div class="card border-success mb-3" style="max-width: 100%;">
			<div class="row g-0">
				<div class="col-md-4">
					<img src="${image }/b1.jpg" class="img-fluid rounded-start"
						alt="...">
				</div>
				<div class="col-md-8">
					<div class="card-body">
						<h5 class="card-title">Apple</h5>
						<p class="card-text">
							This is a wider card with supporting text below as a natural
							lead-in to additional content. This content is a little bit
							longer. <a href="#" class="card-link">More info ...</a>
						</p>
						<button type="button" class="btn btn-outline-success">Add To Cart</button>
						
					</div>
				</div>
			</div>
		</div>
		<br />
		<div class="card border-success mb-3" style="max-width: 100%;">
			<div class="row g-0">
				<div class="col-md-4">
					<img src="${image }/b2.jpg" class="img-fluid rounded-start"
						alt="...">
				</div>
				<div class="col-md-8">
					<div class="card-body">
						<h5 class="card-title">Orange</h5>
						<p class="card-text">This is a wider card with supporting text
							below as a natural lead-in to additional content. This content is
							a little bit longer. <a href="#" class="card-link">More info ...</a></p>
						<button type="button" class="btn btn-outline-success">Add To Cart</button>
					</div>
				</div>
			</div>
		</div>
		<br />
		<div class="card border-success mb-3" style="max-width:100%">
			<div class="row g-0">
				<div class="col-md-4">
					<img src="${image }/b3.jpg" class="img-fluid rounded-start"
						alt="...">
				</div>
				<div class="col-md-8">
					<div class="card-body">
						<h5 class="card-title">Orange</h5>
						<p class="card-text">This is a wider card with supporting text
							below as a natural lead-in to additional content. This content is
							a little bit longer. <a href="#" class="card-link">More info ...</a></p>
						<button type="button" class="btn btn-outline-success">Add To Cart</button>
					</div>
				</div>
			</div>
		</div>
		<c:import url="${foot }"></c:import>
</body>
</html>