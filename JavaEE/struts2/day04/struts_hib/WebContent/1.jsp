<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.1.8.3min.js"></script>

<script type="text/javascript">

/* var person={
		"name":"jack",
		"baby":{
			"name":"littleJack",
			"sex":"男",
			"baby":[
				{
					"name":"芙蓉妹妹",
					"sex":"女"
				},
				{
					"name":"凤妹妹",
					"sex":"女"
				}

			]	
		}
		
}

alert(person.baby.baby[1].name);	 */

	$(function(){
		//失去焦点事件
		/* document.getElementById("uname").onclick=function(){
			
			
		} */
		
		$("#uname").blur(function(){
			//去ajax校验用户名是否存在
			var uname=$(this).val();
			
			$.ajax({
				url:"${pageContext.request.contextPath}/user_check",
				data:{"uname":uname},
				dataType:"json",
				type:"post",
				cache:"false",//不使用浏览器缓存
				async:"true",
				success:function(data){
				alert(data.flag);
					
				},
				error:function(){
					
					
					
				}
				
				
				
				
				
			});
			
			
			
			
			
		});
		
		/* $("#uname").on("blur",function(){
			
			
		}) */
		
		
		
	});


</script>


</head>
<body>
<form action="${pageContext.request.contextPath }/user_register">
<s:token></s:token>
	用户名：<input type="text" id="uname" name="uname" />



</form>
</body>
</html>