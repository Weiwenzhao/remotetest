<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>图纸上传</title>
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
		<script src="js/drawingView/drawingAdd.js"></script>
		<script src="js/drawingView/uploadDrawing.js"></script>
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
}
</style>
		<link rel="shortcut icon" href="../assets/ico/favicon.ico">
		<link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
		<link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
		<link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
		<link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">
	</head>
	<body class="">
		<script type="text/javascript">
</script>
<s:fielderror></s:fielderror><s:actionerror/><s:actionmessage/>
		<div class="navbar">
			<div class="navbar-inner">
				<ul class="nav pull-right">

					<li>
						<a href="javascript:void(0)" class="hidden-phone visible-tablet visible-desktop"
							role="button">设置</a>
					</li>
					<li id="fat-menu" class="dropdown">
						<a href="javascript:void(0)" role="button" class="dropdown-toggle"
							data-toggle="dropdown"> <i class="icon-user"></i>
							${sessionScope.worker.name } <i class="icon-caret-down"></i> </a>

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
				<a class="brand" href="http://www.motustechs.com"><span
					class="first"><img style="height: 30px;"
							src="images/000.png" />
				</span> <span class="second">穆特科技（武汉）股份有限公司</span>
				</a>
			</div>
		</div>




		<div class="sidebar-nav">
			<form class="search form-inline">
				<input type="text" style="height:30px;" placeholder="Search...">
			</form>

			<a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i
				class="icon-dashboard"></i>主页</a>
			<ul id="dashboard-menu" class="nav nav-list collapse in">
				<li><a href="jsp/design/design.jsp">项目图纸信息</a></li>
				<li><a href="jsp/design/uploadDrawing.jsp">上传图纸</a></li>
				
			</ul>
			
			
		</div>
		<div class="content">
			<div class="header">
				<h1 class="page-title">
					上传图纸
				</h1>
			</div>
			<ul class="breadcrumb">
				<li>
					<a href="javascript:void(0)">主页</a>
					<span class="divider">/</span>
				</li>
				<li>
					<a href="javascript:void(0)">项目</a>
					<span class="divider">/</span>
				</li>
				<li class="active">
					图纸上传
				</li>
			</ul>

			<div class="container-fluid">
				<div class="row-fluid">

					<div class="btn-toolbar">
						<button class="btn btn-primary" onclick=sub();>
							<i class="icon-save"></i>确定
						</button>
						<a href="#myModal" data-toggle="modal" class="btn">取消</a>
						<div class="btn-group">
						</div>
					</div>
					<div class="well">
						<ul class="nav nav-tabs">
							<li class="active">
								<a href="#home" data-toggle="tab">信息</a>
							</li></span><font color=red>${Message}${errors.tid[0]}${errors.tid[1]}${errors.tid[2]}</font>
							
						</ul>
						<div id="myTabContent" class="tab-content">
							<div class="tab-pane active in" id="home">
								<form id="drawingForm" action="drawingAction" method="post"
									enctype="multipart/form-data">
									<span style="margin-left: 40px; font-size: 20px;"> 项目编号*
										<select name="pid" id="pid" onchange="setName(this)">
											<option value="170301">170301</option>
											<option value="170302">170302</option>
										</select>
									</span>
									<span style="margin-left: 40px; font-size: 20px;">项目名称*
										<input type="text" name="name" id="pname" value=""
											style="height: 30px;" readonly>
									</span>
									<span style="margin-left: 40px; font-size: 20px;"> 类型 <select
											name="type" id="type">
											<option value="00">
												自生产
											</option>
											<option value="10">
												采购
											</option>
											<option value="20">
												外协
											</option>
											<option value="30">
												其他
											</option>
										</select>
									</span>
									<br>
									<table class="table" id="table_addDrawing" align="center">
										<tr>
											<td align="center">
												#
											</td>
											<td>
												图纸编号
											</td>
											<td>
												生产数量
											</td>
											<td>
												零件名称
											</td>
											<td>
												图纸
											</td>
											<td>
												<button type="button" class="btn btn-primary"
													onclick=addDrawing();>
													<i class="icon-add"></i>添加
												</button>
												<button type="button" class="btn btn-primary"
													onclick=delDrawing();>
													<i class="icon-add"></i>删除
												</button>
											</td>
										</tr>
									</table>
								</form>
							</div>
						</div>

					</div>
					<footer>
					<hr>

					<p class="pull-right">
						版权所有
						<a href="http://www.motustechs.com" title="穆特科技" target="_blank">穆特科技</a>
					</p>

					<p>
						&copy;2012-2017
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
		$('.demo-cancel-click').click(function() {
			return false;
		});
	});
</script>
		<script>
	$('#demo-1').fdatepicker();
	$('#demo-2').fdatepicker();
</script>
	</body>
</html>