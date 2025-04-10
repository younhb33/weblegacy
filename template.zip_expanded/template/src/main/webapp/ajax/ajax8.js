//버튼 클릭시 클래스 미치 메소드를 호출
document.querySelector("#btn").addEventListener("click",function(){
	new ajax_network().ajax_get();
});

document.querySelector("#btn2").addEventListener("click",function(){
	new ajax_network2().ajax_idck();
});
//POST - AJAX
export class ajax_network2{
	
	ajax_idck(){
		this.userid = "hong";
		this.mid = "mid="+this.userid;	//name형태로 Back-end로 POST전송
		fetch("./ajax10.do",{	//이번엔 중괄호 추가
			method : "POST", 	//통신방법(POST)
			headers: {"content-type":"application/x-www-form-urlencoded"},	//headers를 이용하여 UTF-8로 언어셋 세팅
			body : this.mid	//body는 POST전송시에 무조건 사용하게 됩니다.
		}).then(function (aa){
			return aa.text();
		}).then(function(bb){
			console.log(bb);
		}).catch(function(error){
			console.log(error);
		});
	}	
	
	
}



//GET - AJAX
export class ajax_network{
	
	ajax_get(){
		
		this.mid = "홍길동"; //가상 변수
		//fetch : ECMA에서 부터 사용을 했으며, XMLHttpRequest => fetch로 변환
		fetch("./ajax9.do?mid="+this.mid) //GET통신
		.then(function(aa){	//Back-end에서 결과값을 받는 함수
			return aa.text();	//text(), json() => JSON.parse()
		})
		.then(function(bb){	//Front-end에서 return 된 결과함수를 출력하는 함수
			console.log(bb);
		})
		.catch(function(error){	//예외처리로 오류 발생시 출력되는 역할
			console.log(error);
		});
	
	}
	
}