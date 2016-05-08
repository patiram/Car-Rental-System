<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<h1>Welcome to Car Rental System.</h1>

<P>${serverTime}.</P>
<div class="container">
	<div class="row">
		<div class="col-sm-6 col-md-4" id="ECONOMIC">
			<h2>ECONOMIC</h2>
			<c:forEach items="${carList}" var="car">
				<c:if test="${car.cartype.category=='ECONOMIC'}">
					<div class="thumbnail">
						<div class="caption">
							<h4>
								Model: ${car.cartype.model }<br>Brand: ${car.cartype.brand }<br>Year:
								${car.cartype.year }
							</h4>
						</div>
						<img alt="ECONOMIC image not found"
							style="width: 350px; height: 350px" src="${car.urlPicture}">
						<div class="caption">
							<p>Details: ${car.description}</p>
						</div>
					</div>
				</c:if>
			</c:forEach>
		</div>
		<div class="col-sm-6 col-md-4" id="LUXUARY">
			<h2>LUXUARY</h2>
			<c:forEach items="${carList}" var="car">
				<c:if test="${car.cartype.category=='LUXUARY'}">
					<div class="thumbnail">
						<div class="caption">
							<h4>
								Model: ${car.cartype.model }<br>Brand: ${car.cartype.brand }<br>Year:
								${car.cartype.year }
							</h4>
						</div>
						<img alt="LUXUARY image not found"
							style="width: 350px; height: 350px" src="${car.urlPicture}">
						<div class="caption">
							<p>Details: ${car.description}</p>
						</div>
					</div>
				</c:if>

			</c:forEach>
		</div>
		<div class="col-sm-6 col-md-4" id="STANDARD">
			<h2>STANDARD</h2>
			<c:forEach items="${carList}" var="car">

				<c:if test="${car.cartype.category=='STANDARD'}">
					<div class="thumbnail">
						<div class="caption">
							<h4>
								Model: ${car.cartype.model }<br>Brand: ${car.cartype.brand }<br>Year:
								${car.cartype.year }
							</h4>
						</div>

						<img alt="STANDARD image not found"
							style="width: 350px; height: 350px" src="${car.urlPicture}">
						<div class="caption">
							<p>Details: ${car.description}</p>
						</div>
					</div>
				</c:if>
			</c:forEach>
		</div>
		<div class="col-sm-6 col-md-4" id="BUSINESS">
			<h2>BUSINESS</h2>
			<c:forEach items="${carList}" var="car">
				<c:if test="${car.cartype.category=='BUSINESS'}">
					<div class="thumbnail">
						<div class="caption">
							<h4>
								Model: ${car.cartype.model }<br>Brand: ${car.cartype.brand }<br>Year:
								${car.cartype.year }
							</h4>
						</div>

						<img alt="BUSINESS image not found"
							style="width: 350px; height: 350px" src="${car.urlPicture}">
						<div class="caption">
							<p>Details: ${car.description}</p>
						</div>
					</div>
				</c:if>
			</c:forEach>
		</div>

	</div>

</div>

<br />
<br />
<br />
<br />

