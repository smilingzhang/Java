<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1" align="center">
 <tr>
	
	<td>名字</td>
	<td>价格</td>
	
 </tr>
	<c:forEach var="p" items="${page.list }">
		<tr>
			<td>${p.name }</td>
			<td>${p.price}</td>
		</tr>
	</c:forEach>
	<tr>
	   <td>共有${page.totalCount }条数据，共${page.totalPageNum }页
	
		<a href="PageServlet?pageNum=1">首页</a>
		<a href="PageServlet?pageNum=${page.prePageNum }">上一页</a>
		<a href="PageServlet?pageNum=${page.nextPageNum }">下一页</a>
		<a href="PageServlet?pageNum=${page.totalPageNum }">末页</a>
	</td>
	</tr>
	</table>
</body>
</html>