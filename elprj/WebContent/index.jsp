<%@page import="com.Student"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String temp="hello";
	pageContext.setAttribute("msg", temp);
	request.setAttribute("msg", temp);
%>
<%=temp %><br/>
${temp }<br/>   <!-- 没写作用域的时候，取不到，空串 -->
${pageScope.msg}<br/>
${msg}<br/><!-- 不写作用域范围的时候，从page作用域一点点向上找 -->
<%=request.getAttribute("msg") %>


<a href="hello.jsp?name=zhangsan">hello</a>


<%
	Student s=new Student();
  s.setName("zhang");
  request.setAttribute("s", s);
  pageContext.setAttribute("pro", "id");
%>
${s.name }
${s[pro] }<!-- 中括号里为变量，取到了id，若上边为name，则取到name -->


<!-- 实例化数组,list也可以，hashmap不可以 -->
<%
	int num[]=new int[3];
num[0]=1;
num[1]=2;
num[2]=3;
pageContext.setAttribute("n", num);
%>
${n[0] }
${empty n }
</body>
</html>