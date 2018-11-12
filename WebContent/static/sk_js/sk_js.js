
var id = $("#ID"), pass = $("#PASS"), pass2 = $("#PASS2"), nameForm = $("#NAME"), phone = $("#PHONE"), email = $("#EMAIL"), addr = $("#ADDR"), i;

$(document).ready(function() {
	$("#checkBtn").click(memberCheck)
})
$(document).ready(function() {
	$("#sBtn").click(formCheck)
});

$(document).ready(function() {
	$("#searchBtn").click(searchCheck)
});


function searchCheck() {
	if ($("#searchName").val() == "") {
		return alert("사원이름을 입력해주세요");

	}
	loadMemberList();
}

function memberCheck() {
	if (id.val() == "") {
		return alert("사원번호를 입력해주세요");
	}
	;

	if (nameForm.val() == "") {
		return alert("이름을 입력해 주세요 ");
	}

	loadWorkerNumber();

}


function detailName(i){
	var xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var text = this.responseText;
			var textList = text.split(",");
			// textList에는 사원번호, 이름, 부서, 직책, 입사일, 퇴사일, 재직여부,
			//메모, 관리자, 핸드폰, 자택, 이메일, 주소 순으로 들어있다.
			$("#worker_number").val(textList[0]);
			$("#name").val(textList[1]);
			$("#division").val(textList[2]);
			$("#posion").val(textList[3]);
			$("#join_date").val(textList[4]);
			$("#leave_date").val(textList[5]);
			$("#active").val(textList[6]);
			$("#memo").val(textList[7]);
			$("#authority").val(textList[8]);
			$("#phone").val(textList[9]);
			$("#phone2").val(textList[10]);
			$("#e_mail").val(textList[11]);
			$("#adress").val(textList[12]);


		}

	};

	xhttp.open("POST", "detail.do", true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send("name=" + $("#searchName").val()+"&num="+i);
	
}
function loadMemberList() {
	var xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			$("#memberList").html(this.response);

		}

	};

	xhttp.open("POST", "search.do", true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send("name=" + $("#searchName").val());
}

function loadWorkerNumber() {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			$(".checkText").text(this.responseText);
			if (this.responseText == "인증되었습니다") {
				$(".checkInput").attr('readonly', true);
				$(".input").removeAttr('readonly');
				$(".input").css("background-color", "white");
			}
		}

	};

	xhttp.open("POST", "id_check.do", true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send("worker_number=" + $("#ID").val() + "&name=" + $("#NAME").val());

}

function formCheck() {
	// //공백체크

	;
	if (pass.val() == "") {
		return alert("비밀번호를 입력해주세요");
	}
	;
	if (pass2.val() == "") {
		return alert("비밀번호 확인을 입력해주세요");
	}

	// //비밀번호 체크
	if (pass.val().length < 8) {
		return alert("비밀번호를 8자리 이상 입력해주세요")
	} else if (pass2.val().length < 8) {
		return alert("비밀번호 확인을 8자리 이상 입력해주세요")
	}
	;
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

	// //전화번호체크
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
