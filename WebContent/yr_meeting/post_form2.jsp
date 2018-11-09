<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:genericpage>
    <jsp:attribute name="head">
        <title>등록폼</title>
        </jsp:attribute>
    <jsp:body>
        <div class="container">
        연결테스트
<%--         <h1>회의록리스트</h1>
        	${requestScope.member }<br>
        	${requestScope.num }
	 		<table class="table">
			<thead>
				<tr>
					<th colspan="4">${requestScope.text}</th>
				</tr>
			</thead>
			<tbody>
 	 		<c:forEach var="i" items="${requestScope.list}" begin="0" end="${requestScope.num}" step="1">
 	 			<tr>
					<td>${i.met_numb}</td>
					<td width="25%">${i.met_date}</td>
					<td width="50%"><a href="${pageContext.request.contextPath}/yr_meeting/detail.do?met_numb=${i.met_numb}">${i.met_title}</a></td>
					<td width="8%">${i.met_writer}</td>
					<td width="15%">${i.met_project}</td>
				</tr>
 			</c:forEach>
 			</tbody>
		</table>
		<a href="${pageContext.request.contextPath}/yr_meeting/register_form.do">새글쓰기</a> --%>
				<a href="${pageContext.request.contextPath}/yr_meeting/post2.do">저장</a>
		</div>
    </jsp:body>
</t:genericpage>
