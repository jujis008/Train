<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>图书列表页</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript">
	function checkDelete() {
		var flag = window.confirm("确认要删除吗");
		if (flag) {
			return true;
		} else {
			return false;
		}
	}
	function checkAll(){
		//获取全选 复选框的选中状态
		var checked = document.getElementById("ckAll").checked;
		//设置其他复选框的状态
		var ids = document.getElementsByName("ids");
		for(var i=0;i<ids.length;i++){
			ids[i].checked = checked;
		}
	}
	//获取被选中的复选框的value值 -->id 传到servlet中
	function deleteAll(){
		var ids = document.getElementsByName("ids");
		//拼接 id
		var str="";
		for(var i=0;i<ids.length;i++){
			//判断是否被选中
			if(ids[i].checked){
				//ids=1&ids=5&ids=10 如果选中就拼接字符串
				str+="&ids="+ids[i].value;
			}
		}
		location.href="bookManagerServlet?flag=deleteAll"+str;
	}
</script>

</head>

<body>

	<h2 align="center">图书列表页</h2>
	<hr>
<table border="0" align="center" width="80%">
	<tr>
		<td colspan="2" align="center">
			<form action="bookManagerServlet?flag=search" method="post">
				书名<input type="text" name="name">&nbsp;&nbsp;
				价格<input type="text" name="minPrice" size="10">--
					<input type="text" name="maxPrice" size="10">&nbsp;&nbsp;
				种类<select name="category">
						<option value="" selected="selected">--选择商品类加--</option>
						<option value="文学">文学</option>
						<option value="生活">生活</option>
						<option value="计算机">计算机</option>
						<option value="外语">外语</option>
						<option value="经营">经营</option>
						<option value="励志">励志</option>
						<option value="社科">社科</option>
						<option value="学术">学术</option>
						<option value="少儿">少儿</option>
						<option value="艺术">艺术</option>
						<option value="原版">原版</option>
						<option value="科技">科技</option>
						<option value="考试">考试</option>
						<option value="生活百科">生活百科</option>
				</select>&nbsp;&nbsp;
				<input type="submit" value="查询">
			</form>
		</td>
	</tr>
<tr>
	<td>
		<a href="add.jsp">添加图书</a>&nbsp;&nbsp;
		<a href="javascript:deleteAll()">批量删除</a>
	</td>
	<td align="right">
		首页 上一页 1 2 3 4 下一页 尾页 
		<input type="text" id="" size="5"><a href="#">GO</a>
	</td>
</tr>
</table>
	<table border="1" align="center" width="80%">
		<tr>
			<td><input type="checkbox" name="ckAll" id="ckAll" onclick="checkAll()">全选</td>
			<td>序号</td>
			<td>书名</td>
			<td>价格</td>
			<td>数量</td>
			<td>种类</td>
			<td>描述</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${books }" var="book" varStatus="vs">
			<tr>
				<td><input type="checkbox" name="ids" value="${book.id}"></td>
				<td>${vs.count }</td>
				<td>${book.name }</td>
				<td>${book.price }</td>
				<td>${book.num }</td>
				<td>${book.category }</td>
				<td>${book.description }</td>
				<td><a href="bookManagerServlet?flag=delete&id=${book.id }"
					onclick="return checkDelete()">删除</a> &nbsp;
					<a href="bookManagerServlet?flag=preUpdate&id=${book.id }">修改</a>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>
