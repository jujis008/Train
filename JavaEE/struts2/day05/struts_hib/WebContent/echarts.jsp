<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.1.8.3min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/echarts.js"></script>

</head>
<body>
	<input type="button" value="生成图表统计" id="chart"/>
    <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
    <div id="main" style="width: 600px;height:400px;"></div>

</body>
<script type="text/javascript">

		$("#chart").click(function(){
			//ajax请求数据
			$.ajax({
				url:"${pageContext.request.contextPath}/chart",	
				dataType:"json",
				type:"post",
				cache:"false",
				async:"true",
				success:function(data){
					option.xAxis.data=data.xAxis;
					option.series[0].data=data.yAxis;
					
					
					 // 使用刚指定的配置项和数据显示图表。
			        myChart.setOption(option);
				},
				error:function(){
					
					alert("服务器端异常");
				}
				
				
				
			})
			
			
			
			
		
			
		});


        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));

        // 指定图表的配置项和数据
        var option = {
            title: {
                text: 'ECharts 入门示例'
            },
            tooltip: {},
            legend: {
                data:['性别']
            },
            xAxis: {
                data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
            },
            yAxis: {},
            series: [{
                name: '性别',
                type: 'bar',
                data: [15, 20, 36, 10, 10, 20]
            }]
        };

       
    </script>
</html>