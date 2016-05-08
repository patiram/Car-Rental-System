<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	This page will show the List of Car.
	<%--  <h3>${booking.fare}</h3> --%>
	<form:form method="post" modelAttribute="booking"
		action="bookingcarlist">
		<table>
			<form:hidden path="dueDate" />
			<form:hidden path="pickUpDate" />
<%-- 			<c:forEach items="booking.car" var="car" varStatus="status">
				<td><label>RegistrationId</label></td>
				<td><form:input path="car[0].registrationId" type="text" /></td>
			</c:forEach>
 --%>		</table>
		<button type="submit">Next</button>
	</form:form>

	<a href="${pageContext.request.contextPath}/booking">Back</a>
	<a href="${pageContext.request.contextPath}/bookingconfirm">Next</a>
</body>
</html>