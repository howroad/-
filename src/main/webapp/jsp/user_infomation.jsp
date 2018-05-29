<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>我的信息</title>
</head>
<body>
	<div class="container-fluid" id="wrap">
		<div class="row">
			<h2 class="text-center">我的信息</h2>
			<div class="table-responsive col-md-12">
				<div class="modal-body">
					<div class="row">
						<form class="form-horizontal" role="form">
							<div class="col-sm-6">
								<div class="form-group div1">
									<label for="show_user_rname" class="col-sm-3 col-xs-3 control-label">姓名</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="show_user_rname" disabled />
									</div>
								</div>
								<div class="form-group div2">
									<label for="show_user_name" class="col-sm-3 col-xs-3 control-label">用户名</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="show_user_name" disabled />
									</div>
								</div>
								<div class="form-group div3">
									<label for="show_user_birth" class="col-sm-3 col-xs-3 control-label">生日</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="show_user_birth" disabled />
									</div>
								</div>
								<div class="form-group div5">
									<label for="show_user_tel" class="col-sm-3 col-xs-3 control-label">电话</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="show_user_tel" disabled />
									</div>
								</div>
								<div class="form-group div6">
									<label for="show_user_email" class="col-sm-3 col-xs-3 control-label">邮箱</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="show_user_email" disabled />
									</div>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group div8">
									<label for="show_user_pic" class="col-sm-3 col-xs-3 control-label">照片</label>
									<div class="col-sm-9">
										<img alt="图片" src="" id="show_user_pic" width="200" height="300" />
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-xm-6 col-md-6 col-sm-6 text-right pull-left">
				<div class="dataTables_info" id="dataTables-example_info" role="status" aria-live="polite">
					<button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal2" id="update_user">修改我的信息</button>
				</div>
			</div>
		</div>

		<div class="row">
			<!-- 模态框 -->
			<div class="col-xs-6 col-md-6">
				<!-- 修改我的信息 -->
				<div class="modal fade small_font" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close close-btn" data-dismiss="modal" aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">修改我的信息</h4>
							</div>
							<div class="modal-body">
								<div class="row">
									<form class="form-horizontal" role="form">
										<div class="col-sm-10">
											<div class="form-group div1">
												<label for="update_rname" class="col-sm-3 col-xs-3 control-label">姓名</label>
												<div class="col-sm-9">
													<input type="text" class="form-control" id="update_rname" disabled />
												</div>
											</div>
											<div class="form-group div2">
												<label for="update_name" class="col-sm-3 col-xs-3 control-label">用户名</label>
												<div class="col-sm-9">
													<input type="text" class="form-control" id="update_name" disabled />
												</div>
											</div>
											<div class="form-group div3">
												<label for="update_pwd" class="col-sm-3 col-xs-3 control-label">修改密码</label>
												<div class="col-sm-9">
													<input type="text" class="form-control" id="update_pwd"/>
												</div>
											</div>
											<div class="form-group div5">
												<label for="update_pwd2" class="col-sm-3 col-xs-3 control-label">确认密码</label>
												<div class="col-sm-9">
													<input type="text" class="form-control" id="update_pwd2"/>
												</div>
											</div>
											<div class="form-group div6">
												<label for="update_tel" class="col-sm-3 col-xs-3 control-label">电话</label>
												<div class="col-sm-9">
													<input type="text" class="form-control" id="update_tel"/>
												</div>
											</div>
											<div class="form-group div7">
												<label for="update_email" class="col-sm-3 col-xs-3 control-label">邮箱</label>
												<div class="col-sm-9">
													<input type="text" class="form-control" id="update_email"/>
												</div>
											</div>
										</div>
									</form>
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default close-btn" data-dismiss="modal">关闭</button>
                                <button type="button" class="btn btn-primary add-btn" id="submit_update_user">修改</button>
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
		$.ajax({
			url:"findUserById",
			success:function(msg){
				$("#show_user_rname").val(msg.userRname);
				$("#show_user_name").val(msg.userName);
				$("#show_user_birth").val(msg.userBirth);
				$("#show_user_tel").val(msg.userTel);
				$("#show_user_email").val(msg.userEmail);
				$("#show_user_pic").attr("src","http://192.168.1.67:8080/img/"+msg.userPic);
			}
		});
		
		
		$("#update_user").click(function(){
			$.ajax({
				url:"findUserById",
				success:function(msg){
					$("#update_rname").val(msg.userRname);
					$("#update_name").val(msg.userName);
					$("#update_pwd").val(msg.userPassword);
					$("#update_pwd2").val(msg.userPassword);
					$("#update_tel").val(msg.userTel);
					$("#update_email").val(msg.userEmail);
				}
			});
		});	
		//提交修改
	    $("#submit_update_user").click(function(){
			if(!lu_check("myModal2")){
				return false;
			}
			if($("#update_pwd").val()!=$("#update_pwd2").val()){
				alert("两次密码不同!");
				return false;
			}
	    	var orgId = $("#hid").val();
	    	$.ajax({
	    		url:"updateUser",
	    		data:{"userPassword":$("#update_pwd").val(),"userTel":$("#update_tel").val(),"userEmail":$("#update_email").val()},
	    		method:"post",
	    		success:function(msg){
	    			checkSuccess(msg, $("#myModal_alert"), "修改管理员密码",$("#myModal2"));
	    		}
	    	});
	    });
	</script>
</body>
</html>