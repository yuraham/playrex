<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:genericpage>

    <jsp:attribute name="head">
        <title>회의록 리스트</title>
        </jsp:attribute>
    <jsp:body>
		<c:if test="${not empty worker_number }">
		<div class="container">
		 <h1>회의록리스트</h1>
			${requestScope.num }
	 		<table class="table">
			<thead>
				<tr>
					<th colspan="4">${requestScope.text}</th>
				</tr>
			</thead>
			<tbody>
 	 		<c:forEach var="i" items="${requestScope.list}" varStatus="status">
 	 			<tr>
					<td>${i.met_numb}</td>
					<td width="20%">${i.met_date}</td>
					<td width="48%"><a href="${pageContext.request.contextPath}/yr_meeting/detail.do?met_numb=${i.met_numb}">${i.met_title}</a></td>
					<td width="15%">${member[status.index].name}</td>
					<td width="15%">${i.met_project}</td>
				</tr>
 			</c:forEach>
 			</tbody>
		</table>
		<a href="${pageContext.request.contextPath}/yr_meeting/post_form.do">새글쓰기</a>
		</div>
		</c:if>
		<c:if test="${empty worker_number }">
		<h3>로그인 하지 않은 사용자는 접근할 수 없습니다.</h3>
		</c:if>
    </jsp:body>
</t:genericpage>
