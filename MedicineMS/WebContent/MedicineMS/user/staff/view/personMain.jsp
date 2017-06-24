<!-- <%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="medicinems" tagdir="/WEB-INF/tags"%>
<%@ page import="java.lang.*"%> -->
<!-- /*
  药品库存查询----作为响应页
*/   -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>个人主页|仁爱药品管理系统</title>
<medicinems:links></medicinems:links>
      <!-- jQuery 2.2.3 -->
    <script src="<%=request.getContextPath()%>/framework/AdminLTE/plugins/jQuery/jquery-2.2.3.min.js "></script>
    <!-- Bootstrap 3.3.6 -->
    <script src="<%=request.getContextPath()%>/framework/AdminLTE/bootstrap/js/bootstrap.min.js "></script>
    <!-- DataTables -->
        <!-- table.js -->
    <script src="<%=request.getContextPath()%>/js/table.js"></script>
    <style>
    ul.treeview-menu>li>a {
        text-indent: 2em;
    }
    </style>
</head>

<body class="hold-transition skin-green sidebar-mini">
    <medicinems:basePage_Up></medicinems:basePage_Up>
        <!-- Content Wrapper. Contains page content -->
        <div class="content-wrapper" style="padding-top: 15px;">
            <!-- |----------------------------------------------------------------------------------------------------| -->
            <div class="col-lg-12">
                <div class="col-lg-12">
                    <div class="box box-primary">
                        <div class="box-body box-profile">
                            <img class="profile-user-img img-responsive img-circle" src="<%=request.getContextPath() %>/img/common/logo.png" alt="User profile picture">
                            <h3 class="profile-username text-center" id="info_realName">${staff.realName}</h3>
                            <p class="text-muted text-center">
                                ${sessionScope.staff.userType==2?"营业员":""} ${sessionScope.staff.userType==1?"管理员":""} ${sessionScope.staff.userType==4?"采购员":""} ${sessionScope.staff.userType==3?"保管员":""}
                            </p>
                            <ul class="list-group list-group-unbordered">
                                <li class="list-group-item">
                                    <b>账户</b><a class="pull-right" href="#" id="info_accountNo">${staff.accountNo}</a>
                                </li>
                                <li class="list-group-item">
                                    <b>性别</b> <a class="pull-right" id="info_sex" title="${staff.sex}">${staff.sex=='M'?"男":"女"}</a>
                                </li>
                                <li class="list-group-item">
                                    <b>电话</b> <a class="pull-right" id="info_telephone">${staff.telephone}</a>
                                </li>
                                <li class="list-group-item">
                                    <b>账号状态</b> <a class="pull-right" id="info_accountState">${staff.accountState==1?"已激活":"已锁定"}</a>
                                </li>
                                <a href="#ipt_realName" onload="loadStaffInfoToForm()" onclick="$('#update_staffInfo_div').css('display','block');" class="btn btn-primary btn-block">修改信息</a>
                            </ul>
                        </div>
                        <!-- /.box-body -->
                    </div>
                </div>
               
            </div>
            <!-- |----------------------------------------------------------------------------------------------------| -->
             <div class="col-md-12" id="update_staffInfo_div" style="display: none">
                    <div class="nav-tabs-custom">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#settings" data-toggle="tab" aria-expanded="true">Settings</a></li>
                        </ul>
                        <div class="tab-content">
                            

                            <!-- /.tab-pane -->
                            <div class="tab-pane active" id="settings">
                                <form class="form-horizontal" accept-charset="utf-8"  method="post" action="<%=request.getContextPath()%>/updateStaffInfoAction" name="staff_info_form" id="staff_info_form" onsubmit="updateStaffInfo();return false;">
                                    <div class="form-group">
                                        <label for="ipt_realName" class="col-sm-2 control-label">真实姓名</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" id="ipt_realName" name="ipt_realName" placeholder="Real Name">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="ipt_sex" class="col-sm-2 control-label">性别</label>
                                        <div class="col-sm-10">
                                            <select class="form-control" id="ipt_sex" placeholder="Sex" name="ipt_sex" >
                                               <option value="M">---选择性别---</option>
                                              <option value="M">男</option>
                                              <option value="F">女</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="ipt_phone" class="col-sm-2 control-label">电话</label>
                                        <div class="col-sm-10">
                                            <input type="number" class="form-control" id="ipt_phone" name="ipt_phone" placeholder="Phone">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="ipt_pswd" class="col-sm-2 control-label">密码</label>
                                        <div class="col-sm-10">
                                            <input type="password" class="form-control" id="ipt_pswd" name="ipt_pswd" placeholder="Phone">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="ipt_pswd2" class="col-sm-2 control-label">确认密码</label>
                                        <div class="col-sm-10">
                                            <input type="password" class="form-control" id="ipt_pswd2" name="ipt_pswd2" placeholder="Phone">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-offset-2 col-sm-10">
                                            <input type="submit" class="btn btn-danger" value="确认修改" onclick="updateStaffInfo(this.id,'update_staffInfo_div');return false;">
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <!-- /.tab-pane -->
                        </div>
                        <!-- /.tab-content -->
                    </div>
                    <!-- /.nav-tabs-custom -->
                </div>
            <!-- |----------------------------------------------------------------------------------------------------| -->
        </div>
        <!-- /.content-wrapper end -->
	<medicinems:basePage_Down></medicinems:basePage_Down>
</body>

</html>
