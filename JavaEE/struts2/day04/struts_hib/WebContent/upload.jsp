<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
</head>
<body>
<%--
	1.表单必须是post请求
	2.表单必须要有个 enctype:multipart/form-data

${pageContext.request.contextPath }
 --%>

<s:form action="upload" method="post" enctype="multipart/form-data">

	<s:textfield name="uname" label="用户名"></s:textfield>
	<s:file name="photo" label="头像"></s:file>

	<s:submit value="提交"></s:submit>


</s:form>


</body>
</html>