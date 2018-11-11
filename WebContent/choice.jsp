<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:genericpage>
	<jsp:attribute name="head">
        <title>index.jsp</title>
    </jsp:attribute>
	<jsp:attribute name="header">
        <!-- 머릿말 추가 -->
    </jsp:attribute>
	<jsp:attribute name="footer">
        <!-- 꼬릿말 추가 -->
    </jsp:attribute>
	<jsp:body>
	<div class="container" style='width: 600px;'>
	<h2> palyrex </h2>
	<c:if test="${not empty requestScope.message}">
            <div>${requestScope.message }</div>
        </c:if>
        <c:if test="${not empty worker_number }">
<a
				href="${pageContext.request.contextPath}/sk_manager/management_info.do">인사
			관리</a>
			<br /> <a
				href="${pageContext.request.contextPath}/yr_meeting/list.do">회의록
			관리</a>
			<br />
        </c:if>
        <c:if test="${empty worker_number }">
        
        로그인을 해주세요 
	 </c:if>
	
		
		

		
	</div>
	
	
	    </jsp:body>
</t:genericpage>






