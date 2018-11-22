<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<t:genericpage>
    <jsp:attribute name="head">
        <title>${requestScope.post.met_numb} Detail</title>
        </jsp:attribute>
    <jsp:body>
    <main>
		<c:if test="${not empty worker_number }">
		<div class="container post-detail">
			<h2 class="post-main-font">${requestScope.post.met_title}</h2>
			<table class="table table-borderless table-sm post-detail-table">
				<tr>
					<td>글번호 : </td>
					<td>${requestScope.post.met_numb}</td>
					<td>작성일 : </td>
					<td colspan="3"><fmt:formatDate value="${requestScope.post.met_date}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
				</tr>
				<tr>
					<td>작성자 : </td>
					<td> ${requestScope.member.name}</td>
					<td>회의실 : </td>
					<td>${requestScope.post.met_room}</td>
					<td>프로젝트 명 : </td>
					<td>${requestScope.post.met_project}</td>
				</tr>
			</table>
			<hr>
			<h4 class="post-main-font text-center">${requestScope.post.met_subject}</h4>
			<p class="post-detail-text">${requestScope.post.met_text}</p>
			<c:if test="${requestScope.memberlist.size() > 0}">
				<p><strong class="post-main-font">참가자 : </strong>
	 			<c:forEach var="i" items="${requestScope.memberlist}">
					<span class="post-detail-prti">${i.name}</span>
				</c:forEach>
				</p>
			</c:if>
			<c:if test="${requestScope.metlist.size() > 0}">
				<hr>
				<div class="post-detail-filediv">
				<p><strong class="post-main-font">등록 파일 : </strong></p>
				<c:forEach var="i" items="${requestScope.metlist}">
					<p class="post-detail-file"><a href="${pageContext.request.contextPath}/yr_meeting/down_data.do?data_numb=${i.data_numb}">${i.data_name}</a></p>
				</c:forEach>
				</div>
			</c:if>
			<hr>
			<div class="float-right">
				<a href="${pageContext.request.contextPath}/yr_meeting/delete.do?met_numb=${requestScope.post.met_numb}" class="btn btn-outline-secondary post-btn">삭제하기</a>
				<a href="${pageContext.request.contextPath}/yr_meeting/update_form.do?met_numb=${requestScope.post.met_numb}" class="btn btn-outline-secondary post-btn">수정하기</a>
				<a href="${pageContext.request.contextPath}/yr_meeting/list.do" class="btn btn-outline-secondary post-btn">돌아가기</a>
			</div>
		</div>
		</c:if>
		<c:if test="${empty worker_number }">
		<h3 class="text-center post-not-login">로그인 하지 않은 사용자는 접근할 수 없습니다.</h3>
		</c:if>
		</main>
    </jsp:body>
</t:genericpage>
