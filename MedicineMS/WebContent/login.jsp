<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="height: 0!important">

<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="shortcut icon" href="img/common/logo.png" type="image/x-icon">
    <title>【用户登录】|仁爱药品管理系统</title>
    <!-- 获取并控制屏幕信息(响应式) -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- CSS框架 Boostrap 3 -->
    <link rel="stylesheet" href="framework/AdminLTE/bootstrap/css/bootstrap.min.css">
    <!-- Font  -->
    <link rel="stylesheet" href="framework/AdminLTE/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="framework/AdminLTE/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="framework/AdminLTE/dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. We have chosen the skin-blue for this starter
        page. However, you can choose any other skin. Make sure you
        apply the skin class to the body tag so the changes take effect.
  -->
    <link rel="stylesheet" href="framework/AdminLTE/dist/css/skins/skin-blue.min.css">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
  	<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  	<![endif]-->
    <!--
		BODY TAG OPTIONS:
		=================
		Apply one or more of the following classes to get the
		desired effect
		|---------------------------------------------------------|
		| SKINS         | skin-blue                               |
		|               | skin-black                              |
		|               | skin-purple                             |
		|               | skin-yellow                             |
		|               | skin-red                                |
		|               | skin-green                              |
		|---------------------------------------------------------|
		|LAYOUT OPTIONS | fixed                                   |
		|               | layout-boxed                            |
		|               | layout-top-nav                          |
		|               | sidebar-collapse                        |
		|               | sidebar-mini                            |
		|---------------------------------------------------------|
	-->
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <script type="text/javascript">
    function login_check() {

        /*验证用户名*/
        var accountNo = login.accountNo.value;
        if (accountNo == null || accountNo.length != 8) {
            alert("请重新输入账户名...");
            login.accountNo.focus();
            return false;
        }

        /*验证密码*/
        var password = login.password.value;
        if (password == null || password.length < 6 || password.length > 10) {
            alert("请重新输入密码...");
            login.password.focus();
            return false;
        }
    }
    //重置body元素的高度[使布局完美居中]+【配合CSS：弹性布局】
    function reloadBydyHeight() {
        document.body.style.height = window.innerHeight + 'px';
    }


    //点击更换图片


    function changeImg(id) {
        //图片对象
        var imgs = {
            0: "login10.jpg",
            1: "login2.jpg",
            2: "login5.jpg",
            3: "login6.jpg",
            4: "login7.jpg",
            5: "login9.jpg",
            6: "login1.jpg",
            7: "login11.jpg",
            8: "login12.jpg"
        };
        var imgsLength = 6;

        var ranInt = parseInt(Math.random() * imgsLength);
        var img = document.getElementById(id); //ok
        var loginImg = imgs[ranInt];
        // alert(ranInt + "|" + img + "|" + loginImg);
        // img/login/login3.png

        img.src = 'img/login/' + loginImg; //动态设定src  
        // alert(img.src);
    }
    </script>
</head>

<body style="background-color: rgba(0, 0, 0, 0);" onload="javascript:reloadBydyHeight();">
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
    <div class="header text-left flex">
        <div class="login-header-img-cont" ><img src="img/common/logo.png" class="img-responsive login-header-img" style=""></div>
        <div class="login-header-title-cont" ><a href="<%=request.getContextPath()%>">仁爱药品管理系统</a></div>
    </div>
    <div class="row center-block container col-lg-4 login-content-container" style="">
        <div class="visible-lg col-lg-7 login-content-img-container" style=" ">
            <img class="img-responsive login-content-img" src="img/login/login9.jpg" style="" onclick="changeImg(this.id)" id="login_img" title="点击更换">
        </div>
        <div class="login-container col-lg-4 login-form-container" style="">
            <form action="login" name="login" method="post" class="flex-col-center" onsubmit="return login_check()">
                <div class="flex-col-center col-lg-12">
                    <div class="login-form-up-item title-info">
                        <div style="">USER LOGIN</div>
                    </div>
                    <div class="login-form-up-item top-tips">
                        <span><a href="#" class="top-tips-link" style="">Lost
							your ID or password?</a></span>
                    </div>
                </div>
                <!-- /*input group*/ -->
                <div class="flex-col-center col-lg-12 input-outer-container" style="">
                    <div class="flex-col-center input-inner-container col-lg-12" style="">
                        <!-- 输入框 -->
                        <div class="flex-row-center login-form-up-item">
                            <div style="width: 15%;">
                                <span class="glyphicon glyphicon-user" style="color: #b1b1b1"></span>
                            </div>
                            <input type="text" name="accountNo" placeholder="Username" class="clear-input-text normal-input-text" style="width: 85%;">
                        </div>
                        <!-- 输入框 -->
                        <div class="flex-row-center login-form-up-item">
                            <div style="width: 15%;">
                                <span class="glyphicon glyphicon-lock" style="color: #b1b1b1; font-size: 1.2em"></span>
                            </div>
                            <input type="password" name="password" placeholder="Password" class="clear-input-text normal-input-text" style="width: 85%;">
                        </div>
                    </div>
                    <div class="submit-container">
                        <input type="submit" value="LOGIN" class="clear-input-text login-form-down-item login-submit-btn">
                    </div>
                </div>
            </form>
            <div>
                <div id="login_message" style="text-align: center;">
                    ${param.error=="yes"?sessionScope.login_message:"<a href=\"/MedicineMS/MedicineMS/user/reg/register.html\" style=\"color:#ccc\">Don't have an account ? Open an account.</a>"}
                    <br>
                </div>
            </div>
        </div>
    </div>
    <!-- <span class="glyphicon glyphicon-user"></span> -->
    <footer class="footer">
        <div>
            <a href="/MedicineMS/aboutUs.html" target="_blank">关于我们</a> &nbsp;|&nbsp;
            <a href="http://www.johnnyzen.cn/" target="_blank">服务条款</a> &nbsp;|&nbsp;
            <a href="http://www.johnnyzen.cn/" target="_blank">联系我们</a> &nbsp;|&nbsp;
            <a href="http://www.johnnyzen.cn/" target="_blank">帮助中心</a> &nbsp;|&nbsp;
            <span>© 2017 - 2017 Weily Inc. All Rights Reserved.</span>
        </div>
    </footer>
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
    <script src="framework/AdminLTE/plugins/jQuery/jquery-2.2.3.min.js"></script>
    <!-- Bootstrap 3.3.6 -->
    <script src="framework/AdminLTE/bootstrap/js/bootstrap.min.js"></script>
    <!-- AdminLTE App -->
    <script src="framework/AdminLTE/dist/js/app.min.js"></script>
    <!-- Optionally, you can add Slimscroll and FastClick plugins.
     Both of these plugins are recommended to enhance the
     user experience. Slimscroll is required when using the
     fixed layout. -->
</body>

</html>
