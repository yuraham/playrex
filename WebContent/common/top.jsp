<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<a href="${pageContext.request.contextPath}">홈</a>
<c:if test="${not empty worker_number }">
사원번호${sessionScope.worker_number} : <a href="${pageContext.request.contextPath}/sk_user/private_info.do">${sessionScope.name }</a>님 안녕하세요 !
    <a href="${pageContext.request.contextPath}/sk_user/logout.do">로그아웃</a>
    
    <a href="${pageContext.request.contextPath}/choice.jsp">선택화면</a>
</c:if>
<c:if test="${empty worker_number }">
    <a href="${pageContext.request.contextPath}/sk_user/privateRegisterForm.jsp">회원가입</a>
</c:if>
<div>머릿말</div>