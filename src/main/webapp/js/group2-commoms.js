/**
 * 清空表单信息
 * @param clean_modal 要清空的表单
 */
function cleanInput(clean_modal) {
	clean_modal.find("input[type='text']").val("");
	clean_modal.find("input[type='date']").val("");
	clean_modal.find("input[type='file']").val("");
	clean_modal.find("textarea").val("");
	clean_modal.find("select").val("0");
}

/**
 * 验证上传图片格式
 * @param img 图片内容
 * @param modalObj 模态框对象
 * @returns
 */
function checkImage(img, modalObj) {
    if(img===""){
    	alertAiv(modalObj, "请上传图片");
        return false;
    }else if(!/\.(gif|jpg|jpeg|png|GIF|JPG|PNG|bmp)$/.test(img)){
    	alertAiv(modalObj, "图片类型必须是.gif,jpeg,jpg,png,bmp中的一种");
        return false;
    }
    return true;
}

/**
 * 添加警告div
 * @param divObj div对象
 * @param text 警告内容
 * @returns
 */
function addDiv(divObj, text) {
	divObj.after("<div class=\"alert alert-danger alert-dismissable\">" +
             "<button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">&times;</button>" +
             "<strong>注意！</strong>"+text+"</div>");
}

/**
 * 弹出框div
 * @param modalObj 模态框对象
 * @param text 提示内容
 * @returns
 */
function alertAiv(modalObj, text) {
	if(modalObj == null) { modalObj = $("#myModal_alert"); }
	modalObj.find("p").html(text);
	modalObj.modal();
}

/**
 * 验证操作是否成功
 * @param boo 布尔值 
 * @param modalObj 模态框对象
 * @param text 操作内容
 * @param hide_modal 要隐藏的modal对象	非必需
 * @returns
 */
function checkSuccess(boo, modalObj, text, hide_modal) {
	if(modalObj == null) { modalObj = $("#myModal_alert"); }
	if(text == null) { text = "操作"; }
	if(boo){
		alertAiv(modalObj, text+"成功")
	}else{
		alertAiv(modalObj, text+"失败")
	}
	if(hide_modal != null) {
		hide_modal.modal('hide');
	}
	if(text == "添加") {
		cleanInput(hide_modal);
	}
}

/**
 * 补齐表格
 * @param str 要拼接的字符串
 * @param trLen tr数量
 * @param tdLen td数量
 * @param trHeight tr高度
 * @returns {string} 拼接后的字符串
 */
function fillUpTable(str,trLen,tdLen,trHeight) {
	arr = str.match(/tr/g);
	if(arr==null) {
		var num = 0;
	} else if(arr.length) {
		var num = arr.length / 2;
	}
    for(var i = 0; i < trLen - num; i++) {
        str += "<tr style='height:"+trHeight+"px;'>";
        for(var j = 0; j < tdLen; j++) {
            str += "<td></td>";
        }
        str += "</tr>";
    }
    return str;
}

/**
 * 给表格绑定点击事件变色+隐藏表单赋值
 * @param trObj tr对象
 * @param hidObj 隐藏表单对象
 * @constructor
 */
function addTrColor(trObj,hidObj) {
    trObj.click(function(){
        trObj.removeClass("as");
        $(this).addClass("as");
        hidObj.val($(this).attr("index"));
    });
}

/**
 * 加载分页按钮
 * @param page_no 当前页
 * @param total_page 总页数
 * @param pageObj 分页位置
 */
function paging(page_no, total_page, pageObj) {
    var str = "";
    str +="<li "+(page_no==1?"class='active'":"")+"><a href='javascript:jump_page(1,"+total_page+")'>第 1 页</a></li>";
    var temp1 = page_no<=1?1:(page_no-1);
    str +="<li "+(page_no==1?"class='disabled'":"")+"><a href='javascript:jump_page("+temp1+","+total_page+")'>上一页</a></li>";
    str +="<li><a>"+page_no+"</a></li>";
    str +="<li><a class='input-group input-group-sm' style='padding:5px 5px'><input type='text' class='form-control' style='width:50px;height:23px' id='jump_input'/></a></li>";
    str +="<li><a href='javascript:jump_page('',"+total_page+")'>跳转</a></li>";
    var temp2 = page_no>=total_page?total_page:(page_no+1);
    str +="<li "+(page_no==total_page?"class='disabled'":"")+"><a href='javascript:jump_page("+temp2+","+total_page+")'>下一页</a></li>";
    str +="<li "+(page_no==total_page?"class='active'":"")+"><a href='javascript:jump_page("+total_page+","+total_page+")'>第 "+total_page+" 页</a></li>";
    pageObj.html(str); 
}

/**
 * 初始化更新表格方法
 * @param func 方法
 * @returns 
 */
function initTable(func){
    func(1);
    return func;
}

