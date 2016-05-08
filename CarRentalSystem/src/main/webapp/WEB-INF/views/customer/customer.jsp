<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div>
	<form:form id="form-update" action="update/${customer.id}"
		name="customer" modelAttribute="customer" method="post" enctype="multipart/form-data">

		<table>
			<tr>
				<td>FirstName:</td>
				<td><form:input type="text" path="firstName" name="firstName"
						value="${customer.firstName}" /></td>
				<td><form:errors cssStyle="color:red;" path="firstName" /></td>
			</tr>
			<tr>
				<td>LastName:</td>
				<td><form:input type="text" path="lastName" name="lastName"
						value="${customer.lastName}" /></td>
				<td><form:errors cssStyle="color:red;" path="lastName" /></td>
			</tr>
			<tr>
				<td>Licence Number:</td>
				<td><form:input type="text" path="licenceNumber"
						name="licenceNumber" value="${customer.licenceNumber}" /></td>
				<td><form:errors cssStyle="color:red;" path="licenceNumber" /></td>

			</tr>
			<tr>
				<td>Date Of Birth:</td>

				<td><form:input type="text" class="datepicker"
						path="dateOfBirth" name="dateOfBirth"
						value="${customer.dateOfBirth}" /></td>
				<td><form:errors cssStyle="color:red;" path="dateOfBirth" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input type="text" path="email" name="email"
						value="${customer.email}" /></td>
				<td><form:errors cssStyle="color:red;" path="email" /></td>
			</tr>
			<tr>
				<td>Phone:</td>
				<td><form:input type="text" path="phone" name="phone"
						value="${customer.phone}" /></td>
				<td><form:errors cssStyle="color:red;" path="phone" /></td>
			</tr>
			<tr>
				<td>City:</td>
				<td><form:input type="text" path="address.city" name="city"
						value="${customer.address.city}" /></td>
				<td><form:errors cssStyle="color:red;" path="address.city" /></td>
			</tr>
			<tr>
				<td>State:</td>
				<td><form:input type="text" path="address.state" name="state"
						value="${customer.address.state}" /></td>
				<td><form:errors cssStyle="color:red;" path="address.state" /></td>
			</tr>
			<tr>
				<td>Zip:</td>
				<td><form:input type="text" path="address.zip" name="zip"
						value="${customer.address.zip}" /></td>
				<td><form:errors cssStyle="color:red;" path="address.zip" /></td>
			</tr>
			<tr>
				<td>Street:</td>
				<td><form:input type="text" path="address.street" name="street"
						value="${customer.address.street}" /></td>
				<td><form:errors cssStyle="color:red;" path="address.street" /></td>
			</tr>
			<tr>
				<td>Upload License Image:</td>
				<td><form:input type="file" name="fileUpload" value="Upload"
						path="licenseImage" /></td>
			</tr>
			
				<tr>
			
				<td><form:input path="user.username" type="hidden" /></td>
			</tr>
			<tr>
				<td>Change Password</td>
				<td><form:input path="user.password" type="password" /></td>
			</tr>
			<tr>
				<td><form:input path="user.role" type="hidden" value="ROLE_USER" /></td>
			</tr>

		</table>
		<input type="submit" value="update" />
	</form:form>
	<%-- 	<form:form action="delete?customerId=${customer.id}" method="post"> --%>
	<form:form action="/delete/${customer.id}" method="post"
		id="form-delete">
		<button type="submit">Delete</button>
	</form:form>
</div>