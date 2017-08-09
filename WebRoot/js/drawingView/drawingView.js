$(document).ready(function(){
	 var urls = location.search;  //获取参数
	 var id = 0;                     //项目编号
	 if (urls.indexOf("?") != -1) {
	      var str = urls.substr(1);
	      strs = str.split("=");
	      id = strs[1];
	   }
	 if(id != 0){
		 $.ajax({   //获取项目对应图纸信息
				type: "get",
				dataType: "json",
				cache: false,
				data: {id:id},
				url: "getDrawing",
				success: function(data) {
					console.log(data);
					console.log(123);
					var DrawingAddHTML_head =
						"<thead>" +
						"<tr>" +
						"<th colspan='5'>项目编号:" + id + "</th>" +
						"</tr>" +
						"<tr>" +
						"<th>#</th>" +
						"<th>图纸编号</th>" +
						"<th>图纸名称</th>" +
						"<th>上传时间</th>" +
						"<th>上传人</th>" +
						"</tr>" +
						"</thead>";
					var len = data.length; //图纸信息长度   
					if(len == 0 ){           //图纸不存在
						DrawingAddHTML_head = DrawingAddHTML_head +
						   "<tr>"+
							"<td colspan='5'>图纸信息获取失败，请重试！</td>" +
							"</tr>";
					}else{
						for(var i = 0; i < len; i++) {
							DrawingAddHTML_head = DrawingAddHTML_head +
						   "<tr'>"+
							"<td><input type='checkbox' id='checkbox' name='chkbox' value='"+i+"'/></td>" +
							"<td><input type='text' name='id' style='height:30px;' value='" + data[i][1] + "' readonly/></td>" +
							"<td>" + data[i][4] + "</td>" +
							"<td>" + data[i][5] + "</td>" +
							"<td>" + data[i][7] + "</td>" +
							"<td><a href='"+data[i][10]+"'><i class='icon-pencil'></i></a>" +
							"<a href='#myModal' role='button' data-toggle='modal'>" +
							"<i class='icon-remove'></i></a></td>" +
							"</tr>";
						}
						$("#table_drawing_part").append(DrawingAddHTML_head);
					}
				}
			});
	 }
});

