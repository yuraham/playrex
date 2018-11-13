<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:genericpage>
    <jsp:attribute name="head">
        <title>Memo List</title>
        </jsp:attribute>
    <jsp:body>
		<c:if test="${not empty worker_number }">
		<div class="container">
			<h1>디테일페이지</h1>
			<p>${requestScope.post.met_title}</p>
			<p>${requestScope.post.met_numb}번 글</p>
			<p>회의실 : ${requestScope.post.met_room}</p>
			<p>프로젝트 명 : ${requestScope.post.met_project}</p>
			<p>작성일 : ${requestScope.post.met_date}</p>
			<p>작성자 : ${requestScope.member.name}</p>
			<p>안건요약 : ${requestScope.post.met_subject}</p>
			<p>${requestScope.post.met_text}</p>
			<p>참가자 : 
 			<c:forEach var="i" items="${requestScope.memberlist}">
				${i.name} 
			</c:forEach>
			</p>
			<a href="${pageContext.request.contextPath}/yr_meeting/delete.do?met_numb=${requestScope.post.met_numb}">삭제하기</a>
			<a href="${pageContext.request.contextPath}/yr_meeting/update_form.do?met_numb=${requestScope.post.met_numb}">수정하기</a>
			<a href="${pageContext.request.contextPath}/yr_meeting/list.do">돌아가기</a>
		</div>
		</c:if>
		<c:if test="${empty worker_number }">
		<h3>로그인 하지 않은 사용자는 접근할 수 없습니다.</h3>
		</c:if>
    </jsp:body>
</t:genericpage>
