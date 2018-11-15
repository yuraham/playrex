<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:genericpage>
	<jsp:attribute name="head">
        <title>PLAYREX</title>
    </jsp:attribute>
	<jsp:attribute name="header">
        <!-- 머릿말 추가 -->
    </jsp:attribute>
	<jsp:attribute name="footer">
        <!-- 꼬릿말 추가 -->
    </jsp:attribute>
	<jsp:body>
	<div class="container choice_body">
	
	<c:if test="${not empty requestScope.message}">
            <div>${requestScope.message }</div>
        </c:if>
        <c:if test="${not empty worker_number }">
        <input type="button" class="cho_Btn" onclick="location.href='${pageContext.request.contextPath}/sk_manager/management_info.do'" value="인사 관리" />
        <input type="button" class="cho_Btn" onclick="location.href='${pageContext.request.contextPath}/yr_meeting/list.do'" value="회의록관리" />
        
        

        </c:if>
        <c:if test="${empty worker_number }">
        
        로그인을 해주세요 
	 </c:if>
	
		
		

		
	</div>
	
	
	    </jsp:body>
</t:genericpage>






