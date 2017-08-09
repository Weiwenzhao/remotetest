<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

	<head>
		<base href="<%=basePath%>">
		<title>图纸信息</title>
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
		<link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
		<link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
		<link rel="stylesheet" href="lib/dist/css/lobibox.css">
		<link rel="stylesheet" href="lib/dist/css/Lobibox.min.css">
		<script src="lib/jquery-1.7.2.min.js" type="text/javascript"></script>
		<script src="js/jquery-1.11.3.min.js"></script>
		<script src="js/foundation-datepicker.js"></script>
		<script src="js/locales/foundation-datepicker.zh-CN.js"></script>
		<script src="js/drawingView/projectDetailView.js"></script>
		<script src="js/lobibox.js"></script>
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
		<link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
		<link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
		<link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
		<link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
	</head>
	<body class="">
	<s:debug></s:debug>
		<div class="navbar">
			<div class="navbar-inner">
				<ul class="nav pull-right">

					<li>
						<a href="javascript:void(0)" class="hidden-phone visible-tablet visible-desktop" role="button">设置</a>
					</li>
					<li id="fat-menu" class="dropdown">
						<a href="javascript:void(0)" role="button" class="dropdown-toggle" data-toggle="dropdown">
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
					<a href="jsp/project/project.jsp">项目信息</a>
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
				<li class="active">项目信息</li>
			</ul>

			<div class="container-fluid">
				<div class="row-fluid">

					<div class="btn-toolbar">
						<button class="btn btn-primary" onclick="uploadAtt()"><i class="icon-print"></i>上传附件 </button>
						  <a href="#myModal" data-toggle="modal" class="btn">批量删除</a>
						<div class="btn-group">
							<form style="margin-left: 800px;margin-bottom: 10px;">
								<input type="text" style="height:30px;" value="输入查找条件" placeholder="输入图纸编号">
							
							</form>
						</div>
					</div>
					<div class="well">
					<form id ="drawing_part_form" action="exportExcel" method="post">
						<table class="table" id="table_detail">
						<thead>
						<tr>
						<th colspan='5' id='p_id'>项目编号:${pid}</th>
						</tr>
						<tr>
						<th>#项目名称</th>
						<th>开始时间</th>
						<th>交货时间</th>
						<th>当前进度（%）</th>
						<th>图纸数量</th>
						<th>备注</th>
						</tr>
						</thead>
						
						</table>
						<table class="table" id="project_detail_att">
							<tr>
								<th>附件编号</th>
								<th>附件名称</th>
								<th>上传时间</th>
								<th>备注</th>
							</tr>
						</table>
					</form>
					</div>
					<div class="modal small hide fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h3 id="myModalLabel">删除确认</h3>
						</div>
						<div class="modal-body">
							<p class="error-text"><i class="icon-warning-sign modal-icon"></i></p><br/><br/>
							<form action="deleteAtt"  id="delAtt" method="post">
								 项目编号：<input type="text" name="apid" id="apid" readonly/><br>
								 附件编号：<input type="text" name="attid" id="attid" readonly/><br>  
               					 附件名称：<input type="text" name="attname" id="attname" readonly/> 
               				 </form>  
						</div>
						<div class="modal-footer">
							<button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
							<button class="btn btn-danger" data-dismiss="modal" onclick="deleteAtt()" >删除</button>
						</div>
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
			function downloadExcel(){
			   var ab = $('[id=checkbox]')
			   var len = ab.length;
			   if(len == 0){
			   	alert("图纸不存在,请选择需要打印的图纸");
			   	return false;
			   }
			   var flag = false;
			   for(var i=0;i<len;i++){
			   		if(ab[i].checked){
			   			flag = true
			   			break;
			   		}
			   }
			   if(flag){
			   	 drawing_part_form.submit();
			   }else{
			   		alert("请选择图纸！");
			   }
}
		</script>
		</body>

</html>