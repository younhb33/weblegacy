export class api_insert{
	//JSON.stringify 필수
	api_put(){
		fetch("./ajax14/a123456",{
			method : "PUT",
			headers : {"content-type" : "application/json"},
			body : JSON.stringify({
				pd1 : document.querySelector("#pd1").value,
				pd2 : document.querySelector("#pd2").value,
				pd3 : document.querySelector("#pd3").value,
				pd4 : document.querySelector("#pd4").value,
				pd5 : document.querySelector("#pd5").value
			})
		}).then(function(aa){
			return aa.text();
		}).then(function(bb){
			if(bb == "ok"){
				alert("정상적으로 데이터가 입력되었습니다.");
				location.reload();
			}else{
				alert("데이터 입력값 오류 발생!");
			}
		}).catch(function(error){
			console.log(error);
		});
	}
}