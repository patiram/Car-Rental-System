<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h2>Please enter valid information for new car</h2>
<div align="center">
	<form:form class="form-inline" role="form" modelAttribute="car"
		action="${pageContext.request.contextPath}/car-update/${car.id}" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>Car Registration Id:</td>
				<td><form:input type="text" path="registrationId" /></td>
				<td><form:errors cssStyle="color:red;" path="registrationId" /></td>
			</tr>
			<tr>
				<td>Car Registered Date:</td>
				<td><form:input type="text" path="registeredDate"
						class="datepicker" /></td>
				<td><form:errors cssStyle="color:red;" path="registeredDate" /></td>

			</tr>
			<tr>
				<td>Car Expiration Date:</td>
				<td><form:input type="text" path="expirationDate"
						class="datepicker" /></td>
				<td><form:errors cssStyle="color:red;" path="expirationDate" /></td>
			</tr>
			<tr>
				<td>Car Model:</td>
				<td><form:input type="text" path="cartype.model" /></td>
				<td><form:errors cssStyle="color:red;" path="cartype.model" /></td>
			</tr>
			<tr>
				<td>Car Brand:</td>
				<td><form:input path="cartype.brand" type="text" /></td>
				<td><form:errors cssStyle="color:red;" path="cartype.brand" /></td>
			</tr>
			<tr>
				<td>Manufactured Year:</td>
				<td><form:input path="cartype.year" type="text" /></td>
				<td><form:errors cssStyle="color:red;" path="cartype.year" /></td>
			</tr>
			<tr>
				<td>Number of Seats:</td>
				<td><form:input path="cartype.seats" type="text" /></td>
				<td><form:errors cssStyle="color:red;" path="cartype.seats" /></td>
			</tr>
			<tr>
				<td>Car Category:</td>
				<td><form:select path="cartype.category">
						<form:options items="${cartype.category}" />
					</form:select></td>
			</tr>
			<tr>
				<td>Air Conditioner:</td>
				<td><form:select path="cartype.airConditioner">
						<form:option value="1">Yes</form:option>
						<form:option value="0">No</form:option>
					</form:select>
			</tr>
			<tr>
				<td>Upload Picture:</td>
				<td><form:input type="file" name="fileUpload" value="Upload"
						path="carPicture" /></td>
			</tr>
			<tr>
				<td>Car Description:</td>
				<td><form:textarea path="description" type="text" /></td>
				<td><form:errors cssStyle="color:red;" path="description" /></td>
			</tr>
			<tr>
				<td>
					<h3>Rate:</h3>
				</td>
			</tr>
			<tr>
				<td>Daily Rate</td>
				<td><form:input path="cartype.rate.dailyRate" type="text" /></td>
				<td><form:errors cssStyle="color:red;"
						path="cartype.rate.dailyRate" /></td>
			
			
				<td>Weekly Rate</td>
				<td><form:input path="cartype.rate.weeklyRate" type="text" /></td>
				<td><form:errors cssStyle="color:red;"
						path="cartype.rate.weeklyRate" /></td>
			</tr>
			<tr>
				<td>Monthly Rate</td>
				<td><form:input path="cartype.rate.monthlyRate" type="text" /></td>
				<td><form:errors cssStyle="color:red;"
						path="cartype.rate.monthlyRate" /></td>
			</tr>

			
		</table>
		<input type="submit" value="Update" />
	</form:form>
</div>
