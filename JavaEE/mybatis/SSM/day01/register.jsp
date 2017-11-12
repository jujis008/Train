<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>

<style type="text/css">

label.error{
color:red;
}

</style>

<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.validate.min.js"></script>
<script type="text/javascript">

//自定义校验
$.validator.addMethod(
		
		"nameIsExist",
		
		
		
		function(value,element,params){
			//value  用户输入的值
			//element  对象
			//params 校验的值
			/*  alert(value);
			alert(element);
			alert(params);  */
			
			
			return ajax_name(value);
	
}
	)
	
	
	function ajax_name(value){
	
	var flag=true;
	
	$.ajax({
			url:"${pageContext.request.contextPath }/user/user/register",
			data:{"uname":value},
			dataType:"json",
			//application/x-www-form-urlencoded   就是  kery  和value格式
			//contentType:"application/json;charset=utf-8",
			type:"post",
			cache:"false",
			async:false,
			
			success:function(data){
				//stringify 把json对象 转成json字符串
				flag=data.flag;
				
			}
			
		});
	return flag;
}

	$(function(){
		$("#myform").validate({
		//在js中[]表示数组      
			rules:{//指定规则
				"uname":{
					"required":true,
					"maxlength":8,
					"minlength":4,
					"nameIsExist":true//添加自定义校验规则
				},
				"upwd":{
					"required":true,
					"rangelength":[6,20]
					
				},
				"upwd_":{
					"required":true,
					"equalTo":"#upwd"
				},
				/* "birthday":{
					"dateISO":true
					
				}, */
				"email":{
					"required":true,
					"email":true
					
				}
				
			},
			messages:{//不满足规则  相应的提示
				
				"uname":{
					"required":"用户名不能为空",
					"maxlength":"用户长度不能超过8",
					"minlength":"用户长度不能小于4",
					"nameIsExist":"用户名已经存在"//添加自定义校验规则
				},
				"upwd":{
					"required":"密码不能为空",
					"rangelength":"密码长度在6-20"
					
				},
				"upwd_":{
					"required":"密码不能为空",
					"equalTo":"两次输入的密码不一致"
				}
				,
				/* "birthday":{
					"dateISO":"请输入正确的日期格式"
					
				}, */
				"email":{
					"required":"邮箱不能为空",
					"email":"请输入正确的邮箱格式"
					
				}
				
			}
				
		});


	});




</script>
</head>
<body>
<div style="width:300px;margin:0 auto;">
	<div>
	<form id="myform" action="${pageContext.request.contextPath }/user/register" method="post">

		<div>
		<div><label for="uname" generated="true" class="error"></label></div>
		
		用户　名<input type="text" name="uname" /></div>
		<div>密　　码<input type="text" id="upwd" name="upwd" /></div>
		<div>确认密码<input type="text" name="upwd_" /></div>
		<div>性　　别<input type="radio" name="sex" value="男" checked="checked" />男
		<input type="radio" name="sex" value="女"/>女</div>
		<div>生　　日<input type="text" name="birthday" /></div>
		<div>邮　　箱<input type="text" name="email" /></div>
		<div><input type="submit" value="提交" /></div>
	</form>
	</div>
</div>


</body>
</html>