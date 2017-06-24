<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/img/common/logo.png" type="image/x-icon">
    <title>药品信息管理--药品信息更新|仁爱药品管理系统</title>
    <!-- 获取并控制屏幕信息(响应式) -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- CSS框架 Boostrap 3 -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/framework/AdminLTE/bootstrap/css/bootstrap.min.css">
    <!-- Font  -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/framework/AdminLTE/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/framework/AdminLTE/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/framework/AdminLTE/dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. We have chosen the skin-blue for this starter
        page. However, you can choose any other skin. Make sure you
        apply the skin class to the body tag so the changes take effect.
  -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/framework/AdminLTE/css/skin-green.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/framework/AdminLTE/dist/css/skins/skin-blue.min.css">
  <style type="text/css">
      .treeview-menu>li>a{
        text-indent: 2em;
      }
  </style>
</head>

<body class="hold-transition skin-green sidebar-mini">
    <div class="wrapper" id="mybtn1">
        <!-- Main Header -->
        <header class="main-header">
            <!-- Logo -->
            <a href="#" class="logo">
                <!-- mini logo for sidebar mini 50x50 pixels -->
                <span class="logo-mini"><b>仁爱</b></span>
                <!-- logo for regular state and mobile devices -->
                <span class="logo-lg"><b><div
                            style="background: url('<%=request.getContextPath()%>/img/common/logo.png') 50% 50%;"></div>仁爱药品管理系统</b></span>
            </a>
            <!-- Header Navbar -->
            <nav class="navbar navbar-static-top" role="navigation">
                <!-- Sidebar toggle button-->
                <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button"> <span class="sr-only">切换导航栏</span>
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
                        <img src="<%=request.getContextPath()%>/img/user/staff002.jpg" class="img-circle" alt="User Image">
                    </div>
                    <div class="pull-left info">
                        <p>
                            ${sessionScope.staff.userType==2?"营业员":""} ${sessionScope.staff.userType==1?"管理员":""} ${sessionScope.staff.userType==4?"采购员":""} ${sessionScope.staff.userType==3?"保管员":""} :${sessionScope.staff.realName}
                        </p>
                        <!-- Status -->
                        <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
                    </div>
                </div>
                <!-- |--------搜索框----------|search form (Optional) -->
                <form action="<%=request.getContextPath()%>/MedicineMS/medicine/MStorage/search_MSaleStorage.jsp" method="get" class="sidebar-form">
                    <div class="input-group">
                        <input type="text" name="q" class="form-control" placeholder="药品库存查询..."> <span class="input-group-btn">
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
                    <li class="treeview active">
                        <a href="javascript:void(0)"> <i class="fa fa-link"></i>
                            <span>药品管理</span> <span class="pull-right-container"> <i
                                class="fa fa-angle-left pull-right"></i>
                        </span>
                        </a>
                        <ul class="treeview-menu">
                            <li><a href="<%=request.getContextPath()%>/MedicineMS/medicine/MInfo/GSP/search_GSP.jsp">&nbsp;GSP&nbsp;查询</a></li>
                            <li><a href="<%=request.getContextPath()%>/MedicineMS/medicine/MInfo/Info/search_medicineInfo.jsp">药品查询</a></li>
                            <li><a href="<%=request.getContextPath()%>/MedicineMS/medicine/MInfo/Info/update_medicineInfo.jsp">药品更新</a></li>
                           <li><a href="<%=request.getContextPath()%>/MedicineMS/medicine/MStorage/search/search_MSaleStorage.jsp">库存查询</a></li>
                        </ul>
                    </li>
                    <li class="treeview active">
                        <a href="#"> <i class="fa fa-link"></i> <span>销售管理</span> <span class="pull-right-container"> <i
                                class="fa fa-angle-left pull-right"></i>
                        </span>
                        </a>
                        <ul class="treeview-menu">
                            <li><a href="<%=request.getContextPath()%>/MedicineMS/sell/MSaleRecord/add/add_MSaleRecord.jsp">销售记录创建</a></li>
                            <li><a href="<%=request.getContextPath()%>/search_MedicineSaleRecordAction">销售记录查询</a></li>
                            <li><a href="<%=request.getContextPath()%>/MedicineMS/sell/MSaleRecord/update/update_MsaleRecord.jsp">销售记录更新</a> </li>
                            <!-- <li>
              <a href="#">出库管理</a>
            </li> -->
                        </ul>
                    </li>
                    <li class="treeview active">
                        <a href="#"> <i class="fa fa-link"></i>
                            <span>采购管理</span> <span class="pull-right-container"> <i
                                class="fa fa-angle-left pull-right"></i>
                        </span>
                        </a>
                        <ul class="treeview-menu">
                            <li><a href="<%=request.getContextPath()%>/MedicineMS/medicine/MPurchase/plan/purchaseAdmin.jsp">药品采购计划管理</a></li>
                            <li><a href="<%=request.getContextPath()%>/MedicineMS/medicine/MPurchase/do/doAdmin.jsp">药品采购信息管理</a></li>
                        </ul>
                    </li>
                    <li class="treeview active">
                        <a href="#"> <i class="fa fa-link"></i>
                            <span>药品出入库管理【暂不开放】</span> <span class="pull-right-container">
                                <i class="fa fa-angle-left pull-right"></i>
                        </span>
                        </a>
                        <ul class="treeview-menu">
                            <li><a href="<%=request.getContextPath()%>/MedicineMS/medicine/MStorage/admin/in_MStorage.jsp">入库管理</a></li>
                            <li><a href="<%=request.getContextPath()%>/MedicineMS/medicine/MStorage/admin/out_MStorage.jsp">出库管理</a></li>
                        </ul>
                    </li>
                    <li class="treeview active">
                        <a href="#"> <i class="fa fa-link"></i>
                            <span>财务管理</span> <span class="pull-right-container"> <i
                                class="fa fa-angle-left pull-right"></i>
                        </span>
                        </a>
                        <ul class="treeview-menu">
                            <li><a href="<%=request.getContextPath()%>/MedicineMS/sell/MSaleReport/day/index_day.jsp">&nbsp;&nbsp;日结报表管理</a></li>
                            <li><a href="<%=request.getContextPath()%>/MedicineMS/sell/MSaleReport/time/index_time.jsp">时/度报表管理</a></li>
                        </ul>
                    </li>
                    <li class="treeview active">
                        <a href="#"> <i class="fa fa-link"></i>
                            <span>用户管理</span> <span class="pull-right-container"> <i
                                class="fa fa-angle-left pull-right"></i>
                        </span>
                        </a>
                        <ul class="treeview-menu">
                            <li><a href="<%=request.getContextPath()%>/MedicineMS/user/staff/index_STAFadmin.jsp">员工管理</a></li>
                            <li><a href="<%=request.getContextPath()%>/MedicineMS/user/customer/index_CUSTadmin.jsp">顾客管理</a></li>
                        </ul>
                    </li>
                    <li class="treeview active">
                        <a href="#"> <i class="fa fa-link"></i>
                            <span>个人中心</span> <span class="pull-right-container"> <i
                                class="fa fa-angle-left pull-right"></i>
                        </span>
                        </a>
                        <ul class="treeview-menu">
                            <li><a href="<%=request.getContextPath()%>/MedicineMS/user/staff/view/personMain.jsp">个人主页</a></li>
                            <li><a href="<%=request.getContextPath()%>/MedicineMS/user/staff/update/update_staff.jsp">修改信息</a></li>
                            <li><a href="<%=request.getContextPath()%>">切换账号</a></li>
                        </ul>
                    </li>
                    <li class="treeview active">
                        <a href="#"> <i class="fa fa-link"></i>
                            <span>系统设置</span> <span class="pull-right-container"> <i
                                class="fa fa-angle-left pull-right"></i>
                        </span>
                        </a>
                        <ul class="treeview-menu">
                            <li><a href="<%=request.getContextPath()%>/MedicineMS/SYS/view/systemInfo.html">系统信息</a></li>
                            <li><a href="<%=request.getContextPath()%>/MedicineMS/SYS/view/aboutUs.html">关于我们</a></li>
                        </ul>
                    </li>
                </ul>
                <!-- /.sidebar-menu -->
            </section>
            <!-- /.sidebar -->
        </aside>
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
					药品信息管理--药品信息更新|仁爱药品管理系统
                            <!--|----------------------------------------------------------------------------------------------------------  -->
