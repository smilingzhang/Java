<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <form action="/springhibernate1/users/regist" method="post">  <!-- 服务器根目录开始找   或者action的连接写regist-->
 	昵称：<input type="text" name="nickName"/><br/>
 	密码：<input type="password" name="passWord"/><br/>
 	性别：男：<input type="radio" name="gender" value="male"/>
 		女：<input type="radio" name="gender" value="female"/><br/>
 	介绍：<textarea  name="introduce" rows="5" cols="10"></textarea><br/>
 	<input type="submit" value="regist">
 </form>
</body>
</html>