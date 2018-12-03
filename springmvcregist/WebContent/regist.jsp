<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="regist" method="post">
	昵称：<input type="text" name="username"/><br/>
	密码：<input type="password" name="password"/><br/>
	<!--  出生：<input type="text" name="age"/><br/-->
	性别：<input type="radio" name="sex"/>男
			<input type="radio" name="sex"/>女<br/>
	爱好：<input type="checkbox" name="hobby"/>唱歌
			<input type="checkbox" name="hobby"/>赛车
			<input type="checkbox" name="hobby"/>打球<br/>
	籍贯:<select name="city">
		<c:forEach var="p" items="${city }">
			<option value="01">${p} </option>
		</c:forEach>	
	     </select><br/>
	   
	     <input type="submit" value="regist">
</form>
</body>
</html>