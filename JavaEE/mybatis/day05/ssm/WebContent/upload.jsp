<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 文件上传 -->
<!-- application/x-www-form-urlencoded   :key和value的形式 -->
<form action="${pageContext.request.contextPath}/upload1" method="post" enctype="multipart/form-data">

<input type="text" name="name" />
<input type="file" name="file" />

<input type="submit" value="提交" />
</form>

</body>
</html>