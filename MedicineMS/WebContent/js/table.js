function $_id(id) {
	return document.getElementById(id);
}

function ajax(src,data_,method){
	//创建并调用ajax
	htmlobj = $.ajax({
		url : src,
		asyc : false,
		type : method,
		data : data_,//发送到服务器的数据。将自动转换为请求字符串格式。GET 请求中将附加在 URL 后。查看 processData 选项说明以禁止此自动转换。【Eg:{ "id": "value" },    //参数值】
		dataType : "json",//预期服务器返回的数据类型。如果不指定，jQuery 将自动根据 HTTP 包 MIME 信息返回 responseXML 或 responseText，并作为回调函数参数传递
		contentType:"application/x-www-form-urlencoded",
		complete : function(data) {
			try{
//				alert("ajax:data:"+data);//test
				var jsonData = eval("(" + data.responseText + ")");
			}catch(error){
				$("#ajax_info").css({"padding":"10px","bakcground":"#ccc","color":"red","font-size":"1.6em"});
	
				$("#ajax_info").html(data.responseText);
//				alert(error.message);
				$("h3.box-title").css({"background-color":"white","color":"#ccc"});//防止上述文档改变部分的页面样式
				return;
			}
							
//			alert(jsonData.msg);
			if(jsonData.msg=="OK"){//如果数据库中删除成功
				//删除tr文本节点
				alert(jsonData.msg_cont);
			}else{
				alert(jsonData.msg_cont);
			}
		}
	});//htmlobj----end
}

/* *
 * 加载数据到form中
 * */
function loadStaffInfoToForm(){
	alert("加载？");
	//0.加载用户信息到form中
	$("#ipt_realName").text($("#info_realName").text());
	$("#ipt_sex").text($("#info_sex").attr('title'));
	$("#ipt_phone").text($("#info_telephone").text());
	$("#ipt_phone").text($("#info_telephone").text());
}
/* *
 * 更新用户信息[职工操作]
 * FormId:表单所在的id
 * ContainerId:form所在的容器的id
 * */
function updateStaffInfo(Id,Container_id){
	var Id = 'staff_info_form';
	var Container_id = 'update_staffInfo_div';
/*	console.log("测试");
	return;*/
	//1.判断输入合法性
	//两次密码校验
	if(document.getElementById('ipt_pswd').value!= document.getElementById('ipt_pswd2').value){
		alert("前后输入的密码不一致，请重新输入！");
		return;
	}
	console.log("$('#ipt_pswd').text():"+$("#ipt_pswd").text());//test
	//密码长度
	if(document.getElementById('ipt_pswd').value.length>0||document.getElementById('ipt_pswd2').value.length>0){//如果用户有输入信息
		if(document.getElementById('ipt_pswd').value.length>10||document.getElementById('ipt_pswd2').value.length<5){
			alert("密码的长度不得低于5位，高于10位！");
			document.getElementById('ipt_pswd').focus();
			alert("修改失败，重新检查并输入.");
			return;
		}
	}else{//假如没有输入密码
		$("#ipt_pswd").text("");//设置默认密码为""
		//服务器端会获取其原本密码
	}
//	console.log("document.getElementById('ipt_pswd').value.length:"+document.getElementById('ipt_pswd').value.length);
	//电话号码
	if(document.getElementById('ipt_phone').value.length>0)//如果用户有输入电话号码
	if(document.getElementById('ipt_phone').value.length>13||document.getElementById('ipt_pswd').value.length<6){
		alert("电话号码的长度不得低于6位，高于13位！");
		document.getElementById('ipt_phone').focus();
		return;
	}

	//2.执行ajax行为
	document.charset='utf-8';//纠正IE提交时候的编码
	var src = $("#"+Id).attr('action'); //获取form的action值
	console.log("FormId:"+Id);
	console.log("src:"+src);
	
	if(src) 
		ajax(src,$("#"+Id).serialize(),"POST");
	//关闭修改的窗口
//	$('#update_staffInfo_div').css('display','none');
}

/* *
 * 提交用户反馈信息
 * id:form的id
 * */
