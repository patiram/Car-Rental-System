
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

Filter the car by selecting the categories of car you are looking for.
<c:url var="home" value="/" scope="request" />
<form:form modelAttribute="booking">
	<div id="bookingCardate">
		<%-- From:
		<form:input path="pickUpDate" type="text" class="datepicker" />
		To:
		<form:input path="dueDate" type="text" class="datepicker" />
		<br> --%> Type:
		<form:select path="car.cartype.category" id="carCategory"
			onchange="searchCat()" class="btn btn-primary dropdown-toggle">
			<option value="">select category</option>
			<form:options items="${category}" />
		</form:select>

		<div class="container-fluid" id="parent"></div>
		
		<div class="modal fade" tabindex="-1" role="dialog"
			id="addCategoryModal">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title"><b>Car Booked Successfully</h4>
					</div>
					<div class="modal-body">
						<b><p class= "text-success">Car Booked Successfully</p></b>
						
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-dismiss="modal">OK</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<%-- <img alt="sfdfs" src="${listCarEconomy[0].urlPicture}"> --%>
		<script>
			$("#carCategory")
					.change(
							function() {
								var selected = $("#carCategory option:selected")
										.text();
								var selectedLoop = null;
								var html = null;
								if (selected == "ECONOMIC") {
									var html = '<div class="col-md-12"><c:forEach items="${listCarEconomy}" var="car"><div class="col-md-4"><div class="col-md-12"><div class="thumbnail"><img alt="sfdfs" style="width:150px;height:150px" src="${car.urlPicture}"><div class="caption"><b>Brand: ${car.cartype.brand}<br>Year: ${car.cartype.year}<br>Model: ${car.cartype.model}<br>Seats: ${car.cartype.seats}<br>Air Conditioner: ${car.cartype.airConditioner}<br>Daily Rate:${car.cartype.rate.dailyRate}<br>Weekly Rate:${car.cartype.rate.weeklyRate}<br>Monthly Rate:${car.cartype.rate.monthlyRate}<b><br>Description: ${car.description}<br><input class="btn btn-primary"  role="button"  onclick="myFunction(${car.id})" value = "Book Now"/></div></div></div></div></c:forEach></div>';
								} else if (selected == "LUXUARY") {
									var html = '<div class="col-md-12"><c:forEach items="${listLuxuary}" var="car"><div class="col-md-4"><div class="col-md-12"><div class="thumbnail"><img alt="sfdfs" style="width:150px;height:150px" src="${car.urlPicture}"><div class="caption"><b>Brand: ${car.cartype.brand}<br>Year: ${car.cartype.year}<br>Model: ${car.cartype.model}<br>Seats: ${car.cartype.seats}<br>Air Conditioner: ${car.cartype.airConditioner}<br>Daily Rate:${car.cartype.rate.dailyRate}<br>Weekly Rate:${car.cartype.rate.weeklyRate}<br>Monthly Rate:${car.cartype.rate.monthlyRate}<b><br>Description: ${car.description}<br><button class="btn btn-primary" role="button"  onclick="myFunction()">Book Now</button></div></div></div></div></c:forEach></div>';
								} else if (selected == "STANDARD") {
									var html = '<div class="col-md-12"><c:forEach items="${listCarStandard}" var="car"><div class="col-md-4"><div class="col-md-12"><div class="thumbnail"><img alt="sfdfs" style="width:150px;height:150px" src="${car.urlPicture}"><div class="caption"><b>Brand: ${car.cartype.brand}<br>Year: ${car.cartype.year}<br>Model: ${car.cartype.model}<br>Seats: ${car.cartype.seats}<br>Air Conditioner: ${car.cartype.airConditioner}<br>Daily Rate:${car.cartype.rate.dailyRate}<br>Weekly Rate:${car.cartype.rate.weeklyRate}<br>Monthly Rate:${car.cartype.rate.monthlyRate}<b><br>Description: ${car.description}<br><button class="btn btn-primary" role="button"  onclick="myFunction()">Book Now</button></div></div></div></div></c:forEach></div>';
								} else {
									var html = '<div class="col-md-12"><c:forEach items="${listBusiness}" var="car"><div class="col-md-4"><div class="col-md-12"><div class="thumbnail"><img alt="sfdfs" style="width:150px;height:150px" src="${car.urlPicture}"><div class="caption"><b>Brand: ${car.cartype.brand}<br>Year: ${car.cartype.year}<br>Model: ${car.cartype.model}<br>Seats: ${car.cartype.seats}<br>Air Conditioner: ${car.cartype.airConditioner}<br>Daily Rate:${car.cartype.rate.dailyRate}<br>Weekly Rate:${car.cartype.rate.weeklyRate}<br>Monthly Rate:${car.cartype.rate.monthlyRate}<b><br>Description: ${car.description}<br><button class="btn btn-primary" role="button"  onclick="myFunction()">Book Now</button></div></div></div></div></c:forEach></div>';
								}
								$("#child1").remove()
								$("#parent").append(
										'<div id="child1">' + html + '</div>');
							});

			function myFunction(carId) {

				$.ajax({
					url : "${home}booking?id=" + carId,
					type : "POST",
					//data : JSON.stringify(json),
					dataType : 'json',
					//contentType : 'application/json',   

					success : function(val) {
						$("#addCategoryModal").modal('show');
						setTimeout(
								  function() 
								  {
									  window.location.href = "${home}";
								  }, 5000);
						
					},
					error : function(err) {
						$("#addCategoryModal").modal('show');
						setTimeout(
								  function() 
								  {
									  window.location.href = "${home}";
								  }, 5000);
						
					}
				});
			}
		</script>
	</div>
</form:form>

<%-- <a href="${pageContext.request.contextPath}/bookingcarlist">SelectCar</a> --%>
