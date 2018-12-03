<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Products</title>
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //Custom Theme files -->
<link href="css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
<link href="css/style.css" type="text/css" rel="stylesheet" media="all">
<link href="css/form.css" rel="stylesheet" type="text/css" media="all" />
<!-- js -->
<script src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
<!-- //js -->	
<!-- cart -->
<script src="js/simpleCart.min.js"> </script>
<!-- cart -->
<!-- the jScrollPane script -->
<script type="text/javascript" src="js/jquery.jscrollpane.min.js"></script>
		<script type="text/javascript" id="sourcecode">
			$(function()
			{
				$('.scroll-pane').jScrollPane();
			});
		</script>
<!-- //the jScrollPane script -->
<script type="text/javascript" src="js/jquery.mousewheel.js"></script>
<!-- the mousewheel plugin -->		
</head>
<body>
	<%@include file="header.jsp" %>
	<!--products-->
	<div class="products">	 
		<div class="container">
			<h2>Our Products</h2>	
	
			<div class="col-md-9 product-model-sec">
			<c:forEach var="p" items="${pages.cake}">
				<div class="product-grid">
					<a href="CakeDetailServlet?id=${p.id}">				
						<div class="more-product"><span> </span></div>						
						<div class="product-img b-link-stripe b-animate-go  thickbox">
							<img src="images/${p.bigimg }" class="img-responsive" alt="">
							<div class="b-wrapper">
								<h4 class="b-animate b-from-left  b-delay03">							
									<button>View</button>
								</h4>
							</div>
						</div>
					</a>				
					<div class="product-info simpleCart_shelfItem">
						<div class="product-info-cust prt_name">
							<h4>${p.name }</h4>								
							<span class="item_price">${p.price} </span>
							<div class="ofr">
								<p class="pric1"><del>${p.price}</del></p>
								<p class="disc">[${p.discount}% Off]</p>
							</div>
							<input type="text" class="item_quantity" value="1" />
							<a href="CakePageAddServlet?id=${p.id }"><input type="button" class="item_add items" value="Add"></a>
							<div class="clearfix"> </div>
						</div>												
					</div>
				</div>
				</c:forEach>	
				<div id="xiangqing">
				<form text="align">
					<tr>
					 <td>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						共${num }条数据，共${pages.totalPageCount }页
						<a href="CakePageServlet?pageNum=1&level=4">首页</a>
						<a href="CakePageServlet?pageNum=${pages.prePageNum }&level=${level}">上一页</a>
						<a href="CakePageServlet?pageNum=${pages.nextPageNum }&level=${level}">下一页</a>
						<a href="CakePageServlet?pageNum=${pages.totalPageCount}&level=${level}">末页</a>
		    		 </td>
			    	</tr>
			  </form>
			  </div>
			</div>	
	
			<div class="col-md-3 rsidebar span_1_of_left">
				<!---->
				<script type="text/javascript" src="js/jquery-ui.min.js"></script>
				<link rel="stylesheet" type="text/css" href="css/jquery-ui.css">
					<script type='text/javascript'>//<![CDATA[ 
						$(window).load(function(){
						 $( "#slider-range" ).slider({
									range: true,
									min: 0,
									max: 100000,
									values: [ 500, 100000 ],
									slide: function( event, ui ) {  $( "#amount" ).val( "$" + ui.values[ 0 ] + " - $" + ui.values[ 1 ] );
									}
						 });
						$( "#amount" ).val( "$" + $( "#slider-range" ).slider( "values", 0 ) + " - $" + $( "#slider-range" ).slider( "values", 1 ) );

						});//]]> 
					</script>
				<!---->
			
				<section  class="sky-form">
					<h4><span class="glyphicon glyphicon-minus" aria-hidden="true"></span>评星Level(1-5)</h4>
					<div class="row row1 scroll-pane">
						<div class="col col-4">
						<form method="post" action="CakePageServlet">
							<input type="text" name="level" value="${level }"><br/><br/>
							<input type="submit" value="Search">
						</form>	
						</div>
					</div>
				</section>  		 
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
	<!--//products-->
	<%@include file="footer.jsp" %>
</body>
</html>