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
		<form action="${pageContext.request.contextPath}/yr_meeting/post2.do?met_numb=${requestScope.post.met_numb}" method="post">
			<table>
				<tr>
					<td>내용 및 결과</td>
					<td><input type="text" name="met_text"/></td>
				</tr>
				<tr>
					<td><input type="submit" value="저장"/></td>
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
