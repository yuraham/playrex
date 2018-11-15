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
		<c:if test="${not empty worker_number }">
        <div class="container">
        <small>다음버튼을 누르면 이전 돌아오지 않습니다. 신중히 저장해주세요.</small>
		<form action="${pageContext.request.contextPath}/yr_meeting/update2.do?met_numb=${requestScope.post.met_numb}" method="post" enctype="Multipart/form-data">
			<table>
				<tr>
					<td>내용 및 결과</td>
					<td><input type="text" name="met_text" value="${requestScope.post.met_text}"/></td>
				</tr>
				<tr>
					<td>파일추가 : </td>
					<td><input type="file" name="fileName"/></td>
				</tr>
				<tr>
					<td><input type="submit" value="다음"/></td>
					<td><a href="${pageContext.request.contextPath}/yr_meeting/list.do">취소</a></td>
				</tr>
			</table>
			<c:if test="${requestScope.metlist.size() > 0}">
				<hr>
				<p>등록 파일 : </p>
				<c:forEach var="i" items="${requestScope.metlist}">
					<p>${i.data_name}  <a href="${pageContext.request.contextPath}/yr_meeting/delete_data.do?met_numb=${requestScope.post.met_numb}&data_numb=${i.data_numb}">삭제하기</a></p>
				</c:forEach>
			</c:if>
		</form>
		</div>
		</c:if>
		<c:if test="${empty worker_number }">
		<h3>로그인 하지 않은 사용자는 접근할 수 없습니다.</h3>
		</c:if>
    </jsp:body>
</t:genericpage>
