<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--  页面基本组件标签 上部分-->
<!--  除了content-wrap部分 -->
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
			<form action="<%=request.getContextPath()%>/search_MStorageAction"
				method="get" class="sidebar-form" accept="UTF-8"
				onsubmit="javascript:document.charset='utf-8'">
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
				<li class="treeview"><a href="javascript:void(0)"> <i
						class="fa fa-link"></i> <span>药品管理</span> <span
						class="pull-right-container"> <i
							class="fa fa-angle-left pull-right"></i>
					</span>
				</a>
					<ul class="treeview-menu">
						<li><a
							href="<%=request.getContextPath()%>/MedicineMS/medicine/MInfo/GSP/search_GSP.jsp">&nbsp;GSP&nbsp;查询</a></li>
						<li><a
							href="<%=request.getContextPath()%>/MedicineMS/medicine/MInfo/Info/searchIndex_medicineInfo.jsp">药品管理</a></li>
						<%-- <li><a
								href="<%=request.getContextPath()%>/MedicineMS/medicine/MInfo/Info/update_medicineInfo.jsp">药品更新</a></li> --%>
						<li><a
							href="<%=request.getContextPath()%>/search_MStorageAction">库存查询</a></li>
						<!-- <%=request.getContextPath()%>/MedicineMS/medicine/MStorage/search/search_MSaleStorage.jsp -->
					</ul></li>
				<li class="treeview"><a href="#"> <i class="fa fa-link"></i>
						<span>销售管理</span> <span class="pull-right-container"> <i
							class="fa fa-angle-left pull-right"></i>
					</span>
				</a>
					<ul class="treeview-menu">
						<li><a
							href="<%=request.getContextPath()%>/MedicineMS/sell/MSaleRecord/add/add_MSaleRecord.jsp">销售记录创建</a></li>
						<li><a
							href="<%=request.getContextPath()%>/search_MedicineSaleRecordAction">销售记录查询</a></li>
						<%-- <li><a
								href="<%=request.getContextPath()%>/MedicineMS/sell/MSaleRecord/update/update_MsaleRecord.jsp">销售记录更新</a>
							</li> --%>
						<!-- <li>
              <a href="#">出库管理</a>
            </li> -->
					</ul></li>
				<c:if test="${staff.userType==1||staff.userType==4}">
					<li class="treeview"><a href="#"> <i class="fa fa-link"></i>
							<span>采购管理</span> <span class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span>
					</a>
						<ul class="treeview-menu">
							<c:if test="${staff.userType==1}">
								<li><a
									href="<%=request.getContextPath()%>/MedicineMS/medicine/MPurchase/plan/purchaseAdmin.jsp">药品采购计划管理</a></li>
							</c:if>
							<li><a
								href="<%=request.getContextPath()%>/MedicineMS/medicine/MPurchase/do/doAdmin.jsp">药品采购信息管理</a></li>
						</ul></li>
				</c:if>
				<c:if test="${staff.userType==1||staff.userType==2}">
					<li class="treeview"><a href="#"> <i class="fa fa-link"></i>
							<span>药品出入库管理【暂不开放】</span> <span class="pull-right-container">
								<i class="fa fa-angle-left pull-right"></i>
						</span>
					</a>
						<ul class="treeview-menu">
							<li><a
								href="<%=request.getContextPath()%>/MedicineMS/medicine/MStorage/admin/in_MStorage.jsp">入库管理</a></li>
							<li><a
								href="<%=request.getContextPath()%>/MedicineMS/medicine/MStorage/admin/out_MStorage.jsp">出库管理</a></li>
						</ul></li>
				</c:if>
				<c:if test="${staff.userType==1||staff.userType==2}">
					<li class="treeview"><a href="#"> <i class="fa fa-link"></i>
							<span>财务管理</span> <span class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span>
					</a>
						<ul class="treeview-menu">
							<li><a
								href="<%=request.getContextPath()%>/MedicineMS/sell/MSaleReport/day/index_day.jsp">&nbsp;&nbsp;日结报表管理</a></li>
							<li><a
								href="<%=request.getContextPath()%>/MedicineMS/sell/MSaleReport/time/index_time.jsp">时/度报表管理</a></li>
						</ul></li>
				</c:if>
				<li class="treeview active"><a href="#"> <i
						class="fa fa-link"></i> <span>用户管理</span> <span
						class="pull-right-container"> <i
							class="fa fa-angle-left pull-right"></i>
					</span>
				</a>
					<ul class="treeview-menu">
						<c:if test="${staff.userType==1}">
							<li><a
								href="<%=request.getContextPath()%>/search_staffsAction">员工管理</a></li>
						</c:if>
						<!-- /MedicineMS/user/staff/index_STAFadmin.jsp -->
						<li><a
							href="<%=request.getContextPath()%>/MedicineMS/user/customer/index_CUSTadmin.jsp">顾客管理</a></li>
						<!-- /MedicineMS/user/customer/index_CUSTadmin.jsp -->
						<!-- /search_customersAction -->
					</ul></li>
				<li class="treeview"><a href="#"> <i class="fa fa-link"></i>
						<span>个人中心</span> <span class="pull-right-container"> <i
							class="fa fa-angle-left pull-right"></i>
					</span>
				</a>
					<ul class="treeview-menu">
						<li><a
							href="<%=request.getContextPath()%>/MedicineMS/user/staff/view/personMain.jsp">个人主页</a></li>
						<%-- <li><a
								href="<%=request.getContextPath()%>/MedicineMS/user/staff/update/update_staff.jsp">修改信息</a></li> --%>
						<li><a href="<%=request.getContextPath()%>">切换账号</a></li>
					</ul></li>
				<li class="treeview"><a href="#"> <i class="fa fa-link"></i>
						<span>系统设置</span> <span class="pull-right-container"> <i
							class="fa fa-angle-left pull-right"></i>
					</span>
				</a>
					<ul class="treeview-menu">
						<li><a
							href="<%=request.getContextPath()%>/MedicineMS/SYS/view/systemInfo.jsp">系统信息</a></li>
						<li><a
							href="<%=request.getContextPath()%>/MedicineMS/SYS/view/aboutUs.html">关于我们</a></li>
						<c:if test="${staff.userType==1}">
							<li><a
								href="<%=request.getContextPath()%>/FeedBack_ApplyAccountAction">反馈|开户</a></li>
							<!-- MedicineMS/SYS/admin/FB_AT.jsp -->
						</c:if>
					</ul></li>
			</ul>
			<!-- /.sidebar-menu -->
		</section>
		<!-- /.sidebar -->
	</aside>