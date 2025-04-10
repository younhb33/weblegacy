<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ECMA - ES7 ~ 기초코드2 (class 및 외부 js로드)</title>
</head>
<body>
<form id="frm">
검색 : <input type="text" name="search" id="msearch"><br>
<button type="button" id="btn">검색</button>
</form>
</body>
<script type="module">
import{ zzz } from "./ecma2.js";	//zzz함수를 로드
import{ logins } from "./ecma3.js";	//logins라는 class를 로드
zzz();
new logins().zzz();





</script>
</html>