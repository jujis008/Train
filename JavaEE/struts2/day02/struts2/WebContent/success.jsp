<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
2333333333333333~~~~溜了
<br/>
从四个域对象里从小到大的顺序查找：${name }<br/>
指定从request域对象中取数据：${requestScope.name }<br/>
指定从session里面取：${sessionScope.name }<br/>
指定从page里面取：${pageScope.name }<br/>
指定从application里面取：${applicationScope.name }<br/>
</body>
</html>