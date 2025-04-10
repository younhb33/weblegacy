<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX - Jquery로 전송(GET)- JSON.stringify를 이용한 전송</title>
<script src="./jquery.js?v=1"></script>
<script>
$(function() {
	$("#btn").click(function() {
		var $ajaxdata = new Array();
		$ajaxdata[0] = "홍길동";
		$ajaxdata[1] = "이순신";
		$ajaxdata[2] = "장보고";
		
		var $fdata = JSON.stringify($ajaxdata); //실제 JSON 배열화 
		//JSON.stringify => {[]}배열화
		//encodeURI : UTF-8 인코딩 함수 표준 문자로 변환
		$.ajax({
			//encodeURI
			url : "./ajax5.do?no="+encodeURI($fdata),
			cache:false,	//cache메모리 사용 유무/
			type: "GET",	//전송방식
			dataType:"html",	//전송방식 형태(HTML, TXT, XML, JSON)
			async : true,	//true(비동기)/false(동기화)
			success:function($result){
				console.log($result);
			},error:function(){
				console.log("Back-end와 통신오류 발생!");
			}
		});
	});
});

</script>
</head>
<body>
<input type="button" value="전송" id="btn">

</body>
</html>