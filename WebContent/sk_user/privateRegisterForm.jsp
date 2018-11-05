<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<title>Insert title here</title>
</head>
<body>
	<div class="container" style='width:1800px;'>
		회원가입
		<form action="p_register.do" method="post">

			<table>


				<tr>
					<td>사번</td>
					<td><input type="text" name='worker_number' id="ID" /></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name='name' id="NAME" /></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="text" name='pass' id="PASS" /></td>
				</tr>
				<tr>
					<td>비밀번호 확인</td>
					<td><input type="text" id="PASS2" /></td>
				</tr>
				<tr>
					<td>전화</td>
					<td><input type="text" name='phone' id="PHONE" /></td>
				</tr>
				<!-- <tr><td>자택</td> <td><input type="text" name='phone2' id = "PHONE2"/></td></tr> -->
				<tr>
					<td>e-mail</td>
					<td><input type="text" name='e_mail' id="EMAIL" /></td>
				</tr>
				<tr>
					<td>추천인 아이디</td>
					<td><input type="text" name='address' id="ADDR" /></td>
				</tr>
				<tr>
					<td><input type="button" value='확인' /></td>
			</table>
		</form>
	</div>
</body>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script>
	var id = $("#ID"), pass = $("#PASS"), pass2 = $("#PASS2"), nameForm = $("#NAME"), phone = $("#PHONE"), email = $("#EMAIL"), addr = $("#ADDR");

	$(document).ready(function() {
		$(":button").click(formCheck)
	})

	function formCheck() {
		////공백체크
		if (id.val() == "") {
			return alert("아이디를 입력해주세요");
		}
		;
		if (pass.val() == "") {
			return alert("비밀번호를 입력해주세요");
		}
		;
		if (pass2.val() == "") {
			return alert("비밀번호 확인을 입력해주세요");
		}
		;
		if (nameForm.val() == "") {
			return alert("이름을 입력해 주세요 ");
		}
		;

		if (email.val() == "") {
			return alert("이메일을 입력해주세요");
		}

		if (addr.val() == "") {
			return alert("추천인 아이디를 입력해주세요 ")
		}

		////비밀번호 체크
		if (pass.val().length < 8) {
			return alert("비밀번호를 8자리 이상 입력해주세요")
		} else if (pass2.val().length < 8) {
			return alert("비밀번호 확인을 8자리 이상 입력해주세요")
		}

		if (pass.val() != pass2.val()) {
			return alert("비밀번호가 일치하지 않습니다.")
		}

		if (email.val().indexOf("@") == -1) {
			return alert("이메일 형식이 잘못되었습니다.")
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
</script>
</html>