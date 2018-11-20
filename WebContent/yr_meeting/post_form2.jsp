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
			<form action="${pageContext.request.contextPath}/yr_meeting/post2.do" method="post" enctype="Multipart/form-data">
				<table>
					<tr>
						<td>내용 및 결과</td>
						<td><input type="text" name="met_text"/></td>
					</tr>
					<tr>
						<td>파일명 : </td>
						<td><input type="file" name="fileName"/></td>
					</tr>
					<tr>
						<td><input type="submit" value="저장"/></td>
						<td><a href="${pageContext.request.contextPath}/yr_meeting/delete_end.do">취소</a></td>
					</tr>
				</table>
			</form>
			</div>
		</c:if>
		<c:if test="${empty worker_number }">
			<h3 class="text-center post-not-login">로그인 하지 않은 사용자는 접근할 수 없습니다.</h3>
		</c:if>
    </jsp:body>
</t:genericpage>
