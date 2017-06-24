<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.lang.*"%>
<!-- /*
	药品库存查询----作为响应页
*/   -->
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>药品信息查询----结果|仁爱药品管理系统</title>
<link rel="shortcut icon" href="img/common/logo.png" type="image/x-icon">
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.6 -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/framework/AdminLTE/bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/framework/AdminLTE/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/framework/AdminLTE/css/ionicons.min.css">
<!-- DataTables -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/framework/AdminLTE/plugins/datatables/dataTables.bootstrap.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/framework/AdminLTE/dist/css/AdminLTE.min.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/framework/AdminLTE/css/skin-green.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/framework/AdminLTE/dist/css/skins/_all-skins.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/common/table.css">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>

<body class="hold-transition skin-green sidebar-mini">
	<div class="wrapper" id="mybtn1">
		<!-- Main Header -->
		<header class="main-header">
			<!-- Logo -->
			<a href="#" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
				<span class="logo-mini"><b>仁爱</b></span> <!-- logo for regular state and mobile devices -->
				<span class="logo-lg"><b><div
							style="background: url('<%=request.getContextPath()%>/img/common/logo.png') 50% 50%;"></div>仁爱药品管理系统</b></span>
			</a>
			<!-- Header Navbar -->
			<nav class="navbar navbar-static-top" role="navigation">
				<!-- Sidebar toggle button-->
				<a href="#" class="sidebar-toggle" data-toggle="offcanvas"
					role="button"> <span class="sr-only">切换导航栏</span>
				</a>
				<!-- Navbar Right Menu -->
			</nav>
		</header>
		<!-- Left side column. contains the logo and sidebar -->
		<aside class="main-sidebar">
			<!-- sidebar: style can be found in sidebar.less -->
			<section class="sidebar">
				<!-- Sidebar user panel (optional) -->
				<div class="user-panel">
					<div class="pull-left image">
						<img src="<%=request.getContextPath()%>/img/user/staff002.jpg"
							class="img-circle" alt="User Image">
					</div>
					<div class="pull-left info">
						<p>${sessionScope.staff.userType==2?"营业员":""}
							${sessionScope.staff.userType==1?"管理员":""}
							${sessionScope.staff.userType==4?"采购员":""}
							${sessionScope.staff.userType==3?"保管员":""}
							:${sessionScope.staff.realName}</p>
						<!-- Status -->
						<a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
					</div>
				</div>
				<!-- |--------搜索框----------|search form (Optional) -->
				<form
					action="<%=request.getContextPath()%>/MedicineMS/medicine/MStorage/search_MSaleStorage.jsp"
					method="get" class="sidebar-form">
					<div class="input-group">
						<input type="text" name="q" class="form-control"
							placeholder="药品库存查询..."> <span class="input-group-btn">
							<button type="submit" name="search" id="search-btn"
								class="btn btn-flat">
								<i class="fa fa-search"></i>
							</button>
						</span>
					</div>
				</form>
				<!-- /.search form -->
				<!--|--------侧栏菜单----------| Sidebar Menu -->
				<ul class="sidebar-menu">
					<li class="header">主菜单</li>
					<!-- Optionally, you can add icons to the links -->
					<li class="treeview active"><a href="javascript:void(0)">
							<i class="fa fa-link"></i> <span>药品管理</span> <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span>
					</a>
						<ul class="treeview-menu">
							<li><a
								href="<%=request.getContextPath()%>/MedicineMS/medicine/MInfo/GSP/search_GSP.jsp">&nbsp;GSP&nbsp;查询</a></li>
							<li><a
								href="<%=request.getContextPath()%>/MedicineMS/medicine/MInfo/Info/search_medicineInfo.jsp">药品查询</a></li>
							<li><a
								href="<%=request.getContextPath()%>/MedicineMS/medicine/MInfo/Info/update_medicineInfo.jsp">药品更新</a></li>
							<li><a
								href="<%=request.getContextPath()%>/MedicineMS/medicine/MStorage/search/search_MSaleStorage.jsp">库存查询</a></li>
						</ul>
						</li>
					<li class="treeview active"><a href="#"> <i
							class="fa fa-link"></i> <span>销售管理</span> <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span>
					</a>
						<ul class="treeview-menu">
							<li><a
								href="<%=request.getContextPath()%>/MedicineMS/sell/MSaleRecord/add/add_MSaleRecord.jsp">销售记录创建</a></li>
							<li><a
								href="<%=request.getContextPath()%>/search_MedicineSaleRecordAction">销售记录查询</a></li>
							<li><a
								href="<%=request.getContextPath()%>/MedicineMS/sell/MSaleRecord/update/update_MsaleRecord.jsp">销售记录更新</a>
							</li>
							<!-- <li>
              <a href="#">出库管理</a>
            </li> -->
						</ul></li>
					<li class="treeview active"><a href="#"> <i
							class="fa fa-link"></i> <span>采购管理</span> <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span>
					</a>
						<ul class="treeview-menu">
							<li><a
								href="<%=request.getContextPath()%>/MedicineMS/medicine/MPurchase/plan/purchaseAdmin.jsp">药品采购计划管理</a></li>
							<li><a
								href="<%=request.getContextPath()%>/MedicineMS/medicine/MPurchase/do/doAdmin.jsp">药品采购信息管理</a></li>
						</ul></li>
					<li class="treeview active"><a href="#"> <i
							class="fa fa-link"></i> <span>药品出入库管理【暂不开放】</span> <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span>
					</a>
						<ul class="treeview-menu">
							<li><a
								href="<%=request.getContextPath()%>/MedicineMS/medicine/MStorage/admin/in_MStorage.jsp">入库管理</a></li>
							<li><a
								href="<%=request.getContextPath()%>/MedicineMS/medicine/MStorage/admin/out_MStorage.jsp">出库管理</a></li>
						</ul></li>
					<li class="treeview active"><a href="#"> <i
							class="fa fa-link"></i> <span>财务管理</span> <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span>
					</a>
						<ul class="treeview-menu">
							<li><a
								href="<%=request.getContextPath()%>/MedicineMS/sell/MSaleReport/day/index_day.jsp">&nbsp;&nbsp;日结报表管理</a></li>
							<li><a
								href="<%=request.getContextPath()%>/MedicineMS/sell/MSaleReport/time/index_time.jsp">时/度报表管理</a></li>
						</ul></li>
					<li class="treeview active"><a href="#"> <i
							class="fa fa-link"></i> <span>用户管理</span> <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span>
					</a>
						<ul class="treeview-menu">
							<li><a
								href="<%=request.getContextPath()%>/MedicineMS/user/staff/index_STAFadmin.jsp">员工管理</a></li>
							<li><a
								href="<%=request.getContextPath()%>/MedicineMS/user/customer/index_CUSTadmin.jsp">顾客管理</a></li>
						</ul></li>
					<li class="treeview active"><a href="#"> <i
							class="fa fa-link"></i> <span>个人中心</span> <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span>
					</a>
						<ul class="treeview-menu">
							<li><a
								href="<%=request.getContextPath()%>/MedicineMS/user/staff/view/personMain.jsp">个人主页</a></li>
							<li><a
								href="<%=request.getContextPath()%>/MedicineMS/user/staff/update/update_staff.jsp">修改信息</a></li>
							<li><a href="<%=request.getContextPath()%>">切换账号</a></li>
						</ul></li>
					<li class="treeview active"><a href="#"> <i
							class="fa fa-link"></i> <span>系统设置</span> <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span>
					</a>
						<ul class="treeview-menu">
							<li><a
								href="<%=request.getContextPath()%>/MedicineMS/SYS/view/systemInfo.html">系统信息</a></li>
							<li><a
								href="<%=request.getContextPath()%>/MedicineMS/SYS/view/aboutUs.html">关于我们</a></li>
						</ul></li>
				</ul>
				<!-- /.sidebar-menu -->
			</section>
			<!-- /.sidebar -->
		</aside>
		<!-- Content Wrapper. Contains page content -->
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
				<div class="btn-app " style="margin-bottom: 0">
					<span class="fa fa-user "></span>[查询用户]
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
											<td style="padding-right: 30px;">序号</td>
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
													<td>${s.index+1}</td>
													<td>${item.id}</td>
													<td>${item.cmpn}</td>
													<td>${item.batchNum}</td>
													<td>${item.manufcName}</td>
													<td>${item.recomdPrice}</td>
													<td>${item.sotorageNum}</td>
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
											<th style="padding-right: 30px;">序号</th>
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
		<footer class="main-footer ">
			<div class="pull-right hidden-xs ">为您提供最好的服务.</div>
			<strong>©2017---2017 <a href="# ">微力互动实验</a>.
			</strong>
		</footer>
		<!-- Control Sidebar -->
		<aside class="control-sidebar control-sidebar-dark ">
			<!-- Create the tabs -->
			<ul class="nav nav-tabs nav-justified control-sidebar-tabs ">
				<li><a href="#control-sidebar-home-tab " data-toggle="tab "><i
						class="fa fa-home "></i></a></li>
				<li><a href="#control-sidebar-settings-tab " data-toggle="tab "><i
						class="fa fa-gears "></i></a></li>
			</ul>
			<!-- Tab panes -->
			<div class="tab-content ">
				<!-- Home tab content -->
				<div class="tab-pane " id="control-sidebar-home-tab ">
					<h3 class="control-sidebar-heading ">Recent Activity</h3>
					<ul class="control-sidebar-menu ">
						<li><a href="javascript:void(0) "> <i
								class="menu-icon fa fa-birthday-cake bg-red "></i>
								<div class="menu-info ">
									<h4 class="control-sidebar-subheading ">Langdon's Birthday</h4>
									<p>Will be 23 on April 24th</p>
								</div>
						</a></li>
						<li><a href="javascript:void(0) "> <i
								class="menu-icon fa fa-user bg-yellow "></i>
								<div class="menu-info ">
									<h4 class="control-sidebar-subheading ">Frodo Updated His
										Profile</h4>
									<p>New phone +1(800)555-1234</p>
								</div>
						</a></li>
						<li><a href="javascript:void(0) "> <i
								class="menu-icon fa fa-envelope-o bg-light-blue "></i>
								<div class="menu-info ">
									<h4 class="control-sidebar-subheading ">Nora Joined
										Mailing List</h4>
									<p>nora@example.com</p>
								</div>
						</a></li>
						<li><a href="javascript:void(0) "> <i
								class="menu-icon fa fa-file-code-o bg-green "></i>
								<div class="menu-info ">
									<h4 class="control-sidebar-subheading ">Cron Job 254
										Executed</h4>
									<p>Execution time 5 seconds</p>
								</div>
						</a></li>
					</ul>
					<!-- /.control-sidebar-menu -->
					<h3 class="control-sidebar-heading ">Tasks Progress</h3>
					<ul class="control-sidebar-menu ">
						<li><a href="javascript:void(0) ">
								<h4 class="control-sidebar-subheading ">
									Custom Template Design <span
										class="label label-danger pull-right ">70%</span>
								</h4>
								<div class="progress progress-xxs ">
									<div class="progress-bar progress-bar-danger "
										style="width: 70%"></div>
								</div>
						</a></li>
						<li><a href="javascript:void(0) ">
								<h4 class="control-sidebar-subheading ">
									Update Resume <span class="label label-success pull-right ">95%</span>
								</h4>
								<div class="progress progress-xxs ">
									<div class="progress-bar progress-bar-success "
										style="width: 95%"></div>
								</div>
						</a></li>
						<li><a href="javascript:void(0) ">
								<h4 class="control-sidebar-subheading ">
									Laravel Integration <span
										class="label label-warning pull-right ">50%</span>
								</h4>
								<div class="progress progress-xxs ">
									<div class="progress-bar progress-bar-warning "
										style="width: 50%"></div>
								</div>
						</a></li>
						<li><a href="javascript:void(0) ">
								<h4 class="control-sidebar-subheading ">
									Back End Framework <span
										class="label label-primary pull-right ">68%</span>
								</h4>
								<div class="progress progress-xxs ">
									<div class="progress-bar progress-bar-primary "
										style="width: 68%"></div>
								</div>
						</a></li>
					</ul>
					<!-- /.control-sidebar-menu -->
				</div>
				<!-- /.tab-pane -->
				<!-- Stats tab content -->
				<div class="tab-pane " id="control-sidebar-stats-tab ">Stats
					Tab Content</div>
				<!-- /.tab-pane -->
				<!-- Settings tab content -->
				<div class="tab-pane " id="control-sidebar-settings-tab ">
					<form method="post ">
						<h3 class="control-sidebar-heading ">General Settings</h3>
						<div class="form-group ">
							<label class="control-sidebar-subheading "> Report panel
								usage <input type="checkbox " class="pull-right " checked>
							</label>
							<p>Some information about this general settings option</p>
						</div>
						<!-- /.form-group -->
						<div class="form-group ">
							<label class="control-sidebar-subheading "> Allow mail
								redirect <input type="checkbox " class="pull-right " checked>
							</label>
							<p>Other sets of options are available</p>
						</div>
						<!-- /.form-group -->
						<div class="form-group ">
							<label class="control-sidebar-subheading "> Expose author
								name in posts <input type="checkbox " class="pull-right "
								checked>
							</label>
							<p>Allow the user to show his name in blog posts</p>
						</div>
						<!-- /.form-group -->
						<h3 class="control-sidebar-heading ">Chat Settings</h3>
						<div class="form-group ">
							<label class="control-sidebar-subheading "> Show me as
								online <input type="checkbox " class="pull-right " checked>
							</label>
						</div>
						<!-- /.form-group -->
						<div class="form-group ">
							<label class="control-sidebar-subheading "> Turn off
								notifications <input type="checkbox " class="pull-right ">
							</label>
						</div>
						<!-- /.form-group -->
						<div class="form-group ">
							<label class="control-sidebar-subheading "> Delete chat
								history <a href="javascript:void(0) "
								class="text-red pull-right "><i class="fa fa-trash-o "></i></a>
							</label>
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
		<div class="control-sidebar-bg "></div>
	</div>
	<!-- ./wrapper -->
	<!-- jQuery 2.2.3 -->
	<script
		src="<%=request.getContextPath()%>/framework/AdminLTE/plugins/jQuery/jquery-2.2.3.min.js "></script>
	<!-- Bootstrap 3.3.6 -->
	<script
		src="<%=request.getContextPath()%>/framework/AdminLTE/bootstrap/js/bootstrap.min.js "></script>
	<!-- DataTables -->
	<script
		src="<%=request.getContextPath()%>/framework/AdminLTE/plugins/datatables/jquery.dataTables_1.min.js "></script>
	<script
		src="<%=request.getContextPath()%>/framework/AdminLTE/plugins/datatables/dataTables.bootstrap.min.js "></script>
	<!-- SlimScroll -->
	<script
		src="<%=request.getContextPath()%>/framework/AdminLTE/plugins/slimScroll/jquery.slimscroll.min.js "></script>
	<!-- FastClick -->
	<script
		src="<%=request.getContextPath()%>/framework/AdminLTE/plugins/fastclick/fastclick.js "></script>
	<!-- AdminLTE App -->
	<script
		src="<%=request.getContextPath()%>/framework/AdminLTE/dist/js/app.min.js "></script>
	<!-- AdminLTE for demo purposes -->
	<script
		src="<%=request.getContextPath()%>/framework/AdminLTE/dist/js/demo.js "></script>
	<!-- page script -->
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
