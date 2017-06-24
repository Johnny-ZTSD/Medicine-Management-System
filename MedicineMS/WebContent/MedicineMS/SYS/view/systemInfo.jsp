<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.lang.*"%>
<%@ taglib prefix="medicinems" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="user" uri="/WEB-INF/tlds/mytlds.tld"%>
<!-- /*
	药品入库管理|仁爱药品管理系统----作为响应页
*/   -->
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>系统设置|系统信息|仁爱药品管理系统</title>
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
		<div class="row col-lg-12" style="padding:20px;background-color:white;font-size:2em;text-align:center;margin-bottom:20px" >
		
		<i class="fa fa-cog"></i><span style="color:#222">&nbsp;&nbsp;&nbsp;&nbsp;系统设置|系统信息</span>
		<div>
			<user:WelcomeUser name="${staff.realName}"/>
		</div>	
		</div>
		<section class="content">
			<div class="row">
				<div class="col-md-12">
					<!-- The time line -->
					<ul class="timeline">
						<!-- timeline time label -->
						<li class="time-label"><span class="bg-red"> 22 June.
								2017 </span></li>
						<!-- /.timeline-label -->
						<!-- timeline item -->
						<li><i class="fa fa-user bg-aqua"></i>

							<div class="timeline-item">
								<span class="time"><i class="fa fa-clock-o"></i> 2017-06-22 12:05</span>

								<h3 class="timeline-header">
									<a href="#">Technology By</a> Johnny Zen
								</h3>

								<div class="timeline-body">
									My Email as follows: johnnyztsd@gmail.com 
								</div>
								<div class="timeline-footer">
									<a class="btn btn-primary btn-xs">send Email</a>
								</div>
							</div></li>
						<!-- END timeline item -->
						<!-- timeline item -->
						<li><i class="fa fa-comments bg-yellow"></i>

							<div class="timeline-item">
								<span class="time"><i class="fa fa-clock-o"></i> 3 mins
									ago</span>

								<h3 class="timeline-header">
									<a href="#" style="text-indent:2em">Johnny Zen</a> commented on your post
								</h3>

								<div class="timeline-body">
								We look forward to every communication！ 
								</div>
								<div class="timeline-footer">
									<a class="btn btn-warning btn-flat btn-xs">View comment</a>
								</div>
							</div></li>
						<!-- END timeline item -->
						<!-- timeline time label -->
						<!-- /.timeline-label -->
						<!-- timeline item -->
						<li><i class="fa fa-video-camera bg-maroon"></i>

							<div class="timeline-item">
								<span class="time"><i class="fa fa-clock-o"></i> 5 days
									ago</span>

								<h3 class="timeline-header">
									<a href="#">Johnny Zen</a> know me
								</h3>

								<div class="timeline-body">
									<div class="embed-responsive embed-responsive-16by9">
										<iframe class="embed-responsive-item"
											src="http://johnnyzen.cn"
											frameborder="0" allowfullscreen=""></iframe>
									</div>
								</div>
								
							</div></li>
						<!-- timeline item -->
						<li><i class="fa fa-video-camera bg-maroon"></i>

							<div class="timeline-item">
								<span class="time"><i class="fa fa-clock-o"></i> 5 days
									ago</span>

								<h3 class="timeline-header">
									<a href="#">Johnny Zen</a> know us
								</h3>

								<div class="timeline-body">
									<div class="embed-responsive embed-responsive-16by9">
										<iframe class="embed-responsive-item"
											src="https://git-sublime.github.io/test/weily"
											frameborder="0" allowfullscreen=""></iframe>
									</div>
								</div>
								
							</div></li>
						<!-- END timeline item -->
						<li><i class="fa fa-clock-o bg-gray"></i></li>
					</ul>
				</div>
			</div>
		</section>
	</div>
	<!-- /.content-wrapper -->
	<medicinems:basePage_Down></medicinems:basePage_Down>

</body>

</html>
