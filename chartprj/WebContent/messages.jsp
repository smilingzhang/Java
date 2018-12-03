<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.ArrayList"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>char at</title>
<meta http-equiv="refresh" content="1"/>
</head>
<body>
<%
   Object obj=application.getAttribute("msgs");
  if(obj!=null){
	  ArrayList<String> list=(ArrayList)obj;
	  for(String temp:list){
		 out.print(temp+"<br>");
	  }
  }
%>

</body>
</html>