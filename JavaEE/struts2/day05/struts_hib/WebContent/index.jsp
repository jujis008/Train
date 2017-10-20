<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分页显示用户</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.1.8.3min.js"></script>
<script type="text/javascript">
	//全局变量
	var currentPage=1;//当前页
	var pageSize=10;//每页数据大小
	var totalCount;//总个数
	var totalPage;//总页数
	
	
	//页面加载完成之后
	$(function(){
		//分页显示数据
		getData();
	});
	
	//获得分页数据  currentPage  pageSize
	function getData(){
		
		//ajax去后台请求json数据
		$.ajax({
			url:"${pageContext.request.contextPath}/userByPage",
			data:{"currentPage":currentPage,"pageSize":pageSize},
			dataType:"json",
			type:"post",
			cache:"false",
			async:"true",
			success:function(data){
				
				var str="";
				//alert(data.flag);
				if(data.flag=='1'){
					for(var i=0;i<data.pb.list.length;i++){
						
						str+="<div>用户名<span>"+data.pb.list[i].uname+"</span>&nbsp;&nbsp;&nbsp;密码<span>"+data.pb.list[i].upwd+"</span>&nbsp;&nbsp;&nbsp;性别<span>"+data.pb.list[i].sex+"</span>";
						str+="<a href='javascript:void(0)' onclick='deleUser('"+data.pb.list[i].uid+"')'  >删除</a></div>";
						
					}
					
					//给全局变量赋值
					 currentPage=data.pb.currentPage;
					 pageSize=data.pb.pageSize;
					 totalCount=data.pb.totalCount;
					 totalPage=data.pb.totalPage;
					
				}
				//把数据写出去
				$("#data").html(str);
				//拼接分页尾
				getFoot();
			},
			error:function(){
				alert("服务器异常");
			}
			
			
			
		});
		
		
		
	} 
	
	//拼接分页尾    currentPage  pageSize  totalCount(总个数)  totalPage
	function getFoot(){
		
		/**
			对当前页做判断：首页  尾页  中间页
		*/
		currentPage=parseInt(currentPage);
		totalPage=parseInt(totalPage);
		pageSize=parseInt(pageSize);
		
		var str="<div>";
		if(totalPage>1){
			if(currentPage==1){//第一页：   下一页和尾页
				str+="<a href='javascript:void(0)' class='foot' page='"+(currentPage+1)+"' >下一页</a>";
				str+="<a href='javascript:void(0)' class='foot' page='"+totalPage+"' >尾页</a>";

			}
			if(currentPage==totalPage){//尾页：  上一页和首页
				str+="<a href='javascript:void(0)' class='foot' page='1' >首页</a>";
				str+="<a href='javascript:void(0)' class='foot' page='"+(currentPage-1)+"' >上一页</a>";

				
			}
			if(1<currentPage&&currentPage<totalPage){//中间页： 上一页和首页   下一页和尾页
				str+="<a href='javascript:void(0)' class='foot' page='1' >首页</a>";
				str+="<a href='javascript:void(0)' class='foot' page='"+(currentPage-1)+"' >上一页</a>";
				str+="<a href='javascript:void(0)' class='foot' page='"+(currentPage+1)+"' >下一页</a>";
				str+="<a href='javascript:void(0)' class='foot' page='"+totalPage+"' >尾页</a>";
			}

		}
		
		if(pageSize=='10'){
			str+="<select id='sel'><option value='5'>5</option><option value='10' selected='selected'>10</option><option value='15'>15</option></select>";
			
		}
		if(pageSize=='5'){
			str+="<select id='sel'><option value='5' selected='selected'>5</option><option value='10' >10</option><option value='15'>15</option></select>";
			
		}
		
		if(pageSize=='15'){
			str+="<select id='sel'><option value='5'>5</option><option value='10'>10</option><option value='15'  selected='selected'>15</option></select>";
			
		}
		
		
		str+="<span>跳转到：<input type='text' value='' id='go' /></span>";
		str+="当前页<span>"+currentPage+"</span>/总页数<span>"+totalPage+"</span>&nbsp;&nbsp;总个数<span>"+totalCount+"</span></div>"
		//添加到html页面
		$("#foot").html(str);
		
		
		
		
		//追加点击事件】
		
		$(".foot").click(function(){
			currentPage=$(this).attr("page");
			//调用ajax查询数据
			getData();
			
		});
		
		//跳转到某也
		$("#go").blur(function(){
			var a=$(this).val();
			a=parseInt(a);
			if(a>0&&a<=totalPage){
				currentPage=a;
				//查询数据
				getData();
				
			}else{
				alert("请输入正确的页码");
			}
			
			
		});
		
		//
		$("#sel").change(function(){
			var v=$(this).val();
			pageSize=v;
			
			//
			getData();
			
			
		});
		
	}


</script>
</head>
<body>

<div id="data">


</div>
<div id="foot">


</div>


</body>
</html>