document.querySelector("#btn").addEventListener("click",function(){
	new box().abc("hong"); //클래스 호출 및 메소드 호출
	new box2().abc("kim");
	new box2().bbb()
});


class box{ //클래스 
	abc(data){ //메소드
		//this.msg = 인스턴스 상태로 유지
		//let msg = 함수지역 변수로 충분
		this.msg = data + "데이터 확인";
		console.log(this.msg); 
	}
}
var msg = "테스트!!!";

class box2 extends box{
	bbb(){
		console.log("상송받은 클래스 bbb메소드")
	}
}