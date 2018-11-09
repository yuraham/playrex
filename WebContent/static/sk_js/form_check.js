


var id = $("#ID"), pass = $("#PASS"), pass2 = $("#PASS2"), nameForm = $("#NAME"), phone = $("#PHONE"), email = $("#EMAIL"), addr = $("#ADDR");

$(document).ready(function () {
	$("#checkBtn").click(memberCheck)
})
$(document).ready(function () {
	$("#sBtn").click(formCheck)
})

function memberCheck(){
	if (id.val() == "") {
		return alert("사원번호를 입력해주세요");
	}
	;

	if (nameForm.val() == "") {
		return alert("이름을 입력해 주세요 ");
	}

	loadWorkerNumber();

	

}
function loadWorkerNumber(){
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function(){
		if(this.readyState ==4 && this.status ==200 ){
			$(".checkText").innerHTML = this.responseText;
		}
	};
	
	xhttp.open("POST", "id_check.do", true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send("worker_number="+$("#ID").val()+"&name="+$("#NAME"));

}

function formCheck() {
	////공백체크
	
	;
	if (pass.val() == "") {
		return alert("비밀번호를 입력해주세요");
	}
	;
	if (pass2.val() == "") {
		return alert("비밀번호 확인을 입력해주세요");
	}

	////비밀번호 체크
	if (pass.val().length < 8) {
		return alert("비밀번호를 8자리 이상 입력해주세요")
	} else if (pass2.val().length < 8) {
		return alert("비밀번호 확인을 8자리 이상 입력해주세요")
	};
	if (pass.val() != pass2.val()) {
		return alert("비밀번호가 일치하지 않습니다.")
	}


	if (email.val() == "") {
		return alert("이메일을 입력해주세요");
	}
	if (email.val().indexOf("@") == -1) {
		return alert("이메일 형식이 잘못되었습니다.")
	}


	if (addr.val() == "") {
		return alert("주소를 입력해주세요 ")
	}






	////전화번호체크
	var phoneNum = Number($("#PHONE").val());
	if (phone.val() == "") {
		return alert("전화번호를 입력해주세요 ")
	}

	if (phone.val().indexOf("-") > -1) {
		return alert("전화번호에 '-'를 입력할수 없습니다.");

	}
	if (isNaN(phoneNum)) {
		return alert("전화번호는 숫자만 입력해주세요 ");

	}

	$("form").submit();
}
