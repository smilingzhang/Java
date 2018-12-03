<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.ArrayList"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>char at</title>
<meta http-equiv="refresh" content="1"/><!-- 让这个界面一秒刷新一次 -->
</head>
<body>
<%
//从servletcontext中取出自己的名字，但是jsp中叫application
ArrayList<String> list=(ArrayList)application.getAttribute("names");
Object obj=session.getAttribute("myname");
if(obj!=null){
String name=obj.toString();
for(String temp:list){
	if(temp.equals(name)){
		out.print("<font color='red'>"+temp+"</font><br>");
	}else{
		out.print("<font color='blue'>"+temp+"</blue><br>");
	}
}
}else{
	out.print("");
}

%>
</body>
</html>