<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    Date today = new Date();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>간편 회원가입</title>
</head>
<body>
<form id="frm" method="post" action="./joinok.do">
<input type="hidden" id="ck" value="">
<input type="hidden" name="MCODE" value="1"> <!-- 1:자회사 회원가입, 2:카카오, 3:네이버 -->
<input type="hidden" name="MJOIN" value="WEB"> <!-- WEN, KAKAO, NAVER -->
아이디 : <input type="text" name="MID">
<input type="button" value="중복체크" id="idck"><br>
이름 : <input type="text" name="MNAME"><br>
닉네임 : <input type="text" name="MNICK"><br>
패스워드 : <input type="password" name="MPASS"><br>
이메일 : <input type="text" name="MEMAIL"><br>
연락처 : <input type="text" name="MHP"><br>
<input type="button" value="회원가입" id="join">
</form>
<script>
let kid = sessionStorage.getItem("mid");
let knick = sessionStorage.getItem("mnick");
if(kid != ""){
	document.querySelector("#ck").value = "ok";
	document.querySelector("#idck").style.display = "none";
	frm.MCODE.value = "2";
	frm.MJOIN.value = "KAKAO";
	frm.MID.value = kid;
	frm.MNICK.value = knick;
	frm.MPASS.value = kid;
	
	frm.MID.readOnly = true;
	frm.MNICK.readOnly = true;
	frm.MPASS.readOnly = true;
}
</script>

<script type="module">
import {member_ck} from "./join.js?v=<%=today%>";
document.querySelector("#idck").addEventListener("click",function(){
	new member_ck().ajax_idck();
});

document.querySelector("#join").addEventListener("click",function(){
	new member_ck().join_okpage();	
});
</script>



</body>

</html>