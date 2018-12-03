<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.jd.shop.car.service.Car,com.jd.shop.car.service.CarItem" %>
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
<%
	Object obj=session.getAttribute("car");
	if(obj!=null){
		Car car=(Car)obj;
		HashMap<String,CarItem> hm=car.getHs();
		Iterator i=hm.values().iterator();//hm.values()获取map中的所有值，hm.ketSet()获取所有的键得到键的set集合，再通过get获取键对应的值
		while(i.hasNext()){
			CarItem c=(CarItem)i.next();
			out.print(c.getP().getName()+":"+c.getCount());
			out.print("<br/>");
		}
	}else{
		out.print("your car is null!");
	}
%>

<c:forEach var="entity" items="${car.hs }"> hs为私有属性，但是能访问到实际上是调用的get方法
${entity.value.p.name }拿到键就是entity.key
${entity.value.count }
<br/>
</c:forEach>
</body>
</html>