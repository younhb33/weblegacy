/*해당 함수를 외부에서 사용할 수 있도록 내보내는 역할 */

export function zzz(){
	console.log("ES7~~!");
}
export function aaa(){
	var user = "홍길동";
	console.log(user + "포인트 1500 입니다.");
}
export function bbb(){ //외부에서 호출이 가능한 (import)함수
	alert("환영합니다.");
	ccc();
}
function ccc(){ //내부함수
	console.log("ccc함수");
}