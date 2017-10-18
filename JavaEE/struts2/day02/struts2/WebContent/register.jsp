<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>属性驱动方式</h1>
<form action="${pageContext.request.contextPath }/register1" method="post">
	<div>用户名：<input type="text" name="uname" value="" /></div>
	<div>密　码：<input type="password" name="upwd" value="" /></div>
	<div>性　别：男<input type="radio" name="ugender" value="男" />
			女<input type="radio" name="ugender" value="女" />
	</div>
	<div><input type="submit" value="提交" /></div>
</form>

<h1>OGNL表达式方式</h1>
<form action="${pageContext.request.contextPath }/register2" method="post">
	<div>用户名：<input type="text" name="user.uname" value="" /></div>
	<div>密　码：<input type="password" name="user.upwd" value="" /></div>
	<div>性　别：男<input type="radio" name="user.ugender" value="男" />
			女<input type="radio" name="user.ugender" value="女" />
	</div>
	<div><input type="submit" value="提交" /></div>
</form>

<h1>模型驱动的方式</h1>
<form action="${pageContext.request.contextPath }/register3" method="post">
	<div>用户名：<input type="text" name="uname" value="" /></div>
	<div>密　码：<input type="password" name="upwd" value="" /></div>
	<div>性　别：男<input type="radio" name="ugender" value="男" />
			女<input type="radio" name="ugender" value="女" />
	</div>
	<div><input type="submit" value="提交" /></div>
</form>


<h1>注入List</h1>
<form action="${pageContext.request.contextPath }/register4" method="post">
	<div>用户名：<input type="text" name="list[0].uname" value="" /></div>
	<div>密　码：<input type="password" name="list[0].upwd" value="" /></div>
	<div>性　别：男<input type="radio" name="list[0].ugender" value="男" />
			女<input type="radio" name="list[0].ugender" value="女" />
	</div>
	
	<div>用户名：<input type="text" name="list[1].uname" value="" /></div>
	<div>密　码：<input type="password" name="list[1].upwd" value="" /></div>
	<div>性　别：男<input type="radio" name="list[1].ugender" value="男" />
			女<input type="radio" name="list[1].ugender" value="女" />
	</div>
	<div><input type="submit" value="提交" /></div>
</form>

<h1>注入Map</h1>
<form action="${pageContext.request.contextPath }/register5" method="post">
	<div>用户名：<input type="text" name="map['one'].uname" value="" /></div>
	<div>密　码：<input type="password" name="map['one'].upwd" value="" /></div>
	<div>性　别：男<input type="radio" name="map['one'].ugender" value="男" />
			女<input type="radio" name="map['one'].ugender" value="女" />
	</div>
	
	<div>用户名：<input type="text" name="map['two'].uname" value="" /></div>
	<div>密　码：<input type="password" name="map['two'].upwd" value="" /></div>
	<div>性　别：男<input type="radio" name="map['two'].ugender" value="男" />
			女<input type="radio" name="map['two'].ugender" value="女" />
	</div>
	<div><input type="submit" value="提交" /></div>
</form>




<h1>属性驱动方式</h1>
<form action="${pageContext.request.contextPath }/register1" method="post">
	<div>用户名：<input type="text" name="uname" value="" /></div>
	<div>密　码：<input type="password" name="upwd" value="" /></div>
	<div>性　别：男<input type="radio" name="ugender" value="男" />
			女<input type="radio" name="ugender" value="女" />
	</div>
	<div><input type="text" name="birthday" value=""  /></div>
	
	<div>
	西瓜：<input type="checkbox" name="hobby" value="西瓜" />
	大西瓜：<input type="checkbox" name="hobby" value="大西瓜" />
	樱桃：<input type="checkbox" name="hobby" value="樱桃" />
	</div>
	
	<div><input type="submit" value="提交" /></div>
</form>

</body>
</html>