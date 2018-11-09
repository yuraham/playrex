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
		<c:if test="${not empty worker_number}">
        <div class="container">
		<form action="${pageContext.request.contextPath}/yr_meeting/post.do" method="post">
			<table>
				<tr>
					<td>제목</td>
					<td><input type="text" name="met_title"/></td>
				</tr>
				<tr>
					<td>회의실</td>
					<td><input type="text" name="met_room"/></td>
				</tr>
				<tr>
					<td>프로젝트명</td>
					<td><input type="text" name="met_project"/></td>
				</tr>
				<tr>
					<td>안건요약</td>
					<td><input type="text" name="met_subject"/></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td><input type="text" name="met_writer"/></td>
				</tr>
				<tr>
					<td><input type="submit" value="다음"/></td>
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
