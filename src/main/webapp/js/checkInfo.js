/**
 * 清空表单信息
 */
function cleanInput() {
	$(".modal input[type='text']").val("");
	$(".modal input[type='date']").val("");
	$(".modal input[type='file']").val("");
	$(".modal textarea").val("");
}

/**
 * 验证上传图片格式
 * @returns
 */
function checkImage(img) {
    if(img==""){ 
        alert("请上传图片");
        return false;
    }else if(!/\.(gif|jpg|jpeg|png|GIF|JPG|PNG|bmp)$/.test(img)){
      alert("图片类型必须是.gif,jpeg,jpg,png,bmp中的一种")
      return false;
    }
    return true;
}

function lu_check(str){
	var num_arr = $("#"+str+" input.ck_num");
	var date_arr = $("#"+str+" input[type=date]");
	var empty_arr = $("#"+str+" input");
	var reg = /^\d+$/;
	for(var i=0;i<num_arr.length;i++){
		var value = $(num_arr[i]).val();
		if(value==""||!reg.test(value)){
			var id = $(num_arr[i]).attr('id');
			alert($("label[for="+id+"]").html()+"必须为整数且不能为空!");
			return false;
		}
	}
	for(var i=0;i<date_arr.length;i++){
		var value = $(date_arr[i]).val();
		if(value==""){
			var id = $(date_arr[i]).attr('id');
			alert($("label[for="+id+"]").html()+"必须为日期格式!");
			return false;
		}		
	}
	for(var i=0;i<empty_arr.length;i++){
		var value = $(empty_arr[i]).val();
		if(value==""){
			var id = $(empty_arr[i]).attr('id');
			alert($("label[for="+id+"]").html()+"不能为空!");
			return false;
		}			
	}
	return true;
}

function json_to_table(msg,table_id_str,propertys_arr){
	//var ojson = JSON.parse(msg);//转换成json对象
	var ojson = msg;
	page_no = ojson.pageNo;//当前页码
	var page_size = ojson.pageSize;//分页记录数量
	total_page = ojson.totalPage;//总页数
	var total_record = ojson.totalRecord;//总记录数
	var olist = ojson.list;//需要显示的数据
	var str = "";
	for(var i=0;i<olist.length;i++){
		str +="<tr index="+olist[i][propertys_arr[0]]+">";//ID
		for(var j=1;j<propertys_arr.length;j++){
			if(Array.isArray(propertys_arr[j])){
				str +="<td>"+propertys_arr[j][olist[i][propertys_arr[++j]]]+"</td>";//如果是数组
			}else if(propertys_arr[j].indexOf(".")!=-1){//判断是否有逗号
				var arr=propertys_arr[j].split('.');
				if(olist[i][arr[0]]==null){
					str +="<td></td>";
				}else{
					str +="<td>"+olist[i][arr[0]][arr[1]]+"</td>";//只判断两层即可
				}
				
			}else{
				str +="<td>"+olist[i][propertys_arr[j]]+"</td>";//其他属性
			}
		}
	}
	str += "</tr>";
	//填充表格
	for(var i=0;i<page_size-olist.length;i++){
		str+="<tr style='height:36.8px;'>";
		for(var j = 0;j<$("#"+table_id_str+" thead tr th").length;j++) {
			str+="<td></td>";
		}
		str+="</tr>"
	}	
	$("#"+table_id_str+" tbody").html(str);
	//绑定点击事件
	$("#"+table_id_str+" tbody tr").click(function(){
		$("#"+table_id_str+" tbody tr").removeClass("as");
		$(this).addClass("as");
		$("#hid").val($(this).attr("index"));
	});
	//分页按钮
	create_page_btn(page_no,total_page,"show_list");
}

//分页按钮跳转事件
function jump_page(){
	var page = $("#jump_input").val();
	if(page>=1){
		page=page>total_page?total_page:page;
		show_list(page);
	}else{
		$("#jump_input").val("");
	}
}

//只负责分页按钮显示的
function create_page_btn(page_no,total_page,show_list){
	var str2 = "";
	str2 +="<li "+(page_no==1?"class='active'":"")+"><a href='javascript:"+show_list+"(1)'>第 1 页</a></li>";
	var temp1 = page_no<=1?1:(page_no-1);
	str2 +="<li "+(page_no==1?"class='disabled'":"")+"><a href='javascript:"+show_list+"("+temp1+")'>上一页</a></li>";
	str2 +="<li><a>"+page_no+"</a></li>";
	str2 +="<li><a class='input-group input-group-sm' style='padding:5px 5px'><input type='text' class='form-control' style='width:50px;height:22px' id='jump_input'/></a></li>";
	str2 +="<li><a href='javascript:jump_page()'>跳转</a></li>";
	var temp2 = page_no>=total_page?total_page:(page_no+1);
	str2 +="<li "+(page_no==total_page?"class='disabled'":"")+"><a href='javascript:"+show_list+"("+temp2+")'>下一页</a></li>";
	str2 +="<li "+(page_no==total_page?"class='active'":"")+"><a href='javascript:"+show_list+"("+total_page+")'>第 "+total_page+" 页</a></li>";
	$("#page_nav").html(str2);
}

//上传文件
function lu_upload(obj){
    //设置一个根据时间戳的文件名
    var name = obj.val(); 
    var point = name.lastIndexOf("."); 
    var type = name.substr(point).toLocaleLowerCase();
    if(!/^\.(gif|jpg|jpeg|png|bmp)$/.test(type)){
    	alert("图片类型必须是.gif,jpeg,jpg,png,bmp中的一种");
    	obj.val(null);
    	return null;
    }
    name = new Date().getTime()+type;
    //上传
    $.ajax({
        url:"http://192.168.1.67:8080/img/"+name,
        type:"PUT",
        data:obj.get(0).files[0],
        processData:false,
        async:false
    });	
    return name;
}