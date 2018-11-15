<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:genericpage>


<jsp:body>
<c:if test="${not empty author}">

<div class="container">
		<div>
			<h2>사원 정보 변경 내역</h2>
		</div>
		<div class="table">
			<table>
				<tr>
					<td scope="col">순 번</td>
					<td scope="col">사원번호</td>
					<td scope="col">수정내역</td>
					<td scope="col">수정 전</td>
					<td scope="col">수정후</td>
					<td scope="col">수정날짜</td>
				</tr>
				${sessionScope.changeList }
				<%-- <%=session.getAttribute("changeList")%> --%>
			</table>

		</div>
	</div>

</c:if>
	        <c:if test="${empty author }">
	        관리자 권한이 없습니다.
	         </c:if>
	         <c:if test="${empty worker_number }">
        
        로그인을 해주세요 
	 </c:if>


<style>
header{
position: fixed;
top:-500px;}
</style>
 </jsp:body>
</t:genericpage>

