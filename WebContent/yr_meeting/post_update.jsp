<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:genericpage>
    <jsp:attribute name="head">
        <title>수정</title>
        </jsp:attribute>
    <jsp:body>
    <main>
		<c:if test="${not empty worker_number }">
		<div class="container">
			<h2 class="post-main-font post-form-main text-center">회의록 수정</h2>
			<hr>
        <small>다음버튼을 누르면 이전 내용이 돌아오지 않습니다. 신중히 저장해주세요.</small>
		<form action="${pageContext.request.contextPath}/yr_meeting/update.do?met_numb=${requestScope.post.met_numb}" method="post">
		${requestScope.list }
			<div class="form-group">
				<input type="text" class="form-control" id="met_title" name="met_title" value="${requestScope.post.met_title}" />
			</div>
			<div class="form-row post-form-text">
				<div class="form-group col-md-6">
					<input type="text" class="form-control" id="met_room" name="met_room" value="${requestScope.post.met_room}" />
				</div>
				<div class="form-group col-md-6">
					<input type="text" class="form-control" id="met_writer" name="met_writer" value="${requestScope.post.met_writer}" />
				</div>
			</div>
			<div class="form-group">
				<input type="text" class="form-control" id="met_project" name="met_project" value="${requestScope.post.met_project}" />
			</div>
			<div class="form-group">
				<input type="text" class="form-control"  id="met_subject"name="met_subject" value="${requestScope.post.met_subject}" />
			</div>
			<div class="form-row post-form-text">
				<c:forEach var="i" items="${requestScope.part}" varStatus="status">
					<div class="form-group col-md-6">
						<input type="text" class="form-control" id="part${status.index+1}" name="part${status.index+1}" value="${i.par_enum}"/>
					</div>
				</c:forEach>
				<c:forEach var="j" begin="${requestScope.part.size()+1}" end="8" step="1">
					<div class="form-group col-md-6">
						<input type="text" class="form-control" id="part${j}" name="part${j}" placeholder="참가자${j}"/>
					</div>
				</c:forEach>
			</div>
			<hr>
			<div class="float-right">
				<input type="submit" class="btn btn-outline-secondary post-btn" id="post-form-submit" value="다음"/>
				<a href="${pageContext.request.contextPath}/yr_meeting/list.do" class="btn btn-outline-secondary post-btn">취소</a>
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
