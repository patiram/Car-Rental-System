<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<br>
	<script type="text/javascript">
		$(document).ready(function() {
			var someText = '${message}';
			
			if (someText != "") {
				$('#messageModal').modal('show');
			}
		})
	</script>
<!-- 	modal added -->
<div class="modal fade" id="messageModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-body">
        Chose Another One
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
<!--  -->
<div align="center">

	<form:form id="form"
		action="${pageContext.request.contextPath}/customerAdd"
		name="customer" modelAttribute="customer" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>FirstName:</td>
				<td><form:input type="text" path="firstName" /></td>
				<td><form:errors cssStyle="color:red;" path="firstName" /></td>
			</tr>
			<tr>
				<td>LastName:</td>
				<td><form:input type="text" path="lastName" /></td>
				<td><form:errors cssStyle="color:red;" path="lastName" /></td>
			</tr>
			<tr>
				<td>License Number:</td>
				<td><form:input type="text" path="licenceNumber" /></td>
				<td><form:errors cssStyle="color:red;" path="licenceNumber" /></td>
			</tr>
			<tr>
				<td>Date Of Birth:</td>
				<td><form:input type="date" path="dateOfBirth"
						value="01-01-1900" class="datepicker" /></td>

				<td><form:errors cssStyle="color:red;" path="dateOfBirth" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input type="text" path="email" /></td>
				<td><form:errors cssStyle="color:red;" path="email" /></td>
			</tr>
			<tr>
				<td>Phone:</td>
				<td><form:input type="text" path="phone" /></td>
				<td><form:errors cssStyle="color:red;" path="phone" /></td>
			</tr>
			<tr>
				<td>City:</td>
				<td><form:input type="text" path="address.city" /></td>
				<td><form:errors cssStyle="color:red;" path="address.city" /></td>
			</tr>
			<tr>
				<td>State:</td>
				<td><form:input type="text" path="address.state" /></td>
				<td><form:errors cssStyle="color:red;" path="address.state" /></td>
			</tr>
			<tr>
				<td>Zip:</td>
				<td><form:input type="number" path="address.zip" /></td>
				<td><form:errors cssStyle="color:red;" path="address.zip" /></td>
			</tr>
			<tr>
				<td>Street:</td>
				<td><form:input type="text" path="address.street" /></td>
				<td><form:errors cssStyle="color:red;" path="address.street" /></td>
			</tr>
			<tr>
				<td>UserName</td>
				<td><form:input path="user.username" type="text" /></td>
				<td><form:errors cssStyle="color:red:" path="user.username" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><form:input path="user.password" type="password" /></td>
				<td><form:errors cssStyle="color:red:" path="user.password" /></td>
			</tr>
			<tr>
			<td>Upload License Image:</td>
				<td><form:input type="file" name="fileUpload" value="Upload"
						path="licenseImage" /></td>
			<tr>
				<td><form:input path="user.role" type="hidden" value="ROLE_USER" /></td>
			</tr>
			<%-- <tr>
			<td>Id Address</td>
			<td><form:input type="text" path="address.id"  /> </td>
			<td><form:errors cssStyle="color:red;" path="address.id" /></td>
		</tr>
		<tr>
			<td>Id:</td>
			<td><form:input type="text" path="id"  /> </td>
			<td><form:errors cssStyle="color:red;" path="id" /></td>
		</tr> --%>



		</table>
		<input type="submit" value="Save" />

	</form:form>
</div>