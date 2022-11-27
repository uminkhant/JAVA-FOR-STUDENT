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
	<c:url var="head" value="general/header.jsp"></c:url>
	<c:url var="foot" value="general/footer.jsp"></c:url>
	<c:url var="image" value="images"></c:url>
	<c:url var="searchItem" value="/searchItem"></c:url>


	<c:import url="${head }"></c:import>
	<div class="container mt-4">
		<div class="row">
			<div class="col-9">
				<form class="d-flex mb-2" action="${searchItem }" method="post" enctype="multipart/form-data">
					<input class="form-control me-2" type="search" placeholder="Search"
						aria-label="Search" name=itemName>
					<button class="button-color anchor-link" type="submit">
						<i class="bi bi-search"></i>&nbsp;Search
					</button>
				</form>
				<c:forEach var="item" items="${items }">

					<div class="card  mb-3 " style="max-width: 100%;">
						<div class="row g-0">
							<div class="col-md-4 my-auto d-block  ">
								<img src="${image }/${item.img()}"
									class="img-fluid rounded-start img-size " alt="...">
							</div>
							<div class="col-md-8">
								<div class="card-body">
									<h5 class="card-title txt-color"><i class="bi bi-star"></i>&nbsp;${item.name() }</h5>
									<p class="card-text"><span class="txt-color">Category : </span>${item.cat().name() }</p>
									<p class="card-text"><span class="txt-color">Size : </span>${item.cat().size() }</p>
									<p class="card-text"><span class="txt-color">Sex : </span>${item.cat().sex() }</p>
									<p class="card-text">${item.desc() }</p>

									<c:url value="/add-to-cart" var="addToCart">
										<c:param name="id" value="${item.id() }"></c:param>
									</c:url>
									<a href="${addToCart }" class="button-color anchor-link" style="padding:10px 15px;"><i
										class="bi bi-cart-plus-fill"></i>&nbsp;Add</a>

								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>

			<div class="col">
				<form action="${searchItem }" method="post" id="searchForm" enctype="multipart/form-data">
					<div class="card  mb-2 card-style">
						<div class="card-body">
							<div class="card-title txt-color">
								<i class="bi bi-bookmarks-fill"></i>&nbsp;CATEGORIES
							</div>
							<c:forEach var="c" items="${categories_name }">
								<div class="card-text">
									<input class="selectCat" id="${c }" type="radio"  value="${c}"
										name="category" onclick="submitOnClick('searchForm')" /> <label
										for="${c}">${c}</label>
								</div>
							</c:forEach>

						</div>
					</div>
					<div class="card  mb-2 card-style">
						<div class="card-body">
							<div class="card-title txt-color">
								<i class="bi bi-bookmarks"></i>&nbsp;SIZES
							</div>

							<c:forEach var="c" items="${categories_size }">
								<div class="card-text">
									<input class="selectCat" id="${c }" type="radio" value="${c}"
										name="size" onclick="submitOnClick('searchForm')" /> <label
										for="${c}">${c}</label>
								</div>
							</c:forEach>

						</div>
					</div>
					<div class="card  mb-2 card-style">
						<div class="card-body">
							<div class="card-title txt-color">
								<i class="bi bi-people-fill"></i>&nbsp;SEX TYPE
							</div>

							<c:forEach var="c" items="${categories_sex }">
								<div class="card-text">
									<input class="selectCat" id="${c }" type="radio" value="${c}"
										name="sex" onclick="submitOnClick('searchForm')" /> <label
										for="${c}">${c}</label>
								</div>
							</c:forEach>

						</div>
					</div>


				</form>
			</div>
		</div>
	</div>
	

	<c:import url="${foot }"></c:import>

	<script>
		
		function submitOnClick(formName) {
			document.forms[formName].submit();
		}
		
		
	</script>

</body>
</html>