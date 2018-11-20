<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar sticky-top navbar-expand-sm navcor navbar-light">
	<a href="${pageContext.request.contextPath}" class="navbar-brand">PLAYREX</a>
	<c:if test="${not empty worker_number }">
	<span class="navbar-text">사원번호${sessionScope.worker_number} : <a href="${pageContext.request.contextPath}/sk_user/private_info.do">${sessionScope.name }</a>님 안녕하세요 !</span>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNav">
	<ul class="navbar-nav ml-auto">
		<li class="nav-item active">
			<a class="nav-link" href="${pageContext.request.contextPath}/sk_user/logout.do">로그아웃</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="${pageContext.request.contextPath}/choice.jsp">선택화면</a>
		</li>
	</ul>
	</div>
	</c:if>
	<c:if test="${empty worker_number }">
		<a class="tolink" href="${pageContext.request.contextPath}/sk_user/privateRegisterForm.jsp">회원가입</a>
	</c:if>
</nav>
	<hr class="line">