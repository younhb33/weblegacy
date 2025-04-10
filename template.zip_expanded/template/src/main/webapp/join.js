export class member_ck{
	//아이디 체크
	ajax_idck(){
		let id = frm.MID.value.replaceAll(" ","");
		if(id==""){
			alert("아이디를 입력하셔야 합니다.");
			frm.MID.focus();
		}
		else{
			fetch("./login_idck.do",{
				method : "POST",
				headers : {"content-type" : "application/x-www-form-urlencoded"},
				body : "id=" + frm.MID.value
			}).then(function(aa){
				return aa.text();
			}).then(function(bb){
				if(bb=="ok"){
					alert("사용가능한 아이디 입니다.");
					frm.MID.readOnly = true;
					document.querySelector("#ck").value = "ok";
				}
				else{
					alert("이미 사용중인 아이디 입니다.");
					frm.MID.value = "";
				}
			}).catch(function(error){
				console.log(error);
			});
		}
	}
	//회원가입
	join_okpage(){
		if(document.querySelector("#ck").value != "ok"){
			alert("아이디 입력 및 아이디 중복 체크를 하셔야 합니다.");
		}else if(frm.MPASS.value==""){
			alert("패스워드를 입력하셔야 합니다.");
		}else{
			frm.submit();	
		}
	}

}