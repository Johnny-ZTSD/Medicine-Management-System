<%@ tag language="java" pageEncoding="UTF-8"%>
<!-- 员工管理功能[App logo] -->
<div
	style="display: flex; justify-content: row; align-items: center; padding: 5px; background: white">
	<!--  #00a65a -->
	<div class="btn-app"
		style="margin-bottom: 0; background-color: rgba(0, 166, 90, .8); color: white">
		<span class="fa fa-gears  "></span>员工管理
	</div>
	<div class="btn-app"
		style="margin-bottom: 0;">
		<a href="<%=request.getContextPath()%>/search_staffsAction"><span class="fa fa-glass"></span><br>刷新</a>
	</div>
</div>