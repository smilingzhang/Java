<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <%@page import="com.Student" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<%
// int n=10/0;
request.setAttribute("stu", new Student());
%>
<c:out value="a"></c:out><br/>
<c:out value="${a }" default="111"> </c:out><br/> 
<c:set var="b" value="100"></c:set> <%-- 键是b，b的值是100 --%>
<c:out value="${b }" default="111"></c:out><br/>


<!-- ============================================= -->
<!-- <!-- 两个div层，一个是登陆前显示的页面，另一个是登陆 之后显示的，user是存在于session里边的一个键 --> 

<%-- <c:if test="${empty user }"> --%>
<!-- <div> -->
<!-- 	<form action=""> -->
<!-- 	<input type="text" name="username"> -->
<!-- 	<input type="submit" value="登陆"> -->
<!-- 	</form> -->
<!-- </div> -->
<%-- </c:if> --%>

<%-- <c:if test="${not empty user }"> --%>
<!-- <div> -->
<!-- 	nice to me too! -->
<!-- </div> -->
<%-- </c:if> --%>

<!-- ================================================== -->
<%-- <% --%>
<%
 request.setAttribute("age", 20);
%>
<c:choose>
<c:when test="${age > 10}"> old </c:when>
	<c:otherwise>young</c:otherwise>
</c:choose>

</body>
</html>