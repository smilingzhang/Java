<%@page import="java.sql.ResultSet"%>
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
    int i=0;
	int j=0;
	Object obj=request.getAttribute("un");
    ResultSet rs=(ResultSet)obj;
    out.print(" <table border=1 width=300px height=200px cellspacing=0 cellpading=0>");
    while(rs.next()){
    	out.print("<tr><td>"+rs.getString("id")+"</td><td>"+rs.getString("name")+"</td><td>"+rs.getFloat("price")+"</td></tr>");
    }
    out.print("</table>");
	%>
</body>
</html>