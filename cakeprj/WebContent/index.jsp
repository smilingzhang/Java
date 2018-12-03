<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home</title>
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!-- //Custom Theme files -->
<link href="css/bootstrap.css" type="text/css" rel="stylesheet"
	media="all">
<link href="css/style.css" type="text/css" rel="stylesheet" media="all">
<!-- js -->
<script src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
<!-- //js -->
<!-- cart -->
<script src="js/simpleCart.min.js">
	
</script>
<!-- cart -->
</head>
<body>
	<%@include file="header.jsp"%>
	<!--banner-->
	<div class="banner">
		<div class="container">
			<h2 class="hdng">
				Yummy <span>Cakes</span> for u
			</h2>
			<p>Our best cakes make your day special</p>
			<a href="CakePageServlet">SHOP NOW</a>
			<div class="banner-text">
				<img src="images/2.png" alt="" />
			</div>
		</div>
	</div>
	<!--//banner-->
	<!--gallery-->
	<div class="gallery">
		<div class="container">
			<div class="gallery-grids">
				<div class="col-md-8 gallery-grid glry-one">
					<a href="single.jsp"><img src="images/g1.jpg"
						class="img-responsive" alt="" />
						<div class="gallery-info">
							<p>
								<span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
								view
							</p>
							<a class="shop" href="single.jsp">SHOP NOW</a>
							<div class="clearfix"></div>
						</div> </a>
					<div class="galy-info">
						<p>Lorem Ipsum is simply</p>
						<div class="galry">
							<div class="prices">
								<h5 class="item_price">$95.00</h5>
							</div>
							<div class="rating">
								<span>☆</span> <span>☆</span> <span>☆</span> <span>☆</span>
							</div>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
				<div class="col-md-4 gallery-grid glry-two">
					<a href="single.jsp"><img src="images/g2.jpg"
						class="img-responsive" alt="" />
						<div class="gallery-info galrr-info-two">
							<p>
								<span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
								view
							</p>
							<a class="shop" href="single.jsp">SHOP NOW</a>
							<div class="clearfix"></div>
						</div> </a>
					<div class="galy-info">
						<p>Lorem Ipsum is simply</p>
						<div class="galry">
							<div class="prices">
								<h5 class="item_price">$95.00</h5>
							</div>
							<div class="rating">
								<span>☆</span> <span>☆</span> <span>☆</span> <span>☆</span>
								<span>☆</span>
							</div>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>


				<c:forEach var="ca" items="${cake }">
					<div class="col-md-3 gallery-grid ">
						<a href="CakeDetailServlet?id=${ca.id }"><img
							src="images/${ca.bigimg }" class="img-responsive" alt="" />
							<div class="gallery-info">
								<p>
									<span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
									view
								</p>
								<a class="shop" href="CakeDetailServlet?id=${ca.id }">SHOP
									NOW</a>
								<div class="clearfix"></div>
							</div> </a>
						<div class="galy-info">
							<p>${ca.name }</p>
							<div class="galry">
								<div class="prices">
									<h5 class="item_price">${ca.price }</h5>
								</div>
								<div class="rating">
									<c:forEach var="a" begin="1" end="${ ca.level}">
										<span>☆</span>
									</c:forEach>
								</div>
								<div class="clearfix"></div>
							</div>
						</div>
					</div>
				</c:forEach>



			</div>
		</div>
	</div>
	<!--//gallery-->
	<!--subscribe-->
	<div class="subscribe">
		<div class="container">
			<h3>Newsletter</h3>
			<form>
				<input type="text" class="text" value="Email"
					onFocus="this.value = '';"
					onBlur="if (this.value == '') {this.value = 'Email';}"> <input
					type="submit" value="Subscribe">
			</form>
		</div>
	</div>
	<!--//subscribe-->
	<%@include file="footer.jsp"%>
</body>
</html>