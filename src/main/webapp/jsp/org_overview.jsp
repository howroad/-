<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page errorPage="error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>机构总览</title>
</head>
<body>
    <div class="container-fluid" id="wrap">
        <div class="row">
            <h2 class="text-center">机构总览</h2>
            <div class="table-responsive col-md-12">
                <nav class="navbar navbar-default" id="query" role="navigation">
                    <div class="navbar-header col-md-3"><span class="navbar-brand">按条件查询</span></div>
                    <div class="navbar-collapse" id="bs-example-navbar-collapse-1">
                        <form class="navbar-form navbar-right" role="search">
                            <div class="form-group">
                                <label>机构类型</label>
                                <select id="org_type" class="form-control">
                                	<option value="">全部</option>
                                	<c:forEach var="org_type" items="${dataMap.JGLX }">
                                	<option value=${org_type.key }>${org_type.value }</option>
                                	</c:forEach>
		                        </select>
                            </div>
                            <div class="form-group">
                                <label>所在区域</label>
                                <select id="area_type" class="form-control">
                               		<option value="">全部</option>
                                    <c:forEach var="org_type" items="${dataMap.QY }">
                                	<option value=${org_type.key }>${org_type.value }</option>
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
                        <th>机构名称</th>
                        <th>机构类型</th>
                        <th>区域</th>
                        <th>车辆资源</th>
                        <th>人员资源</th>
                        <th>联系人名字</th>
                        <th>联系人电话</th>
                    </tr>
                    </thead>
                    <tbody></tbody>
                </table>
            </div>
        </div>
        <div class="row">
	        <div class="col-sm-6">
	            <div class="dataTables_info" id="dataTables-example_info" role="status" aria-live="polite">
	                <button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal" id="add_org">添加机构</button>
	                <button type="button" class="btn btn-default" id="update_user_pwd">修改管理员密码</button>
	                <button type="button" class="btn btn-default" id="export_excel">导出Excel</button>
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
            	<!-- 添加机构-->
                <div class="modal fade small_font" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close close-btn" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h4 class="modal-title" id="myModalLabel">添加机构</h4>
                            </div>
                            <div class="modal-body">
                                <div class="row">
                                    <form class="form-horizontal" role="form">
                                        <div class="col-sm-6">
                                            <div class="form-group div1">
                                                <label for="add_org_name" class="col-sm-3 col-xs-3 control-label">机构名称</label>
                                                <div class="col-sm-9">
                                                    <input type="text" class="form-control" id="add_org_name" placeholder="请输入" >
                                                </div>
                                            </div>
                                            <div class="form-group div2">
                                                <label for="add_area_type" class="col-sm-3 col-xs-3 control-label">所属区域</label>
                                                <div class="col-sm-9">
                                                    <select id="add_area_type" class="form-control" >
					                                    <c:forEach var="org_type" items="${dataMap.QY }">
					                                	<option value=${org_type.key }>${org_type.value }</option>
					                                	</c:forEach>                                                    
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group div3">
                                                <label for="add_org_type" class="col-sm-3 col-xs-3 control-label">机构类型</label>
                                                <div class="col-sm-9">
                                                    <select id="add_org_type" class="form-control" >
					                                    <c:forEach var="org_type" items="${dataMap.JGLX }">
					                                	<option value=${org_type.key }>${org_type.value }</option>
					                                	</c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group div4">
                                                <label for="add_user_rname" class="col-sm-3 col-xs-3 control-label">负责人姓名</label>
                                                <div class="col-sm-9">
                                                    <input type="text" class="form-control" id="add_user_rname" placeholder="请输入" >
                                                </div>
                                            </div>
                                            <div class="form-group div5">
                                                <label for="add_user_tel" class="col-sm-3 col-xs-3 control-label">负责人电话</label>
                                                <div class="col-sm-9">
													<input type="text" class="form-control" id="add_user_tel" placeholder="请输入" >
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group div8">
                                                <label for="add_org_logo" class="col-sm-3 col-xs-3 control-label">机构Logo图片</label>
                                                <div class="col-sm-9">
                                                    <input type="file" class="form-control" id="add_org_logo"/>
                                                </div>
                                            </div>
                                            <div class="form-group div11">
                                                <label for="add_user_name" class="col-sm-3 col-xs-3 control-label">管理员账号</label>
                                                <div class="col-sm-9">
                                                    <input type="text" class="form-control" id="add_user_name"/>
                                                </div>
                                            </div>
                                            <div class="form-group div12">
                                                <label for="add_user_pwd" class="col-sm-3 col-xs-3 control-label">管理员密码</label>
                                                <div class="col-sm-9">
                                                    <input type="text" class="form-control" id="add_user_pwd" placeholder="请输入">
                                                </div>
                                            </div>
                                            <div class="form-group div13">
                                                <label for="add_org_code" class="col-sm-3 col-xs-3 control-label">组织机构代码号</label>
                                                <div class="col-sm-9">
                                                    <input type="text" class="form-control" id="add_org_code" placeholder="请输入">
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default close-btn" data-dismiss="modal">关闭</button>
                                <button type="button" class="btn btn-primary add-btn" id="submit_add_org">确认添加</button>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- 修改管理员密码 -->
                <div class="modal fade small_font" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close close-btn" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h4 class="modal-title" id="myModalLabel">修改管理员密码</h4>
                            </div>
                            <div class="modal-body">
                                <div class="row">
                                    <form class="form-horizontal" role="form">
                                        <div class="col-sm-10">
                                            <div class="form-group div1">
                                                <label for="update_user_name" class="col-sm-3 col-xs-3 control-label">账号</label>
                                                <div class="col-sm-9">
                                                    <input type="text" class="form-control" id="update_user_name" name="not-none-check" disabled />
                                                </div>
                                            </div>
                                            <div class="form-group div2">
                                                <label for="update_user_pwd_input" class="col-sm-3 col-xs-3 control-label">修改密码</label>
                                                <div class="col-sm-9">
                                                    <input type="text" class="form-control" id="update_user_pwd_input" placeholder="请输入" name="not-none-check">
                                                </div>
                                            </div>
                                            <div class="form-group div3">
                                                <label for="update_user_pwd2" class="col-sm-3 col-xs-3 control-label">确认密码</label>
                                                <div class="col-sm-9">
                                                    <input type="text" class="form-control" id="update_user_pwd2" placeholder="请输入" name="not-none-check">
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default close-btn" data-dismiss="modal">关闭</button>
                                <button type="button" class="btn btn-primary add-btn" id="submit_update_user">确认修改</button>
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
    <input type="hidden" id="hid" value="0"/> 
    <script type="text/javascript">
    //显示所有机构分页信息
	function show_list(pageNo){
		$.ajax({
			data:{"pageNo":pageNo,"orgType":$("#org_type").val(),"orgArea":$("#area_type").val()},
			url:"findOrg",
			success:function(msg){
				json_to_table(msg,"my_table",["orgId","orgName","orgTypeKey","areaKey","carNum","personNum","orgUserName","orgUserTel"]);
				$("#hid").val("0");
			}
		});
	}
    //调用
	show_list(1);
    $("#query-btn").click(function(){
    	show_list(1);
    });
    //添加机构
    $("#submit_add_org").click(function(){
		var orgPic = lu_upload($("#add_org_logo"));
		if(orgPic==null){
			return false;
		}
		if(!lu_check("myModal")){
			return false;
		}
    	$.ajax({
    		url:"addOrg",
    		type:"post",
    		data:{
    	    	"orgName":$("#add_org_name").val(),
    	    	"areaKey":$("#add_area_type").val(),
    	    	"orgTypeKey":$("#add_org_type").val(),
    	    	"orgUserName":$("#add_user_name").val(),
    	    	"orgUserTel":$("#add_user_tel").val(),
    	    	"userName":$("#add_user_rname").val(),
    	    	"userPwd":$("#add_user_pwd").val(),
    	    	"orgCode":$("#add_org_code").val(),
    	    	"orgPic":orgPic
    		},
    		success:function(msg){
    			checkSuccess(msg, $("#myModal_alert"), "添加机构",$("#myModal"));
    			show_list(total_page);
    		}
    	});
    });
    $("#update_user_pwd").click(function(){
		var orgId = $("#hid").val();
		if(orgId=="0"||orgId==""){
			alert("请选择一行");
			return;
		}
		$.ajax({
			url:"findManagerByOrgId",
			data:{"orgId":orgId},
			success:function(msg){
				$("#update_user_name").val(msg);
				$("#myModal2").modal();
			}
		});
    });
    //提交修改
    $("#submit_update_user").click(function(){
		if(!lu_check("myModal2")){
			return false;
		}
		if($("#update_user_pwd_input").val()!=$("#update_user_pwd2").val()){
			alert("两次密码不同!");
			return false;
		}
    	var orgId = $("#hid").val();
    	$.ajax({
    		url:"updateOrgUserPwd",
    		data:{"orgId":orgId,"pwd":$("#update_user_pwd_input").val()},
    		method:"post",
    		success:function(msg){
    			checkSuccess(msg, $("#myModal_alert"), "修改管理员密码",$("#myModal2"));
    		}
    	});
    });
    //导出excel
    $("#export_excel").click(function(){
    	window.open("downloadExcel");
    });
    </script>
</body>
</html>