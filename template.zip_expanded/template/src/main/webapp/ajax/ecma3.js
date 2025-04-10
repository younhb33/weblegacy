//addEventListener : 이벤트 핸들링 함수이며, 페이지 로드시 무조건 작동하는 함수
//(굳이 export를 안 써도 우선순위이기 때문에) 하지만 자바스크립트 안에는 두면 안됨 웬만하면jsp 안에 넣기
document.querySelector("#btn").addEventListener("click",function(){
	//frm.search.value
	//querySelector : id(#), class(.)를 위주로 오브젝트를 로드할 수 있음
	let search = document.querySelector("#msearch").value;
	console.log(search);
	new logins().search_ck(search);
});

export class logins{ //외부로 호출 할 수 있는 class
	
	constructor(){	//constructor : 클래스를 호출시 작동하는 즉시실행 메소드
		console.log("테스트 입니다.");
	}
	agree_data(a,b){	//setter
		this.data = a;
		this.data2 = b;
	}
	get agree_data(){	//getter(get을 사용하는 메소드)
		return this.data;
	}
	
	
	search_ck(word){
		if(word == ""){
			alert("검색어를 입력하세요");
		}else{
			location.href = "http://nate.com"; //GET통신 무조건
		}
	}
	
	zzz(){	 //method
		let data = new Array();
		data[0] ="a1";
		data[1] ="a2";
		console.log(data);
	}
}