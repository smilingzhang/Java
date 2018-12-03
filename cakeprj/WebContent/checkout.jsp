<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Checkout</title>
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //Custom Theme files -->
<link href="css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
<link href="css/style.css" type="text/css" rel="stylesheet" media="all">
<!-- js -->
<script src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
<!-- //js -->
<!-- cart -->
<script src="js/simpleCart.min.js"> </script>
<!-- cart -->
</head>
<body>
	<%@include file="header.jsp" %>
	<!--cart-items-->
	<div class="cart-items">
		<div class="container">
			<h2>My Shopping Cart</h2>
			<script>$(document).ready(function(c) {
				$('.close1').on('click', function(c){
					$('.cart-header').fadeOut('slow', function(c){
						$('.cart-header').remove();
					});
					});	  
				});
			</script>
			
		<c:forEach var="entity" items="${cart.hMap }">
			<div class="cart-header">
				<div class="close1"> </div>
				<div class="cart-sec simpleCart_shelfItem">
					<div class="cart-item cyc">
						 <img src="images/${entity.value.cake.bigimg }" class="img-responsive" alt="">
					</div>

					<div class="cart-item-info">
						<h3><a href="#"> ${entity.value.cake.name }</a><span>Purchase quantity:</span></h3>
						<ul class="qty">
							<li><p>${entity.value.count }</p></li>
						</ul>
						<div class="delivery">
							<p>Service Charges : ${entity.value.cake.price }</p>
							<span>	
							<form action="OrderServlet?mail=${u.mail}&cakeid=${entity.value.cake.id}&count=${entity.value.count}" method="post"  >
								<a href="OrderServlet"><input type="submit" value="Check Out" ></a>
		                   </form>  
		                   </span>          
		                   
							<div class="clearfix"></div>
						</div>	
					</div>
					
					
					<div class="clearfix"></div>
				</div>
			</div>
		</c:forEach>

			 <script>$(document).ready(function(c) {
					$('.close2').on('click', function(c){
							$('.cart-header2').fadeOut('slow', function(c){
						$('.cart-header2').remove();
					});
					});	  
					});
			 </script>
			
				<script>$(document).ready(function(c) {
					$('.close3').on('click', function(c){
							$('.cart-header3').fadeOut('slow', function(c){
						$('.cart-header3').remove();
					});
					});	  
					});
				</script>
			
		</div>
	</div>
	<!--//checkout-->	
	<%@include file="footer.jsp" %>
</body>
</html>