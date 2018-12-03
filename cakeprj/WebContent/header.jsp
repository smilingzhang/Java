<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--header-->
<div class="header">
	<div class="container">
		<nav class="navbar navbar-default" role="navigation">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<h1 class="navbar-brand">
					<a href="main.jsp">Yummy</a>
				</h1>
			</div>
			<!--navbar-header-->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="main.jsp" class="active">Home</a></li>

					<c:forEach var="p" items="${cakeType }">
						
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">${p.name }<b class="caret"></b></a>
								<ul class="dropdown-menu multi-column columns-4">
									<div class="row">
										<c:forEach var="i" items="${p.cakeTypes }">
											
												<div class="col-sm-3">
													<h4>${i.name }</h4>
													<ul class="multi-column-dropdown">
														<c:forEach var="j" items="${i.cakeTypes }">
															
																<li><a class="list"
																	href="CakePageServlet?typeId=${j.id }">${j.name }</a></li>
														
														</c:forEach>
													</ul>
												</div>
										
										</c:forEach>
									</div>
								</ul></li>
						
					</c:forEach>

				</ul>
				<!--/.navbar-collapse-->
			</div>
			<!--//navbar-header-->
		</nav>
		<div class="header-info">
			<div class="header-right search-box">
				<a href="#"><span class="glyphicon glyphicon-search"
					aria-hidden="true"></span></a>
				<div class="search">
					<form class="navbar-form">
						<input type="text" class="form-control">
						<button type="submit" class="btn btn-default"
							aria-label="Left Align">Search</button>
					</form>
				</div>
			</div>
			<div class="header-right login">
				<a href="#"><span class="glyphicon glyphicon-user"
					aria-hidden="true"></span></a>
				<div id="loginBox">


					<c:if test="${empty u}">
						<form id="loginForm" action="LoginServlet" method="post">
							<fieldset id="body">
								<fieldset>
									<label for="email">Email Address</label> <input type="text"
										name="mail" id="email">
								</fieldset>
								<fieldset>
									<label for="password">Password</label> <input type="password"
										name="password" id="password">
								</fieldset>
								<input type="submit" id="login" value="Sign in"> <label
									for="checkbox"><input type="checkbox" id="checkbox">
									<i>Remember me</i></label>
							</fieldset>
							<p>
								New User ? <a class="sign" href="account.jsp">Sign Up</a> <span><a
									href="#">Forgot your password?</a></span>
							</p>
						</form>
					</c:if>
					<c:if test="${not empty u }">
						<p>welcome ${u.mail}</p>
					</c:if>


				</div>
			</div>



			<div class="header-right cart">
				<a href="#"><span class="glyphicon glyphicon-shopping-cart"
					aria-hidden="true"></span></a>
				<div class="cart-box">
					<h4>
						<a href="checkout.jsp"> <%-- <span class="simpleCart_total"> $0.00 </span> (<span id="simpleCart_quantity" class="simpleCart_quantity"> 0 </span>) --%>
							View shopping cart
						</a>
					</h4>
					<p>
						<a href="javascript:;" class="simpleCart_empty">Empty cart</a>
					</p>
					<div class="clearfix"></div>
				</div>
			</div>



			<div class="clearfix"></div>
		</div>
		<div class="clearfix"></div>
	</div>
</div>
<!--//header-->