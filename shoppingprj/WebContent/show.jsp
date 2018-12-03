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
<%-- <%--    <% --%> 
<!-- //   Object obj= request.getAttribute("un"); -->
<!-- //    if(obj!=null){ -->
<!-- // 	   ArrayList<Product> list=(ArrayList)obj; -->
<!-- // 	   out.print("<table border=1 align=center>"); -->
<!-- //   	 out.print("<tr><td>序号</td><td>名字</td><td>价格</td><td>操作</td></tr>"); -->
<!-- //   	 for(Product p:list){ -->
<!-- //   		 out.print("<tr><td>"+p.getId()+"</td><td>"+p.getName()+"</td><td>"+p.getPrice()+"</td><td><a href='AddCarServlet?id="+p.getId()+"'>加入购物车</td></tr>"); -->
<!-- //   	 } -->
<!-- //   	 out.print("</table>"); -->
<!-- //   	 out.print("<a href='car.jsp'>查看购物车</a>"); -->
<!-- //    }else{ -->
<!-- // 	   out.print("there is nothing"); -->
<!-- //    } -->
<%-- <%--    %> --%> 

<!-- 循环打印i,包括0 和 10,step表示步长 -->
<c:forEach var="i" begin="0" end="10" step="2">
${i }
</c:forEach>

<%
pageContext.setAttribute("temp", "aa,bb,cc");
%>
<c:forTokens items="${temp }" delims="," var="t">  <!-- 分割字符串，按照逗号分隔，给变量t -->
${t }====
</c:forTokens>

<table border="1">
<tr>
	<td>序号</td>
	<td>名字</td>
	<td>价格</td>
	<td>操作</td>
</tr>
<c:forEach var="p" items="${ un}" step="2" varStatus="sta"><!-- un为存到request里的键,p为临时变量的名字,step="2"的话,就是隔一个取一个,varStatus属性 -->
<tr>
	<td>${p.id }</td>
	<td>${p.name }</td>
	<td>${p.price }</td>
	<td><a href="AddCarServlet?id=${p.id }">加入购物车</a></td>
 	<td>${sta.count }</td> <%--打印出这条数据是第几个，从1开始；若sta.index从0开始;sta.first,sta.last判断此数据是不是第一条、最后一条数据 --%>
	
	</tr>
</c:forEach>
</table>

<c:url var="u" value="/"></c:url>
<c:set var="m" value="/"></c:set>
${u }<!-- 得到的是项目根目录 -->

<%-- <a href="${u }/static/zui/a.css"></a>   static为webcontent下的一个文件   --%>
</body>
</html>