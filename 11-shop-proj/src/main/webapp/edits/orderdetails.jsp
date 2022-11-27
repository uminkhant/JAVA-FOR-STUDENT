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
	<c:url var="head" value="../general/header.jsp"></c:url>
	<c:url var="foot" value="../general/footer.jsp"></c:url>
	<c:url var="orderdetails" value="/order-detail-list"></c:url>
	<c:url var="searchDetails" value="/search-deails"></c:url>

	<c:import url="${head }"></c:import>
	<div class="container mt-4 ">
		<h3 class="txt-color">
			<i class="bi bi-stack"></i>&nbsp;Order Details
		</h3>
		<form action="${searchDetails }" method="post">
			<div class="row mb-2">
				<div class="col-4 ">
					<input class="form-control " type="search" placeholder="Search"
						aria-label="Search" name="member">
				</div>
				<div class="col-2">
					<select class="form-select" name="category">
						<option value="">Select One Category</option>
						<c:forEach var="s" items="${categories_name }">
							<option value="${s }">${s }</option>
						</c:forEach>
					</select>
				</div>
				<div class="col-2">
					<select class="form-select" name="size">
					<option value="">Select One Size</option>
						<c:forEach var="s" items="${categories_size }">
							<option value="${s }">${s }</option>
						</c:forEach>
					</select>
				</div>
				<div class="col-2">
					<select class="form-select " name="sex">
					<option value="">Select One Sex Type</option>
						<c:forEach var="s" items="${categories_sex }">
							<option value="${s }">${s}</option>
						</c:forEach>
					</select>
				</div>
				<div class="col ms-4">
					<button class="button-color anchor-link " type="submit">
						<i class="bi bi-search"></i>&nbsp;Search
					</button>
				</div>
			</div>
		</form>


		<div class="table-responsive">
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th class="col text-secondary">No</th>
						<th class="col text-secondary">Customer Name</th>
						<th class="col text-secondary">Phone 1</th>
						<th class="col text-secondary">Phone 2</th>
						<th class="col text-secondary">Item Name</th>
						<th class="col text-secondary">Item Price</th>
						<th class="col text-secondary">Item Qtys</th>
						<th class="col text-secondary">Total</th>
						<th class="col text-secondary">Order Date</th>
						<th class="col text-secondary">Delivered Date</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="od" items="${orderDetails }" varStatus="loop">
						<tr>
							<td class="col">${loop.index+1}</td>
							<td class="col">${od.getOrder().getMember().name() }</td>
							<td class="col">${od.getOrder().getMember().phoneOne() }</td>
							<td class="col">${od.getOrder().getMember().phoneTwo() }</td>
							<td class="col">${od.getItem().name() }</td>
							<td class="col">${od.getItem().price() }</td>
							<td class="col">${od.getQty() }</td>
							<td class="col">${od.getTotal() }</td>
							<td class="col">${od.getOrder().getOrder_dt() }</td>
							<td class="col"><c:url value="/update-delivered-date"
									var="updateDeliveredDate">
									<c:param name="order_id" value="${od.getOrder().getId() }"></c:param>
								</c:url> <c:if test="${od.getOrder().getDelivered_dt()==null  }">
									<a href="${updateDeliveredDate }"
										class="text-danger anchor-link  mr-2">Need to ship</a>
								</c:if> <c:if test="${od.getOrder().getDelivered_dt()!=null  }">
								${od.getOrder().getDelivered_dt()}
							</c:if></td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</div>
	<c:import url="${foot }"></c:import>
</body>
</html>