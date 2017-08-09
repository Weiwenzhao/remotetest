$(document).ready(function() {
	var v = document.getElementById("path").value;
	var href = document.getElementById("pdf");
	var t = document.getElementById("did");
	
	t.focus();
	if(v != ""){
		//h = "https://huiweixin.club" + v;
		h = v;
		console.log(v);
		href.setAttribute("href",h);
		document.getElementById("path").value = "";
		document.getElementById("did").value = "";
		//t.focus();
		href.click();
}
});