<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page errorPage="error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>进行中任务</title>
</head>
<body>
	<div class="container-fluid" id="wrap">
		<div class="row">
			<h2 class="text-center">进行中</h2>
			<div class="table-responsive col-md-12">
				<nav class="navbar navbar-default" id="query" role="navigation">
					<div class="navbar-header col-md-3">
						<span class="navbar-brand">派遣列表</span>
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
					<button type="button" class="btn btn-default" id="show_plan">查看详情</button>
					<button type="button" class="btn btn-default" id="send_message">反馈消息</button>
					<button type="button" class="btn btn-default" id="end_task">结束任务</button>
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
								<h4 class="modal-title" id="myModalLabel">派遣详情</h4>
							</div>
							<div class="modal-body">
								<div class="row">
									<form class="form-horizontal" role="form">
										<div class="col-sm-10 col-sm-offset-1">
											<div class="form-group">
												<label class="col-sm-8 col-xs-8">开始时间 :　　<span id="s_start_time"></span></label>
											</div>
											<div class="form-group">
												<label class="col-sm-8 col-xs-8">任务地点 :　　<span id="s_address"></span></label>
											</div>											
											<div class="form-group">
												<label class="col-sm-8 col-xs-8">出发时间 :　　<span id="s_go_time"></span></label>
											</div>
											<div class="form-group">
												<label class="col-sm-8 col-xs-8">负责人员 :　　<span id="s_task_person"></span>(电话:<span id="s_task_person_tel"></span>)</label>
											</div>											
											<div class="form-group">
												<label class="col-sm-8 col-xs-8">车辆(实际派出/需要车辆):　　<span id="s_car1"></span>/<span id="s_car2"></span></label>
											</div>																							
											<div class="form-group">
												<label class="col-sm-8 col-xs-8">人员 (实际派出/需要人数):　　<span id="s_person1"></span>/<span id="s_person2"></span></label>
											</div>
											<div class="form-group">
												<label for="s_person_list" class="col-sm-4 col-xs-4">正在执行任务的用户:</label>
												<select id="s_person_list" class="form-control" multiple disabled></select>
											</div>
											<div class="form-group">
												<label for="s_car_list" class="col-sm-4 col-xs-4">正在执行任务的车辆:</label>
												<select id="s_car_list" class="form-control" multiple disabled></select>
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
				<!-- /查看方案完成 -->
				<!-- 反馈消息开始-->
				<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close close-btn" data-dismiss="modal" aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">反馈消息</h4>
							</div>
							<div class="modal-body">
								<table class="table">
									<thead><tr><th>时间</th><th>消息内容</th></tr></thead>
									<tbody id="s_tbody"></tbody>
								</table>
								<label for="msg_content">反馈内容</label>
								<input type="text" class="form-control" id="msg_content"/>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-primary add-btn" id="submit_send">发送</button>
								<button type="button" class="btn btn-default close-btn" data-dismiss="modal">关闭</button>
							</div>
						</div>
					</div>
				</div>
				<!-- /反馈消息完成 -->
				<!-- 确认消息-->
				<div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close close-btn" data-dismiss="modal" aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">你确定结束吗?</h4>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-primary add-btn" id="submit_end">确定</button>
								<button type="button" class="btn btn-default close-btn" data-dismiss="modal">关闭</button>
							</div>
						</div>
					</div>
				</div>
				<!-- /确认消息完成 -->				
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
		//显示所有进行中任务
		function show_list(pageNo) {
			$.ajax({
				data : {"taskLevel" : $("#task_level").val(),"pageNo":pageNo},
				url : "findAllTaskOngoing",
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
			//得到所需要的数据
			$.ajax({
				url : "showTaskVO",
				data:{"taskId":taskId},
				success : function(msg) {
					$("#s_start_time").html(msg.taskTime);
					$("#s_address").html(msg.taskAddress);
					$("#s_go_time").html(msg.taskStartTime);
					$("#s_task_person").html(msg.taskPerson);
					$("#s_task_person_tel").html(msg.taskPersonTel);
					$("#s_car1").html(msg.realCarNum);
					$("#s_car2").html(msg.taskCarNum);
					$("#s_person1").html(msg.realPersonNum);
					$("#s_person2").html(msg.taskPersonNum);
					var str1 = "";
					var str2 = "";
					var users = msg.users;
					var cars = msg.cars;
					for(var i=0;i<users.length;i++){
						str1+="<option valu="+users[i].userId+">"+users[i].userRname+"</option>";
					}
					for(var i=0;i<cars.length;i++){
						str2 +="<option>"+cars[i].carLicense+"</option>";
					}
					$("#s_person_list").html(str1);
					$("#s_car_list").html(str2);
				}				
			});
			//再弹出模态框
			$("#myModal").modal();
		});
		//弹出反馈消息
		$("#send_message").click(function(){
			//判断是否选中
			var taskId = $("#hid").val();
			if(taskId=="0"||taskId==""){
				alert("请选择一行");
				return;
			}
			//得到所需要的数据
			$.ajax({
				url : "showTaskVO",
				data:{"taskId":taskId},
				success : function(msg) {
					var msgs = msg.messages;
					var str = "";
					for(var i=0;i<msgs.length;i++){
						str += "<tr><td>"+msgs[i].msgTime+"</td><td>"+msgs[i].msgContent+"</td></tr>";
					}
					$("#s_tbody").html(str);
				}				
			});
			//再弹出模态框
			$("#myModal2").modal();
		});
		//发送反馈
		$("#submit_send").click(function(){
			if(!lu_check("myModal2")){
				return false;
			}
			$.ajax({
				data:{"taskId":$("#hid").val(),"msg":$("#msg_content").val()},
				url:"sendMsg",
				method:"post",
				success:function(msg){
					checkSuccess(msg, $("#myModal_alert"), "发送消息",$("#myModal2"));
					show_list(1);
				}
			});
		});
		//结束任务
		$("#end_task").click(function(){
			//判断是否选中
			var taskId = $("#hid").val();
			if(taskId=="0"||taskId==""){
				alert("请选择一行");
				return;
			}
			$("#myModal3").modal();
		});
		//发送结束
		$("#submit_end").click(function(){
			$.ajax({
				data:{"taskId":$("#hid").val()},
				url:"endTask",
				success:function(msg){
					checkSuccess(msg, $("#myModal_alert"), "归队",$("#myModal3"));
					show_list(1);
				}
			});
		});
	</script>
</body>
</html>