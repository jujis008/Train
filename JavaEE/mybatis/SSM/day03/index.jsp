<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.1.8.3min.js"></script>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/Pager.css"></link>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.pager.js"></script>

<script type="text/javascript">


//删除用户 根据id删除   交给你们做      可以吧当前页传过去
function deleteUser(id){
	alert(id);
		
}
//修改直接跳转到界面

$(function(){
	 

	queryUser(1);
	
});


function  queryUser(currentPage){
	$.ajax({
		url:"${pageContext.request.contextPath }/ajaxQueryUserByPage",
		data:{"currentPage":currentPage},
		dataType:"json",
		type:"post",
		cache:false,
		async:true,
		success:function(data){
			//alert(data.msg);
			var str="";
			if(data.msg=="ok"){//有数据
				
				for(var i=0;i<data.pb.list.length;i++){
					//页面拼接数据
					str+="<div><span>用户名："+data.pb.list[i].uname+"<span>&nbsp;&nbsp;&nbsp;<span>密码："+data.pb.list[i].upwd+"</span><a href='javascript:void(0);' onclick='deleteUser(\""+data.pb.list[i].uid+"\")' >删除</a></div>";
					
				}
				$("#pageData").html(str);
				//回调函数
				//---------pager分页插件  (此处不要换行)--------------		
				$("#pager").pager({ pagenumber: data.pb.currentPage, pagecount: data.pb.totalPage, buttonClickCallback: queryUser });
			
			}
			
		},
		error:function(){
			alert("服务器异常");
		},
		complete:function(){//请求访问完成之后  会走该函数
			//拼接分页的尾
			
	
			
			
		},
		beforeSend:function(){//发送请求之前会走的函数
			
		}
		
		
		
	});
	
	
}

 /* PageClick = function(pageclickednumber) {
    $("#pager").pager({ pagenumber: pageclickednumber, pagecount: 15, buttonClickCallback: PageClick });
    $("#result").html("Clicked Page " + pageclickednumber);
}  */

</script>

</head>
<body>
<a href="javascript:void(0)" id="queryUser" >分页查询所有用户</a>

<div id="pageData">



</div>
<!-- <h1 id="result">Click the pager below.</h1> -->
<div id="pager" ></div>

</body>
</html>