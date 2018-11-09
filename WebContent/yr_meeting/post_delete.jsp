<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:genericpage>
    <jsp:attribute name="head">
        <title>${requestScope.post.title}</title>
        </jsp:attribute>
    <jsp:body>
	<h1>정말 삭제하시겠습니까?</h1>
		<p>${requestScope.post.met_title}</p>
		<p>${requestScope.post.met_numb}번 글</p>
		<p>회의실 : ${requestScope.post.met_room}</p>
		<p>프로젝트 명 : ${requestScope.post.met_project}</p>
		<p>작성일 : ${requestScope.post.met_date}</p>
		<p>작성자 : ${requestScope.post.met_writer}</p>
		<p>안건요약 : ${requestScope.post.met_subject}</p>
		<p>${requestScope.post.met_text}</p>
	<a href="${pageContext.request.contextPath}/yr_meeting/delete_end.do?met_numb=${requestScope.memo.idx}">네</a>
	<a href="${pageContext.request.contextPath}/yr_meeting/detail.do?met_numb=${requestScope.memo.idx}">아니오</a>
    </jsp:body>
</t:genericpage>
