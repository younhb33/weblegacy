<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 및 외부 API 로그인 방식(Kakao) - ECMA</title>
</head>
<body>
<form id="frm" method="post" action="./ajax/web_loginok.do">
<input type="hidden" name="code" value="1">
아이디 : <input type="text" name="mid"><br>
패스워드 : <input type="password" name="mpass"><br>
<input type="submit" value="로그인">
</form><br><br>
<img src="./ajax/kakao_login.png" onclick="loginWithKakao()">
<p id="token-result"></p>
</body>
<script src="https://t1.kakaocdn.net/kakao_js_sdk/2.7.4/kakao.min.js" integrity="sha384-DKYJZ8NLiK8MN4/C5P2dtSmLQ4KwPaoqAfyA/DfmEc1VDxu4yyC7wy6K1Hs90nka" crossorigin="anonymous"></script>
<script>
  Kakao.init('d18830751fbb55c90ecad090ab45f41c'); // 사용하려는 앱의 JavaScript 키 입력
</script>
<script>
  function loginWithKakao() {
    Kakao.Auth.authorize({
      redirectUri: 'http://localhost:8080/myapp/ajax/web_loginok.do', //설정한 redirectUri 입력 
    });
  }
  // 아래는 데모를 위한 UI 코드입니다.
  displayToken()
  function displayToken() {
    var token = getCookie('authorize-access-token');

    if(token) {
      Kakao.Auth.setAccessToken(token);
      Kakao.Auth.getStatusInfo()
        .then(function(res) {
          if (res.status === 'connected') {
            document.getElementById('token-result').innerText
              = 'login success, token: ' + Kakao.Auth.getAccessToken();
          }
        })
        .catch(function(err) {
          Kakao.Auth.setAccessToken(null);
        });
    }
  }
  function getCookie(name) {
    var parts = document.cookie.split(name + '=');
    if (parts.length === 2) { return parts[1].split(';')[0]; }
  }
</script>


<script>
//ECMA => submit 사용시 return, return false가 없음
document.querySelector("#frm").addEventListener("submit",function(e){
	e.preventDefault(); //강제 정지
	if(frm.mid.value==""){
		alert("아이디를 입력하세요");
	}else if(frm.mpass.value==""){
		alert("패스워드를 입력하세요");
	}else{
		frm.submit();
	}
});

</script>
</html>