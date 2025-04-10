export class ecma_ajax{
	//배열 생성 후 POST 전송 
	ajax_arr(){
		//this.arr = {mid:"hong",mname:"홍길동"}; //얘나
		//this.arr =["hong","kim","park"]; //얘나 잘 나옴
		fetch("./ajax11.do",{
			method : "POST",
			/* //Backend : @RequestBody로 받아야 함 => JSONArray, JSONObject
			headers: {"content-type":"application/json"},
			body : JSON.stringify(this.arr)
			*/
			
			
			
			/*//Backend : @RequestParam 또는 @ModelAttribute로 처리 가능
			headers: {"content-type":"application/x-www-form-urlencoded"},
			body : "mid=hong&mname=홍길동"
			*/
			
			//new URLSearchParams : 키배열, 원시배열을 구성하여 Ajax로 데이터를 전송시키는 방식
			headers : {"content-type":"application/x-www-form-urlencoded"},
			body : new URLSearchParams({
				mid : "hong",
				mname : "홍길동",
				mage : 25,
				memail : "hong@nate.com"
			})
		}).then(function(aa){
			return aa.text();
		}).then(function(bb){
			console.log(bb);
		}).catch(function(error){
			console.log(error);
		});
	}

	
}