function submitFeedBack(id){
	document.charset='utf-8';//纠正IE提交时候的编码
	var src = $("#"+id).attr('action'); //获取form的action值
	if(src) 
		ajax(src,$("#"+id).serialize(),"POST");
}
 
function updateMedicineInfo(){
	document.charset='utf-8';//纠正IE提交时候的编码
//	$("#update_medicineInfo_form").serialize()
	var src = $("#update_medicineInfo_form").attr('action'); //获取form的action值
	if(src){
		//console.log($("#update_medicineInfo_form").serialize());//test
		ajax(src,$("#update_medicineInfo_form").serialize(),"POST");
		//alert("document.getElementById('update_cmpk').value:"+document.getElementById('update_cmpk').value);
	}
}

function updateMedicineInfo2(src){//默认：post提交
	document.charset='utf-8';//纠正IE提交时候的编码
	
	if(src){
		var method = "POST";
		var form_data = {
				update_cmpk:document.getElementById('update_cmpk').value,
				update_medicineName:document.getElementById('update_medicineName').value,
				update_prescription:document.getElementById('update_prescription').value,
				update_component:document.getElementById('update_component').value,
				update_perproty:document.getElementById('update_perproty').value,
				update_useType:document.getElementById('update_useType').value,
				update_mainFunc:document.getElementById('update_mainFunc').value,
				update_standard:document.getElementById('update_standard').value,
				update_usage:document.getElementById('update_usage').value,
				update_wrap:document.getElementById('update_cmpk').value,
				update_storageWay:document.getElementById('update_storageWay').value,
				update_forbid:document.getElementById('update_forbid').value,
				update_badEffect:document.getElementById('update_badEffect').value,
				update_attention:document.getElementById('update_attention').value,
				update_Type:document.getElementById('update_Type').value
		}
		alert('form_data:update_attention||:'+form_data.update_attention);
		alert('form_data:update_cmpk||:'+form_data.update_cmpk);
		ajax(src,form_data,method);
	}
}



/* *
 * id:更新按钮的id[规定：id的最后部分是该记录的排序号，且排序号码前必须至少有一个'_'作分隔符]
 */
function loadForm_addMedicineRecord(id){
	//改变Apps样式
	$("#"+id).css({
		"font-weight":"bolder"
	});
	//更改表单标题并解除cmpk的属性
	$('#form_updateMedicineTitle').text('添加药品信息');
//	$('#update_cmpk').removeAttr('disabled');//disabled慎用：js序列化时，无法获取到该输入组件的value
	$('#update_cmpk').removeAttr('readonly');
	//更新表单中的提交方式[告诉服务器是更新记录还是插入记录]
	$_id("update_Type").value = 'insert';
	//通过id获取到该行记录的序号
    var TH = id.substring(id.lastIndexOf('_') + 1, id.length); //取得最后一个字符('_')的位置，再＋1，取得其序号
//	alert(id);//test
    
}

/* *
 * id:更新按钮的id[规定：id的最后部分是该记录的排序号，且排序号码前必须至少有一个'_'作分隔符]
 */
