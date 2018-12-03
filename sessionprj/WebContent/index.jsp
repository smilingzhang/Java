<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>???????</title>
</head>
<body>
<%
//1.读cookie
String temp="";
	Cookie[] cs=request.getCookies();//拿到所有的cookie值，循环找到想要的,把记住的用户名显示在文本框中
	for(Cookie c:cs){
		//out.print(c.getName()+":"+c.getValue());//给客户端，输出在页面
		if(c.getName().equals("un")){
			temp=c.getValue();
		}
	}
%>
    <form action="login" method="post">
    	<input type="text" name="username" value="<%=temp %>"><br/> <!-- 尖括号 百分号 -->
    	<input type="password" name="password"><br/>
    	<input type="submit" name="登陆">
    </form>
</body>
</html>