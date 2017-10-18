<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="s" uri="/struts-tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 通过ognl表达式获取值   value：默认会当成ognl表达式语言来解析-->
<%-- <s:property  value="'qwerdf'.length()"/> --%>



<s:property value="[0]"/><br/><%-- [0] 表示从栈顶元素开始遍历显示所有数据 --%>
<hr/>
<%-- <s:property value="[0].top"/> --%><%-- [0].top  栈顶的第一个元素 --%>
<s:property value="[0].top.detail"/>

<hr/>
<s:property value="[2].top.xxx"/>
<s:property value="[2].xxx"/>
<s:property value="xxx"/><%--会去栈里面找第一个key是xxx的值 --%>


<hr/>
<s:property value="[0].top.uname"/>

<hr/>

<h1>s标签遍历list</h1>
<%--<s:iterator>遍历的标签 list  map 
	
	var:
	写var： 写var的时候，取数据要加#
	
	不写var：

--%>
<s:iterator value="list" var="user">

<div><s:property value="#user.uname"/><s:property value="#user.upwd"/><s:property value="#user.sex"/></div>

</s:iterator>


<s:iterator value="list">
<div><s:property value="uname"/></div>
</s:iterator>



<!-- 遍历map -->
 <h1>遍历map </h1>
<s:iterator value="map">
<div><s:property value="value.uname"/><s:property value="value.upwd"/></div>
</s:iterator>

<%-- <s:property value="user.uname"/> --%>

<!-- 用这个标签可以在jsp页面上看值栈里的数据 -->



<!-- ognl表达式取出域对象中的数据 -->

查找:<s:property value="#attr.ooo"/><br/>
request:<s:property value="#request.ooo"/><br/>
session:<s:property value="#session.ooo"/><br/>
application:<s:property value="#application.ooo"/><br/>



<h1>EL表达式取出值栈中的数据(root栈和context栈都能取)</h1>
查找:${ooo }<br/>
request:${requestScope.ooo }<br/>
session:${sessionScope.ooo }<br/>
application:${applicationScope.ooo }<br/>


${xxx }

<s:debug></s:debug>
</body>
</html>