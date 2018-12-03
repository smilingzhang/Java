<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Account</title>
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
	<!--account-->
	<div class="account">
		<div class="container">
			<div class="register">
			
			
			
				<form action="RegistServlet" method="post"> 
					<div class="register-top-grid">
						<h3>Personal information</h3>
						<div class="input">
							<span>Email<label>*</label></span>
							<input type="text" name="mail"> 
						</div>
						<div class="input">
							<span>UserName<label>*</label></span>
							<input type="text" name="username"> 
						</div>
						
						<a class="news-letter" href="#">
							<label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i> </i>Sign Up for Newsletter</label>
						</a>
						<div class="clearfix"> </div>
					</div>
				    <div class="register-bottom-grid">
						<h3>Login information</h3>
						<div class="input">
							<span>Password<label>*</label></span>
							<input type="password" name="password">
						</div>
						
					</div>
					<div class="clearfix"> </div>
				<div class="register-but">
				   
					   <input type="submit" value="submit">
					   <div class="clearfix"> </div>
				   
				</div>
				</form>	
				
			</div>
	    </div>
	</div>
	<!--//account-->
	<%@include file="footer.jsp" %>
</body>
</html>