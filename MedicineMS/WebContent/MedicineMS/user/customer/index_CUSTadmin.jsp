<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.lang.*"%>
<%@ taglib prefix="medicinems" tagdir="/WEB-INF/tags"%>
<!-- /*
	顾客管理----作为响应页
*/   -->
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>顾客管理|仁爱药品管理系统</title>
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
		<section class="content ">
			<div class="row ">
				<div class="col-xs-12 ">


					<div class="box">
						<medicinems:customerAdminFunction></medicinems:customerAdminFunction>
						<!-- /.box-header -->
						<div class="box-body table-responsive">
							<!-- 响应式[数据显示不够时，可以自动出现水平滚动栏] -->
							<table id="example1" class="table table-bordered table-striped">
								<thead>
									<tr>
										<th style="padding-right: 30px">序号</th>
										<th>账号名</th>
										<th>真实姓名</th>
										<th>用户类型</th>
										<th>当前密码</th>
										<th>职工性别</th>
										<th>账号状态</th>
										<th>职工电话</th>
										<th>年龄</th>
										<th>消费金额</th>
									</tr>
								</thead>
								<tbody>

									<c:if test="${Customer_List != null}">
										<c:forEach items="${Customer_List }" var="item" varStatus="s">
											<!-- items:指定数据源[迭代的对象] or 设置begin和end值 -->
											<tr>
												<td>${s.index+1}</td>
												<td>${item.accountNo}</td>
												<td>${item.realName}</td>
												<td>
													${item.userType==0?"普通顾客":"会员顾客"}
												</td>
												<td>${item.password}</td>
												<td>${item.sex=='M'?"男":"女"}</td>
												<td>${item.accountState==1?"已激活":"已锁定"}</td>
												<td>${item.telephone}</td>
												<td>${item.age}</td>
												<td>${item.consumpTotal}</td>
											</tr>
										</c:forEach>
									</c:if>
								</tbody>
								<tfoot>
									<tr>
										<th style="padding-right: 30px">序号</th>
										<th>账号名</th>
										<th>真实姓名</th>
										<th>用户类型</th>
										<th>当前密码</th>
										<th>职工性别</th>
										<th>账号状态</th>
										<th>职工电话</th>
										<th>年龄</th>
										<th>消费金额</th>
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

