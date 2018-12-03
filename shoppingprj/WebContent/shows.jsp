<%@page import="java.util.ArrayList"%>
<%@page import="com.jd.shop.entity.Product" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

 <table border="1" align="center">
 <tr>
	<td>序号</td>
	<td>名字</td>
	<td>价格</td>
	<td>操作</td>
 </tr>
<c:forEach var="p" items="${un }"> 
	<tr>
		<td>${p.id }</td>
		<td>${p.name }</td>
		<td>${p.price }</td>
		<td><a href="AddCarServlet?id=${p.id }">加入购物车</a></td>
	</tr>
</c:forEach>
</table>
<a href='car.jsp'>查看购物车</a>
</body>
</html>