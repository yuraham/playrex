<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page session="true" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="container" style='width:600px;' >
<%= request.getAttribute("message") %>
<%=session.getAttribute("message") %>
사원번호<%=session.getAttribute("worker_number")%> :    <a href="<%= request.getContextPath()%>/sk_user/private_info.do"><%=session.getAttribute("name")%></a>님 안녕하세요 !
<a href="<%= request.getContextPath()%>/sk_user/logout.do">로그아웃</a><br>
<%-- <a href="<%= request.getContextPath()%>/profile.jsp">자기소개</a>
<br>
<a href="<%= request.getContextPath()%>/sk_user/private_info.do">정보수정<a></a> --%>
<a href="<%= request.getContextPath()%>/sk_manager/management_info.do">인사 관리</a><br />
<a href="<%= request.getContextPath()%>/yr_meeting/list.do">회의록 관리</a><br />
</div>


</body>
</html>