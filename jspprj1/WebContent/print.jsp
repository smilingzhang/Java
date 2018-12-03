<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--打印三角形  -->
<%
	int i=1;
    int j=1;
	for(i=1;i<=3;i++){
		for(j=1;j<=i;j++){	
		out.print("*");
		}
		out.print("<br/>");
	}
%>
<!--打印九九乘法表 -->
<%
pageContext.setAttribute("key1", "val1", PageContext.APPLICATION_SCOPE);
int m=1;
int n=1;
for(m=1;m<=9;m++){
	for(n=1;n<=m;n++){
		out.print(n+"*"+m+"="+m*n);
		out.print("&nbsp;&nbsp;&nbsp;");
	}
	out.print("<br/>");
}
%>
<!-- 打印菱形 -->
<%!int a=1,b=1,c=1; %>
<%
	for(a=1;a<=5;a++){
		if(a<=3){
			for(b=1;b<=3-a;b++){
				out.print("&nbsp;");
			}
			for(b=1;b<=2*a-1;b++){
				out.print("*");
			}
			out.print("<br/>");
		}
		else{
			for(b=1;b<=a-3;b++){
				out.print("&nbsp;");
			}
			for(b=1;b<=11-2*a;b++){
				out.print("*");
			}
			out.print("<br/>");
		}
		
	}
out.print("abc");
out.println("abc");
%>

</body>
</html>