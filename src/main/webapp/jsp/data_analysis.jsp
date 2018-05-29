<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page errorPage="error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>数据分析</title>
</head>
<body>
	<div class="container-fluid" id="wrap">
		<div class="row">
			<h2 class="text-center">数据分析</h2>
			<div class="table-responsive col-md-12">
				<nav class="navbar navbar-default" id="query" role="navigation">
					<div class="navbar-collapse" id="bs-example-navbar-collapse-1">
						<form class="navbar-form navbar-right" role="search">
							<div class="form-group">
								<label for="user_role">请选择年份</label> <select id="user_role" class="form-control">
									<option value="2018">2018</option>
								</select>
							</div>
							<button type="button" class="btn btn-default" id="query-btn">查询</button>
						</form>
					</div>
				</nav>
			</div>
		</div>
		<div id="data_div" class="row">
			<div id="chartmain" style="width:100%; height: 400px;"></div>
		</div>
	</div>
	<!-- 提醒弹出框  -->
	<div class="modal fade" id="myModal_alert" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="width: 200px;">
			<div class="modal-content">
				<div class="modal-body">
					<p></p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<input type="hidden" id="hid" value="0" />

	<script type="text/javascript">
	
	var xzhou;
	var yzhou;
	//alert(xzhou);
	$.ajax({
		url:"getData1",
		data:{"year":2018},
		async:false,
		success:function(msg){
			xzhou = Object.keys(msg);
			yzhou = Object.values(msg);
		}
	});
    //指定图标的配置和数据
option = {
    title: {
        x: 'center',
        text: '成都市各机构任务次数',
    },
    xAxis: {
        type: 'category',
        data: xzhou,
        "axisLabel":{  
            interval: 0  
        } 
    },
    yAxis: {
        type: 'value'
    },
    series: [{
        data: yzhou,
        type: 'bar',
        itemStyle:{
            normal:{
                color:'#00a0ed'
            }
        },
    }]
};

                    
                    
    //初始化echarts实例
    var myChart = echarts.init(document.getElementById('chartmain'));

    //使用制定的配置项和数据显示图表
    myChart.setOption(option);
	</script>
</body>
</html>