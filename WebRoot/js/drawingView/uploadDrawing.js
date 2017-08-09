$(document).ready(function() {
	$.ajax({
		type: "get",
		dataType: "json",
		cache:false,
		url: "getProjectItem",
		success: function (data) {
		console.log(data);
			var len = data.length;
			var obj = document.getElementById("pid"); //获取项目编号下拉框
			var name = document.getElementById("pname");//获取项目名称
				if(len > 0){
					obj.options.length = 0;
					for(var i=0;i<len;i++){
   					obj.add(new Option(data[i][0]+"-"+data[i][1],data[i][0]));
					}	
					name.value=data[0][1];
		}
	}
	});
});
function setName(obj) {
	var index = obj.selectedIndex;
	var text = obj.options[index].text; // 选中文本
	var value = obj.options[index].value; // 选中值
	var s = text.split("-");
	console.log(s[1]);
	document.getElementById("pname").value =s[1];
	console.log(document.getElementById("pid").value);
	console.log(text);
}
function sub() {
	var len = $("#table_addDrawing").find("tr").length; //行数
	console.log(len)
	console.log(document.getElementById("pid").value);
	if(len < 2){
		alert("请先添加图纸！");
		return false;
	}
	if (document.getElementById('tid').value == "") {
		alert("请输入图纸编号！");
		document.getElementById('tid').focus();
		return false;
	}
	if (document.getElementById("dra").value == "") {
		alert("请选择文件！");
		return false;
	} else {
		drawingForm.submit();
	}
}