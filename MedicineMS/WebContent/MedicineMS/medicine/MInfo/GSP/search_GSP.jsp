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

<title>GSP查询|仁爱药品管理系统</title>
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
			<div
				style="display: flex; justify-content: row; align-items: center; padding: 5px; background: white">
				<!--  #00a65a -->
				<div class="btn-app"
					style="margin-bottom: 0; background-color: rgba(0, 166, 90, .8); color: white">
					<span class="fa fa-search "></span>GSP查询
				</div>
			</div>
			<!-- |----------------------------------------------------------------------------------------------------| -->
			<!-- Main content -->
			<section class="content ">
				<div class="row ">
					<div class="col-xs-12 ">


						<div class="box">
							<div class="box-header">
								<h3 class="box-title">药品库存状态</h3>
							</div>
							<!-- /.box-header -->
							<div class="box-body table-responsive">
								<!-- 响应式[数据显示不够时，可以自动出现水平滚动栏] -->
								<table id="example1" class="table table-bordered table-striped">
									<thead>
										<tr>
											<th>药品库存编号</th>
											<th>国药准字号</th>
											<th>药品品名</th>
											<th>生产批次号</th>
											<th>生产企业</th>
											<th>库存数目</th>
											<th>推荐单价</th>
											<th>联系电话</th>
											<th>传真号码</th>
											<th>生产地址</th>
											<th>电子监管码</th>
											<th>生产日期</th>
											<th>有效日期</th>
										</tr>
									</thead>
									<tbody>
										
										<c:if test="${MedicineStorage_List != null}">
											<c:forEach items="${MedicineStorage_List }" var="item"
												varStatus="s">
												<!-- items:指定数据源[迭代的对象] or 设置begin和end值 -->
												<tr>
													<td>${item.id}</td>
													<td>${item.cmpn}</td>
													<td>${item.name}</td>
													<td>${item.batchNum}</td>
													<td>${item.manufcName}</td>
													<td>${item.sotorageNum}</td>
													<td>${item.recomdPrice}</td>
													<td>${item.productTele}</td>
													<td>${item.productFax}</td>
													<td>${item.productAddr}</td>
													<td>${item.elecMonitCode}</td>
													<td>${item.productDate}</td>
													<td>${item.expireDate}</td>
												</tr>
											</c:forEach>
										</c:if>
									</tbody>
									<tfoot>
										<tr>
											<th>药品库存编号</th>
											<th>国药准字号</th>
											<th>药品品名</th>
											<th>生产批次号</th>
											<th>生产企业</th>
											<th>库存数目</th>
											<th>推荐单价</th>
											<th>联系电话</th>
											<th>传真号码</th>
											<th>生产地址</th>
											<th>电子监管码</th>
											<th>生产日期</th>
											<th>有效日期</th>
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
			<!-- /.content -->
			<!-- |----------------------------------------------------------------------------------------------------| -->
		</div>
		<!-- /.content-wrapper -->
	<medicinems:basePage_Down></medicinems:basePage_Down>	
	<script>
		$(function() {
			$("#example1 ").DataTable({
				"paging " : true,
				"lengthChange " : false,
				"searching " : false,
				"ordering " : true,
				"info " : true,
				"autoWidth " : false
			});
			// $("#example1 ").DataTable();
		});
		window.onload = function() {
			reloadTable();
		}
		//重新加载table[使布局美观]
		function reloadTable() {
			$("table.dataTable th").css("white-space", "nowrap");
			$("table.dataTable td").css("white-space", "nowrap");
		}
	</script>
</body>

</html>

