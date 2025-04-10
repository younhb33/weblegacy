<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete, PUT - AJAX</title>
<script src="./jquery.js"></script>
</head>
<body>
   <input type="button" value="JS삭제" onclick="ajax_del()">
   <input type="button" value="ES삭제" id="ajax_del">
</body>
<script>
//ECMA -> Array() => @RequestBody
document.querySelector("#ajax_del").addEventListener("click",function(){
		this.arr = ["3","6","9","10"];

	
	   fetch("./ajax13/a123456",{
	      method : "DELETE",
	      headers : {"content-type":"application/json"},
	      body : JSON.stringify(this.arr)
	   }).then(function(aa){ // Back-end에서 결과값을 받는 함수
	      return aa.text(); // text(), json() => JSON.parse()
	   })
	   .then(function(bb){ // Front-end에서 return된 결과 함수를 출력하는 함수
	      console.log(bb);
	   }).catch(function(error){
	      console.log(error);
	   })
	});








//FormData() => @RequestBody
function ajax_del(){
   var formdata = new FormData();
   formdata.append("midx",5);
   formdata.append("midx",9);
   formdata.append("midx",12);
   //console.log(formdata.getAll("midx"));
   
   var http,result;
   http = new XMLHttpRequest();
   http.open("DELETE","./ajax13/a123456",false);
   http.setRequestHeader("content-type","application/json");
   http.onload = function() {
      console.log(this.response);
   };
   http.onerror = function() {
      console.log("통신오류");
   };
   http.send(formdata);
}
</script>
</html>






