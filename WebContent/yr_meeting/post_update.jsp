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
		<form action="${pageContext.request.contextPath}/yr_meeting/update.do?met_numb=${requestScope.post.met_numb}" method="post">
        ${requestScope.list }
			<table>
				<tr>
					<td>제목</td>
					<td colspan="2"><input type="text" name="met_title" value="${requestScope.post.met_title}"/></td>
				</tr>
				<tr>
					<td>회의실</td>
					<td colspan="2"><input type="text" name="met_room" value="${requestScope.post.met_room}"/></td>
				</tr>
				<tr>
					<td>프로젝트명</td>
					<td colspan="2"><input type="text" name="met_project" value="${requestScope.post.met_project}"/></td>
				</tr>
				<tr>
					<td>안건요약</td>
					<td colspan="2"><input type="text" name="met_subject" value="${requestScope.post.met_subject}"/></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td colspan="2"><input type="text" name="met_writer" value="${requestScope.post.met_writer}"/></td>
				</tr>
				<c:forEach var="i" items="${requestScope.part}" varStatus="status">
					<tr>
						<td>참석자${status.index+1} : </td>
						<td colspan="2"><input type="text" name="part${status.index+1}" value="${i.par_enum}"/></td>
					</tr>
				</c:forEach>
				<c:forEach var="j" begin="${requestScope.part.size()+1}" end="8" step="1">
					<tr>
						<td>참석자${j} : </td>
						<td colspan="2"><input type="text" name="part${j}"/></td>
					</tr>
				</c:forEach>
				<tr>
					<td><input type="submit" value="저장"/></td>
					<td><small>한번 저장버튼을 누르면 돌아오지 않습니다.</small></td>
					<td><a href="${pageContext.request.contextPath}/yr_meeting/list.do">취소</a></td>
				</tr>
			</table>
		</form>
		</div>
		</c:if>
		<c:if test="${empty worker_number }">
		<h3>로그인 하지 않은 사용자는 접근할 수 없습니다.</h3>
		</c:if>
    </jsp:body>
</t:genericpage>