function loadCMPK(id){
	//更改表单标题并封锁
	$('#form_updateMedicineTitle').text('修改药品信息');
//	$('#update_cmpk').attr('disabled','disabled');//disabled慎用：js序列化时，无法获取到该输入组件的value
	$('#update_cmpk').attr('readonly',"readonly");
	//更新表单中的提交方式[告诉服务器是更新记录还是插入记录]
	$_id("update_Type").value ='update';
	
	//通过id获取到该行记录的序号
    var TH = id.substring(id.lastIndexOf('_') + 1, id.length); //取得最后一个字符('_')的位置，再＋1，取得其序号
	//alert(id);
    document.getElementById('update_cmpk').value = document.getElementById('pk_'+TH).innerHTML;
    document.getElementById('update_medicineName').value =$('#pk_'+TH).next().text();
    document.getElementById('update_prescription').value = $('#pk_'+TH).next().next().attr('title')=='true'?'1':'0';
    document.getElementById('update_component').value = $('#pk_'+TH).next().next().next().text();
    document.getElementById('update_perproty').value = $('#pk_'+TH).next().next().next().next().text();
    
    var useType = $('#pk_'+TH).next().next().next().next().next().text();
    document.getElementById('update_useType').value = (useType=='未知'?"0":(useType=='口服'?"1":"2"));
    document.getElementById('update_mainFunc').value =  $('#pk_'+TH).next().next().next().next().next().next().text();//主治功能
    document.getElementById('update_standard').value =  $('#pk_'+TH).next().next().next().next().next().next().next().text();//药品规格
    document.getElementById('update_usage').value =     $('#pk_'+TH).next().next().next().next().next().next().next().next().text();
    document.getElementById('update_forbid').value =    $('#pk_'+TH).next().next().next().next().next().next().next().next().next().text();
    document.getElementById('update_badEffect').value = $('#pk_'+TH).next().next().next().next().next().next().next().next().next().next().text();
    document.getElementById('update_attention').value = $('#pk_'+TH).next().next().next().next().next().next().next().next().next().next().next().text();
    document.getElementById('update_wrap').value =      $('#pk_'+TH).next().next().next().next().next().next().next().next().next().next().next().next().text();
    document.getElementById('update_storageWay').value =$('#pk_'+TH).next().next().next().next().next().next().next().next().next().next().next().next().next().text();
    
    //$('#update_cmpk').text($('tr#record_tr_'+TH).children('#pk_'+TH).text());
	// document.getElementById('update_cmpk').value;
}

//加载数据到药品修改表中
function loadDataToMedicineUpdateForm(id, formId) {
    var InputsNames = [
    	"update_cmpk",
    	"update_medicineName",
    	"update_prescription",
    	"update_component",
    	"update_perproty",
    	"update_useType",
    	"update_mainFunc",
    	"update_standard",
    	"update_usage", - 
    	"update_wrap",
    	"update_storageWay",
    	"update_forbid", - 
    	"update_badEffect",
    	"update_attention"];
    	
    	var tds= new Array(14); //new一个长度为14的数组  注意：var test = [3454,5577]这样的并不是预期的数组
    	tds[0] = 2;
    	tds[1] = 3;
    	tds[2] = 4;
    	tds[3] = 5;
    	tds[4] = 6;
    	tds[5] = 7;
    	tds[6] = 8;
		tds[7] = 9;
		tds[8] = 11;/*usage*/
		tds[9] = 12;
		tds[10] = 13;
		tds[11] = 10;
		tds[12] = 11;
		tds[13] = 12;/*attention*/
    loadDataToForm(id,formId,tds,InputsNames);
}

/* *
 * 加载数据到Form中
 * id:删除操作所在的id[规定：id的最后部分是该记录的排序号，且排序号码前必须至少有一个'_'作分隔符]
 * formId:要访问的单Id[暂时不需要用]
 * update_medicineName ,"update_prescription","update_component","update_perproty","update_useType","update_mainFunc",""* tds:该行记录的顺序号
 * InputsNames:输入框的name数组[默认：取第一个 即：[0]]	
 * */
function loadDataToForm(id, formId, tds, InputsNames) {
    //通过id获取到该行记录的序号
    var TH = id.substring(id.lastIndexOf('_') + 1, id.length); //取得最后一个字符('_')的位置，再＋1，取得其序号
    //
    for (var i = 0; i < InputsNames.length; i++) {
        // var node = document.getElementsByName(InputsNames[i])[0];
       $("[name='+"+InputsNames[i]+"']")[0].text($('#record_tr_' + TH + " td:eq(" + tds[i] + ")"));
       alert("节点值："+$("[name='+"+InputsNames[i]+"']")[0].text());
    }
}




/* * *
 * id:删除操作按钮所在的id [规定：id的最后部分是该记录的排序号，且排序号码前必须至少有一个'_'作分隔符]
 * src:要访问的url路径
 * pk_th:主键在tr中的排序位置[注释：按照数组下标0开始]
 * method:请求方式："GET"|"POST"
 * * */

