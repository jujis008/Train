<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<div id="divhead">
	<table cellspacing="0" class="headtable">
		<tr>
			<td>
			<a href="index.jsp">
				<img src="images/logo.png"width="95" height="30" border="0" /> 
			</a>
			</td>
			<td style="text-align:right"><img src="images/cart.gif"
				width="26" height="23" style="margin-bottom:-4px" />&nbsp;
				<a href="cart.jsp">购物车</a> | 
				<a href="#">帮助中心</a> | 
				
				<a href="login.jsp">您好,请登录</a>
				
				
				|<a href="register.jsp">新用户注册</a>
				
				
				|<a href="${pageContext.request.contextPath }/UserServlet?action=loginOut">注销</a> |
				| <a href="myAccount.jsp">我的账户</a> 
				</td>
		</tr>
	</table>
</div>