<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
      <%! int num=10; %> <!-- 这是相当于写在了类的属性位置 -->
      <%!String hi(){ 
    	  return "hi";
      } %>
      
      <%
        int num=20;//相当于写在了类的方法里边
      	out.print(num);  //作用为向客户端输出,结果为20
      %>
      
      <%=num %>
      <%=hi()%>
</body>
</html>