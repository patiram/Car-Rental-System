<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div>
<form id="form-search"  action="${pageContext.request.contextPath}/search/"  method="post">
	<table>
	<tr>
			<td>	
					<select  name="search">
					<option value="1">Licence</option>
					<option value="2">Frist Name</option>
					<option value="3">Last Name</option>
					<option value="4">Zip</option>
					<option value="5">State</option>
					</select>	
			</td>
			<td><input type="text" name="str"  /> </td>
			<td><input type="submit" name="submit" value ="Search"/></td>
	</tr>
		
	</table>
</form> 
</div>