var jump_page;
/**
 * 初始化页面包括表格和分页按钮
 * @param param json对象
 * 		value:ajax返回的字符串*	必需
 * 		data:数据*			必需： id：必须叫id，传入对象的id属性。
 * 								 arr：传入一个数组，第一个值传入数组，第二个值传属性
 * 								 其他属性名字随便取
 *      func:更新表格方法* 		必需
 *      tbodyObj:tbody对象	非必需：默认页面中第一个tbody
 *      hidObj:隐藏表单对象		非必需：默认页面中第一个hidden表单
 *      pageObj:分页按钮位置	非必需：默认页面中第一个class为pagination的分页按钮位置
 */
function init(param) {
    if(param.tbodyObj==null) { param.tbodyObj=$("tbody").eq(0); }
    if(param.hidObj==null) { param.hidObj=$("input[type='hidden']").eq(0); }
    if(param.pageObj==null) { param.pageObj=$(".pagination").eq(0); }
    var json = param.value;
	page_no = json.pageNo;
	total_page = json.totalPage;
	page_size = json.pageSize;
	var str = "";
	for(var i=0;i<json.list.length;i++){
		if(json.list[i][param.data.id] == null) { json.list[i][param.data.id]=0; }
		str += "<tr index='"+json.list[i][param.data.id]+"'>";
		$.each(param.data,function(name,value) {
			if(name == "id"){ return; }
			str += "<td>";
			if(name == "arr") {
				str += value[0][json.list[i][value[1]]];
				str += "</td>";
				return;
			}
			var arr1 = value.split("+");
			for(var j=0;j<arr1.length;j++) {
				var arr2 = arr1[j].split(".");
				if(arr2.length === 1) { str += json.list[i][arr2[0]]; }
				else if(arr2.length === 2) { 
					if(json.list[i][arr2[0]] == null) { str += ""; break; }
					str += json.list[i][arr2[0]][arr2[1]];
				}
				else if(arr2.length === 3) { 
					if(json.list[i][arr2[0]] == null || json.list[i][arr2[0]][arr2[1]] == null) { str += ""; break; }
					str += json.list[i][arr2[0]][arr2[1]][arr2[2]];
				}
			}
			str += "</td>";
		});
		str += "</tr>";
	}
	param.tbodyObj.html(str);
	var trHeight = 0;
	if(json.list.length==0) {
		trHeight = param.tbodyObj.prev().find("th").get(0).offsetHeight;
	} else {
		trHeight = param.tbodyObj.find("td").get(0).offsetHeight;
	}
    //填充表格
    str = fillUpTable(str,page_size,param.tbodyObj.prev().find("th").length,trHeight);
    param.tbodyObj.html(str);
    //给tr绑定点击事件
    addTrColor(param.tbodyObj.find("tr"), param.hidObj);
    //分页
    paging(page_no, total_page, param.pageObj);
    //需要初始化hid
    param.hidObj.val("");
    /**
     * 跳页
     * @param page_no 当前页
     * @param total_page 总页数
     */
    jump_page = function(page_no, total_page){
    	var page = 0;
    	if(page_no=='') {
    		page = $("#jump_input").val();
    	} else {
    		page = page_no;
    	}
        if(page>=1){
            page = page > total_page ? total_page : page;
            var fn = param.func;
            fn(page);
        }
    }
}

/**
 * 不分页表格
 * @param param
 * @returns
 */
function initList(param) {
    if(param.tbodyObj==null) { param.tbodyObj=$("tbody").eq(0); }
    if(param.hidObj==null) { param.hidObj=$("input[type='hidden']").eq(0); }
    var list = param.value;
	var str = "";
	for(var i=0;i<list.length;i++){
		if(list[i][param.data.id] == null) { list[i][param.data.id]=0; }
		str += "<tr index='"+list[i][param.data.id]+"'>";
		$.each(param.data,function(name,value) {
			if(name == "id"){ return; }
			str += "<td>";
			if(name == "arr") {
				str += value[0][list[i][value[1]]];
				str += "</td>";
				return;
			}
			var arr1 = value.split("+");
			for(var j=0;j<arr1.length;j++) {
				var arr2 = arr1[j].split(".");
				if(arr2.length === 1) { str += list[i][arr2[0]]; }
				else if(arr2.length === 2) { 
					if(list[i][arr2[0]] == null) { str += ""; break; }
					str += list[i][arr2[0]][arr2[1]];
				}
				else if(arr2.length === 3) { 
					if(list[i][arr2[0]] == null || list[i][arr2[0]][arr2[1]] == null) { str += ""; break; }
					str += list[i][arr2[0]][arr2[1]][arr2[2]];
				}
			}
			str += "</td>";
		});
		str += "</tr>";
	}
	param.tbodyObj.html(str);
	var trHeight = 0;
	if(list.length==0) {
		trHeight = param.tbodyObj.prev().find("th").get(0).offsetHeight;
	} else {
		trHeight = param.tbodyObj.find("td").get(0).offsetHeight;
	}
    //填充表格
	if(param.tbodyObj.find("tr").length<5) {
		str = fillUpTable(str,5,param.tbodyObj.prev().find("th").length,trHeight);
	    param.tbodyObj.html(str);
	}
    //给tr绑定点击事件
    addTrColor(param.tbodyObj.find("tr"), param.hidObj);
    //需要初始化hid
    param.hidObj.val("");
}