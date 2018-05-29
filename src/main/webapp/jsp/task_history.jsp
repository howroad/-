<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>部门历史任务</title>
</head>
<body>
    <div class="container-fluid" id="wrap">
        <div class="row">
            <h2 class="text-center">部门历史任务</h2>
            <div class="table-responsive col-md-12">
                <nav class="navbar navbar-default" id="query" role="navigation">
                    <div class="navbar-collapse" id="bs-example-navbar-collapse-1">
                        <form class="navbar-form navbar-right" role="search">
                        	<div class="form-group">
                            	<label for="start_date">查询时间范围：</label>
                            	<input type="date" id="start_date" class="form-control"/>
                        	</div>
                       	 	<div class="form-group">
                            	<label for="end_date">至</label>
                            	<input type="date" id="end_date" class="form-control"/>
                        	</div>
                        	<div class="form-group">
                            	<label for="task_name">事件名称</label>
                                <input type="text" class="form-control" id="task_name" >
                        	</div>
                            <button type="button" class="btn btn-default" id="query-btn">查询</button>
                        </form>
                    </div>
                </nav>
                <table class="table table-bordered table-hover table-striped" id="my_table">
                    <thead>
                    <tr>
                        <th>任务名称</th>
                        <th>事件类型</th>
                        <th>地点</th>
                        <th>负责人</th>
                        <th>开始时间</th>
                        <th>结束时间</th>
                        <th>任务等级</th>
                    </tr>
                    </thead>
                    <tbody></tbody>
                </table>
            </div>
        </div>
        <div class="row">
	        <div class="col-sm-6">
	            <div class="dataTables_info" id="dataTables-example_info" role="status" aria-live="polite">
	                <button type="button" class="btn btn-default" id="task_view_btn">查看详情</button>
	            </div>
	        </div>
	        <div class="col-xm-6 col-md-6 col-sm-6 text-right pull-right">
	        	<!-- 分页开始 -->
				<nav class="text-center">
				 	<ul class="pagination" id="page_nav"></ul>
				</nav>
				<!-- 分页结束 -->
	        </div>
	    </div>
        
        <div class="row">
        <!-- 模态框 -->
            <div class="col-xs-6 col-md-6">
                <!-- 任务详情 -->
                <div class="modal fade small_font" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close close-btn" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h4 class="modal-title" id="myModalLabel">任务详情</h4>
                            </div>
                            <div class="modal-body">
                                <div class="row">
                                    <form class="form-horizontal" role="form">
                                        <div class="col-sm-6">
                                            <div class="form-group div1">
                                                <label for="task_name_view" class="col-sm-3 col-xs-3 control-label">事件名称</label>
                                                <div class="col-sm-9">
                                                    <input type="text" class="form-control" id="task_name_view" disabled/>
                                                </div>
                                            </div>
                                            <div class="form-group div2">
                                                <label for="org_name_view" class="col-sm-3 col-xs-3 control-label">负责机构</label>
                                                <div class="col-sm-9">
                                                    <input type="text" class="form-control" id="org_name_view" disabled/>
                                                </div>
                                            </div>
                                            <div class="form-group div3">
                                                <label for="leader_name_view" class="col-sm-3 col-xs-3 control-label">负责人</label>
                                                <div class="col-sm-9">
                                                    <input type="text" class="form-control" id="leader_name_view" disabled/>
                                                </div>
                                            </div>
                                            <div class="form-group div4">
                                                <label for="person_num_view" class="col-sm-3 col-xs-3 control-label">指派人数</label>
                                                <div class="col-sm-9">
                                                    <input type="text" class="form-control" id="person_num_view" disabled/>
                                                </div>
                                            </div>
                                            <div class="form-group div5">
                                                <label for="start_time_view" class="col-sm-3 col-xs-3 control-label">开始时间</label>
                                                <div class="col-sm-9">
                                                    <input type="text" class="form-control" id="start_time_view" disabled/>
                                                </div>
                                            </div>
                                            <div class="form-group div6">
                                                <label for="task_address_view" class="col-sm-3 col-xs-3 control-label">详细地址</label>
                                                <div class="col-sm-9">
                                                    <input type="text" class="form-control" id="task_address_view" disabled/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group div8">
                                                <label for="task_level_view" class="col-sm-3 col-xs-3 control-label">事件等级</label>
                                                <div class="col-sm-9">
                                                    <input type="text" class="form-control" id="task_level_view" disabled/>
                                                </div>
                                            </div>
                                            <div class="form-group div9">
                                                <label for="task_type_view" class="col-sm-3 col-xs-3 control-label">事件类型</label>
                                                <div class="col-sm-9">
                                                    <input type="text" class="form-control" id="task_type_view" disabled/>
                                                </div>
                                            </div>
                                            <div class="form-group div10">
                                                <label for="leader_tel_view" class="col-sm-3 col-xs-3 control-label">负责人电话</label>
                                                <div class="col-sm-9">
                                                    <input type="text" class="form-control" id="leader_tel_view" disabled/>
                                                </div>
                                            </div>
                                            <div class="form-group div11">
                                                <label for="car_num_view" class="col-sm-3 col-xs-3 control-label">指派车辆</label>
                                                <div class="col-sm-9">
                                                    <input type="text" class="form-control" id="car_num_view" disabled/>
                                                </div>
                                            </div>
                                            <div class="form-group div12">
                                                <label for="end_time_view" class="col-sm-3 col-xs-3 control-label">结束时间</label>
                                                <div class="col-sm-9">
                                                    <input type="text" class="form-control" id="end_time_view" disabled/>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default close-btn" data-dismiss="modal">关闭</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <input type="hidden" id="hid" value="0"/> 
    <script type="text/javascript">
  	//显示所有任务分页信息
	function show_list(pageNo){
		$.ajax({
			method:"post",
			data:{"pageNo":pageNo,
				"startTime":$("#start_date").val(),
				"endTime":$("#end_date").val(),
				"taskName":$("#task_name").val()
				},
			url:"showAllTaskByOrg",
			success:function(msg){
				json_to_table(msg,"my_table",["taskId","taskName","taskType","taskAddress","leaderName","startTime","endTime","taskLevel"]);
				$("#hid").val("0");
			}
		});
	}
    //调用
	show_list(1);
	$("#query-btn").click(function(){
    	show_list(1);
    });
	//查看历史事件详情
	$("#task_view_btn").click(function(){
		var taskId = $("#hid").val();
		if(taskId=="0"||taskId==""){
			alert("请选择一行");
			return;
		}
		$.ajax({
			url:"showHistoryById",
			data:{"taskId":taskId},
			success:function(msg){
				$("#task_name_view").val(msg.taskName);
				$("#org_name_view").val(msg.orgName);
				$("#leader_name_view").val(msg.leaderName);
				$("#person_num_view").val(msg.personNum);
				$("#start_time_view").val(msg.startTime);
				$("#task_address_view").val(msg.taskAddress);
				$("#task_level_view").val(msg.taskLevel);
				$("#task_type_view").val(msg.taskType);
				$("#leader_tel_view").val(msg.leaderTel);
				$("#car_num_view").val(msg.carNum);
				$("#end_time_view").val(msg.endTime);
			}
		});
		$("#myModal2").modal();
    });
    </script>
</body>
</html>