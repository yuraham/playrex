var id = $("#ID"), pass = $("#PASS"), pass2 = $("#PASS2"), nameForm = $("#NAME"), phone = $("#PHONE"), phone2 = $("#PHONE2"), email = $("#EMAIL"), addr = $("#ADDR"), i;

// 서버 연결 변수
var memberNumber = $("#worker_number"), memberName = $("#name"), memberDivision = $("#division"), memberPosition = $("#position"), memberJoinDate = $("#join_date"), memberLeaveDate = $("#leave_date"), memberActive = $("#active"), memberMemo = $("#memo"), memberAuthority = $("#authority"), memberPhone = $("#phone"), memberPhone2 = $("#phone2"), memberEmail = $("#e_mail"), memberAdress = $("#address");

var oldDiv, oldPos, oldAct;

$(document).ready(function() {
	$("#checkBtn").click(memberCheck);
	$("#sBtn").click(formCheck);
	$("#searchBtn").click(searchCheck);
	$("#updateBtn").click(updateForm);
	$("#memRegForm").click(insertMember);
	memberDivision.change(function() {
		changeValue(oldDiv)
	});
	memberPosition.change(function() {
		changeValue(oldPos)
	});
	memberActive.change(function() {
		changeValue(oldAct)
	});

})

function changeValue(old) {

	if (old == undefined) {
		old = ""
	}
	if (old == oldDiv) {
		if (confirm(memberName.val() + "님의 부서를 " + old + "팀에서 "
				+ memberDivision.val() + "팀으로 변경하시겠습니까?")) {
			return;

		} else {
			return memberDivision.val(old);
		}

	} else if (old == oldPos) {
		if (confirm(memberName.val() + "님의 직책을 " + old + "에서 "
				+ memberPosition.val() + "으로 변경하시겠습니까?")) {
			return;

		} else {
			return memberPosition.val(old);
		}
	} else if (old == oldAct) {
		if (old == 1) {
			var oldTxt = "재직중"
		} else {
			oldTxt = "퇴 사"
		}
		;
		if (memberActive.val() == 1) {
			var actTxt = "재직중"
		} else {
			actTxt = "퇴 사"
		}

		if (confirm(memberName.val() + "님의 재직여부를 " + oldTxt + "에서 " + actTxt
				+ "(으)로 변경하시겠습니까?")) {
			var date = new Date();
			var year = date.getFullYear();
			var month = date.getMonth() + 1;
			var day = date.getDate();
			if (actTxt == "퇴 사") {
				memberLeaveDate.val(year + "-" + month + "-" + day);
			} else {
				memberLeaveDate.val(null);
			}

		} else {
			return memberActive.val(old);
		}
	}
}

function managementNull() {
	if (memberNumber.val() == "") {
		return alert("사원을 선택해 주세요");
	}
	window
			.open(//배포할때 주소 변경  또는 로컬호스트 처리방법 찾아보기 
					'http://localhost:8080/PlayRex/sk_manager/management_list.do?worker_number='+memberNumber.val(),
					'인사기록',
					'width=700, height=500, toolbar=no, menubar=no, scrollbars=yes, resizable=yes')
}

function privateNull() {
	if (memberNumber.val() == "") {
		return alert("사원을 선택해 주세요");
	}
	window
			.open(
					'http://localhost:8080/PlayRex/sk_manager/private_list.do?worker_number='+memberNumber.val(),
					'개인기록',
					'width=700, height=500, toolbar=no, menubar=no, scrollbars=yes, resizable=yes')

}

