<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html><head>
 		<base href="<%=basePath%>">
		<title>项目信息</title>
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
		<script src="js/project/project.js"></script>
		<style type="text/css">
			#line-chart {
				height: 300px;
				width: 800px;
				margin: 0px auto;
				margin-top: 1em;
			}
			
			.brand {
				font-family: georgia, serif;
			}
			
			.brand .first {
				color: #ccc;
				font-style: italic;
			}
			
			.brand .second {
				color: #fff;
				font-weight: bold;
			}.table tr:hover,.datatable tr.hilite
    {
    color:#CC9900;
    cursor: pointer;
    }
		</style>
		<link rel="shortcut icon" href="../assets/ico/favicon.ico">
		<link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
		<link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
		<link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
		<link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">
	</head>

	<body class="">
		<div class="navbar">
			<div class="navbar-inner">
				<ul class="nav pull-right">

					<li>
						<a href="javascript:void(0)" class="hidden-phone visible-tablet visible-desktop" role="button">设置</a>
					</li>
					<li id="fat-menu" class="dropdown">
						<a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">
							<i class="icon-user"></i> ${sessionScope.worker.name }
							<i class="icon-caret-down"></i>
						</a>

						<ul class="dropdown-menu">
							<li>
								<a tabindex="-1" href="javascript:void(0)">我的账户</a>
							</li>
							<li class="divider"></li>
							<li>
								<a tabindex="-1" class="visible-phone" href="javascript:void(0)">设置</a>
							</li>

							<li>
								<a tabindex="-1" href="login.jsp">安全退出</a>
							</li>
						</ul>
					</li>

				</ul>
				<a class="brand" href="http://www.motustechs.com"><span class="first"><img style="height:30px;" src="images/000.png"/></span> <span class="second">穆特科技（武汉）股份有限公司</span></a>
			</div>
		</div>

		<div class="sidebar-nav">
			<form class="search form-inline">
				<input type="text" style="height:30px;" placeholder="Search...">
			</form>

			<a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i class="icon-dashboard"></i>主页</a>
			<ul id="dashboard-menu" class="nav nav-list collapse in">
				<li>
					<a href="javascript:void()">项目信息</a>
				</li>
			</ul>
		</div>

		<div class="content">

			<div class="header">

				<h1 class="page-title">项目信息</h1>
			</div>

			<ul class="breadcrumb">
				<li>
					<a href="javascript:void(0)">主页</a> <span class="divider">/</span></li>
				<li>
					<a href="javascript:void(0)">项目</a> <span class="divider">/</span></li>
				<li class="active">信息</li>
				<a href='javascript:void()' role='button' onclick='project_his()' style="float:right"><i class='icon-exclamation-sign'></i>历史记录</a>
			</ul>
			<div class="container-fluid">
				<div class="row-fluid">
					<div class="btn-toolbar">
						<button class="btn btn-primary" onclick="new_Project()"><i class="icon-plus"></i>新建项目</button>
						<a href="#myModal" data-toggle="modal" class="btn">删除</a>
						<div class="btn-group">
						</div>
					</div>
					<div class="well">
					<font color=red>${info} </font>
						<table id="project_view" class="table" width="1019" height="263">
							<thead>
								<tr>
									<th>#项目编号</th>
									<th>项目名称</th>
									<th>开始时间</th>
									<th>结束时间</th>
									<th>责任部门</th>
									<th>负责人</th>
									<th style="width: 26px;"></th>
								</tr>
							</thead>
						</table>
					</div>
					<footer>
						<hr>
						<p class="pull-right">版权所有
							<a href="http://www.motustechs.com" title="穆特科技" target="_blank">穆特科技</a>
						</p>
						<p>&copy;2012-2017
							<a href="javascript:void(0)" target="_blank">Motus</a>
						</p>
					</footer>
				</div>
			</div>
		</div>

		<script src="lib/bootstrap/js/bootstrap.js"></script>
		<script type="text/javascript">
			$("[rel=tooltip]").tooltip();
			$(function() {
				$('.demo-cancel-click').click(function() { return false; });
			});
		</script>
		<script>
			$('#demo-1').fdatepicker();
			$('#demo-2').fdatepicker();
		</script>
	</body>

</html>