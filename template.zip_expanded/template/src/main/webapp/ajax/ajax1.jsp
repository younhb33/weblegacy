<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX (GET) - 문자열, Array를 이용하여 데이터 전송 </title>
</head>
<body>
<!-- 
ajax : 현재 페이지에서 값을 바꾸는 것, 즉 경로가 바뀌지 않음
1. ajax => form 태그로 전송하지 않습니다. <form></form> (X)
2. FormData함수를 통하여 전송은 합니다.
3. ajax는 브라우저에 URL이 변경되지 않습니다.
4. Back-end가 무조건 결과값을 Front-end에게 줘야 함(컨트롤러에서 Model사용하면 안됨 form태그가 아니니까)
 -->
<input type="button" value="전송" onclick="ajax_gopage()">
</body>
<!-- 
ajax GET통신(선택된 상품만 Back-end로 전송)
1. 같은 이름으로 문자열로 보내면 될까요? => ./ajax1.do?product=1,2,3,4,5
:product라는 이름으로 1,2,3,4,5보내도 되는지
2. 키를 이용하여 배열로 보내면 될까요? => product=['1','2','4']
: 배열로 보내기
 -->
<script src="./ajax1.js?v=2"></script>
</html>