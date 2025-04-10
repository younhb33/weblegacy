<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX (POST) - FormData </title>
</head>
<body>
<input type="button" value="전송" onclick="ajax_gopage()"><br>
<input type="button" value="전송 form키가 다를경우" onclick="ajax_gopage2()">
</body>
<!-- 
POST 값 전송
2. FormData를 이용하여 데이터 전송
3. JSON.stringify를 이용하여 데이터 전송

 -->
<script src="./ajax3.js?v=3"></script>
</html>