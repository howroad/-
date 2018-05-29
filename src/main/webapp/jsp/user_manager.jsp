<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page errorPage="error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>人员管理</title>
</head>
<body>
	<div class="container-fluid" id="wrap">
		<div class="row">
			<h2 class="text-center">人员管理</h2>
			<div class="table-responsive col-md-12">
				<nav class="navbar navbar-default" id="query" role="navigation">
					<div class="navbar-collapse" id="bs-example-navbar-collapse-1">
						<form class="navbar-form navbar-right" role="search">
							<div class="form-group">
								<label for="user_role">角色</label>
								<select id="user_role" class="form-control">
									<option value="">全部</option>
									<c:forEach var="role" items="${roleMap}">
										<option value="${role.key}">${role.value}</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<label for="user_name">员工姓名</label> <input type="text" class="form-control" id="user_name">
							</div>
							<button type="button" class="btn btn-default" id="query-btn">查询</button>
						</form>
					</div>
				</nav>
				<table class="table table-bordered table-hover table-striped" id="my_table">
					<thead>
						<tr>
							<th>姓名</th>
							<th>性别</th>
							<th>邮箱</th>
							<th>电话</th>
							<th>角色</th>
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
					<button type="button" class="btn btn-default" id="show_user_info">查看详情</button>
					<button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal1" id="add_user">添加员工</button>
					<button type="button" class="btn btn-default" id="update_user">修改员工信息</button>
					<button type="button" class="btn btn-default" id="delete_user">删除员工</button>
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
				<!-- 查看详情-->
				<div class="modal fade small_font" id="myModal0" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close close-btn" data-dismiss="modal" aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">查看员工</h4>
							</div>
							<div class="modal-body">
								<div class="row">
									<form class="form-horizontal" role="form">
										<div class="col-sm-6">
											<div class="form-group div1">
												<label for="show_user_name" class="col-sm-3 col-xs-3 control-label">用户名</label>
												<div class="col-sm-9">
													<input type="text" class="form-control" id="show_user_name" placeholder="请输入" disabled>
												</div>
											</div>
											<div class="form-group div3">
												<label for="show_user_rname" class="col-sm-3 col-xs-3 control-label">真实姓名 </label>
												<div class="col-sm-9">
													<input type="text" class="form-control" id="show_user_rname" placeholder="请输入" disabled>
												</div>
											</div>
											<div class="form-group div4">
												<label for="show_user_tel" class="col-sm-3 col-xs-3 control-label">电话</label>
												<div class="col-sm-9">
													<input type="text" class="form-control" id="show_user_tel" placeholder="请输入" disabled>
												</div>
											</div>
											<div class="form-group div6">
												<label for="show_user_date" class="col-sm-3 col-xs-3 control-label">生日</label>
												<div class="col-sm-9">
													<input type="text" class="form-control" id="show_user_date" placeholder="请输入" disabled>
												</div>
											</div>
											<div class="form-group div5">
												<label for="show_user_address" class="col-sm-3 col-xs-3 control-label">住址</label>
												<div class="col-sm-9">
													<input type="text" class="form-control" id="show_user_address" placeholder="请输入" disabled>
												</div>
											</div>

											<div class="form-group div6">
												<label for="show_user_email" class="col-sm-3 col-xs-3 control-label">邮箱</label>
												<div class="col-sm-9">
													<input type="text" class="form-control" id="show_user_email" placeholder="请输入" disabled>
												</div>
											</div>
										</div>

										<div class="col-sm-6">
											<div class="form-group div7">
												<label for="show_user_pic" class="col-sm-3 col-xs-3 control-label">照片</label>
												<div class="col-sm-9">
													<img alt="图片" src="" id="show_user_pic" width="150" height="150" />
												</div>
											</div>
										</div>
									</form>
								</div>

							</div>

							<div class="modal-footer">
								<button type="button" class="btn btn-default close-btn" data-dismiss="modal">返回</button>
							</div>
						</div>
					</div>
				</div>
				<!-- 添加员工-->
				<div class="modal fade small_font" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close close-btn" data-dismiss="modal" aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">添加员工</h4>
							</div>
							<div class="modal-body">
								<div class="row">
									<form class="form-horizontal" role="form">
										<div class="col-sm-6">
											<div class="form-group div1">
												<label for="add_user_name" class="col-sm-3 col-xs-3 control-label">用户名</label>
												<div class="col-sm-9">
													<input type="text" class="form-control" id="add_user_name" placeholder="请输入" />
												</div>
											</div>
											<div class="form-group div2">
												<label for="add_user_pwd" class="col-sm-3 col-xs-3 control-label">密码</label>
												<div class="col-sm-9">
													<input type="text" class="form-control" id="add_user_pwd" placeholder="请输入" />
												</div>
											</div>
											<div class="form-group div3">
												<label for="add_user_rname" class="col-sm-3 col-xs-3 control-label">真实姓名 </label>
												<div class="col-sm-9">
													<input type="text" class="form-control" id="add_user_rname" placeholder="请输入" />
												</div>
											</div>
											<div class="form-group div4">
												<label for="add_user_tel" class="col-sm-3 col-xs-3 control-label">电话</label>
												<div class="col-sm-9">
													<input type="text" class="form-control" id="add_user_tel" placeholder="请输入" />
												</div>
											</div>
											<div class="form-group div5">
												<label for="add_user_address" class="col-sm-3 col-xs-3 control-label">住址</label>
												<div class="col-sm-9">
													<input type="text" class="form-control" id="add_user_address" placeholder="请输入" />
												</div>
											</div>
											<div class="form-group div6">
												<label for="add_user_birth" class="col-sm-3 col-xs-3 control-label">生日</label>
												<div class="col-sm-9">
													<input type="date" class="form-control" id="add_user_birth" placeholder="请输入" />
												</div>
											</div>
											<div class="form-group div7">
												<label for="add_user_role" class="col-sm-3 col-xs-3 control-label">角色</label>
												<div class="col-sm-9">
													<select id="add_user_role" class="form-control">
														<c:forEach var="role" items="${roleMap}">
															<option value="${role.key}">${role.value}</option>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="form-group div8">
												<label for="add_user_gender" class="col-sm-3 col-xs-3 control-label">性别</label>
												<div class="col-sm-9">
													<select id="add_user_gender" class="form-control">
														<option value="男">男</option>
														<option value="女">女</option>
													</select>
												</div>
											</div>
											
										</div>

										<div class="col-sm-6">
											<div class="form-group div7">
												<label for="add_user_pic" class="col-sm-3 col-xs-3 control-label">照片</label>
												<div class="col-sm-9">
													<input type="file" id="add_user_pic"/>
												</div>
											</div>
											<div class="form-group div2">
												<label for="add_user_email" class="col-sm-3 col-xs-3 control-label">邮箱</label>
												<div class="col-sm-9">
													<input type="text" class="form-control" id="add_user_email" placeholder="请输入" />
												</div>
											</div>
										</div>
										
									</form>
								</div>

							</div>

							<div class="modal-footer">
								<button type="button" class="btn btn-primary add-btn" id="submit_add">添加</button>
								<button type="button" class="btn btn-default close-btn" data-dismiss="modal">返回</button>
							</div>
						</div>
					</div>
				</div>
				<!-- 修改员工信息 -->
				<div class="modal fade small_font" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close close-btn" data-dismiss="modal" aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">修改员工信息</h4>
							</div>
							<div class="modal-body">
								<div class="row">
									<form class="form-horizontal" role="form">
										<div class="col-sm-6">
											<div class="form-group div1">
												<label for="update_user_name" class="col-sm-3 col-xs-3 control-label">用户名</label>
												<div class="col-sm-9">
													<input type="text" class="form-control" id="update_user_name" placeholder="请输入" disabled>
												</div>
											</div>
											<div class="form-group div2">
												<label for="update_user_rname" class="col-sm-3 col-xs-3 control-label">真实姓名 </label>
												<div class="col-sm-9">
													<input type="text" class="form-control" id="update_user_rname" placeholder="请输入">
												</div>
											</div>
											<div class="form-group div3">
												<label for="update_user_tel" class="col-sm-3 col-xs-3 control-label">电话</label>
												<div class="col-sm-9">
													<input type="text" class="form-control" id="update_user_tel" placeholder="请输入" />
												</div>
											</div>
											<div class="form-group div4">
												<label for="update_user_address" class="col-sm-3 col-xs-3 control-label">住址</label>
												<div class="col-sm-9">
													<input type="text" class="form-control" id="update_user_address" placeholder="请输入" />
												</div>
											</div>
											<div class="form-group div5">
												<label for="update_user_birth" class="col-sm-3 col-xs-3 control-label">生日</label>
												<div class="col-sm-9">
													<input type="text" class="form-control" id="update_user_birth" placeholder="请输入" disabled>
												</div>
											</div>
										</div>

										<div class="col-sm-6">
											<div class="form-group div7">
												<label for="update_user_pic" class="col-sm-3 col-xs-3 control-label">照片</label>
												<div class="col-sm-9">
													<img alt="图片" src="" id="update_user_pic" width="150" height="150" />
												</div>
											</div>
											<div class="form-group div2">
												<label for="update_user_email" class="col-sm-3 col-xs-3 control-label">邮箱</label>
												<div class="col-sm-9">
													<input type="text" class="form-control" id="update_user_email" placeholder="请输入" />
												</div>
											</div>
										</div>
									</form>
								</div>

							</div>

							<div class="modal-footer">
								<button type="button" class="btn btn-primary add-btn" id="submit_update">修改</button>
								<button type="button" class="btn btn-default close-btn" data-dismiss="modal">返回</button>
							</div>
						</div>
					</div>
				</div>
				<!-- 删除员工-->
				<div class="modal fade small_font" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close close-btn" data-dismiss="modal" aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">删除员工</h4>
							</div>
							<div class="modal-body">
								<div class="row">
									<form class="form-horizontal" role="form">
										<div class="col-sm-10">
											<div class="form-group div1">
												<h3>是否需要删除</h3>
											</div>
										</div>
									</form>
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-primary add-btn" id="submit_delete">是</button>
								<button type="button" class="btn btn-default close-btn" data-dismiss="modal">否</button>
							</div>
						</div>
					</div>
				</div>
			</div>
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
	<input type="hidden" id="hid" value="0" />
	<script type="text/javascript">
		//显示所有员工分页信息
		function show_list(pageNo) {
			$.ajax({
				data : {"pageNo" : pageNo,"roleId":$("#user_role").val(),"userRName":$("#user_name").val()},
				url : "userList",
				method:"post",
				success : function(msg) {
					json_to_table(msg, "my_table",[ "userId", "userRname", "userGender", "userEmail","userTel", "roleName","userAddress"]);
					$("#hid").val("0");
				}
			});
		}
		//调用
		show_list(1);
		$("#query-btn").click(function(){
			show_list(1);
		});
		//弹出显示详情
		$("#show_user_info").click(function(){
			//判断是否选中
			var userId = $("#hid").val();
			if(userId=="0"||userId==""){
				alert("请选择一行");
				return;
			}
			//发送查看
			$.ajax({
				data:{"userId":userId},
				url:"showUser",
				success:function(msg){
					$("#show_user_name").val(msg.userName);
					$("#show_user_rname").val(msg.userRname);
					$("#show_user_tel").val(msg.userTel);
					$("#show_user_date").val(msg.userBirth);
					$("#show_user_address").val(msg.userAddress);
					$("#show_user_email").val(msg.userEmail);
					$("#show_user_pic").attr("src","http://192.168.1.67:8080/img/"+msg.userPic);
				}
			});
			//显示模态框
			$("#myModal0").modal();
		});
		//添加员工
		$("#submit_add").click(function(){
			var userPic = lu_upload($("#add_user_pic"));
			if(userPic==null){
				return false;
			}
			if(!lu_check("myModal1")){
				return false;
			}
			$.ajax({
				data:{
					"userName":$("#add_user_name").val(),
					"userPassword":$("#add_user_pwd").val(),
					"userRname":$("#add_user_rname").val(),
					"userTel":$("#add_user_tel").val(),
					"userAddress":$("#add_user_address").val(),
					"userBirth":$("#add_user_birth").val(),
					"roleId":$("#add_user_role").val(),
					"userGender":$("#add_user_gender").val(),
					"userEmail":$("#add_user_email").val(),
					"userPic":userPic
				},
				url:"addUser",
				method:"post",
				success:function(msg){
					checkSuccess(msg, $("#myModal_alert"), "添加员工",$("#myModal1"));
					show_list(total_page);
				}
			});
		});
		//弹出修改框
		$("#update_user").click(function(){
			//判断是否选中
			var userId = $("#hid").val();
			if(userId=="0"||userId==""){
				alert("请选择一行");
				return;
			}
			//ajax查询数据
			$.ajax({
				data:{"userId":userId},
				url:"showUser",
				success:function(msg){
					$("#update_user_name").val(msg.userName);
					$("#update_user_rname").val(msg.userRname);
					$("#update_user_tel").val(msg.userTel);
					$("#update_user_birth").val(msg.userBirth);
					$("#update_user_address").val(msg.userAddress);
					$("#update_user_email").val(msg.userEmail);
					$("#update_user_pic").attr("src","http://192.168.1.67:8080/img/"+msg.userPic);
					//图片没写
				}
			});
			//显示模态框
			$("#myModal2").modal();
		});
		//修改真实姓名和电话,地址
		$("#submit_update").click(function(){
			var userId = $("#hid").val();
			$.ajax({
				method:"post",
				data:{"userId":userId,"userRname":$("#update_user_rname").val(),"userTel":$("#update_user_tel").val(),"userAddress":$("#update_user_address").val(),"userEmail":$("#update_user_email").val()},
				url:"updateUserByManager",
				success:function(msg){
					checkSuccess(msg, $("#myModal_alert"), "修改员工",$("#myModal2"));
					show_list(1);
				}
			});
		});
		//删除
		$("#delete_user").click(function(){
			//提示是否选中
			var userId = $("#hid").val();
			if(userId=="0"||userId==""){
				alert("请选择一行");
				return;
			}
			//弹出框
			$("#myModal3").modal();
		});
		//删除功能
		$("#submit_delete").click(function(){
			$.ajax({
				data:{"userId":$("#hid").val()},
				url:"deleteUser",
				success:function(msg){
					checkSuccess(msg, $("#myModal_alert"), "删除员工",$("#myModal3"));
					show_list(page_no);
				}
			});
		});
	</script>
</body>
</html>