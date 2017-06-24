销售管理|仁爱药品管理系统
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
<style type="text/css">
.treeview-menu>li>a {
	text-indent: 2em;
}
</style>
<script type="text/javascript">
	// onclick="refresh_overlay()"
	/*切换模态框*/
	window.onload = function() {
		closeModal();
		// refresh_overlay();    
	}

	function closeModal() { //ok
		var modal_div = document.getElementById('modal_div');
		$('#close_btn').click(function() {
			$('#modal_div').hide();
		});
	}

	function closeForm() {
		$('#form').click(function() {
			$('#modal_div').hide();
		});
	}

	function showModal() {
		// var modal_div = document.getElementById('modal_div');
		// $('#close_btn')
		$('#modal_div').show();
	}

	function refresh_overlay() {
		$('#form').hide();
		// var div = document.getElementById('fresh_overlay_div');
		// alert('test');
		$('#fresh_overlay_div').show();
		// showModal();
	}
</script>
</head>

<body class="hold-transition skin-green sidebar-mini">
	<medicinems:basePage_Up></medicinems:basePage_Up>
	<!-- Content Wrapper. Contains page content -->
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<!--             <section class="content-header">
                <h1>
        Page Header
        <small>Optional description</small>
      </h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
                    <li class="active">Here</li>
                </ol>
            </section> -->
		<!-- |----------------------------------------------------------------------------------↑------------------------------ -->
		<!-- Main content -->
		<!-- 导航条/ -->
		<div
			style="display: flex; justify-content: row; align-items: center; padding: 5px; background: white">
			<div class="btn-app"
				style="margin-bottom: 0; background-color: rgba(0, 166, 90, .8); color: white"
				title="Create A Medicine's Sale Of Record">
				<span class="fa fa-edit active"></span>创建单条销售记录
			</div>
			<!--  #00a65a -->
			<div class="btn-app" style="margin-bottom: 0;">
				<span class="fa fa-search"></span>查询销售记录
			</div>
			<c:if test="${staff.userType==1}">
				<div class="btn-app" style="margin-bottom: 0">
					<a href="<%=request.getContextPath()%>/search_staffsAction"><span
						class="fa fa-user"></span><br>[查询用户]</a>
				</div>
			</c:if>
			<c:if test="${staff.userType!=1}">
				<div class="btn-app" style="margin-bottom: 0">
					<a
						href="<%=request.getContextPath()%>/MedicineMS/user/customer/index_CUSTadmin.jsp"><span
						class="fa fa-user"></span><br>[查询用户]</a>
				</div>
			</c:if>
		</div>
		<!-- /导航条 -->
		<section class="content">
			<!--|------|  -->
			<!--|------|  -->
			<!-- 模态框/ -->
			<div class="modal fade in" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true"
				style="display: block;" id="modal_div">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">
								<a
									href="<%=request.getContextPath() + "/MedicineMS/sell/MSaleRecord/add/add_MSaleRecord.jsp"%>">X</a>
							</button>
							<div class="chatBox-header-container"
								style="display: flex; color: #286090;">
								<div>
									<a href="#">药品销售记录-提交反馈</a>
								</div>

							</div>
							<!-- <h4 class="modal-title" id="myModalLabel">
                    发起聊天...
                </h4> -->
						</div>
						<div class="modal-body">
							<!-- body -->
							<c:if
								test="${requestScope.createMedicineSaleRecord_status=='010'}"
								var="test" scope="request">
								<form style="color: #666" name="topicForm" action="#">
									<div class="form-group" style="text-align: center">
										<label for="medicineSaleNumber_input">销售记录编号</label> <input
											type="text" class="form-control"
											id="medicineSaleNumber_input"
											placeholder="Medicine Sale Number" name="medicineSaleNumber"
											value="${requestScope.MSaleRecord_FeedBack.id}" disabled
											required>
									</div>
									<div style="display: flex; justify-content: space-between;">
										<div class="form-group">
											<label for="medicineName_input">药品名称</label> <input
												type="text" class="form-control" id="medicineName"
												placeholder="Medicine's Name" name="medicineName"
												value="${requestScope.MSaleRecord_FeedBack.medicineName}"
												disabled required>
										</div>
										<div class="form-group">
											<label for="salePrice_input">药品单价</label> <input type="text"
												class="form-control" id="salePrice_input" name="salePrice"
												placeholder="Sale Price[Unit:RMB]"
												value="${requestScope.MSaleRecord_FeedBack.salePrice}"
												disabled required>
										</div>
										<div class="form-group">
											<label for="medicineAmount_input">药品数目</label> <input
												type="number" class="form-control" id="medicineAmount_input"
												name="medicineAmount" placeholder="Medicine's Amount"
												value="${requestScope.MSaleRecord_FeedBack.saleNum}"
												disabled required>
										</div>
									</div>
									<div style="display: flex; justify-content: space-between;">
										<div style="display: flex; justify-content: space-between;">
											<div class="form-group">
												<label for="amountPayable_input">应付金额</label> <input
													type="text" class="form-control" id="amountPayable_input"
													placeholder="Amount Payable" name="amountPayable"
													value="${requestScope.MSaleRecord_FeedBack.amountPayable}"
													disabled required>
											</div>
										</div>
										<div class="form-group">
											<label for="payAmountMoney_input">支付金额</label> <input
												type="text" class="form-control" id="payAmountMoney_input"
												name="payAmountMoney"
												placeholder="Pay Amount Of Money.[Unit:RMB]"
												value="${requestScope.MSaleRecord_FeedBack.payAmountMoney}"
												disabled required>
										</div>
										<div class="form-group">
											<label for="oddChange_input">找零</label> <input type="text"
												class="form-control" id="oddChange_input" name="oddChange"
												placeholder="Odd Change"
												value="${requestScope.MSaleRecord_FeedBack.oddChange}"
												disabled>
										</div>
									</div>
									<div style="display: flex; justify-content: space-between;">
										<div class="form-group">
											<label for="salerName_input">顾客账户</label> <input type="text"
												class="form-control" id="customerAccountNo_input"
												placeholder="Customer's Account No"
												value="${requestScope.MSaleRecord_FeedBack.customerAccountNo}"
												name="customerAccountNo" disabled>
										</div>
										<div class="form-group">
											<label for="salerName_input">销售者姓名</label> <input type="text"
												class="form-control" id="salerName_input"
												placeholder="Saler's Name" name="salerName"
												value="${requestScope.MSaleRecord_FeedBack.salerName}"
												disabled>
										</div>
										<div class="form-group">
											<label for="dealDateTime_input">交易时间</label> <input
												type="text" class="form-control" id="dealDateTime_input"
												placeholder="Deal's Time" name="dealDateTime"
												value="${requestScope.MSaleRecord_FeedBack.saleDate}"
												disabled>
										</div>
									</div>
							</c:if>
							<div class="modal-footer">
								<!-- <br> -->
								<div style="text-align: left; padding: 20px">

									${requestScope.createMedicineSaleRecord_message}</div>
								<button type="button" class="btn btn-danger"
									data-dismiss="modal">打印[暂未开放]</button>
								<a
									href="<%=request.getContextPath() + "/MedicineMS/sell/MSaleRecord/add/add_MSaleRecord.jsp"%>">
									<input type="button" class="btn btn-success"
									data-dismiss="modal" value="我知道了" id="close_btn">
								</a>
								<!-- </form> -->
							</div>
							<!-- </form> -->
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal -->
			</div>
			<!-- /.modal-dialog -->
			<div class="overlay" id="fresh_overlay_div"
				style="padding: 10px; font-size: 1.6em; display: none;">
				数据正在提交[请不要刷新]...<i class="fa fa-refresh fa-spin"></i>
			</div>
		</section>
	</div>
	<!-- /模态框 -->
	<!-- Your Page Content Here -->

	<!-- |----------------------------------------------------------------------------------↑------------------------------ -->
	<!-- /.content -->
	</div>
	<!-- /.content-wrapper -->
	<!-- Main Footer -->
	<footer class="main-footer">
		<!-- To the right -->
		<div class="pull-right hidden-xs">为您提供最好的服务.</div>
		<!-- Default to the left -->
		<strong>&copy;2017---2017 <a href="#">微力互动实验</a>.
		</strong> 版权所有
	</footer>
	<!-- Control Sidebar -->
	<aside class="control-sidebar control-sidebar-dark">
		<!-- Create the tabs -->
		<ul class="nav nav-tabs nav-justified control-sidebar-tabs">
			<li class="active"><a href="#control-sidebar-home-tab"
				data-toggle="tab"><i class="fa fa-home"></i></a></li>
			<li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i
					class="fa fa-gears"></i></a></li>
		</ul>
		<!-- Tab panes -->
		<div class="tab-content">
			<!-- Home tab content -->
			<div class="tab-pane active" id="control-sidebar-home-tab">
				<h3 class="control-sidebar-heading">Recent Activity</h3>
				<ul class="control-sidebar-menu">
					<li><a href="javascript:;"> <i
							class="menu-icon fa fa-birthday-cake bg-red"></i>
							<div class="menu-info">
								<h4 class="control-sidebar-subheading">Langdon's Birthday</h4>
								<p>Will be 23 on April 24th</p>
							</div>
					</a></li>
				</ul>
				<!-- /.control-sidebar-menu -->
				<h3 class="control-sidebar-heading">Tasks Progress</h3>
				<ul class="control-sidebar-menu">
					<li><a href="javascript:;">
							<h4 class="control-sidebar-subheading">
								Custom Template Design <span class="pull-right-container">
									<span class="label label-danger pull-right">70%</span>
								</span>
							</h4>
							<div class="progress progress-xxs">
								<div class="progress-bar progress-bar-danger" style="width: 70%"></div>
							</div>
					</a></li>
				</ul>
				<!-- /.control-sidebar-menu -->
			</div>
			<!-- /.tab-pane -->
			<!-- Stats tab content -->
			<div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab
				Content</div>
			<!-- /.tab-pane -->
			<!-- Settings tab content -->
			<div class="tab-pane" id="control-sidebar-settings-tab">
				<form method="post">
					<h3 class="control-sidebar-heading">General Settings</h3>
					<div class="form-group">
						<label class="control-sidebar-subheading"> Report panel
							usage <input type="checkbox" class="pull-right" checked>
						</label>
						<p>Some information about this general settings option</p>
					</div>
					<!-- /.form-group -->
				</form>
			</div>
			<!-- /.tab-pane -->
		</div>
	</aside>
	<!-- /.control-sidebar -->
	<!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
	<div class="control-sidebar-bg"></div>
	</div>
	<!--  
  |--------------------------------------------------------------------------|  
  |--------------------------------------------------------------------------|  
  |--------------------------------------------------------------------------|  
  |--------------------------------------------------------------------------|  
  |--------------------------------------------------------------------------|  
  |--------------------------------------------------------------------------|  
  |--------------------------------------------------------------------------|  
  |--------------------------------------------------------------------------|  
 -->
	<!-- REQUIRED JS SCRIPTS -->
	<!-- jQuery 2.2.3 -->
	<script src="framework/AdminLTE/plugins/jQuery/jquery-2.2.3.min.js"></script>
	<!-- jQuery -->
	<!-- <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
         -->
	<!-- <script type="text/javascript" src=""></script> -->
	<!-- Bootstrap 3.3.6 -->
	<script src="framework/AdminLTE/bootstrap/js/bootstrap.min.js"></script>
	<!-- AdminLTE App -->
	<script src="framework/AdminLTE/dist/js/app.min.js"></script>
	<!-- Optionally, you can add Slimscroll and FastClick plugins.
     Both of these plugins are recommended to enhance the
     user experience. Slimscroll is required when using the
     fixed layout. -->
</body>

</html>
