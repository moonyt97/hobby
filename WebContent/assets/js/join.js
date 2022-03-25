/**
 * 
 */
function idCheck() {
	if (document.joinForm.memberID.value == "") {
		alert('아이디를 입력해주세요');
		document.joinForms.memberID.focus();
		return;
	} else {
		var url = "/Idcheck.do?memberID=" + document.joinForm.memberID.value;
		window.open(url, "", "width=500, height=200");
	}
}

function idok(memberID) {
	opener.joinForm.memberID.value = document.joinForm.memberID.value;
	self.close();
}


function checkPW() {
	var pw1 = document.joinForm.memberPassword.value;
	var pw2 = document.joinForm.memberPassword2.value;
	if(pw1==pw2){
		document.getElementById('passwordCheck').innerHTML="비밀번호가 일치합니다."
		document.joinForm.joinBtn.style.visibility="visible"
	}else{
		document.getElementById('passwordCheck').innerHTML="비밀번호가 일치하지않습니다."
			document.joinForm.joinBtn.style.visibility="hidden"
	}
}

// 영어로만 입력 받기
function handleOnInput(e) {
	e.value = e.value.replace(/[^a-zA-Z0-9]*$/ig, '')
}