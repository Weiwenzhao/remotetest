<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>用户登录</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
    <link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
    <script src="lib/jquery-1.7.2.min.js" type="text/javascript"></script>
	<script src="js/jquery-1.11.3.min.js"></script>
	<script src="js/foundation-datepicker.js"></script>
	<script src="js/locales/foundation-datepicker.zh-CN.js"></script>
	<style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .brand { font-family: georgia, serif; }
        .brand .first {
            color: #ccc;
            font-style: italic;
        }
        .brand .second {
            color: #fff;
            font-weight: bold;
        }
    </style>
    <link rel="shortcut icon" href="../assets/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
   <script type="text/javascript">
   		function check(){
    	var obj = document.getElementById("username"); 
    		//alert("456");
    		//alert(obj);
    		obj.focus();
    		
     }
   </script>
  </head>
  <body class="" onload="check()"> 
 
    <div class="navbar">
        <div class="navbar-inner">
                <ul class="nav pull-right">
                    
                </ul>
                <a class="brand" href="#"><span class="first"><img style="height:30px;" src="images/000.png"/></span> <span class="second">穆特科技（武汉）股份有限公司</span></a>
        </div>
    </div>
        <div class="row-fluid">
    <div class="dialog">
        <div class="block">
            <p class="block-heading">员工登录</p>
            <div class="block-body">
                <form id="loginForm" action="loginAction" method="post">
                    <label>用户名</label>
                    <input type="text" id="username" class="span12" maxlength="6" name="username">${errors.username[0]}
                  <!--    <label>密码</label>
                    <input type="password" class="span12">
                    <a href="index.html" class="btn btn-primary pull-right">Sign In</a>
                    <label class="remember-me"><input type="checkbox"> Remember me</label>
                    <div class="clearfix"></div>-->
                </form>
            </div>
        </div>
        <p class="pull-right" style=""><a href="#" target="blank" onclick="alert('暂不支持此操作')">联系我们</a></p>
        <p><a href="#" onclick="alert('暂不支持此操作')">忘记账号?</a></p>
    </div>
</div>


    


    <script src="lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>
    
  </body>
</html>
