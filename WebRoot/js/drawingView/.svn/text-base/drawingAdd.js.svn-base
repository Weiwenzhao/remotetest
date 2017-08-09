function SendDrawingData() {
	var len = $("#table_addDrawing").find("tr").length; //行数
	var data = new Array();
	var tids = new Array(); //图纸编号
	var nums = new Array(); //图纸编号
	var dnames = new Array(); //图纸编号
	var pname = $("#pname").val();
	var pid = $("#pid").val();
	var type = $("#type").val();
	var i = 0;
	var j = 0;
	var k = 0;
	//获取图纸编号数组
	$('input[name="tid"]').each(function() {
		tids[i] = $(this).val();
		i++;
	});
	//图纸对应零件数量
	$('input[name="num"]').each(function() {
		nums[j] = $(this).val();
		j++;
	});
	//图纸对应零件数量
	$('input[name="dname"]').each(function() {
		dnames[k] = $(this).val();
		k++;
	});
	for(var i = 0; i < len - 1; i++) {
		data[i] = new Array();
		data[i][0] = tids[i];
		data[i][1] = nums[i]
		data[i][2] = dnames[i];
	}
	
	
	var jsondata = {}; 
	for(var i=0;i<data.length;++i){
		jsondata[i] = {};
		jsondata[i].tid = data[i][0];
 		jsondata[i].num = data[i][1];
 		jsondata[i].name = data[i][2];
	}
	var datajson = JSON.stringify(jsondata);
	
	$.ajax({
		type: "post",
		//url: 'drawingAdd',
		url:'addDrawings',
		//async : false,  
		data: {
		data:datajson,
		pid:pid,
		type:type,
		name:name
			},
		dataType:'html',
		cache: false,
		success: function(data) {
				alert(data);
				
				//$("#tab_drawing").submit();
			//while($("#table_addDrawing").find("tr").length > 1) {
			//		$("#table_addDrawing tr:last").remove();
			//	}
				
		}
	});
}

function addDrawing() {
	var addDrawingHTML = "<tr>" +
		"<td><input name='ckb' id='cbk' type='checkbox'></td>" +
		"<td><input name='tid' type='text' value='' maxlength='9' style='height:30px;'  id='tid'/></td>" +
		"<td><input name='num' type='text'  value='4' style='height:30px;)'></td>" +
		"<td><input name='dname' type='text'  value='舱体底座' style='height:30px;'></td>" +
		"<td><input name='drawing' id='dra' type='file'  style='height:30px;'></td>" +
		"</tr>"
	$("#table_addDrawing").append(addDrawingHTML);
}
function delDrawing() {
	delTr('ckb');
}

function delTr(ckb) {
	//获取选中的复选框，然后循环遍历删除
	$("#table_addDrawing").find("tr").length; //行数
	if($("#table_addDrawing").find("tr").length > 1) {
		$("#table_addDrawing tr:last").remove();
	} else {
		alert("已全部删完");
	}
}