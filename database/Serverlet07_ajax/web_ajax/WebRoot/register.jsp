<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Ajax 注册验证</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/myjs.js"></script>
	<script type="text/javascript">
		function ckName(){
			//创建 XMLHttpRequest对象
			var xmlhttp = getXmlHttpRequest();
			//响应
			xmlhttp.onreadystatechange=function(){
				//获得响应数据 可以注册  返回 true  否则 返回 false
				//如果 请求 和 响应 都成功了 
				if(xmlhttp.readyState==4 && xmlhttp.status==200){
					var msg = document.getElementById("msg");
					var text = xmlhttp.responseText;
					if(text=="true"){
						msg.innerHTML="该用户名可以使用";
						msg.style.color="green";
					}else{
						msg.innerHTML="该用户名已被注册";
						msg.style.color="red";
					}
				}
			};
			
			//请求
			var username = document.getElementById("username").value;
			/*使用Get 请求 servlet  
			method：请求的类型；GET 或 POST
		    url：文件在服务器上的位置
		    async：true（异步）或 false（同步）
			*/
			xmlhttp.open("GET","checkUserName?username="+username,true);
			/*
			send(string)将请求发送到服务器。string：仅用于 POST 请求
			*/
			xmlhttp.send();
		}
	</script>
  </head>
  
  <body>
  	用户名<input type="text" name="username" id="username" onblur="ckName()">
  	<span id="msg"></span>
  	<br>
  	密码<input type="password" name="password" id="password">
  </body>
</html>
