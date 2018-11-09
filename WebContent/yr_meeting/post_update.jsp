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
		<a href="${pageContext.request.contextPath}/yr_meeting/update.do">수정</a>
		<a href="${pageContext.request.contextPath}/yr_meeting/list.do">취소</a>
		
		</div>
    </jsp:body>
</t:genericpage>
