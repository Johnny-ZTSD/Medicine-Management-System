<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.lang.*"%>
<%@ taglib prefix="medicinems" tagdir="/WEB-INF/tags"%>
<!-- /*
	药品销售记录查询----作为响应页
*/   -->
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>药品销售记录查询|仁爱药品管理系统</title>
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
		<!-- |----------------------------------------------------------------------------------------------------| -->
		<div
			style="display: flex; justify-content: row; align-items: center; padding: 5px; background: white">
			<div class="btn-app" style="margin-bottom: 0"
				title="Create A Medicine's Sale Of Record">
				<span class="fa fa-edit active"></span>创建单条销售记录
			</div>
			<!--  #00a65a -->
			<div class="btn-app"
				style="margin-bottom: 0; background-color: rgba(0, 166, 90, .8); color: white""=" ">
				<span class="fa fa-search "></span>查询销售记录
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
		<!-- |----------------------------------------------------------------------------------------------------| -->
		<!-- Main content -->
		<section class="content ">
			<div class="row ">
				<div class="col-xs-12 ">


					<div class="box">
						<div class="box-header">
							<h3 class="box-title">所有药品销售记录</h3>
						</div>
						<!-- /.box-header -->
						<div class="box-body table-responsive">
							<!-- 响应式[数据显示不够时，可以自动出现水平滚动栏] -->
							<table id="example1" class="table table-bordered table-striped">
								<thead>
									<tr>
										<th style="padding-right: 30px;">序号</th>
										<th>药品销售记录编号</th>
										<th>国药准字号</th>
										<th>生产批次号</th>
										<th>销售时间</th>
										<th>药品品名</th>
										<th>销售数目</th>
										<th>销售单价</th>
										<th>顾客账号</th>
										<th>销售员账号</th>
									</tr>
								</thead>
								<tbody>
									<!--                 <tr>
                  <td>Trident</td>
                  <td>Internet  Explorer 4.0</td>
                  <td>Win 95+</td>
                  <td> 4</td>
                  <td>X</td>
                  <td>X</td>
                  <td>X</td>
                  <td>X</td>
                  <td>X</td>
                  <td>X</td>
                </tr> -->
									<c:if test="${MedicineSaleRecord_List != null}">
										<c:forEach items="${MedicineSaleRecord_List }" var="item"
											varStatus="s">
											<!-- items:指定数据源[迭代的对象] or 设置begin和end值 -->
											<tr>
												<td>${s.index}</td>
												<td>${item.id}</td>
												<td>${item.cmpn}</td>
												<td>${item.batchNum}</td>
												<td>${item.saleDate}</td>
												<td>${item.name}</td>
												<td>${item.saleNum}</td>
												<td>${item.salePrice}</td>
												<td>${item.customerId}</td>
												<td>${item.salerId}</td>
											</tr>
										</c:forEach>
									</c:if>
								</tbody>
								<tfoot>
									<tr>
										<th style="padding-right: 30px;">序号</th>
										<th>药品销售记录编号</th>
										<th>国药准字号</th>
										<th>生产批次号</th>
										<th>销售时间</th>
										<th>药品品名</th>
										<th>销售数目</th>
										<th>销售单价</th>
										<th>顾客账号</th>
										<th>销售员账号</th>
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
<script type="text/javascript">
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
	 *        "data": [
	 *          ['Trident', 'Internet Explorer 4.0', 'Win 95+', 4, 'X'],
	 *          ['Trident', 'Internet Explorer 5.0', 'Win 95+', 5, 'C'],
	 *        ],
	 *        "columns": [
	 *          { "title": "Engine" },
	 *          { "title": "Browser" },
	 *          { "title": "Platform" },
	 *          { "title": "Version" },
	 *          { "title": "Grade" }
	 *        ]
	 *      } );
	 *    } );
	 *
	 *  @example
	 *    // Using an array of objects as a data source (`data`)
	 *    $(document).ready( function () {
	 *      $('#example').dataTable( {
	 *        "data": [
	 *          {
	 *            "engine":   "Trident",
	 *            "browser":  "Internet Explorer 4.0",
	 *            "platform": "Win 95+",
	 *            "version":  4,
	 *            "grade":    "X"
	 *          },
	 *          {
	 *            "engine":   "Trident",
	 *            "browser":  "Internet Explorer 5.0",
	 *            "platform": "Win 95+",
	 *            "version":  5,
	 *            "grade":    "C"
	 *          }
	 *        ],
	 *        "columns": [
	 *          { "title": "Engine",   "data": "engine" },
	 *          { "title": "Browser",  "data": "browser" },
	 *          { "title": "Platform", "data": "platform" },
	 *          { "title": "Version",  "data": "version" },
	 *          { "title": "Grade",    "data": "grade" }
	 *        ]
	 *      } );
	 *    } );
	 */
</script>
