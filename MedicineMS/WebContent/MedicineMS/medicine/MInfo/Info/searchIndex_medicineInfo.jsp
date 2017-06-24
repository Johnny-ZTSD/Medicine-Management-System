<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.lang.*"%>
<%@ taglib prefix="medicinems" tagdir="/WEB-INF/tags"%>
<!-- /*
	GSP查询----作为响应页
*/   -->
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>药品信息查询[索引页]|仁爱药品管理系统</title>
<medicinems:links></medicinems:links>
<style>
ul.treeview-menu>li>a {
	text-indent: 2em;
}
</style>
</head>
<body class="hold-transition skin-green sidebar-mini">
	<medicinems:basePage_Up></medicinems:basePage_Up>
	<!-- Content Wrapper. Contains page content -->
        <div class="content-wrapper">
                                   <!-- |----------------------------------------------------------------------------------------------------| -->
                        <div style="display: flex; justify-content: row; align-items: center; padding: 5px; background: white">
                            <!--  #00a65a -->
                            <div class="btn-app" style="margin-bottom: 0; background-color: rgba(0, 166, 90, .8); color: white">
					            <span class="fa fa-gears "></span>药品管理
				     		</div>
				     		<c:if test="${staff.userType==1}">
				     			<div class="btn-app" style="margin-bottom: 0;">
				     			<a class="" style="width:100%;height:100%" href="#update_medicineName" id="add_btn_${s.index+1}" onclick="loadForm_addMedicineRecord(this.id)">
				     				<span class="fa fa-edit"></span>
				     				<br>添加药品
				     			</a>
				     		</div>
				     		</c:if>
					</div>
			<!-- |----------------------------------------------------------------------------------------------------| -->
			<!-- Main content -->
				<section >
					<form action="<%=request.getContextPath()%>/search_MedicineInfoAction" name="search_MedicineInfo_form" method="post" accept-charset="UTF-8" onsubmit="javascript:document.charset='UTF-8'" class="container" style="padding-top:15px;margin:0;background:#fff9ed;border:1px solid #fee7bb" >
                                <div class="form-group col-lg-3">
                                    <input class="form-control" type="text" name="medicineName" placeholder="药品品名">
                                </div>
                                <div class="form-group col-lg-2">
                                    <input class="form-control" type="text" name="cmpk" value="" placeholder="国药准字号">
                                </div>
                                <div class="form-group col-lg-2">
                                    <input class="form-control" type="text" name="mainFunc" placeholder="主治功能">
                                </div>
                                <div class="form-group col-lg-2">
                                    <select class="form-control" name="isPrescription">
                                        <option value="-1" title="默认：无">---药品类型---</option>
                                        <option value="0">非处方药</option>
                                        <option value="1">处方药</option>
                                    </select>
                                </div>
                                <div class="col-lg-2 col-xs-12">
                                    <input type="submit" class="col-lg-12 col-xs-12 btn btn-danger mybtn" value="查询">
                                </div>
                                </form>
                                </section>
                                <section>
                                    <div class="row ">
                                        <div class="col-xs-12 " style="padding: 15px">
                                            <div class="box">
                                                <div class="box-header">
                                                    <h3 class="box-title">药品信息查询列表</h3>
                                                </div>
                                                <!-- /.box-header -->
                                                <div class="box-body table-responsive">
                                                    <!-- 响应式[数据显示不够时，可以自动出现水平滚动栏] -->
                                                    <table id="example1" class="table table-bordered table-striped">
                                                        <thead>
                                                            <tr>
                                                                <th style="padding-right: 30px;">序号</th>
                                                                <th style="text-align:center ">操作</th>
                                                                <th>国药准字号</th>
                                                                <th>药品品名</th>
                                                                <th>是否处方药</th>
                                                                <th>药品成分</th>
                                                                <th style="display: none;">药物性状</th>*
                                                                <th style="display: none;">使用方式</th>*
                                                                <th>主治功能</th>
                                                                <th>药品规格</th>
                                                                <th style="">用法用量</th>*
                                                                <th style="display: none;">药物禁忌</th>*
                                                                <th style="display: none;">不良反应</th>*
                                                                <th style="display: none;">注意事项</th>*
                                                                <th style="display: none;">药品包装</th>*
                                                                <th style="display: none;">贮存方式</th>*
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <script type="text/javascript">
                                                            function $_id(id) {
                                                                return document.getElementById(id)
                                                            }

                                                            function deleteRecord(id) {
                                                                var $_sure = confirm('确定删除该记录？');
                                                                var node = $_id('record_tr_' + id);
                                                                alert(node);

                                                            }

                                                            function deleteRecord(id) {
                                                                $("#record_tr_" + id).remove();
                                                            }
                                                            </script>
                                                            <c:if test="${MedicineInfo_List != null}">
                                                                <c:forEach items="${MedicineInfo_List }" var="item" varStatus="s">
                                                                    <!-- items:指定数据源[迭代的对象] or 设置begin和end值 -->
                                                                    <tr id="record_tr_${s.index+1}">
                                                                        <td>${s.index+1}</td>
                                                                        <td>
                                                                            <button class="btn btn-xs btn-info btn-preview" id="testBtn" data-toggle="modal" data-target="#preview_Modal">详情</button>&nbsp;
                                                                            <c:if test="${staff.userType==1}">
                                                                            	<button class="btn btn-xs btn-danger" onclick="deleteRecord(this.id,'<%=request.getContextPath()%>/deleteMedicineInfoAction',2,'GET')" id="delete_btn_${s.index+1}">删除</button>&nbsp;
                                                                            </c:if>	
                                                                            <a class="btn btn-xs btn-warning" href="#update_medicineName" id="update_btn_${s.index+1}" onclick="loadCMPK(this.id)">修改</a>
                                                                        	
                                                                        </td>
                                                                        <td id="pk_${s.index+1}">${item.cmpk}</td>
                                                                        <td>${item.name}</td>
                                                                        <td title="${item.prescription}">${item.prescription==true?"处方药":"非处方药"}</td>
                                                                        <td>${item.component}</td>
                                                                        <td style="display: none;">${item.property}</td>
                                                                        <td style="display: none;">${item.useType}</td>
                                                                        <td>${item.mainFun}</td>
                                                                        <td>${item.standard}</td>
                                                                        <td style="">${item.usageX}</td>
                                                                        <td style="display: none;">${item.forbid}</td>
                                                                        <td style="display: none;">${item.badEffect}</td>
                                                                        <td style="display: none;">${item.attention}</td>
                                                                        <td style="display: none;">${item.wrap}</td>
                                                                        <td style="display: none;">${item.storageWay}</td>
                                                                    </tr>
                                                                </c:forEach>
                                                            </c:if>
                                                        </tbody>
                                                        <tfoot>
                                                            <tr>
                                                                <th style="padding-right: 30px;">序号</th>
                                                                <th>操作</th>
                                                                <th>国药准字号</th>
                                                                <th>药品品名</th>
                                                                <th>是否处方药</th>
                                                                <th>药品成分</th>
                                                                <th style="display: none;">药物性状</th>*
                                                                <th style="display: none;">使用方式</th>*
                                                                <th>主治功能</th>
                                                               
                                                                <th>药品规格</th>
                                                                <th style="">用法用量</th>*
                                                                <th style="display: none;">药物禁忌</th>*
                                                                <th style="display: none;">不良反应</th>*
                                                                <th style="display: none;">注意事项</th>*
                                                                <th style="display: none;">药品包装</th>*
                                                                <th style="display: none;">贮存方式</th>*
                                                            </tr>
                                                        </tfoot>
                                                    </table>
                                                </div>
                                                <!-- /.box-body -->
                                            </div>
                                            <!-- /.box -->
                                            <!-- |----------------------------------------------------------------------------------------------------| -->
                                        </div>
                                        <!-- /.col -->
                                    </div>
                                    <!-- /.row -->
                                </section>
                                <!-- 详细--模态框 -->
                                <section>
                                    <!-- 模态框（Modal） -->
                                    <div class="modal col-lg-12 fade" id="preview_Modal" tabindex="-1" role="dialog" aria-labelledby="preview_ModalLabel" aria-hidden="true">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                                        &times;
                                                    </button>
                                                    <h4 class="modal-title" id="preview_ModalLabel"><i class="fa fa-medkit"></i>&nbsp;&nbsp;药品信息</h4>
                                                </div>
                                                <div class="modal-body">
                                                    <!-- |---------------------------------------------------------------------------------------------- -->
                                                    <div class="row">
                                                        <div class="col-xs-12">
                                                            <h2 class="page-header" style="color:#f56954">
            													<i class="fa fa-globe"></i> <span><span type="text" class="modal_name">消炎止痢灵片</span><strong>&nbsp;&nbsp;<small class="modal_cmpn">Z44021906</small></strong></span>
            													<small class="pull-right">Date:
            													<span id="modal_time"></span>
            														<script type="text/javascript" id="modal_time">var d=new Date()
            															var day=d.getDate();
            															var month=d.getMonth() + 1;
            															var year=d.getFullYear();
            															document.getElementById("modal_time").innerHTML = year + "/" + month + "/" + day;
            														</script>
            													</small>
          													</h2>
                                                            <h5></h5>
                                                        </div>
                                                    </div>
                                                    <div class="row invoice-info">
                                                        <div class="col-lg-12">
                                                            <strong>[成&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;分]&nbsp;&nbsp;</strong> <span  class="modal_component">苦参，甲氧苄氨嘧啶</span>
                                                        </div>
                                                        <div class="col-lg-12">
                                                            <strong>[性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;状]&nbsp;&nbsp;</strong>
                                                            <span class="modal_property">本品为糖衣片，除去糖衣后显棕色；味苦</span>
                                                        </div>
                                                        <div class="col-lg-12">
                                                            <strong>[主治功能]&nbsp;&nbsp;</strong> <span class="modal_mainFunc">清热燥湿，健脾止泻。用于脾虚湿热内蕴所致的泄泻急迫，泻而不爽，或大便溏泻，食少倦怠，腹胀腹痛。</span>
                                                        </div>
                                                        <div class="col-lg-12">
                                                            <strong>[规&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;格]&nbsp;&nbsp;</strong> <span class="modal_standard">每片重0.4g</span>
                                                        </div>
                                                        <div class="col-lg-12">
                                                            <strong>[用法用量]&nbsp;&nbsp;</strong><span class="modal_usage"> 口服一次4-6片，一日3次。</span>
                                                        </div>
                                                        <div class="col-lg-12">
                                                            <strong>[不良反应]&nbsp;&nbsp;</strong> <span class="modal_badEffect"></span>尚不明确。
                                                        </div>
                                                        <div class="col-lg-12">
                                                            <strong>[药物禁忌]&nbsp;&nbsp;</strong> <span class="modal_forbid">孕妇、哺乳期妇女禁用。</span>
                                                        </div>
                                                        <div class="col-lg-12">
                                                            <strong>[注意事项]&nbsp;&nbsp;</strong>
                                                            <div style="padding-left:5em" class="modal_attention">
                                                                1.饮食宜清淡，忌食辛辣、生冷、油腻食物。
                                                                <br>2.不宜在服药期间同时服用滋补性中药。
                                                                <br>3.有 慢性结肠炎、溃疡性结肠炎便脓血等慢性病史者，患泄泻后应去医院就诊。
                                                                <br>4.有高血压、心脏病、糖尿病、肝病、肾病等慢性病严重者应在医师指导下服用。
                                                                <br>5.服药3天症状无缓解，应去医院 就诊。
                                                                <br>6.严格按用法用量服用，儿童、年老体弱者应在医师指导下服用。
                                                                <br>7.对本品过敏者禁用，过敏体质者慎用。
                                                                <br>8.本品性状发生改变时禁止使用。
                                                                <br>9.儿童必须在成人监护下使用。
                                                                <br>10.请将本 品放在儿童不能接触的地方。
                                                                <br>11.如正在使用其他药品，使用本品前请咨询医师或药师。
                                                            </div>
                                                        </div>
                                                        <div class="col-lg-12">
                                                            <strong>[贮存方式]&nbsp;&nbsp;</strong><span class="modal_storageWay"> 密封。</span>
                                                        </div>
                                                        <div class="col-lg-12">
                                                            <strong>[包&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;装]&nbsp;&nbsp;</strong> <span class="modal_wrap">药用铝塑板，每板9片。</span>
                                                        </div>
                                                    </div>
                                                    <!-- |---------------------------------------------------------------------------------------------- -->
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                                                    </button>
                                                    <button type="button" class="btn btn-success pull-right" onclick="javascript:window.print();">
                                                        <i class="fa fa-print"></i> 打印
                                                    </button>
                                                </div>
                                            </div>
                                            <!-- /.modal-content -->
                                        </div>
                                    </div>
                                    <!-- /.modal -->
                                </section>
                               
                               
                               
                                                               <!-- |----------------------------------------------------------------------------------------------------| -->
                                <section style="padding: 20px;">
                                    <div class="box box-info">
                                        <div class="box-header with-border">
                                            <h3 class="box-title" id="form_updateMedicineTitle">修改药品信息</h3>
                                        </div>
                                        <!-- /.box-header -->
                                        <!-- form start -->
                                        <form class="form-horizontal" id="update_medicineInfo_form" action="<%=request.getContextPath()%>/updateMedicineInfoAction" method="post" accept-charset="utf-8" onsubmit="updateMedicineInfo();return false">
                                            <div class="box-body">
                                                <div class="form-group">
                                                    <label for="update_cmpk" class="col-sm-2 control-label">国药准字号</label>
                                                    <div class="col-sm-10">
                                                        <input type="text" class="form-control" name="update_cmpk" id="update_cmpk" placeholder="Country Medicine Permit Number" value="Z20080195"  required  readonly>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="update_medicineName" class="col-sm-2 control-label">药品品名</label>
                                                    <div class="col-sm-10">
                                                        <input type="text" class="form-control"  id="update_medicineName" name="update_medicineName" placeholder="Medicine Name" required>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="update_prescription" class="col-sm-2 control-label">是否处方药</label>
                                                    <div class="col-sm-10">
                                                        <select class="form-control" id="update_prescription" name="update_prescription" placeholder="Is it Prescription?" required>
                                                            <option value="-1">---请选择---</option>
                                                            <option value="1">是</option>
                                                            <option value="0">否</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="update_component" class="col-sm-2 control-label">药品成分</label>
                                                    <div class="col-sm-10">
                                                        <input type="text" class="form-control" id="update_component" name="update_component" placeholder="Medicine Component" required>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="update_perproty" class="col-sm-2 control-label">药品性状</label>
                                                    <div class="col-sm-10">
                                                        <input type="text" class="form-control" name="update_perproty" id="update_perproty" placeholder="Medicine Perproty" required>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-2 control-label" for="update_useType">使用方式</label>
                                                    <div class="col-sm-10">
                                                        <select class="form-control" id="update_useType" name="update_useType" required>
                                                            <option value="0">未知</option>
                                                            <option value="1">仅可口服</option>
                                                            <option value="2">仅可外用</option>
                                                            <option value="3">口服兼外用</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="update_mainFunc" class="col-sm-2 control-label">主治功能</label>
                                                    <div class="col-sm-10">
                                                        <input type="text" class="form-control" name="update_mainFunc" id="update_mainFunc" placeholder="Medicine Main Functions" required>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="update_standard" class="col-sm-2 control-label">药品规格</label>
                                                    <div class="col-sm-10">
                                                        <input type="text" class="form-control" id="update_standard" name="update_standard" placeholder="Medicine Main Standard" required>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="update_usage" class="col-sm-2 control-label">用法用量</label>
                                                    <div class="col-sm-10">
                                                        <input type="text" class="form-control" name="update_usage" id="update_usage" placeholder="Medicine Main Usage" required>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="update_wrap" class="col-sm-2 control-label">药品包装</label>
                                                    <div class="col-sm-10">
                                                        <input type="text" class="form-control" name="update_wrap" id="update_wrap" placeholder="Medicine Main Wrap" required>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="update_storageWay" class="col-sm-2 control-label">贮存方式</label>
                                                    <div class="col-sm-10">
                                                        <input type="text" class="form-control" name="update_storageWay" id="update_storageWay" placeholder="Medicine Main Storage's Way" required>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="update_forbid" class="col-sm-2 control-label">药品禁忌</label>
                                                    <div class="col-sm-10">
                                                        <textarea name="update_forbid" id="update_forbid" class="form-control" placeholder="Medicine Forbid" rows="3" ></textarea>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="update_badEffect" class="col-sm-2 control-label">不良反应</label>
                                                    <div class="col-sm-10">
                                                        <textarea name="update_badEffect" id="update_badEffect" class="form-control" placeholder="Medicine badEffect" rows="3" ></textarea>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label for="update_attention" class="col-sm-2 control-label">注意事项</label>
                                                    <div class="col-sm-10">
                                                        <textarea name="update_attention" id="update_attention" class="form-control" placeholder="Medicine Attention" rows="3"></textarea>
                                                    </div>
                                                </div>
                                                 <div class="form-group" style="display:none">
                                                    <label for="update_Type" class="col-sm-2 control-label">更新方式</label>
                                                    <div class="col-sm-10">
                                                        <input type="text" class="form-control" name="update_Type" id="update_Type" value="update" required >
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- /.box-body -->
                                            <div class="box-footer">
                                                <input type="submit" class="btn btn-info pull-right" value="提交">
                                            </div>
                                            <!-- /.box-footer -->
                                        </form>
                                    </div>
                                </section>
                                <!-- |----------------------------------------------------------------------------------------------------| -->
                               
                               
                               
			<!-- /.content -->
			<!-- |----------------------------------------------------------------------------------------------------| -->
		</div>
		<!-- /.content-wrapper -->
	<medicinems:basePage_Down></medicinems:basePage_Down>		
	<!-- 表格操作脚本 -->
	<script
		src="<%=request.getContextPath()%>/js/table.js"></script>
	
                        <script>
                        $(function() {
                            $("#example1 ").DataTable({
                                "paging ": true,
                                "lengthChange ": false,
                                "searching ": false,
                                "ordering ": true,
                                "info ": true,
                                "autoWidth ": false
                            });
                            // $("#example1 ").DataTable();
                        });
                        window.onload = function() {
                                reloadTable();
                                
                                $('button.btn-preview').click(function(){
                                	var modal_id = 'preview_Modal';
                                	var tr = $(this).parent().parent();
                                	loadDataToModal(modal_id,tr);
                                	// alert("$(this).parent().parent().id():"+tr.html());
                                	//$('#'+modal_id).modal('show');
                                	//$().css({"display":"block"});
                                	var modal = document.getElementById('#'+modal_id);
                                	modal.style.display = 'block';
                                	
                                });
                 
                            }
                            //重新加载table[使布局美观]
                        function reloadTable() {
                            $("table.dataTable th ").css("white-space", "nowrap");
                            $("table.dataTable td ").css("white-space", "nowrap");
                        }

                        /*加载数据到模态框*/
                        function loadDataToModal(modal_id,tr){
                        	var modal = $("#"+modal_id);
                        	console.log("tr:"+tr);
                        	console.log('测试:'+tr.children().eq(2).text());
                        	// var tr = $("#"+tr_id);	
                        	$('.modal_cmpn').text(tr.children().eq(2).text());
                        	$('.modal_name').text(tr.children().eq(3).text());
                        	$('.modal_component').text(tr.children().eq(5).text());
                        	$('.modal_property').text(tr.children().eq(6).text());
                        	$('.modal_mainFunc').text(tr.children().eq(8).text());
                        	$('.modal_standard').text(tr.children().eq(9).text());
                        	$('.modal_usage').text(tr.children().eq(10).text());
                        	$('.modal_forbid').text(tr.children().eq(11).text());
                        	$('.modal_badEffect').text(tr.children().eq(12).text());

                        	$('.modal_attention').text(tr.children().eq(13).text());
                        	// $('#modal_attention').css("padding-left":"3em");
                        	$('.modal_wrap').text(tr.children().eq(14).text());
                        	$('.modal_storageWay').text(tr.children().eq(15).text());
                        	$('.modal_badEffect').text(tr.children().eq(12).text());
                        	//alert('加载成功！');
                        }
                       
                        
                        
                        </script>
