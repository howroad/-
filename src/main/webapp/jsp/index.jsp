<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="XXXX系统">
<meta name="author" content="luhao">
<base href="/YJBZXT/" />
<title>${session_orgName}管理系统</title>
<!-- Bootstrap Core CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css"/>
<!-- Custom CSS -->
<link rel="stylesheet" href="css/sb-admin-2.css" />
<!-- Custom Fonts -->
<link rel="stylesheet" href="css/font-awesome.min.css" />
<!--zzm-->
<link rel="stylesheet" href="css/zzmcss.css">
<!--luhao-->
<link rel="stylesheet" href="css/lu.css" />
<!-- jQuery -->
<script src="js/jQuery-2.2.2-min.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>
<!-- Metis Menu Plugin JavaScript -->
<script src="js/metisMenu.min.js"></script>
<!-- Custom Theme JavaScript -->
<script src="js/sb-admin-2.js"></script>
<!-- 公共类 -->
<script src="js/group2-commoms.js"></script>
<!-- 公共类2 -->
<script src="js/checkInfo.js"></script>
<!-- echarts -->
<script src="js/echarts.min.js"></script>
</head>
<body>
	<div id="wrapper">
		<!-- 头部导航栏 -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation" id="header">
			<div class="navbar-header" id="group2-title">
				<a class="navbar-brand">${session_orgName}管理系统</a>
			</div>
			<!-- /.标题结束 -->
			<ul class="nav navbar-top-links navbar-right" id="hover-color">
				<li class="dropdown"><span class="wlcome">欢迎你,${session_user.userRname }</span></li>
				<!--个人信息按钮-->
				<li class="dropdown">
					<a class="dropdown-toggle tip" data-toggle="dropdown" href="#"> <i
							class="fa fa-user fa-fw write-title"></i> <i class="fa fa-caret-down write-title"></i>
					</a>
					<ul class="dropdown-menu dropdown-user">
						<li><a href="#"><i class="fa fa-user fa-fw"></i> 个人信息</a></li>
						<li><a href="#"><i class="fa fa-gear fa-fw"></i> 设置</a></li>
						<li class="divider"></li>
						<li><a href="javascript:login_out()"><i class="fa fa-sign-out fa-fw"></i> 退出</a></li>
					</ul>
				</li>
				<!-- /.个人信息按钮结束 -->
			</ul>
			<!-- /.头部结束 -->
			<!--左边导航栏-->
			<div class="navbar-default sidebar" role="navigation" id="left_nav">
				<div class="sidebar-nav navbar-collapse">
					<ul class="nav" id="side-menu">
						<!--搜索框-->
						<li class="sidebar-search">
							<div class="input-group custom-search-form">
								<input type="text" class="form-control" placeholder="搜索..."> <span
									class="input-group-btn">
									<button class="btn btn-default" type="button">
										<i class="fa fa-search"></i>
									</button>
								</span>
							</div>
						</li>
						<!-- /搜索框结束 -->
						<c:forEach var="power" items="${session_power }">
							${power.powerDesc }
						</c:forEach>
					</ul>
				</div>
			</div>
			<!--左边导航栏结束-->
		</nav>
		<!--导航栏结束-->
		<!--内容部分-->
		<div id="page-wrapper" class="bgchange1"></div>
		<!--内容部分结束-->
		<!--尾部-->
		<div class="footer">
			<div class="footer_content">
				<p>
					&nbsp;&copy;2018-2018 AUTHOR：<a href="#">J153二组</a>
				</p>
				<p>
					机构总览：<a href="#">路昊</a><span>|</span> 任务总览：<a href="#">陈韵蕊</a><span>|</span>
					未处理任务：<a href="#">路昊</a><span>|</span> 进行中任务：<a href="#">路昊</a><span>|</span> 人员管理：<a
						href="#">路昊</a><span>|</span> 车辆管理：<a href="#">柯强林</a><span>|</span> 通讯录：<a href="#">陈韵蕊</a><span>|</span>
						 我的信息：<a href="#">陈韵蕊</a><span>|</span>
				</p>
				<p>
					蜀ICP备8888-6666号-1<span>|</span> 增值电信业务经营许可证蜀C-20180302<span>|</span> 蜀公网安备 86861234567号
				</p>
			</div>
		</div>
		<!--尾部结束-->
	</div>
	<script>
		//提示权限不足的tooltips
		$(function() {
			$("[data-toggle='tooltip']").tooltip();
		});
		var content = $("#page-wrapper");
		//显示的首页
		content.load("html/banner.html");
		//退出
		function login_out() {
			window.location.href = "logout";
		}
		//机构总览
		$("#org_overview").click(function() {
			content.load("jsp/org_overview.jsp");
		});
		//任务总览
		$("#task_overview").click(function() {
			content.load("jsp/task_overview.jsp");
		});
		//角色管理
		$("#role_manager").click(function() {
			content.load("jsp/role_manager.jsp");
		});
		//部门历史事件
		$("#task_history").click(function() {
			content.load("jsp/task_history.jsp");
		});
		//我的信息
		$("#user_infomation").click(function() {
			content.load("jsp/user_infomation.jsp");
		});
		//通讯录
		$("#address_list").click(function() {
			content.load("jsp/address_list.jsp");
		});
		//人员管理
		$("#user_manager").click(function() {
			content.load("jsp/user_manager.jsp");
		});
		//车辆管理
		$("#car_manager").click(function() {
			content.load("jsp/car_manager.jsp");
		});
		//待处理的任务
		$("#task_pending").click(function() {
			content.load("jsp/task_pending.jsp");
		});
		//进行中的任务
		$("#task_ongong").click(function() {
			content.load("jsp/task_ongoing.jsp");
		});
		//数据字典维护
		$("#data_manager").click(function() {
			content.load("jsp/data_manager.jsp");
		});
		//数据分析
		$("#data_analysis").click(function() {
			content.load("jsp/data_analysis.jsp");
		});
	</script>
</body>
</html>
