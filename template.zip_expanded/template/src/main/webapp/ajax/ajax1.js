
//ajax => get통신
function ajax_gopage(){
	//1번째 방식
	var ajax,result;
	
	//ajax 동기화 통신 : Back-end에 값을 받아야만 처리를 할 수 있고 그 다음 결과를 작동시키는 원리
	//ajax 비동기화 통신 : Back-end에 값을 받지 않아도 다음 처리할 항목을 전송시킬 수 있음
	//var data = "1,2,3,4"; //문자열 형태
	
	//배열 형태
	var data = new Array(); //빈 배열
	data[0] = "홍길동";
	data[1] = "강감찬";
	data[2] = "유관순";
	
	ajax = new XMLHttpRequest();
    ajax.onreadystatechange = function(){
      if(ajax.readyState == 4){
         if(ajax.status == 200){
            console.log(this.response); //this.response: Back-end값을 무조건 출력
			}
		}
	}
	//백엔드랑 얘기해서 false : 동기화, true : 비동기화(아예 false/true 안쓰는 경우 기본: true)
	ajax.open("GET","./ajax1.do?product="+data,true); // false : 동기화, true : 비동기화 (default)
  	ajax.send();

}