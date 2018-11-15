<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>PLAYREX</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link href="${pageContext.request.contextPath}/static/main_css/main.css"
	rel="stylesheet" type="text/css">
</head>
<body>
<div class="fullheight">
	<div class="col">
    <c:if test="${not empty requestScope.message}">
        <div>${requestScope.message }</div>
    </c:if>
    <c:if test="${not empty worker_number }">
		<div class="mainfont"><h1>로그인 되었습니다.</h1></div>
		<a href="${pageContext.request.contextPath}/sk_user/logout.do">로그아웃</a>
		<a href="${pageContext.request.contextPath}/choice.jsp">선택화면</a>
    </c:if>
    <c:if test="${empty worker_number }">
		<div class="main">
			<div><hr noshade class="line1"></div>
			<div><hr noshade class="line2"></div>
			<div class="mainfont">PLAYREX</div>
		</div>
		<div class="loginbox">
			<form
			action="${pageContext.request.contextPath}/sk_user/login.do"
			method="post">
				<div class="mylogin">
				<input type="text" name="worker_number" id="id" placeholder="사원번호"/><br />
				<input type="password" name="pass" id="pass" placeholder="비밀번호"/><br />
				</div>
						<div class="btnbox">
							<input type="submit" value="접속" class='loginbtn' />
						</div>
					</form>
				</div>
				<div class="loginbox">
					<p class="logintext">
						<a
							href="${pageContext.request.contextPath}/sk_user/privateRegisterForm.jsp">회원가입</a>
					</p>
				</div>
			</c:if>
		</div>
	</div>
	<script type="text/javascript">
		history.pushState(null, null, location.href);
		window.onpopstate = function() {
			history.go(1);
		};
		
		$("#pass").keydown(function(e){if(e.keyCode == 13){submit()}});
	</script>
</body>
</html>
