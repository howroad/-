<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page errorPage="error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>角色管理</title>
</head>
<body>
	<div class="container-fluid" id="wrap">
		<div class="row">
			<h2 class="text-center">角色管理</h2>
			<div class="table-responsive col-md-12">
				<nav class="navbar navbar-default" id="query" role="navigation">
					<div class="navbar-header col-md-3">
						<span class="navbar-brand">按照角色查询</span>
					</div>
					<div class="navbar-collapse" id="bs-example-navbar-collapse-1">
						<form class="navbar-form navbar-right" role="search">
							<div class="form-group">
								<label>角色列表 </label> <select id="role_select" class="form-control">
									<!-- <option value="">全部</option> -->
									<c:forEach var="role" items="${roleMap}">
										<option value="${role.key}">${role.value}</option>
									</c:forEach>
								</select>
							</div>
							<button type="button" class="btn btn-default" id="query-btn">查询</button>
							<button type="button" class="btn btn-default" id="update-role-user">修改管理的角色</button>
							<button type="button" class="btn btn-default" id="update_role_power">修改管理的权限</button>
						</form>
					</div>
				</nav>
				<table class="table table-bordered table-hover table-striped" id="my_table">
					<thead>
						<tr>
							<th>姓名</th>
							<th>性别</th>
							<th>账号</th>
							<th>电话</th>
							<th>家庭住址</th>
						</tr>
					</thead>
					<tbody></tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-6">
				<div class="dataTables_info" id="dataTables-example_info" role="status" aria-live="polite">
					<button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal" id="add_role">添加角色</button>
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
				<!-- 修改管理的角色 -->
				<div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close close-btn" data-dismiss="modal" aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">修改管理的用户</h4>
							</div>
							<div class="modal-body">
								<div class="row">
									<form class="form-horizontal" role="form">
										<div class="col-sm-10 col-sm-offset-1">
											<div class="form-group">
												<label for="update_del_person" class="col-sm-4 col-xs-4">需要删除的用户:</label>
												<select id="update_del_person" class="form-control" multiple></select>
											</div>
											<div class="form-group">
												<label for="update_add_person" class="col-sm-4 col-xs-4">需要添加的用户:</label>
												<select id="update_add_person" class="form-control" multiple ></select>
											</div>
										</div>
									</form>
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default close-btn" data-dismiss="modal">关闭</button>
								<button type="button" class="btn btn-primary add-btn" id="submit_role_user">确认修改</button>
							</div>
						</div>
					</div>
				</div>
				<!-- /修改管理的角色完成 -->
				<!-- 添加角色 -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close close-btn" data-dismiss="modal" aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">添加角色</h4>
							</div>
							<div class="modal-body">
								<div class="row">
									<form class="form-horizontal" role="form">
										<div class="col-sm-10">
											<div class="form-group div1">
												<label for="add_role_name" class="col-sm-3 col-xs-3 control-label">角色名称</label>
												<div class="col-sm-9">
													<input type="text" class="form-control" id="add_role_name" placeholder="请输入" name="not-none-check">
												</div>
											</div>
											<div class="form-group div2">
												<label for="add_role_desc" class="col-sm-3 col-xs-3 control-label">角色描述</label>
												<div class="col-sm-9">
													<input type="text" class="form-control" id="add_role_desc" placeholder="请输入" name="not-none-check">
												</div>
											</div>
											<div class="form-group div3">
												<label for="add_role_powers" class="col-sm-3 col-xs-3 control-label">选择权限</label>
												<div class="col-sm-9">
													<select id="add_role_powers" class="form-control" multiple="multiple">
														<c:forEach var="power" items="${powerMap}">
															<option value="${power.key}">${power.value}</option>
														</c:forEach>
													</select>
												</div>
											</div>
										</div>
									</form>
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default close-btn" data-dismiss="modal">关闭</button>
								<button type="button" class="btn btn-primary add-btn" id="add_dlog_submit">确认添加</button>
							</div>
						</div>
					</div>
				</div>
				<!-- /添加角色完成 -->
				<!-- 修改角色权限 -->
				<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close close-btn" data-dismiss="modal" aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">修改角色权限</h4>
							</div>
							<div class="modal-body">
								<div class="row">
									<form class="form-horizontal" role="form">
										<div class="col-sm-10">
											<div class="form-group">
												<label for="update2_role_name" class="col-sm-4 col-xs-4 control-label">角色名称</label>
												<div class="col-sm-8">
													<input type="text" class="form-control" id="update2_role_name">
												</div>
											</div>
											<div class="form-group">
												<label for="update2_del_powers" class="col-sm-4 col-xs-4 control-label">需要删除的权限:</label>
												<div class="col-sm-8">
													<select id="update2_del_powers" class="form-control" multiple="multiple"></select>
												</div>
											</div>
											<div class="form-group">
												<label for="update2_add_powers" class="col-sm-4 col-xs-4 control-label">需要添加的权限:</label>
												<div class="col-sm-8">
													<select id="update2_add_powers" class="form-control" multiple="multiple"></select>
												</div>
											</div>
										</div>
									</form>
								</div>
							</div>							
							<div class="modal-footer">
								<button type="button" class="btn btn-default close-btn" data-dismiss="modal">关闭</button>
								<button type="button" class="btn btn-primary add-btn" id="submit_role_power">确认修改</button>
							</div>
						</div>
					</div>
				</div>
				<!-- /修改角色权限完成 -->
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
		//显示所有员工分页信息
		function show_list(pageNo) {
			$.ajax({
				data : {
					"pageNo" : pageNo,
					"roleId" : $("#role_select").val()
				},
				url : "roleManager",
				success : function(msg) {
					json_to_table(msg, "my_table",[ "userId", "userRname", "userGender", "userName","userTel", "userAddress" ]);
					$("#hid").val("0");
				}
			});
		}
		//调用
		show_list(1);
		//查询
		$("#query-btn").click(function() {
			show_list(1);
		});
		//添加角色
		$("#add_dlog_submit").click(
			function() {
				if(!lu_check("myModal")){
					return false;
				}
				$.ajax({
					method : "post",
					data : {
						"roleName" : $("#add_role_name").val(),
						"roleDesc" : $("#add_role_desc").val(),
						"powerIds" : $("#add_role_powers").val() + ""
					},
					url : "addRole",
					success : function(msg) {
						checkSuccess(msg, $("#myModal_alert"), "添加",
								$("#myModal"));
					}
			});
		});
		//弹出显示修改管理的角色的内容
		$("#update-role-user").click(function(){
			$("#myModal3").modal();
			$.ajax({
				url:"findAllUserInRole",
				data:{"roleId":$("#role_select").val()},
				success:function(msg){
					var str = "";
					for(var i=0;i<msg.length;i++){
						str += "<option value='"+msg[i].userId+"'>"+msg[i].userRname+"</option>";
					}
					$("#update_del_person").html(str);
				}
			});
			$.ajax({
				url:"findAllUserNotInRole",
				data:{"roleId":$("#role_select").val()},
				success:function(msg){
					var str = "";
					for(var i=0;i<msg.length;i++){
						str += "<option value='"+msg[i].userId+"'>"+msg[i].userRname+"</option>";
					}
					$("#update_add_person").html(str);
				}
			});
		});
		//修改角色用户
		$("#submit_role_user").click(function(){
			$.ajax({
				url:"updateRoleUser",
				method:"post",
				data:{"addUsers":$("#update_add_person").val()+"","delUsers":$("#update_del_person").val()+"","roleId":$("#role_select").val()},
				success:function(msg){
					checkSuccess(msg, $("#myModal_alert"), "修改角色下的用户",$("#myModal3"));
				}
			});
		});
		//弹出显示修改角色权限的内容
		$("#update_role_power").click(function(){
			$("#myModal2").modal();
			$("#update2_role_name").val($("#role_select").find("option:selected").text());
			$.ajax({
				url:"findAllPowerInRole",
				data:{"roleId":$("#role_select").val()},
				success:function(msg){
					var str = "";
					for(var i=0;i<msg.length;i++){
						str += "<option value='"+msg[i].powerId+"'>"+msg[i].powerName+"</option>";
					}
					$("#update2_del_powers").html(str);
				}
			});
			$.ajax({
				url:"findAllPowerNotInRole",
				data:{"roleId":$("#role_select").val()},
				success:function(msg){
					var str = "";
					for(var i=0;i<msg.length;i++){
						str += "<option value='"+msg[i].powerId+"'>"+msg[i].powerName+"</option>";
					}
					$("#update2_add_powers").html(str);
				}
			});
		});
		//修改角色权限
		$("#submit_role_power").click(function(){
			$.ajax({
				url:"updateRolePower",
				method:"post",
				data:{"addPowers":$("#update2_add_powers").val()+"","delPowers":$("#update2_del_powers").val()+"","roleId":$("#role_select").val()},
				success:function(msg){
					checkSuccess(msg, $("#myModal_alert"), "修改角色下的权限",$("#myModal2"));
				}
			});
		});
	</script>
</body>
</html>