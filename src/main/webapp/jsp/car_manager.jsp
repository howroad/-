<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page errorPage="error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>车辆guanl</title>
</head>
<body>
    <div class="container-fluid" id="wrap">
        <div class="row">
            <h2 class="text-center">车辆管理</h2>
            <div class="table-responsive col-md-12">
                <nav class="navbar navbar-default" id="query" role="navigation">
                   
                    <div class="navbar-collapse" id="bs-example-navbar-collapse-1">
                        <form class="navbar-form navbar-right" role="search">
                            <div class="form-group">
                                <label>车辆类型 </label>
								<select id="find_car_type" class="form-control">
									<option value="">全部</option>
									<c:forEach var="car_type" items="${dataMap.CLLX}">
										<option value="${car_type.key}">${car_type.value}</option>
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
                        <th>车牌号</th>
                        <th>车辆类型</th>
                        <th>核载人数</th>
                        <th>出警状态</th>
                        <th>事故状态</th>
                        <th>其他信息</th>
                    </tr>
                    </thead>
                    <tbody></tbody>
                </table>
            </div>
        </div>
        <div class="row">
	        <div class="col-sm-6">
	            <div class="dataTables_info" id="dataTables-example_info" role="status" aria-live="polite">
	                <button type="button" class="btn btn-default"  id="add_car_type">维修完成</button>
	                 <button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal1" id="add_car">添加车辆</button>
	                <button type="button" class="btn btn-default" id="break_car">报修</button>
	                <button type="button" class="btn btn-default" id="delete_car">删除车辆</button>
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
            	<!-- 维修完成-->
                <div class="modal fade small_font" id="myModal0" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close close-btn" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h4 class="modal-title" id="myModalLabel">维修</h4>
                            </div>
                            <div class="modal-body">
                                <div class="row">
                                    <form class="form-horizontal" role="form">
                                        <div class="col-sm-10">
                                            <div class="form-group div1">
                                                 <div class="form-group div1">
                                                <h3 align="center">是否需要维修</h3>
                                            </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default close-btn" data-dismiss="modal">关闭</button>
                                <button type="button" class="btn btn-primary add-btn" id="add_cartype_submit">确认维修</button>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- 添加车辆 -->
                <div class="modal fade small_font" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close close-btn" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h4 class="modal-title" id="myModalLabel">添加车辆</h4>
                            </div>
                            <div class="modal-body">
                                <div class="row">
                                    <form class="form-horizontal" role="form">
                                        <div class="col-sm-10">
                                            <div class="form-group div1">
                                                <label for="add_car_carLicense" class="col-sm-3 col-xs-3 control-label">车牌号(*)</label>
                                                <div class="col-sm-9">
                                                    <input type="text" class="form-control" id="add_car_carLicense" placeholder="请输入">
                                                </div>
                                            </div>
                                              <div class="form-group div2">
                                                <label for="add_car_type_sel" class="col-sm-3 col-xs-3 control-label">车辆类型</label>
                                                <div class="col-sm-9">
                                                    <select id="add_car_type_sel" class="form-control">
														<c:forEach var="car_type" items="${dataMap.CLLX}">
															<option value="${car_type.key}">${car_type.value}</option>
														</c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group div3">
                                                <label for="add_car_carLoadNum" class="col-sm-3 col-xs-3 control-label">核载人数</label>
                                                <div class="col-sm-9">
                                                    <input type="text" class="form-control ck_num" id="add_car_carLoadNum" placeholder="请输入">
                                                </div>
                                            </div>
                                            <div class="form-group div4">
                                                <label for="add_car_carBreakState" class="col-sm-3 col-xs-3 control-label">事故状态</label>
                                                <div class="col-sm-9">
                                                    <select id="add_car_carBreakState" class="form-control">
                                                        <option value="0">正常</option>
                                                        <option value="1">报修</option>
                                                    </select>
                                                </div>
                                            </div>
                                             <div class="form-group div3">
                                                <label for="add_car_desc" class="col-sm-3 col-xs-3 control-label">描述</label>
                                                <div class="col-sm-9">
                                                    <input type="text" class="form-control" id="add_car_desc" placeholder="请输入">
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-primary add-btn" id="add_car_submit">添加</button>
                                <button type="button" class="btn btn-default close-btn" data-dismiss="modal">返回</button>
                            </div>
                        </div>
                    </div>
                </div>
              
               <!-- 报修-->
                <div class="modal fade small_font" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close close-btn" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h4 class="modal-title" id="myModalLabel">报修</h4>
                            </div>
                            <div class="modal-body">
                                <div class="row">
                                    <form class="form-horizontal" role="form">
                                        <div class="col-sm-10">
                                            <div class="form-group div1">
                                                <h3 align="center">是否需要报修</h3>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-primary add-btn" id="add_carBreakState_submit">是</button>
                                <button type="button" class="btn btn-default close-btn" data-dismiss="modal">否</button>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- 删除-->
                <div class="modal fade small_font" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close close-btn" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h4 class="modal-title" id="myModalLabel">删除</h4>
                            </div>
                            <div class="modal-body">
                                <div class="row">
                                    <form class="form-horizontal" role="form">
                                        <div class="col-sm-10">
                                            <div class="form-group div1">
                                                <h3 align="center">是否需要删除</h3>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-primary add-btn" id="del_car_submit">是</button>
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
    <input type="hidden" id="hid" value="0"/> 
    <script type="text/javascript">
    var car_go_arr = ["未出警","已出警"];
    var car_break_arr = ["正常","事故"];
    //显示所有车辆分页信息
	function show_list(pageNo){
		$.ajax({
			data:{"pageNo":pageNo,"carType":$("#find_car_type").val()},
			url:"listpage",
			success:function(msg){
				json_to_table(msg,"my_table",["carId","carLicense","carType","carLoadNum",car_go_arr,"carOutState",car_break_arr,"carBreakState","carDesc"]);
				$("#hid").val("0");
			}
		});
	}
    //调用
	show_list(1);
	$("#query-btn").click(function(){
		show_list(1);
	});
	//删除车辆
	$("#del_car_submit").click(function(){
		$.ajax({
			method:"post",
			url:"deletecar",
			data:{"id":$("#hid").val()},
			success:function(msg){
				checkSuccess(msg, $("#myModal_alert"), "删除车辆",$("#myModal3"));
				show_list(page_no);
			}
		})
	});
	//添加车辆
	$("#add_car_submit").click(function(){
		if(!lu_check("myModal1")){
			return false;
		}
		$.ajax({
			method:"post",
			url:"addcar",
			data:{carLicense:$("#add_car_carLicense").val(),carType:$("#add_car_type_sel").val(),carLoadNum:$("#add_car_carLoadNum").val(),carBreakState:$("#add_car_carBreakState").val(),carDesc:$("#add_car_desc").val()},
			success:function(msg){
				checkSuccess(msg, $("#myModal_alert"), "添加车辆",$("#myModal1"));
				show_list(total_page);
			}
		})
	});
	//修改车辆信息
	$("#add_carBreakState_submit").click(function(){
		console.info($("#hid").val())
		$.ajax({
			method:"post",
			url:"carbreak",
			data:{"id":$("#hid").val()},
			success:function(msg){
				checkSuccess(msg, $("#myModal_alert"), "报修",$("#myModal2"));
				show_list(page_no);
			}
		})
		});
	
	//维修完成 
	$("#add_cartype_submit").click(function(){
		$.ajax({
			method:"post",
			url:"repaircar",
			data:{"id":$("#hid").val()},
			success:function(msg){
				checkSuccess(msg, $("#myModal_alert"), "维修",$("#myModal0"));
				show_list(page_no);
			}
		})
	});
	//弹出维修框
	$("#add_car_type").click(function(){
		//判断是否选中
		var id = $("#hid").val();
		if(id=="0"||id==""){
			alert("请选择一行");
			return;
		}
		$("#myModal0").modal();
	});
	//弹出报修框
	$("#break_car").click(function(){
		//判断是否选中
		var id = $("#hid").val();
		if(id=="0"||id==""){
			alert("请选择一行");
			return;
		}
		$("#myModal2").modal();
	});
	//弹出删除框
	$("#delete_car").click(function(){
		//判断是否选中
		var id = $("#hid").val();
		if(id=="0"||id==""){
			alert("请选择一行");
			return;
		}
		$("#myModal3").modal();
	});
	
    </script>
</body>
</html>