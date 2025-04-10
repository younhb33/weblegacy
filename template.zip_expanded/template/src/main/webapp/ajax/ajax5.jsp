<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX - Jquery로 전송(POST) - JSON.stringify를 이용한 전송</title>
</head>
<script src="./jquery.js?v=1"></script>
<script>
$(function () {
	
	var $data = new Array();
	$data[0] = "홍길동";
	$data[1] = "이순신";
	$data[2] = "장보고";
	
	//json.stringify 전송 : 대표키로 보낼까요? 대표키 없이 보낼까요?
	$("#btn").click(function() {
		$.ajax({
			url : "./ajax6.do",
			cache : false,
			type : "POST",
			dataType : "HTML",
			contentType: "application/json; charset=utf-8",
			//data : JSON.stringify($data), //대표키 없는 상태에서 보내기
			data : JSON.stringify({userdata : $data}), //대표키가 있는 상태에서 보내기
			async : true,
			success : function($result) {
				console.log($result)
			},
			error : function($error) {
				console.log($error);
			}
		});
	});
});


</script>
<body>
<input type="button" value="전송" id="btn">
</body>
</html>