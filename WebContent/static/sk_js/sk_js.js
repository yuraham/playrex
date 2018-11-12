
var id = $("#ID"), pass = $("#PASS"), pass2 = $("#PASS2"), nameForm = $("#NAME"), phone = $("#PHONE"), email = $("#EMAIL"), addr = $("#ADDR"), i;

//서버 연결 변수
var memberNumber = $("#worker_number"),
	memberName = $("#name"),
	memberDivision = $("#division"),
	memberPosition = $("#position"),
	memberJoinDate = $("#join_date"),
	memberLeaveDate = $("#leave_date"),
	memberActive = $("#active"),
	memberMemo = $("#memo"),
	memberAuthority = $("#authority"),
	memberPhone = $("#phone"),
	memberPhone2 = $("#phone2"),
	memberEmail = $("#e_mail"),
	memberAdress = $("#address");





$(document).ready(function () {
	$("#checkBtn").click(memberCheck);
	$("#sBtn").click(formCheck);
	$("#searchBtn").click(searchCheck);
	$("#updateBtn").click(updateForm);
})



function resetButn() {
	detailName($("#worker_number").val());
	$(".update_box").css("background-color", "lightgray");
	$(".update_box").attr('readonly', true);
	$(".plusBtn").text("");
	$("#updateBtn").val("수정");

}

function updateForm() {
	if ($("#worker_number").val() != "") {
		$(".update_box").css("background-color", "white");
		$(".update_box").removeAttr('readonly');

		$(".changeBtn").html("<input type=\"button\" value=\"수정완료\" id=\"changeBtn\" />");

		// $("#updateBtn").val("수정완료");
		$("#changeBtn").click(update_submit);
		$(".plusBtn").html("<input type=\"button\" value=\"취소\" id=\"resetBtn\" onclick=\"resetButn()\"/>");
	}
}

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


function update_submit() {
	var xhttp = new XMLHttpRequest();


	xhttp.onreadystatechange = function () {
		if (this.readyState == 4 && this.status == 200) {
			var text = this.responseText;
			$(".msg").text(text);
			detailName($("#worker_number").val());
			$(".update_box").css("background-color", "lightgray");
			$(".update_box").attr('readonly', true);
			$(".plusBtn").text("");
			$(".changeBtn").html("<input type=\"button\" value=\"수정\" id=\"updateBtn\" />");

			$("#updateBtn").click(updateForm);
			// $("#updateBtn").removeAttr("onclick",false);
			



		}
	}
	xhttp.open("POST", "update.do", true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send("worker_number=" + memberNumber.val() + "&name=" + memberName.val() + "&division=" + memberDivision.val() + "&position=" + memberPosition.val() +
		"&join_date=" + memberJoinDate.val() + "&leave_date=" + memberLeaveDate.val() + "&active=" + memberActive.val() + "&memo=" + memberMemo.val() +
		"&authority=" + memberAuthority.val() + "&phone=" + memberPhone.val() + "&phone2=" + memberPhone2.val() + "&e_mail=" + memberEmail.val() +
		"&address=" + memberAdress.val());

}

function detailName(i) {
	var xhttp = new XMLHttpRequest();


	xhttp.onreadystatechange = function () {
		if (this.readyState == 4 && this.status == 200) {
			var text = this.responseText;
			var textList = text.split(",");
			// textList에는 사원번호, 이름, 부서, 직책, 입사일, 퇴사일, 재직여부,
			//메모, 관리자, 핸드폰, 자택, 이메일, 주소 순으로 들어있다.
			memberNumber.val(textList[0]);
			memberName.val(textList[1]);
			memberDivision.val(textList[2]);
			memberPosition.val(textList[3]);
			memberJoinDate.val(textList[4]);
			memberLeaveDate.val(textList[5]);
			memberActive.val(textList[6]);
			memberMemo.val(textList[7]);
			memberAuthority.val(textList[8]);
			memberPhone.val(textList[9]);
			memberPhone2.val(textList[10]);
			memberEmail.val(textList[11]);
			memberAdress.val(textList[12]);


		}

	};

	xhttp.open("POST", "detail.do", true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send("name=" + $("#searchName").val() + "&num=" + i);

}
function loadMemberList() {
	var xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function () {
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
	xhttp.onreadystatechange = function () {
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