function deleteRecord(id, src, pk_th,method) {

	var $_sure = confirm('确定删除本记录？');
	var TH = id.substring(id.lastIndexOf('_')+1,id.length);//取得最后一个字符('_')的位置，再＋1，取得其序号
//	alert("TH:"+TH);
	var tr = $("#record_tr_" + TH); // 方法2：选择元素的[直接]父级元素
//	alert("tr:" + tr);// tr:[object Object]
	if ($_sure) {
		if (src == null || src == ""){
			alert("参数设置不完整：src缺省！");
			return;
		}
		//获取要删除的主键值
		var pk = $("#record_tr_"+TH+">td:eq("+pk_th+")").text();//选择tr列表中的第pk_th个的元素
			pk = pk.replace(' ','');//替换掉空格
//		alert("主键值pk:"+pk);
		//创建并调用ajax	
		htmlobj = $.ajax({
			url : src,
			asyc : false,
			type : method,
			data : "pk="+pk,
			dataType : "json",
			complete : function(data) {
				try{
					var jsonData = eval("(" + data.responseText + ")");
				}catch(error){
					$("#ajax_info").css({"padding":"10px","bakcground":"#ccc","color":"red","font-size":"1.6em"});
		
					$("#ajax_info").html(data.responseText);
//					alert(error.message);
					$("h3.box-title").css({"background-color":"white","color":"#ccc"});//防止上述文档改变部分的页面样式
					return;
				}
								
//				alert(jsonData.msg);
				if(jsonData.msg=="OK"){//如果数据库中删除成功
					//删除tr文本节点
					alert(jsonData.msg_cont);
					tr.remove();
				}else{
					alert(jsonData.msg_cont);
				}
			}
		});//htmlobj----end

	}//if($_sure)----end

}

/* * * *
 * 以下属于测试环境
 * */
function deleteTest(src) {
	var src = '<%=request.getContextPath()%>/test1_Servlet';
	var xmlhttp = getXMLHTTP(src);
	$("#text").remove();
	$.ajax({
		url : src,
		success : function(result) {
			$("#result_hint").html(result);
		}
	});
	alert("删除成功！");
}

function deleteRecordTest(id, src, pk_th) {

	var $_sure = confirm('确定删除本记录？');
	// var tr = $("#record_tr_"+id);//方法1：选择父级元素tr
	var tr = $("#" + id).parent(); // 方法2：选择元素的直接父级元素
	alert("tr:" + tr);// tr:[object Object]
	if ($_sure) {
		if (src == null || src == "")
			src = "/MedicineMS/deleteMedicineTest";// 默认路径
		htmlobj = $.ajax({
			url : src,
			asyc : false,
			type : "GET",
			data : "test1=Helloworld&test2=nihao",
			dataType : "json",
			complete : function(data) {
				var jsonData = eval("(" + data.responseText + ")");

				alert("data:" + data);// data:[object Object]
				alert("data.responseText:" + data.responseText);// data.responseText:{"bean_id":"ID435893468966","bean_name":"匿名用户","bean_password":"0123456","bean_sex":"M"}
				alert("data.name:" + data.bean_id);// data.name:undefined
				alert("data.type:" + data.bean_password);// data.type:undefined
				alert("jsonData.bean_id:" + jsonData.bean_id);// jsonData.bean_id:ID435893468966

				/***************************************************************
				 * 经过网友指出，这个问题已经有了比较明确的结论，那就是jquery
				 * ajax方法的complete方法是不会处理dataType的，所以如果你是在complete里面试图直接用json数据是不可行的，必须先通过eval。
				 */
				// 在这里做些事情，假设返回的json数据里有name这个属性
				// 有时候可以直接data.name或者data['name']去访问
				// 但有时候，却要通过var jsonData =
				// eval("("+data.responseText+")");才可以通过jsonData.name访问，而且这种情况下，需要是complete而不是success
			}
		}),

		alert("htmlobj:" + htmlobj);// htmlobj:[object Object]
		alert("htmlobj.responseText:" + htmlobj.responseText);// htmlobj.responseText:undefined
		if (htmlobj.responseText == 'OK') {
			alert('删除成功!');
		}

	}

}

/*
 * <!-- success:function(result){ alert("result:"+result);//test
 * alert(result.innerHTML().subtring(0,1)); if(result.substring(0,1)=="OK"){ //
 * $('#record_tr_'+id).remove(); }else{ alert("删除失败！"); } } -->
 */