</body>

</html>
<script type="text/javascript ">
	/**
	 * An array of data to use for the table, passed in at initialisation which
	 * will be used in preference to any data which is already in the DOM. This is
	 * particularly useful for constructing tables purely in Javascript, for
	 * example with a custom Ajax call.
	 *  @type array
	 *  @default null
	 *
	 *  @dtopt Option
	 *  @name DataTable.defaults.data
	 *
	 *  @example
	 *    // Using a 2D array data source
	 *    $(document).ready( function () {
	 *      $('#example').dataTable( {
	 *        "data ": [
	 *          ['Trident', 'Internet Explorer 4.0', 'Win 95+', 4, 'X'],
	 *          ['Trident', 'Internet Explorer 5.0', 'Win 95+', 5, 'C'],
	 *        ],
	 *        "columns ": [
	 *          { "title ": "Engine " },
	 *          { "title ": "Browser " },
	 *          { "title ": "Platform " },
	 *          { "title ": "Version " },
	 *          { "title ": "Grade " }
	 *        ]
	 *      } );
	 *    } );
	 *
	 *  @example
	 *    // Using an array of objects as a data source (`data`)
	 *    $(document).ready( function () {
	 *      $('#example').dataTable( {
	 *        "data ": [
	 *          {
	 *            "engine ":   "Trident ",
	 *            "browser ":  "Internet Explorer 4.0 ",
	 *            "platform ": "Win 95+ ",
	 *            "version ":  4,
	 *            "grade ":    "X "
	 *          },
	 *          {
	 *            "engine ":   "Trident ",
	 *            "browser ":  "Internet Explorer 5.0 ",
	 *            "platform ": "Win 95+ ",
	 *            "version ":  5,
	 *            "grade ":    "C "
	 *          }
	 *        ],
	 *        "columns ": [
	 *          { "title ": "Engine ",   "data ": "engine " },
	 *          { "title ": "Browser ",  "data ": "browser " },
	 *          { "title ": "Platform ", "data ": "platform " },
	 *          { "title ": "Version ",  "data ": "version " },
	 *          { "title ": "Grade ",    "data ": "grade " }
	 *        ]
	 *      } );
	 *    } );
	 */
</script>
