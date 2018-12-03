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
<!-- commandName的值为user在model作用域里存的键值 -->
<form:form commandName="user" action="/springjstl/user/add" method="post">
	<table border="1" align="center">
		<tr>
			<td>id</td>
			<td> <form:input path="id"/> </td>
		</tr>
		<tr>
			<td>province</td>
			<td>
				<form:select path="province.id">
					<form:option value="0" label="请选择" />
					<form:options items="${pros }" itemValue="id" itemLabel="name" /><!-- id 和name为province中的属性 -->
				</form:select>
			</td>
		</tr>
		<tr>
				<td colspan="2"><input type="submit" value="保存" /></td>
			</tr>
	</table>
</form:form>
	
</body>
</html>