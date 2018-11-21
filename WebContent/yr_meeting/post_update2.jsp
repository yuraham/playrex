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
        <small>다음버튼을 누르면 이전 돌아오지 않습니다. 신중히 저장해주세요.</small>
		<form action="${pageContext.request.contextPath}/yr_meeting/update2.do?met_numb=${requestScope.post.met_numb}" method="post" enctype="multipart/form-data">
			<div class="form-group">
				<textarea class="form-control" name="met_text" id="met_text" rows="23" >${requestScope.post.met_text}</textarea>
			</div>
			<div class="custom-file">
				<input type="file" name="fileName" id="form2-file-input" class="custom-file-input" />
				<label class="custom-file-label my-post-file" for="form2-file-input">파일 첨부</label>
			</div>
			<div class="float-right">
				<input type="submit" class="btn btn-outline-secondary update-btn" id="post-form2-submit" value="저장"/>
				<a href="${pageContext.request.contextPath}/yr_meeting/list.do" class="btn btn-outline-secondary update-btn" >취소</a>
			</div>
			<c:if test="${requestScope.metlist.size() > 0}">
				<hr>
				<div class="post-detail-filediv">
					<p><strong class="post-main-font">등록 파일 : </strong></p>
					<c:forEach var="i" items="${requestScope.metlist}">
						<p>${i.data_name} <a href="${pageContext.request.contextPath}/yr_meeting/delete_data.do?met_numb=${requestScope.post.met_numb}&data_numb=${i.data_numb}">삭제하기</a></p>
					</c:forEach>
				</div>
			</c:if>
		</form>
		</div>
		</c:if>
		<c:if test="${empty worker_number }">
		<h3 class="text-center post-not-login">로그인 하지 않은 사용자는 접근할 수 없습니다.</h3>
		</c:if>
		</main>
    </jsp:body>
</t:genericpage>
