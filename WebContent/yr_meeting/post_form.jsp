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
					<td colspan="2"><input type="text" name="met_title"/></td>
				</tr>
				<tr>
					<td>회의실</td>
					<td colspan="2"><input type="text" name="met_room"/></td>
				</tr>
				<tr>
					<td>프로젝트명</td>
					<td colspan="2"><input type="text" name="met_project"/></td>
				</tr>
				<tr>
					<td>안건요약</td>
					<td colspan="2"><input type="text" name="met_subject"/></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td colspan="2"><input type="text" name="met_writer"/></td>
				</tr>
				<tr>
					<td>참가자1</td>
					<td colspan="2"><input type="text" name="part1"/></td>
				</tr>
				<tr>
					<td>참가자2</td>
					<td colspan="2"><input type="text" name="part2"/></td>
				</tr>
				<tr>
					<td>참가자3</td>
					<td colspan="2"><input type="text" name="part3"/></td>
				</tr>
				<tr>
					<td>참가자4</td>
					<td colspan="2"><input type="text" name="part4"/></td>
				</tr>
				<tr>
					<td>참가자5</td>
					<td colspan="2"><input type="text" name="part5"/></td>
				</tr>
				<tr>
					<td>참가자6</td>
					<td colspan="2"><input type="text" name="part6"/></td>
				</tr>
				<tr>
					<td>참가자7</td>
					<td colspan="2"><input type="text" name="part7"/></td>
				</tr>
				<tr>
					<td>참가자8</td>
					<td colspan="2"><input type="text" name="part8"/></td>
				</tr>
				<tr>
					<td><input type="submit" value="다음"/></td>
					<td><small>다음 버튼을 누르면 저장됩니다.</small></td>
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
