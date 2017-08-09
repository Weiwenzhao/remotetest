$(document).ready(function(){
	 var urls = location.search;  //获取参数
	 var id = 0;                     //项目编号
	 if (urls.indexOf("?") != -1) {
	      var str = urls.substr(1);
	      strs = str.split("=");
	      id = strs[1];
	   }
	 console.log(id);
	 $("#pid").attr("value",id);//填充内容
});
function add_attach(){
	if($("#attname").val() == "") {
	$("#msg_name").html(" <font color=red>请输入附件名称！</font>");
	$("#attname").focus();
		return false;
	}
	if($("#attachment").val() == ""){
		$("#msg_att").html(" <font color=red>请选择文件！</font>");
		return false;
	}
	$('#tab').submit();
}

