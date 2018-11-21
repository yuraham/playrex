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
			<form action="${pageContext.request.contextPath}/yr_meeting/post2.do" method="post" enctype="Multipart/form-data">
				<div class="form-group">
					<textarea class="form-control" id="met_text" name="met_text" rows="23" placeholder="내용 및 결과"></textarea>
				</div>
				<div class="custom-file">
					<input type="file" name="fileName" id="form2-file-input" class="custom-file-input" />
					<label class="custom-file-label my-post-file" for="form2-file-input">파일 첨부</label>
				</div>
				<div class="float-right">
					<input type="submit" class="btn btn-outline-secondary post-btn" id="post-form2-submit" value="저장"/>
					<a href="${pageContext.request.contextPath}/yr_meeting/delete_end.do?met_numb=${requestScope.post.met_numb}" class="btn btn-outline-secondary post-btn">취소</a>
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
