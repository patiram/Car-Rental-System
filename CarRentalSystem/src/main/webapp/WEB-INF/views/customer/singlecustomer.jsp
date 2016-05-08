<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<br>
<div align="center">
	<h1>Customers currently registred</h1>
	<table>
		<tr>
			<td>Fisrt Name:</td>
			<td>&emsp;&emsp;</td>
			<td>last Name:</td>
			<td>&emsp;&emsp;</td>
			<td>licence Num:</td>
			<td>&emsp;&emsp;</td>
			<td>date Of Birth</td>
			<td>&emsp;&emsp;</td>
			<td>Email:</td>
			<td>&emsp;&emsp;</td>
			<td>Phone:</td>
			<td>&emsp;&emsp;</td>
			<td>Street:</td>
			<td>&emsp;&emsp;</td>
			<td>City:</td>
			<td>&emsp;&emsp;</td>
			<td>State:</td>
			<td>&emsp;&emsp;</td>
			<td>Zip:</td>
			<td>&emsp;&emsp;</td>

			<td></td>
		</tr>
		<tr>
			<td>${customer.firstName}</td>
			<td>&emsp;&emsp;</td>
			<td>${customer.lastName}</td>
			<td>&emsp;&emsp;</td>
			<td>${customer.licenceNumber}</td>
			<td>&emsp;&emsp;</td>
			<td><fmt:formatDate value="${customer.dateOfBirth}"
					pattern="MM-dd-yyyy" /></td>
			<td>&emsp;&emsp;</td>
			<td>${customer.email}</td>
			<td>&emsp;&emsp;</td>
			<td>${customer.phone}</td>
			<td>&emsp;&emsp;</td>
			<td>${customer.address.street}</td>
			<td>&emsp;&emsp;</td>
			<td>${customer.address.city}</td>
			<td>&emsp;&emsp;</td>
			<td>${customer.address.state}</td>
			<td>&emsp;&emsp;</td>
			<td>${customer.address.zip}</td>
			<td>&emsp;&emsp;</td>

			<td><a
				href="${pageContext.request.contextPath}/${customer.id}">edit</a></td>
			<td>&emsp;&emsp;</td>
			<td><a
				href="${pageContext.request.contextPath}/delete/${customer.id}">delete</a></td>
		</tr>

	</table>

	<a href="${pageContext.request.contextPath}/customerAdd"> Add a
		Customer</a>
</div>