function resetButn() {
	if (memberNumber.val() != "") {
		detailName($("#worker_number").val());
	}
	$(".update_box").css("background-color", "lightgray");
	$(".update_box").attr('readonly', true);
	memberName.attr('readonly', true);
	memberName.css("background-color", "lightgray");
	$(".plusBtn").text("");
	$(".changeBtn").html(
			"<input type=\"button\" value=\"수정\"	id=\"updateBtn\" />");
	$("#updateBtn").click(updateForm);
	$("#searchBtn").removeAttr('disabled');
	$("#memRegForm").removeAttr('disabled');
	$("#mangementList").removeAttr('disabled');
	$("#privateList").removeAttr('disabled');
	$("#searchName").removeAttr('disabled');
	memberDivision.attr("disabled", true);
	memberPosition.attr("disabled", true);
	memberActive.attr("disabled", true);
	// if (memberNumber.val() == "") {
	// 	memberDivision.val("");
	// }
	loadMemberList();

}

function updateForm() {
	if ($("#worker_number").val() != "") {
		// 다른버튼 안눌리게 하기
		$("#searchName").attr("disabled", true);
		$("#searchBtn").attr("disabled", true);
		$("#memRegForm").attr("disabled", true);
		$("#mangementList").attr("disabled", true);
		$("#privateList").attr("disabled", true);
		$(".list_num").attr("onclick", false);

		oldDiv = memberDivision.val();
		oldPos = memberPosition.val();
		oldAct = memberActive.val();
		$(".update_box").removeAttr('readonly');
		$(".update_box").css("background-color", "white");
		$(".update_box").removeAttr("disabled");
		$(".changeBtn").html(
				"<input type=\"button\" value=\"수정완료\" id=\"changeBtn\" />");
		$("#changeBtn").click(update_submit);
		$(".plusBtn")
				.html(
						"<input type=\"button\" value=\"취소\" id=\"resetBtn\" onclick=\"resetButn()\"/>");
		$("#resetBtn").click(resetButn);

	} else {
		alert("사원을 선택 해 주세요.")
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

function insertMember() {
	// $("#searchName").val("");
	$("#searchName").attr("disabled", true);
	$("#searchBtn").attr("disabled", true);
	$("#memRegForm").attr("disabled", true);
	$("#mangementList").attr("disabled", true);
	$("#privateList").attr("disabled", true);
	$(".list_num").attr("onclick", false);
	$(".input_box").val("");
	memberName.css("background-color", "white");
	memberName.removeAttr('readonly');
	memberDivision.css("background-color", "white");
	memberDivision.attr("disabled", false);// //
	memberPosition.css("background-color", "white");
	memberPosition.attr("disabled", false);
	memberMemo.css("background-color", "white");
	memberMemo.removeAttr('readonly');
	$(".changeBtn").html(
			"<input type=\"button\" value=\"등록완료\" id=\"insertBtn\" />");
	$("#insertBtn").click(insertFormcheck);
	$(".plusBtn")
			.html(
					"<input type=\"button\" value=\"취소\" id=\"resetBtn\" onclick=\"resetButn()\"/>");

}
function insertFormcheck() {
	if (memberName.val() == "") {
		return alert("이름을 입력해주세요")
	}
	if (memberDivision.val() == null) {
		return alert("부서를 선택해주세요")
	}
	if (memberPosition.val() == null) {
		return alert("직책을 선택해주세요")
	}
	insert_submit();
}

function insert_submit() {

	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var text = this.responseText;
			$(".msg").html(text);
			memberName.css("background-color", "lightgray");
			memberName.attr('readonly', true);
			memberDivision.css("background-color", "lightgray");
			memberDivision.attr('readonly', true);
			memberPosition.css("background-color", "lightgray");
			memberPosition.attr('readonly', true);
			memberMemo.css("background-color", "lightgray");
			memberMemo.attr('readonly', true);
			$("#searchBtn").removeAttr('disabled');
			$("#memRegForm").removeAttr('disabled');
			$("#mangementList").removeAttr('disabled');
			$("#privateList").removeAttr('disabled');
			$("#searchName").removeAttr('disabled');
			loadMemberList();
			$(".changeBtn").html(
					"<input type=\"button\" value=\"수정\" id=\"updateBtn\" />");
			$("#updateBtn").click(updateForm);
			$(".plusBtn").text("");
			memberDivision.attr("disabled", true);
			memberPosition.attr("disabled", true);

		}
	}

	xhttp.open("POST", "m_register.do", true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp
			.send("name=" + memberName.val() + "&division="
					+ memberDivision.val() + "&position="
					+ memberPosition.val() + "&memo=" + memberMemo.val());

}

function update_submit() {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var text = this.responseText;
			$(".msg").html(text);
			detailName($("#worker_number").val());
			$(".update_box").css("background-color", "lightgray");
			$(".update_box").attr('readonly', true);
			$("select").attr('disabled', true);
			$(".plusBtn").text("");
			$(".changeBtn").html(
					"<input type=\"button\" value=\"수정\" id=\"updateBtn\" />");
			$("#updateBtn").click(updateForm);
			$("#searchBtn").removeAttr('disabled');
			$("#memRegForm").removeAttr('disabled');
			$("#mangementList").removeAttr('disabled');
			$("#privateList").removeAttr('disabled');
			$("#searchName").removeAttr('disabled');
			loadMemberList();

		}
	}
	// ////////////////////////////////////////////////////
	var levedate;
	if (memberLeaveDate.val() == "") {
		levedate = null
	} else {
		levedate = memberLeaveDate.val();
	}
	xhttp.open("POST", "m_update.do", true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send("worker_number=" + memberNumber.val() + "&name="
			+ memberName.val() + "&division=" + memberDivision.val()
			+ "&position=" + memberPosition.val() + "&join_date="
			+ memberJoinDate.val() + "&leave_date=" + memberLeaveDate.val()
			+ "&active=" + memberActive.val() + "&memo=" + memberMemo.val()
			+ "&authority=" + memberAuthority.val() + "&phone="
			+ memberPhone.val() + "&phone2=" + memberPhone2.val() + "&e_mail="
			+ memberEmail.val() + "&address=" + memberAdress.val()
			+ "&leave_date=" + levedate);

}

