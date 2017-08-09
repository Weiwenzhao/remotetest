$(document).ready(function() {
	$.ajax({
		type: "get",
		dataType: "json",
		cache: false,
		url: "getProjectItem",
		success: function(data) {
			var len = data.length; //项目长度       
			if(len > 0) {
				for(var i = 0; i < len; i++) {
					var addDrawingHTML = "<tr onclick='show_project(this)'>" +
						"<td>" + data[i][0] + "</td>" +
						"<td>" + data[i][1] + "</td>" +
						"<td>" + data[i][2] + "</td>" +
						"<td>" + data[i][3] + "</td>" +
						"<td>" + data[i][4] + "</td>" +
						"<td>" + data[i][6] + "</td>" +
						"<td>"+
						"<a href='javascript:void(0);'><i class='icon-pencil'></i></a>" +
//						"<a href='javascript:void(0);' role='button'>"+
	//					"<i class='icon-exclamation-sign'></i></a>
						"</td>";
					$("#project_view").append(addDrawingHTML);
				}

			}
		}
	});
});
function uploadDrawing(){
	alert("请使用导航栏上传图纸功能！");
}
function form_submit() {
	if($("#pid").val() == "") {
		$("#msg_id").html("<font color=red>请输入项目编号！</font>");
		$("#pid").focus();
		return false;
	}
	if($("#pname").val() == "") {
	$("#msg_name").html(" <font color=red>请输入项目名称！</font>");
	$("#pid").focus();
				return false;
	}
	$('#tab').submit();
}
function project_his(){
	alert("暂无历史记录信息");
}function show_project(obj){
	alert("暂无详细信息！");
}
