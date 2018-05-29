<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page errorPage="error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>待处理任务</title>
</head>
<body>
	<div class="container-fluid" id="wrap">
		<div class="row">
			<h2 class="text-center">待处理任务</h2>
			<div class="table-responsive col-md-12">
				<nav class="navbar navbar-default" id="query" role="navigation">
					<div class="navbar-header col-md-3">
						<span class="navbar-brand">任务列表</span>
					</div>
					<div class="navbar-collapse" id="bs-example-navbar-collapse-1">
						<form class="navbar-form navbar-right" role="search">
							<div class="form-group">
								<label>任务等级 </label>
								<select id="task_level" class="form-control">
									<option value="">查看全部</option>
									<c:forEach var="task_level" items="${dataMap.RWDJ}">
										<option value="${task_level.key}">${task_level.value}</option>
									</c:forEach>
								</select>
							</div>
							<button type="button" class="btn btn-default" id="query-btn">查询</button>
						</form>
					</div>
				</nav>
				<table class="table table-bordered table-hover table-striped" id="my_table">
					<thead>
						<tr>
							<th>任务名称</th>
							<th>任务时间</th>
							<th>任务地点</th>
							<th>所需车辆</th>
							<th>所需人员</th>
							<th>任务等级</th>
							<th>任务类型</th>
						</tr>
					</thead>
					<tbody></tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-6">
				<div class="dataTables_info" id="dataTables-example_info" role="status" aria-live="polite">
					<button type="button" class="btn btn-default" id="show_plan">查看方案</button>
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
				<!-- 查看方案 -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close close-btn" data-dismiss="modal" aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">任务调动安排</h4>
							</div>
							<div class="modal-body">
								<div class="row">
									<form class="form-horizontal" role="form">
										<div class="col-sm-10 col-sm-offset-1">
											<div class="form-group">
												<label for="need_car_num" class="col-sm-8 col-xs-8">所需车辆 (可派出:<span id="task001"></span>/总数:<span id="task002"></span>):</label>
												<div class="col-sm-4">
													<input type="text" class="form-control" id="need_car_num" disabled />
												</div>
											</div>
											<div class="form-group">
												<label for="need_person_num" class="col-sm-8 col-xs-8">所需人员 (可派出:<span id="task003"></span>/总数:<span id="task004"></span>):</label>
												<div class="col-sm-4">
													<input type="text" class="form-control" id="need_person_num" disabled/>
												</div>
											</div>
											<div class="form-group">
												<label for="task_person" class="col-sm-4 col-xs-4">请选择用户:</label>
												<select id="task_person" class="form-control" multiple></select>
											</div>
											<div class="form-group">
												<label for="task_car" class="col-sm-4 col-xs-4">请选择车辆:</label>
												<select id="task_car" class="form-control" multiple ></select>
											</div>
											<div class="form-group">
												<label for="task_user" class="col-sm-4 col-xs-4">选择负责人:</label>
												<select id="task_user" class="form-control"></select>
											</div>											
										</div>
									</form>
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default close-btn" data-dismiss="modal">关闭</button>
								<button type="button" class="btn btn-primary add-btn" id="submit_can_not_go">无法出动</button>
								<button type="button" class="btn btn-primary add-btn" id="submit_go">确认出动</button>
							</div>
						</div>
					</div>
				</div>
				<!-- /查看方案完成 -->
			</div>
		</div>
		<!-- 提醒弹出框  -->
		<div class="modal fade" id="myModal_alert" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
	</div>
	<input type="hidden" id="hid" value="0" />
	<script type="text/javascript">
		//显示所有待处理任务
		function show_list(pageNo) {
			$.ajax({
				data : {"taskLevel" : $("#task_level").val(),"pageNo":pageNo},
				url : "findAllTaskPending",
				success : function(msg) {
					json_to_table(msg, "my_table",[ "taskId","taskName", "taskTime", "taskAddress","taskCarNum","taskPersonNum", "taskLevel","taskType"]);
					$("#hid").val("0");
				}
			});
		}
		//调用
		show_list(1);
		//查询按钮
		$("#query-btn").click(function(){
			show_list(1);
		});
		//弹出查看详情的模态框
		$("#show_plan").click(function(){
			//判断是否选中
			var taskId = $("#hid").val();
			if(taskId=="0"||taskId==""){
				alert("请选择一行");
				return;
			}
			//得到所需要的车辆和人员数量
			$.ajax({
				url : "getTaskById",
				data:{"taskId":taskId},
				success : function(msg) {
					$("#need_person_num").val(msg.taskPersonNum);
					$("#need_car_num").val(msg.taskCarNum);
				}				
			});
			//先查询库存状态
			$.ajax({
				url : "getOrgState",
				success : function(msg) {
					$("#task001").html(msg.currentCarNum);
					$("#task002").html(msg.carNum);
					$("#task003").html(msg.currentPersonNum);
					$("#task004").html(msg.personNum);
				}				
			});
			//再显示车辆信息
			$.ajax({
				url:"findCarCanGo",
				success:function(msg){
					var str = "";
					for(var i=0;i<msg.length;i++){
						str += "<option value ='"+msg[i].carId+"'>"+msg[i].carLicense+"</option>";
					}
					$("#task_car").html(str);
				}
			});
			//再显示人员信息
			$.ajax({
				url:"findUserCanGo",
				success:function(msg){
					var str = "";
					for(var i=0;i<msg.length;i++){
						str += "<option value ='"+msg[i].userId+"'>"+msg[i].userRname+"</option>";
					}
					$("#task_person").html(str);
					$("#task_user").html(str);
				}
			});
			//再弹出模态框
			$("#myModal").modal();
		});
		//确认出动
		$("#submit_go").click(function(){
			if($("#task_user").val()==""||$("#task_person").val()==""||$("#task_car").val()==null){
				checkSuccess(false, $("#myModal_alert"), "请选择人员和车辆,出动");
				return;
			}
			$.ajax({
				url:"goTask",
				data:{"taskId":$("#hid").val(),"taskUserId":$("#task_user").val(),"userList":$("#task_person").val()+"","carList":$("#task_car").val()+""},
				method:"post",
				success:function(msg){
					checkSuccess(msg, $("#myModal_alert"), "出动",$("#myModal"));
					show_list(1);
				}
			})		
		});
		
		//无法出动
		$("#submit_can_not_go").click(function(){
			$.ajax({
				url:"cantGoTask",
				data:{"taskId":$("#hid").val()},
				success:function(msg){
					checkSuccess(msg, $("#myModal_alert"), "发送",$("#myModal"));
					show_list(1);
				}
			});
		});
	</script>
</body>
</html>