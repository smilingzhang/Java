<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.Student" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <%@ include file="head.jsp" %>
  
<!--   动态包含传参 -->
  <jsp:include page="head.jsp">
  	<jsp:param value="zhangsan" name="username"/>
  </jsp:include>
  shdsj
  sdjfhsk
  skdjfsk
  sdjfsk
  skjdfk
  kjk
  <%@ include file="foot.jsp" %>
  
  
  <jsp:useBean id="stu" class="com.Student">
  	<jsp:setProperty property="id" name="stu" value="100"></jsp:setProperty>
  </jsp:useBean>
</body>
</html>