<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="static/jquery/1.8.1/jquery-1.8.1.min.js"></script> 
<script type="text/javascript">
	function checkName(){
		var name=document.getElementById("username").value;  //先拿到文本框里的名字
		var xmlhttp;//构造xml对象
		if (window.XMLHttpRequest)
		{
		    //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
		    xmlhttp=new XMLHttpRequest();
		}
		else
		{
		    // IE6, IE5 浏览器执行代码
		    xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
		//发请求
		xmlhttp.open("POST","CheckNameServlet?username="+name+"",true);//第一个参数为请求方式，第二个参数为servlet地址，第三个参数为是否异步
		xmlhttp.send();
		//回调函数，请求响应完成之后自动调用的函数
		xmlhttp.onreadystatechange=function()
		{
		    if (xmlhttp.readyState==4 && xmlhttp.status==200)//4代表请求响应结束,responseText为服务器响应回来的数据文本
		    {
		        var res=xmlhttp.responseText;
		        if(res=="ok"){
		        	document.getElementById("msg").innerHTML="名字可用";    	
		        }else{
		        	document.getElementById("msg").innerHTML="名字已被占用";
		        }
		    }
		}
	}
	
	function searchWord(){
		$.get("SearchServlet",{searchword:$("#txtSearch").val()},
				function (data){//data为返回的数据
					var msg=eval(data);
					var res="";
					for(var i=0;i<msg.length;i++){
						res+=msg[i]+"<br/>";
					}
					document.getElementById("searchmsg").innerHTML=res;

		}
				
		);//第一个参数是servlet地址，第二个参数为传参，传参内容为文本框里的内容，第三个参数为回调函数
	}
</script>
</head>
<body>
<form action="regist" method="post">
	<input type="text" name="username" onblur="checkName()" id="username"> <!-- 离开焦点时调函数 -->
	<div id="msg"></div><br/>
	<input type="password" name="psw"><br/>
	<input type="submit" value="登陆">
</form>
===============================================================
<form action="" method="post">
	<input type="text" id="txtSearch" name="search" onkeypress="searchWord()"/>
	<div id="searchmsg"></div>
	<input type="submit" value="search"/>
	
</form>
</body>
</html>