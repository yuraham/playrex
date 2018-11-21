<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:genericpage>
    <jsp:attribute name="head">
        <title>등록</title>
        </jsp:attribute>
    <jsp:body>
    <main>
		<c:if test="${not empty worker_number}">
        <div class="container">
        <h2 class="post-main-font post-form-main text-center">회의록 등록</h2>
		<form action="${pageContext.request.contextPath}/yr_meeting/post.do" method="post">
			<div class="form-group">
				<input type="text" class="form-control" id="met_title" name="met_title" placeholder="제목" />
			</div>
			<div class="form-row post-form-text">
				<div class="form-group col-md-6">
					<input type="text" class="form-control" id="met_room" name="met_room" placeholder="회의실" />
				</div>
				<div class="form-group col-md-6">
					<input type="text" class="form-control" id="met_writer" name="met_writer" placeholder="작성자" />
				</div>
			</div>
			<div class="form-group">
				<input type="text" class="form-control" id="met_project" name="met_project" placeholder="프로젝트" />
			</div>
			<div class="form-group">
				<input type="text" class="form-control"  id="met_subject"name="met_subject" placeholder="안건요약" />
			</div>
			<div class="form-row post-form-text">
				<div class="form-group col-md-6">
					<input type="text" class="form-control" id="part1" name="part1" placeholder="참가자1" />
				</div>
				<div class="form-group col-md-6">
					<input type="text" class="form-control" id="part2" name="part2" placeholder="참가자2"/>
				</div>
				<div class="form-group col-md-6">
					<input type="text" class="form-control" id="part3" name="part3" placeholder="참가자3"/>
				</div>
				<div class="form-group col-md-6">
					<input type="text" class="form-control" id="part4" name="part4" placeholder="참가자4" />
				</div>
				<div class="form-group col-md-6">
					<input type="text" class="form-control" id="part5" name="part5" placeholder="참가자5" />
				</div>
				<div class="form-group col-md-6">
					<input type="text" class="form-control" id="part6" name="part6" placeholder="참가자6" />
				</div>
				<div class="form-group col-md-6">
					<input type="text" class="form-control" id="part7" name="part7" placeholder="참가자7" />
				</div>
				<div class="form-group col-md-6">
					<input type="text" class="form-control" id="part8" name="part8" placeholder="참가자8" />
				</div>
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
