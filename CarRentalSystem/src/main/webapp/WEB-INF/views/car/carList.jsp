<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">
	<div class="dropdown">
		<select id="carCat" onchange="searchCat()"
			class="btn btn-primary dropdown-toggle">
			<option value="">select category</option>
			<c:forEach var="cat" items="${category}">
				<option value="${cat }">${cat }</option>
			</c:forEach>
		</select>
	</div>
	<h2>Car List</h2>
	<div align="center" class="table-responsive">
		<table class="table table-hover" id = "carListTable">
			<tr>
				<th>ID</th>
				<th>Reg Id</th>
				<th>Registered Date</th>
				<th>Expiration Date</th>
				<th>Year</th>
				<th>Model</th>
				<th>Brand</th>
				<th>Seats</th>
				<th>Category</th>
				<th>Action</th>
				<th></th>
			</tr>
			<tbody>
				<c:forEach var="car" items="${carList}">
					<tr>
						<td>${car.id}</td>
						<td>${car.registrationId}</td>
						<td>${car.registeredDate}</td>
						<td>${car.expirationDate}</td>
						<td>${car.cartype.year }</td>
						<td>${car.cartype.model }</td>
						<td>${car.cartype.brand }</td>
						<td>${car.cartype.seats }</td>
						<td>${car.cartype.category }</td>
						<td>
							<form
								action="${pageContext.request.contextPath}/car-update/${car.id}"
								method="get">
								<button class="btn btn-info">Edit</button>
							</form>
						</td>
						<td><form
								action="${pageContext.request.contextPath}/car-delete/${car.id}"
								method="post"
								onsubmit="return confirmDelete(this, '${pageContext.request.contextPath}/car-delete/${car.id}')">
								<button type="submit" class="btn btn-danger">Delete</button>
							</form></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</div>