document.querySelector("#btn").addEventListener("click",function(){
	new myinfos().ajax_data();
});
//var, let(동일한 변수명을 사용못함), const(상수)
export class myinfos{
	
	ajax_data(){
		//사용자가 입력한 아이디 값을 가져오는 코드
		let mid = document.querySelector("#mid").value;
		this.arr = new Array();	//빈배열을 생성
		this.arr[0] = mid;	//배열에 아이디를 적용
		this.arr[1] = "apink@naver.com";	//이메일
		this.arr[2] = "01010041004";	//전화번호
		this.arr[3] = "서울시 종로구";	//주소
		
		fetch("./ajax12.do/patch_myinfo",{
			method : "PATCH",
			headers : {"content-type":"application/json"},
			body : JSON.stringify(this.arr)
		}).then(function(aa){
			return aa.text(); //Back-end 결과값 받음
		}).then(function(bb){
			console.log(bb);	//결과값 출력
		});
	}
}