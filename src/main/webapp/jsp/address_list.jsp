<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page errorPage="error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>通讯录</title>
</head>
<body>
    <div class="container-fluid" id="wrap">
        <div class="row">
            <h2 class="text-center">通讯录</h2>
            <div class="table-responsive col-md-12">
                <nav class="navbar navbar-default" id="query" role="navigation">
                    <div class="navbar-collapse" id="bs-example-navbar-collapse-1">
                        <form class="navbar-form navbar-right" role="search">
                        	<div class="form-group">
                                <label>职位 </label>
                                <select id="role_name" class="form-control">
                                	<option value="">全部</option>
                               	 	<c:forEach var="role_name" items="${roleMap }">
                                	<option value=${role_name.key }>${role_name.value }</option>
                                	</c:forEach>
		                        </select>
                            </div>
                        	<div class="form-group">
                            	<label for="user_rname">姓名</label>
                                <input type="text" class="form-control" id="user_rname" >
                        	</div>
                            <button type="button" class="btn btn-default" id="query-btn">查询</button>
                        </form>
                    </div>
                </nav>
                <table class="table table-bordered table-hover table-striped" id="my_table">
                    <thead>
                    <tr>
                        <th>姓名</th>
                        <th>职位</th>
                        <th>电话</th>
                        <th>邮箱</th>
                    </tr>
                    </thead>
                    <tbody></tbody>
                </table>
            </div>
        </div>
        <div class="row">
	        <div class="col-xm-6 col-md-6 col-sm-6 text-right pull-right">
	        	<!-- 分页开始 -->
				<nav class="text-center">
				 	<ul class="pagination" id="page_nav"></ul>
				</nav>
				<!-- 分页结束 -->
	        </div>
	    </div>
    </div>
    <input type="hidden" id="hid" value="0"/> 
    <script type="text/javascript">
    //显示所有员工通讯录分页信息
	function show_list(pageNo){
		$.ajax({
			data:{"pageNo":pageNo,"roleId":$("#role_name").val(),"userRname":$("#user_rname").val()},
			method:"post",
			url:"findAddressList",
			success:function(msg){
				json_to_table(msg,"my_table",["userId","userRname","roleName","userTel","userEmail"]);
				$("#hid").val("0");
			}
		});
	}
    //调用
	show_list(1);
	$("#query-btn").click(function(){
    	show_list(1);
    });
    </script>
</body>
</html>