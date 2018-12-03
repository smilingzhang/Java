<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form commandName="pro" action="/springjstl/product/add" method="post">
	<table border="1" align="center">
		<tr>
			<td>id</td>
			<td><form:hidden path="id"/></td>
		</tr>
		<tr>
			<td>name</td>
			<td><form:input path="name"/></td>
		</tr>
		<tr>
			<td>soldOut</td>
			<td><form:checkbox path="soldOut"/>售完</td>
		</tr>
		<tr>
			<td>coloe</td>
			<td><form:checkbox path="color" value="red"/>红
				<form:checkbox path="color" value="green"/>绿
				<form:checkbox path="color" value="blue"/>蓝
			</td>
		</tr>
		<tr>
				<td>coloe</td>
			<td><form:checkbox path="favourateColor" value="red"/>红
		</tr>
		<tr>
			<td>size</td>
			<td><form:checkboxes items="${sizes }" path="size"/></td>
		</tr>
		<tr>
			<td>sellType</td>
			<td>
				<form:radiobutton path="sellType" value="self"/>自营
				<form:radiobutton path="sellType" value="other"/>代理
			</td>
		</tr>
		<tr>
			<td>producingArea</td>
			<td><form:radiobuttons items="${pa }" path="producingArea"/></td>
		</tr>
		<tr>
				<td colspan="2"><input type="submit" value="保存" /></td>
			</tr>
	</table>
</form:form>
</body>
</html>