<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<t:genericpage>
    <jsp:attribute name="head">
        <title>${requestScope.post.met_title}</title>
    </jsp:attribute>
    <jsp:body>
    <main>
		<c:if test="${not empty worker_number }">
			<div class="container">
				<div class="card">
					<div class="card-header">
						<h1 class="post-main-font post-form-main text-center delete-form-margin">정말 삭제하시겠습니까?</h1>
					</div>
					<div class="card-body">
						<h2 class="post-main-font" >${requestScope.post.met_title}</h2>
						<table class="table table-borderless table-sm post-detail-table">
							<tr>
								<td>글번호 : </td>
								<td>${requestScope.post.met_numb}</td>
								<td>작성일 : </td>
								<td><fmt:formatDate value="${requestScope.post.met_date}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
							</tr>
							<tr>
								<td>작성자 : </td>
								<td>${requestScope.post.met_writer}</td>
								<td>회의실 : </td>
								<td>${requestScope.post.met_room}</td>
								<td>프로젝트 명 : </td>
								<td>${requestScope.post.met_project}</td>
							</tr>
						</table>
						<hr>
						<h4 class="post-main-font text-center">${requestScope.post.met_subject}</h4>
						<p class="post-detail-text">${requestScope.post.met_text}</p>
						<div class="mx-auto text-center">
							<p><small>한번 삭제된 내용은 돌아오지 않습니다.</small></p>
							<a href="${pageContext.request.contextPath}/yr_meeting/delete_end.do?met_numb=${requestScope.post.met_numb}" class="btn btn-outline-secondary post-delete-btn">네</a>
							<a href="${pageContext.request.contextPath}/yr_meeting/detail.do?met_numb=${requestScope.post.met_numb}" class="btn btn-outline-secondary post-delete-btn">아니오</a>
						</div>
					</div>
				<c:if test="${requestScope.metlist.size() > 0}">
					<div class="card-footer">
					<p class="delete-margin-zero"><strong class="post-main-font">등록 파일 : </strong></p>
					<c:forEach var="i" items="${requestScope.metlist}">
						<p class="post-detail-file delete-margin-zero">${i.data_name}</p>
					</c:forEach>
					</div>
				</c:if>
			</div>
			</div>
		</c:if>
		<c:if test="${empty worker_number }">
		<h3 class="text-center post-not-login">로그인 하지 않은 사용자는 접근할 수 없습니다.</h3>
		</c:if>
	</main>
    </jsp:body>
</t:genericpage>