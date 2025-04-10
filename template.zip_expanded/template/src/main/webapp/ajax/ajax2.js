function ajax_gopage(){
	var ajax, result;
	
	var data = new Array();
	data[0] ="홍길동";
	data[1] ="강감찬";
	data[2] ="이순신";
	
	ajax = new XMLHttpRequest();
	ajax.onreadystatechange=function(){
		if(ajax.readystate == 4){
			if(ajax.status == 200){
				console.log(this.response);
			}
		}
	}
	ajax.open("POST","./ajax2.do",true);
	//post전송시 해당 content-type을 설정하여 전송
	ajax.setRequestHeader("content-type","application/x-www-form-urlencoded");
	ajax.send("product="+data+"&person=hong"); //해당 key name명 + 배열 데이터
	
}
	