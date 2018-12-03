
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>login</title>
</head>
<body>
	<form action="LoginServlet" method="post">
		<input type="text" name="username">	
		<% 
		Object obj=request.getAttribute("msg");
		if(obj!=null){
			out.print("<font color='red'>"+obj+"</font>");
		}
		%><br/>
		<input type="submit" name="进入聊天室">
	</form>


</body>
</html>