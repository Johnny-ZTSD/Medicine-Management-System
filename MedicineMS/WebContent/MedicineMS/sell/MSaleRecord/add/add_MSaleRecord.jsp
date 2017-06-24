<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.lang.*"%>
<%@ taglib prefix="medicinems" tagdir="/WEB-INF/tags"%>
<!-- /*
	药品销售记录创建----作为响应页
*/   -->
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>药品销售记录创建|仁爱药品管理系统</title>
<medicinems:links></medicinems:links>

<style>
ul.treeview-menu>li>a {
	text-indent: 2em;
}
</style>
</head>
<body class="hold-transition skin-green sidebar-mini">
	<medicinems:basePage_Up></medicinems:basePage_Up>
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
				<a href="<%=request.getContextPath()%>/search_staffsAction"><span class="fa fa-user"></span><br>[查询用户]</a>
			</div>
			</c:if>
			<c:if test="${staff.userType!=1}">
			<div class="btn-app" style="margin-bottom: 0">
				<a href="<%=request.getContextPath()%>/MedicineMS/user/customer/index_CUSTadmin.jsp"><span class="fa fa-user"></span><br>[查询用户]</a>
			</div>
			</c:if>
		</div>
		<!-- /导航条 -->
		<section class="content">
			<!--|------|  -->
			<div class="box box-primary" style="padding: 50px;" id="form">
				<div class="box-header with-border">
					<h3 class="box-title" title="Create A Medicine's Sale Of Record">创建单条销售记录</h3>
				</div>
				<!-- /.box-header -->
				<!-- form start -->
				<form role="form" name="createMedicineSaleRecord_form"
					action="<%=request.getContextPath()%>/createMedicineSaleRecordService"
					method="post" accept-charset="UTF-8"
					onsubmit="return commitMedicineSaleRecord()">
					<div class="box-body">
						<div class="form-group">
							<label for="CMPN_input">国药准字号</label> <input type="text"
								class="form-control" id="CMPN_input" name="cmpn"
								placeholder="Country Medicine Permit Number" required>
						</div>
						<div class="form-group">
							<label for="batchNum_input">生产批次号</label> <input type="text"
								class="form-control" id="batchNum_input" name="batchNum"
								placeholder="Medicine Batch Number" required>
						</div>
						<div class="form-group">
							<label for="medicineName_input">药品名称</label> <input type="text"
								class="form-control" id="medicineName_input" name="medicineName"
								placeholder="Medicine's Name" required>
						</div>
						<div class="form-group">
							<label for="salePrice_input">销售价格[单位：元]</label> <input
								type="text" class="form-control" id="salePrice_input"
								name="salePrice" placeholder="Sale Price[Unit:RMB]" required>
						</div>
						<div class="form-group">
							<label for="medicineAmount_input">药品数目[单位：个/盒/件]</label> <input
								type="number" class="form-control" id="medicineAmount_input"
								name="medicineAmount" placeholder="Medicine's Amount" required>
						</div>
						<!-- <div class="form-group">
                                <label for="medicineAmount_input">药品数目</label>
                                <select class="form-control" name="medicineAmount" id="medicineAmount_input">
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                    <option value="7">7</option>
                                    <option value="8">8</option>
                                    <option value="9">9</option>
                                    <option value="10">10</option>
                                    <option value="11">11</option>
                                    <option value="12">12</option>
                                    <option value="13">13</option>
                                    <option value="14">14</option>
                                    <option value="15">15</option>
                                    <option value="16">16</option>
                                    <option value="17">17</option>
                                    <option value="18">18</option>
                                    <option value="19">19</option>
                                    <option value="20">20</option>
                                </select>
                            </div> -->
						<div class="form-group">
							<label for="payAmountMoney_input">支付金额[单位：元]</label> <input
								type="text" class="form-control" id="payAmountMoney_input"
								name="payAmountMoney"
								placeholder="Pay Amount Of Money.[Unit:RMB]" required>
						</div>
					</div>
					<div class="input-group margin">
						<div class="input-group-btn">
							<button type="button" class="btn btn-success">顾客账户名</button>
						</div>
						<!-- /btn-group -->
						<input type="text" class="form-control"
							name="coustomerAccountName" value="0000000000"
							placeholder="Customer's Account Name[Allow anonymous.]" required>
					</div>
					<!-- /.box-body -->
					<div class="box-footer">
						<input type="submit" class="btn btn-danger" value="确认"
							title="sure"> &nbsp;&nbsp;&nbsp;&nbsp;
						<button type="submit" class="btn btn-default" title="cancle">取消</button>
					</div>
				</form>
				<!-- Button trigger modal -->
				<!--                     <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
                        Launch demo modal
                    </button> -->
			</div>
		</section>
		<!--|------|  -->
		<!-- 模态框/ -->
		<div class="modal fade in" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true"
			style="display: none;" id="modal_div">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
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
						<form style="color: #666" name="topicForm" action="#">
							<div class="form-group" style="text-align: center">
								<label for="medicineSaleNumber_input">销售记录编号</label> <input
									type="text" class="form-control" id="medicineSaleNumber_input"
									placeholder="Medicine Sale Number" name="medicineSaleNumber"
									disabled>
							</div>
							<div style="display: flex; justify-content: space-between;">
								<div class="form-group">
									<label for="medicineName_input">药品名称</label> <input type="text"
										class="form-control" id="medicineName"
										placeholder="Medicine's Name" name="medicineName" disabled>
								</div>
								<div class="form-group">
									<label for="salePrice_input">药品单价</label> <input type="text"
										class="form-control" id="salePrice_input" name="salePrice"
										placeholder="Sale Price[Unit:RMB]" disabled>
								</div>
								<div class="form-group">
									<label for="medicineAmount_input">药品数目</label> <input
										type="number" class="form-control" id="medicineAmount_input"
										name="medicineAmount" placeholder="Medicine's Amount" disabled>
								</div>
							</div>
							<div style="display: flex; justify-content: space-between;">
								<div style="display: flex; justify-content: space-between;">
									<div class="form-group">
										<label for="amountPayable_input">应付金额</label> <input
											type="text" class="form-control" id="amountPayable_input"
											placeholder="Amount Payable" name="amountPayable" disabled>
									</div>
								</div>
								<div class="form-group">
									<label for="payAmountMoney_input">支付金额</label> <input
										type="text" class="form-control" id="payAmountMoney_input"
										name="payAmountMoney"
										placeholder="Pay Amount Of Money.[Unit:RMB]" disabled>
								</div>
								<div class="form-group">
									<label for="oddChange_input">找零</label> <input type="text"
										class="form-control" id="oddChange_input" name="oddChange"
										placeholder="Odd Change" disabled>
								</div>
							</div>
							<div style="display: flex; justify-content: space-between;">
								<div class="form-group">
									<label for="CustomerName_input">顾客姓名</label> <input type="text"
										class="form-control" id="salerName_input"
										placeholder="Customer's Name" name="customerName" disabled>
								</div>
								<div class="form-group">
									<label for="salerName_input">销售者姓名</label> <input type="text"
										class="form-control" id="salerName_input"
										placeholder="Saler's Name" name="salerName" disabled>
								</div>
								<div class="form-group">
									<label for="dealDateTime_input">交易时间</label> <input type="text"
										class="form-control" id="dealDateTime_input"
										placeholder="Deal's Time" name="dealDateTime" disabled>
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-danger"
									data-dismiss="modal">打印[暂未开放]</button>
								<input type="submit" class="btn btn-success mybtncss"
									data-dismiss="modal" value="我知道了" id="close_btn">
								<!-- </form> -->
							</div>

						</form>
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
	</div>
	<!-- /模态框 -->
	<!-- Your Page Content Here -->

	<!-- |----------------------------------------------------------------------------------↑------------------------------ -->









	<!--|----------------------------------------------------------------------------------------------------------  -->

	<!-- |----------------------------------------------------------------------------------↑------------------------------ -->
	<!-- /.content -->
	</div>
	<!-- /.content-wrapper -->
	<medicinems:basePage_Down></medicinems:basePage_Down>

	<script src="<%=request.getContextPath()%>/js/add_saleRecord.js"></script>

</body>

</html>
