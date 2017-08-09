$(document).ready(function(){
	 var urls = location.search;  //获取参数
	 var id = 0;                     //项目编号
	 if (urls.indexOf("?") != -1) {
	      var str = urls.substr(1);
	      strs = str.split("=");
	      id = strs[1];
	   }
	
	 if( id != 0){
		 document.getElementById("p_id").innerHTML = "项目编号:"+id;
	 }
	
	var pid = document.getElementById("p_id").innerHTML ;
	var strs = pid.split(":");
	 if(strs[1] != ""){
		 id = strs[1];
	 }

	console.log(id);
	
	 if(id != 0){
		 $.ajax({   //获取项目对应项目信息
				type: "get",
				dataType: "json",
				cache: false,
				data: {id:id},
				url: "getProject",
				success: function(data) {
					console.log(id);	
					$.ajax({
						type: "get",
						dataType: "json",
						cache: false,
						data:{id:id},
						url: "getProjectInfo",
						success: function(data) {
							
							var DrawingAddHTML_head =
								"<tr>" +
								"<td>"+data.pname+"</td>" +
								"<td>"+data.createTime+"</td>" +
								"<td>"+data.endTime +"</td>" +
								"<td>"+data.createDepart+"</td>" +
								"<td>"+data.createDepart+"</td>" +
								"<td>"+data.comment+"</td>" +
								"</tr>" ;
							$("#table_detail").append(DrawingAddHTML_head);
						}
					});
					
					var len = data.length; //项目附件信息   
					if(len == 0 ){           //图纸不存在
					var 	DrawingAddHTML_head = DrawingAddHTML_head +
						   "<tr>"+
							"<td colspan='5'>图纸信息获取失败，请重试！</td>" +
							"</tr>";
					}else{
						var DrawingAddHTML_head_att = "";
						for(var i = 0; i < len; i++) {
							
							var info = data[i][0] + data[i][2];
							DrawingAddHTML_head_att = DrawingAddHTML_head_att +
						   "<tr'>"+
							"<td><input type='text' name='id' style='height:30px;' id='"+i+"'value='" + id+"-"+data[i][0] + "' readonly/></td>" +
							"<td >" + data[i][2] + "</td>" +
							"<td>" + data[i][3] + "</td>" +
							"<td>" + data[i][8] + "</td>" +
							"<td><a href='"+data[i][7]+"'><i class='icon-eye-open'></i></a>" +
									"<a href='#myModal' data-toggle='modal'  onclick='editInfo("+i+")'><i class='icon-remove'></i></a>" +
							"</td>" +
							"</tr>";
						}
						$("#project_detail_att").append(DrawingAddHTML_head_att);
					}
				}
			});
	 }
});
function uploadAtt(){
	var pid = document.getElementById("p_id").innerHTML;
	var strs = pid.split(":");
	var id = strs[1];
	console.log(id);
    window.location.href= "jsp/project/project_attach.jsp?id="+id;
	
}
function deleteAtt(){
	console.log(1);
}
function editInfo(obj) {  
	var name = document.getElementById("project_detail_att").rows[obj+1].cells[1].innerHTML;
	var id = document.getElementById(obj).value;
    var strs = id.split("-");
    $("#apid").attr("value",strs[0]);
    $("#attid").attr("value",strs[1]);
    $("#attname").attr("value",name);
    $.ajax({
    	type: "get",
		dataType: "json",
		cache: false,
		data:{attid:strs[1]},
		url: "deleteAtt",
		success: function(data) {
			
		}
    });
}  
