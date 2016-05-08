<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div align="center">
	<form:form class="form-inline" role="form" modelAttribute="rate"
		action="addRate" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>Car Category:</td>
				<td><form:select path="cartype.category">
						<form:options items="${cartype.category}" />
					</form:select></td>
			</tr>
			<tr>
				<td>Weekly Rate:</td>
				<td><form:input type="text" path="weeklyRate" /></td>
				<td><form:errors cssStyle="color:red;" path="weeklyRate" /></td>
			</tr>
			<tr>
				<td>Daily Rate:</td>
				<td><form:input type="text" path="dailyRate" /></td>
				<td><form:errors cssStyle="color:red;" path="dailyRate" /></td>
			</tr>
			<tr>
				<td>Monthly Rate:</td>
				<td><form:input type="text" path="monthlyRate" /></td>
				<td><form:errors cssStyle="color:red;" path="monthlyRate" /></td>
			</tr>
		</table>
		<input type="submit" value="Save" />
	</form:form>
</div>
