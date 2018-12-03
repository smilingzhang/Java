<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 基于servlet3.0 -->
<form action="upload1" method="post" enctype="multipart/form-data">
	<input type="text" name="title"/><br/>
	<input type="file" name="upload"/><br/>
	<input type="submit" value="submit"/>
</form>

<!-- 基于commons upload -->

<form action="upload2" method="post" enctype="multipart/form-data">
	<input type="text" name="title"/><br/>
	<input type="file" name="upload"/><br/>
	<input type="submit" value="submit"/>
</form>
<!-- 基于commons upload多文件上传 控制器里循环上传 -->
<form action="upload3" method="post" enctype="multipart/form-data">
	<input type="text" name="title"/><br/>
	<input type="file" name="upload"/><br/>
	<input type="file" name="upload"/><br/>
	<input type="submit" value="submit"/>
</form>
</body>
</html>