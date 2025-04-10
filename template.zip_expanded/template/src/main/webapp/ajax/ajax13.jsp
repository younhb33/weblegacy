<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax - @PutMapping => DTO로 처리</title>
<!--  JQuery -->
<script src="./jquery.js"></script>
<script>
	$(function() {
		$("#jqbtn").click(function() {
			var data = {
					pd1: $("#pd1").val(),
					pd2: $("#pd2").val(),
					pd3: $("#pd3").val(),
					pd4: $("#pd4").val(),
					pd5: $("#pd5").val()
				};
			
			
			//$("#pd1").val(); =>사용자가 입력한 값을 가져옴
			$.ajax({
				url : "./ajax14/a123456",
				cache : false,
				type : "PUT",
				contentType : "application/json", // 전송 형식은 JSON
				data : JSON.stringify(data),
				success: function($data) {
					if ($data == "ok") {
						alert("정상적으로 데이터가 입력되었습니다.");
						location.reload();
					} else {
						alert("데이터 입력값 오류 발생!");
					}
				},
				error : function() {
					console.log("통신 오류 발생!"); // 오류 발생 시
				}
			});
		});
	});
</script>
</head>
<body>
<input type="text" id="pd1"><br>
<input type="text" id="pd2"><br>
<input type="text" id="pd3"><br>
<input type="text" id="pd4"><br>
<input type="text" id="pd5"><br>
<input type="button" value="Jquery 전송" id="jqbtn"><br>
<input type="button" value="AJAX 전송" onclick="ajax_put()"><br>
<input type="button" value="ES AJAX 전송" id="btn"><br>
</body>
<!-- JS -->
<script>
function ajax_put() {
	//eval() => 문자 형태를 Script화 시켜주는 역할 함수
	var a = 1;
	while(a < 6){
		eval("var pd" + a + "= document.getElementById('pd'+a).value");
		a++;
	}
	//키배열 pd1 ~ pd5
	var keyarray = {
		pd1 : pd1,
		pd2 : pd2,
		pd3 : pd3,
		pd4 : pd4,
		pd5 : pd5
	};
	var json = JSON.stringify(keyarray);
	console.log(json);
	
	var http,result;
	http = new XMLHttpRequest();
	http.open("PUT","./ajax14/a123456",false);
	//http.setRequestHeader("content-type","application/x-www-form-urlencoded"); //얘도 되고
	http.setRequestHeader("content-type","application/json");//얘도 됨
	 http.onload = function() {
	       result = this.response;
			console.log(result);
	       if(result == "ok"){
	    	   alert("저장 완료");
	    	   //location.href.reload();	// reload 오류 발생가능
	    	   location.reload();
	    	   //window.location.reload();
	       }else{
	    	   alert("저장 실패");
	       }
	}
	http.onerror = function() {
		console.log("통신오류!!");
	}
	http.send(json);
	//http.send(keyarray);

}
</script>

<!-- ES -->
<script type="module">
import {api_insert} from "./ajax13.js";
document.querySelector("#btn").addEventListener("click",function(){
	new api_insert().api_put();
});
</script>

</html>