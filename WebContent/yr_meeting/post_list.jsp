<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<t:genericpage>

    <jsp:attribute name="head">
        <title>회의록 리스트</title>
        </jsp:attribute>
    <jsp:body>
    <main role="main" class="container post-main">
		<c:if test="${not empty worker_number }">
		<div>
		 <h2 class="post-main-font">회의록 리스트</h2>
			${requestScope.num }
			<table class="table post-table">
			<thead>
				<tr>
					<td colspan="5" class="black-td">${requestScope.text}</td>
				</tr>
			</thead>
			<tbody>
 	 		<c:forEach var="i" items="${requestScope.list}" varStatus="status">
 	 			<tr>
					<td>${i.met_numb}</td>
					<td width="20%" class="align-middle"><small><fmt:formatDate value="${i.met_date}" pattern="yyyy-MM-dd HH:mm:ss" /></small></td>
					<td width="48%" class="black-td align-middle"><a href="${pageContext.request.contextPath}/yr_meeting/detail.do?met_numb=${i.met_numb}">${i.met_title}</a>
						<c:if test="${requestScope.metData[status.index] > 0}"> [파일]</c:if>
					</td>
					<td width="15%" class="align-middle">${member[status.index].name}</td>
					<td width="15%" class="align-middle">${i.met_project}</td>
				</tr>
 			</c:forEach>
 			</tbody>
		</table>
		<hr class="post-line">
		<div class="float-right">
		<a href="${pageContext.request.contextPath}/yr_meeting/post_form.do" class="btn btn-outline-secondary post-btn">새글쓰기</a>
		<c:if test="${pText == 1}">
			<a href="${pageContext.request.contextPath}/yr_meeting/list.do" class="btn btn-outline-secondary post-btn">돌아가기</a>
		</c:if>
		</div>
		</div>
 		<div class="post-search-div">
			<form method="GET" action="${pageContext.request.contextPath}/yr_meeting/list.do" class="needs-validation align-items-center">
			<div class="form-row">
				<div class="form-group col-auto">
				<label class="sr-only" for="post-search">search</label>
				<select name="col" class="custom-select" id="post-search">
					<option value="none">전체</option>
					<option value="title">제목</option>
					<option value="titext">제목/내용</option>
					<option value="writer">작성자</option>
					<option value="part">참석자</option>
					<option value="project">프로젝트명</option>
				</select>
				</div>
				<div class="form-group col-auto">
				<label class="sr-only" for="post-search-text">text</label>
				<input type="text" name="word" class="form-control mb-2" id="post-search-text"/>
				</div>
				<div class="form-group col-auto">
				<input type="submit" class="btn btn-outline-secondary mb-2" id="post-search-submit" value="검색"/>
				</div>
				</div>
			</form>
		</div>
		</c:if>
		<c:if test="${empty worker_number }">
		<h3 class="text-center post-not-login">로그인 하지 않은 사용자는 접근할 수 없습니다.</h3>
		</c:if>
	</main>
    </jsp:body>
</t:genericpage>
