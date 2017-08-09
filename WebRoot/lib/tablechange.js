function sine(){
	 	var table = document.getElementById("paramtertable");
		var rowNum = table.rows.length;
		if(rowNum != 0){
			for (var i=0;i<rowNum;i++){
        	 table.deleteRow(i);
			 rowNum=rowNum-1;
             i=i-1;
     		}
		}
		var trow = new Array();
		var cells = new Array();
		var rowNum = table.rows.length;
		
	      for(i=0;i<4;i++){
			  trow[i] = table.insertRow(i);
			  for(j=0;j<7;j++){
				   trow[i].insertCell(j);
			  }
		  }
		
		var colums = table.rows[0].cells.length;
		
		 table.rows[0].cells[0].innerHTML="#";
		 table.rows[1].cells[0].innerHTML="幅值（°/mm）"
		 table.rows[2].cells[0].innerHTML="频率（Hz）"
		 table.rows[3].cells[0].innerHTML="相位（0~360°）"
		 table.rows[0].cells[1].innerHTML="纵倾";
		 table.rows[0].cells[2].innerHTML="横移";
		 table.rows[0].cells[3].innerHTML="航向";
		 table.rows[0].cells[4].innerHTML="横摇";
		 table.rows[0].cells[5].innerHTML="前冲";
		 table.rows[0].cells[6].innerHTML="升降";
		 for(k=1;k<4;k++){
			 for(l=1;l<7;l++){
				table.rows[k].cells[l].innerHTML="<input type='text' class='input-msmall' value='0.000'>";
			 }
		 }
	 }
  function mulity(){
	 	var table = document.getElementById("paramtertable");
		var rowNum = table.rows.length;
		if(rowNum != 0){
			for (i=0;i<rowNum;i++){
        	 table.deleteRow(i);
			 rowNum=rowNum-1;
             i=i-1;
     		}
		}
	    var row = table.insertRow(0);
		var row1 = table.insertRow(1);
		var row2 = table.insertRow(2);;
		var y = row.insertCell(0);
		var z = row.insertCell(1);
		var m = row.insertCell(2);
		var x1 = row1.insertCell(0);
		var y1 = row1.insertCell(1);
		var z1 = row1.insertCell(2);
		var m1 = row1.insertCell(3);
		var x2 = row2.insertCell(0);
		var y2 = row2.insertCell(1);
		var z2 = row2.insertCell(2);
		var m2 = row2.insertCell(3);
		y.innerHTML="加速度系数";
		z.innerHTML="运动角度（°）";
		m.innerHTML="运动位移（mm）";
		x1.innerHTML="<input  type='text' class='input-msmall' value='1'>"
		y1.innerHTML="<input type='text' class='input-msmall' value='5'>"
		z1.innerHTML="<input type='text' class='input-msmall' value='50'>"
		x2.innerHTML="<input  class='btn' type='button' value='球面'>"
		y2.innerHTML="<input  class='btn' type='button' value='圆周'>"
		z2.innerHTML="<input  class='btn' type='button' value='扇形'>"
		m2.innerHTML="<input  class='btn' type='button' value='螺旋'>"
	 }
	 function src(){
		var table = document.getElementById("paramtertable");
		var rowNum = table.rows.length;
		if(rowNum != 0){
			for (i=0;i<rowNum;++i){
        	 table.deleteRow(i);
			 rowNum=rowNum-1;
             i=i-1;
     		}
		}
		 var row1 = table.insertRow(0); 
		 var row2 = table.insertRow(1);
		 var x1 = row1.insertCell(0);
		 var x2 = row1.insertCell(1);
		 var x3 = row1.insertCell(2);
		 var x4 = row1.insertCell(3);
		 var y1 = row2.insertCell(0);
		 x1.innerHTML="加速度系数";
		 x2.innerHTML="<input type='text' class='input-msmall' value='0.5'>";
		 x3.innerHTML="位移系数";
		 x4.innerHTML="<input type='text' class='input-msmall' value='0.5'>	";
		 y1.innerHTML="<input  class='btn' type='button' value='读取并运行'>";
		 
	 }
	 function sing(){
		 var table = document.getElementById("paramtertable");
		var rowNum = table.rows.length;
		if(rowNum != 0){
			for (i=0;i<rowNum;i++){
        	 table.deleteRow(i);
			 rowNum=rowNum-1;
             i=i-1;
     		}
		}
		  var trow = new Array();
		  var cells = new Array();
		  for(i=0;i<4;i++){
			  trow[i] = table.insertRow(i);
			  for(j=0;j<7;j++){
				   trow[i].insertCell(j);
			  }
		  }
		 //var colums = table.rows[0].cells.length;
		 table.rows[0].cells[0].innerHTML="#";
		 table.rows[1].cells[0].innerHTML="幅值"
		 table.rows[2].cells[0].innerHTML="#"
		 table.rows[3].cells[0].innerHTML="速度"
		 table.rows[0].cells[1].innerHTML="纵倾";
		 table.rows[0].cells[2].innerHTML="横移";
		 table.rows[0].cells[3].innerHTML="航向";
		 table.rows[0].cells[4].innerHTML="横摇";
		 table.rows[0].cells[5].innerHTML="前冲";
		 table.rows[0].cells[6].innerHTML="升降";
		 for(i=1;i<7;i++){
			 table.rows[1].cells[i].innerHTML="<input type='text' class='input-msmall' value='0'>";
		 }
		 for(j=1;j<4;++j){
			 table.rows[2].cells[j].innerHTML="°/s";
			 table.rows[2].cells[j+3].innerHTML="mm/s";
		 }
		 for(l=1;l<7;l++){
			 table.rows[3].cells[l].innerHTML="<input type='text' class='input-msmall' value='10'>";
		 }
		 
	 }
	 function mog(){
		 var table = document.getElementById("paramtertable");
		var rowNum = table.rows.length;
		if(rowNum != 0){
			for (i=0;i<rowNum;i++){
        	 table.deleteRow(i);
			 rowNum=rowNum-1;
             i=i-1;
     		}
		}
		var row = table.insertRow(0);
		var row1 = table.insertRow(1);
		var y = row.insertCell(0);
		var z = row.insertCell(1);
		var m = row.insertCell(2);
		var y1 = row1.insertCell(0);
		var z1 = row1.insertCell(1);
		var m1 = row1.insertCell(2);
		y.innerHTML="<input type='checkbox'  name='mog' class='radio' value='1'/>1号缸"
		z.innerHTML="<input type='checkbox'  name='mog' class='radio' value='2'/>2号缸"
		m.innerHTML="<input  class='radio' name='mog' type='checkbox' value='3'/>3号缸"
		y1.innerHTML="<input  class='radio' name='mog' type='checkbox' value='4'/>4号缸"
		z1.innerHTML="<input  class='radio' name='mog' type='checkbox' value='5'/>5号缸"
		m1.innerHTML="<input  class='radio' name='mog' type='checkbox' value='6'/>6号缸"
	 }