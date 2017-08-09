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
					var addDrawingHTML = "<tr onclick='ProjectInfo(this)'>" +
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
function ProjectInfo(obj) {
	var id = obj.cells[0].innerText;
	$.ajax({
		type: "get",
		dataType: "json",
		cache: false,
		data: { id: id },
		url: "getDrawing",
		success: function(data) {
			var len = data.length; //项目长度     
			if(len == 0) {
				alert("该项目暂未上传图纸，请与设计部门联系！");
			}else{
				window.location.href= "jsp/manu/drawing_view.jsp?id="+id;
			}
		}
		})
	
}
function printDrawing(){
	alert("请先选择项目！");
}
function project_his(){
	alert(13);
}

