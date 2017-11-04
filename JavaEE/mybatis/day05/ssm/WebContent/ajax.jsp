<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">

	$.ajax({
		url:"${pageContext.request.contextPath }/ajax",
		data:'{"name":"鞋子","price":100}',
		dataType:"json",
		//application/x-www-form-urlencoded   就是  kery  和value格式
		contentType:"application/json;charset=utf-8",
		type:"post",
		cache:"false",
		
		success:function(data){
			//stringify 把json对象 转成json字符串
			alert(JSON.stringify(data));
			
		}
		
		
		
	})





</script>

</head>
<body>

</body>
</html>