iframe
                    <!-- |----------------------------------------------------------------------------------↑------------------------------ -->
                    <!-- /.content -->
                </div>
                <!-- /.content-wrapper -->
                <!-- Main Footer -->
                <footer class="main-footer ">
                    <!-- To the right -->
                    <div class="pull-right hidden-xs ">为您提供最好的服务.</div>
                    <!-- Default to the left -->
                    <strong>&copy;2017---2017 <a href="# ">微力互动实验</a>.
        </strong> 版权所有</footer>
                    <!-- Control Sidebar -->
                    <aside class="control-sidebar control-sidebar-dark ">
                        <!-- Create the tabs -->
                        <ul class="nav nav-tabs nav-justified control-sidebar-tabs ">
                            <li class="active "><a href="#control-sidebar-home-tab " data-toggle="tab "><i class="fa fa-home "></i></a></li>
                            <li><a href="#control-sidebar-settings-tab " data-toggle="tab "><i
                        class="fa fa-gears "></i></a></li>
                        </ul>
                        <!-- Tab panes -->
                        <div class="tab-content ">
                            <!-- Home tab content -->
                            <div class="tab-pane active " id="control-sidebar-home-tab ">
                                <h3 class="control-sidebar-heading ">Recent Activity</h3>
                                <ul class="control-sidebar-menu ">
                                    <li>
                                        <a href="javascript:; "> <i class="menu-icon fa fa-birthday-cake bg-red "></i>
                                            <div class="menu-info ">
                                                <h4 class="control-sidebar-subheading ">Langdon's Birthday</h4>
                                                <p>Will be 23 on April 24th</p>
                                            </div>
                                        </a>
                                    </li>
                                </ul>
                                <!-- /.control-sidebar-menu -->
                                <h3 class="control-sidebar-heading ">Tasks Progress</h3>
                                <ul class="control-sidebar-menu ">
                                    <li>
                                        <a href="javascript:; ">
                                            <h4 class="control-sidebar-subheading ">
                                    Custom Template Design <span class="pull-right-container ">
                                        <span class="label label-danger pull-right ">70%</span>
                                    </span>
                                </h4>
                                            <div class="progress progress-xxs ">
                                                <div class="progress-bar progress-bar-danger " style="width: 70% "></div>
                                            </div>
                                        </a>
                                    </li>
                                </ul>
                                <!-- /.control-sidebar-menu -->
                            </div>
                            <!-- /.tab-pane -->
                            <!-- Stats tab content -->
                            <div class="tab-pane " id="control-sidebar-stats-tab ">Stats Tab Content
                            </div>
                            <!-- /.tab-pane -->
                            <!-- Settings tab content -->
                            <div class="tab-pane " id="control-sidebar-settings-tab ">
                                <form method="post ">
                                    <h3 class="control-sidebar-heading ">General Settings</h3>
                                    <div class="form-group ">
                                        <label class="control-sidebar-subheading "> Report panel usage
                                            <input type="checkbox " class="pull-right " checked>
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
                    <div class="control-sidebar-bg "></div>
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
                    <script src="<%=request.getContextPath()%>/framework/AdminLTE/plugins/jQuery/jquery-2.2.3.min.js "></script>
                    <!-- jQuery -->
                    <!-- <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js "></script>
         -->
                    <!-- <script type="text/javascript " src=" "></script> -->
                    <!-- Bootstrap 3.3.6 -->
                    <script src="<%=request.getContextPath()%>/framework/AdminLTE/bootstrap/js/bootstrap.min.js "></script>
                    <!-- AdminLTE App -->
                    <script src="<%=request.getContextPath()%>/framework/AdminLTE/dist/js/app.min.js "></script>
                    <!-- Optionally, you can add Slimscroll and FastClick plugins.
     Both of these plugins are recommended to enhance the
     user experience. Slimscroll is required when using the
     fixed layout. -->
            </body>

            </html>