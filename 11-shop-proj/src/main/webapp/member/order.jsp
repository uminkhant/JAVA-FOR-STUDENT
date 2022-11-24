<%@page import="com.jdc.mkt.model.OrderDetail"%>
<%@page import="com.jdc.mkt.model.Item"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Form</title>
</head>
<body>
	<c:url var="head" value="../general/header.jsp"></c:url>
	<c:url var="foot" value="../general/footer.jsp"></c:url>
	<c:url var="takeOrder" value="/take-order"></c:url>



	<c:import url="${head }"></c:import>

	<div class="container mt-4 ">

		<h3 class="txt-color">Order Form</h3>
		<table class="table">
			<thead>
				<tr>
					<th class="col text-secondary">No</th>
					<th class="col text-secondary">Name</th>
					<th class="col text-secondary">Price</th>
					<th class="col text-secondary">Qtys</th>
					<th class="col text-secondary">Total</th>
					<th class="col text-secondary">Category Name</th>
					<th class="col text-secondary">Category Size</th>
					<th class="col text-secondary">Category Sex</th>
					<th class="col text-secondary">Edit</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="i" items="${orderDetailList }" varStatus="loop">

					<tr>
						<td class="col">${loop.index+1}</td>
						<td class="col">${i.getItem().name() }</td>
						<td class="col">${i.getItem().price() }</td>
						<td class="col">${i.getQty() }</td>
						<td class="col">${i.getQty()*i.getItem().price() }</td>
						<td class="col">${i.getItem().cat().name() }</td>
						<td class="col">${i.getItem().cat().size() }</td>
						<td class="col">${i.getItem().cat().sex() }</td>
						<td class="col">
							<div class="">
								<a href="" class="btn btn-outline-danger mr-2">Delete</a> <a
									href="" class="btn btn-outline-warning mr-2">Edit</a>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>

		</table>

		<form action="${takeOrder }" method="post">
			<table class="table">
				<thead>
					<tr>
						<th class="col text-secondary">Name</th>
						<th class="col text-secondary">Qtys</th>
						<th class="col text-secondary">Total</th>

					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Totals</td>
						<td>${qtys }</td>
						<td>${total }</td>

					</tr>
					<tr>
						<td class="col">
							<div class="">
								<button type="submit" class="btn btn-outline-danger mr-2">Order
									Now</button>
								<button type="submit" class="btn btn-outline-warning mr-2">Cancel</button>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	<c:import url="${foot }"></c:import>
</body>
</html>