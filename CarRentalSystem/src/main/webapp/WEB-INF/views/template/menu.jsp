<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- <ul style="list-style:none;line-height:28px;"> -->

<%-- 	<li><spring:url value="/home" var="homeUrl" htmlEscape="true" /> --%>
<%-- 		<a href="${homeUrl}">Home</a> --%>
<!-- 	</li> -->

<%-- 	<li><spring:url value="/home" var="personListUrl" htmlEscape="true" /> --%>
<%-- 		<a href="${personListUrl}">Product</a> --%>
<!-- 	</li> -->

<!-- </ul> -->

<nav class="container-fluid">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand nav nav-pills" href="#">APP - Car Rental
				Service</a>
		</div>
		<ul class="nav nav-pills nav-tabs navbar-nav">
			<li><a href="${pageContext.request.contextPath}/home">Home</a></li>
			<li><a href="${pageContext.request.contextPath}/booking">Reservation</a></li>
			<%-- 			<sec:authorize url="/SecureArea">
			<li><a href="/secureArea"> The secured area </a></li>
			</sec:authorize> --%>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Car<span class="caret"></span></a>
					<ul class="dropdown-menu nav nav-pills">
						<li><a href="addCar">Add Car</a></li>
						<li><a href="carList">Show Car List</a></li>
					</ul></li>
				<!-- Added Abdel File By Prabhat -->
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Customer<span class="caret"></span></a>
					<ul class="dropdown-menu nav nav-pills">
						<li><a href="${pageContext.request.contextPath}/customerList">Customer
								List</a></li>
						<li><a href="${pageContext.request.contextPath}/customerAdd">Add
								Customer</a></li>
						<li><a href="${pageContext.request.contextPath}/search">Search</a></li>

					</ul></li>
			</sec:authorize>
			<!-- End Of Added Abdel File By Prabhat -->
		</ul>



		<ul class="nav navbar-nav navbar-right">
			<sec:authorize access="isAuthenticated()">
				<sec:authorize access="hasRole('CUSTOMER')">
					<li class="dropdown"><a href="#"><font color="yellow"
							class="dropbtn"><sec:authentication
									property="principal.username" /> (Admin Panel) </font></a></li>
				</sec:authorize>
			</sec:authorize>

			<sec:authorize access="isAuthenticated()">
				<sec:authorize access="hasRole('ROLE_USER')">
					<li><a href="#"><font color="yellow"> <sec:authentication
									property="principal.username" /> (Customer)
						</font></a></li>
				</sec:authorize>
			</sec:authorize>

			<sec:authorize access="isAnonymous()">
				<li><a href="${pageContext.request.contextPath}/customerAdd"><span
						class="glyphicon glyphicon-user"></span> Sign Up</a></li>
				<li><a href="${pageContext.request.contextPath}/login"><span
						class="glyphicon glyphicon-log-in"></span> Login</a></li>
			</sec:authorize>

			<sec:authorize access="isAuthenticated()">
				<li><a href="<c:url value="/j_spring_security_logout" />"><span
						class="glyphicon glyphicon-log-out"></span> Logout</a></li>
			</sec:authorize>
		</ul>
	</div>
</nav>