function detailName(i) {
	var xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var text = this.responseText;
			var textList = text.split(",");
			// textList에는 사원번호, 이름, 부서, 직책, 입사일, 퇴사일, 재직여부,
			// 메모, 관리자, 핸드폰, 자택, 이메일, 주소 순으로 들어있다.
			memberNumber.val(textList[0]);
			memberName.val(textList[1]);
			memberDivision.val(textList[2]);
			memberPosition.val(textList[3]);
			memberJoinDate.val(textList[4].substring(0, 10));
			if (textList[5] == "null") {
				var leaveD = null;
			} else {
				leaveD = textList[5].substring(0, 10)
			}
			memberLeaveDate.val(leaveD);
			memberActive.val(textList[6]);
			memberMemo.val(textList[7]);
			memberAuthority.val(textList[8]);
			memberPhone.val(textList[9]);
			memberPhone2.val(textList[10]);
			memberEmail.val(textList[11]);
			memberAdress.val(textList[12]);
			if (memberLeaveDate.val() == "null") {
				memberLeaveDate.val("")
			}
			;

		}

	};

	xhttp.open("POST", "detail.do", true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send("name=" + $("#searchName").val() + "&num=" + i);

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
	var phoneNum2 = Number($("#PHONE2").val());
	if (phone.val() == "") {
		return alert("전화번호를 입력해주세요 ")
	}

	if (phone.val().indexOf("-") > -1) {
		return alert("전화번호에 '-'를 입력할수 없습니다.");

	}
	if (phone2.val().indexOf("-") > -1) {
		return alert("자택 번호에 '-'를 입력할수 없습니다.");

	}

	if (isNaN(phoneNum)) {
		return alert("전화번호는 숫자만 입력해주세요 ");

	}

	if (isNaN(phoneNum2)) {
		return alert("자택번호는 숫자만 입력해주세요 ");

	}

	$("form").submit();
}
