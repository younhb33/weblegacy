<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX - Jquery로 전송(POST) - JSON.stringify(DTO 연결)</title>
</head>
<script src="./jquery.js?v=1"></script>
<script>
$(function () {
	//이렇게 만들어주는 이유: Back-end가 DTO형태 기준으로 정보를 요청하였을 경우
	var $userdata = "pd1=홍길동&pd2=이순신&pd4=유관순";
	
	$("#btn").click(function() {
		$.ajax({
			url : "./ajax7.do",
			cache : false,
			type : "POST",
			dataType : "HTML",
			data : $userdata,  		//JSON.stringify 미사용
			/*
			contentType: "application/json", 
			data : JSON.stringify({
				"pd1" : "홍길동",
				"pd3" : "이순신",
				"pd4" : "유관순"
			}),
			*/
			success : function($result) {
				console.log($result)
			},error : function() {
				
			}
		});
	});
});


</script>
<body>
<input type="button" value="전송" id="btn">
</body>
</html>