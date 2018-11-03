<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
로그인 테스트중 
사원번호   <a href="<%= request.getContextPath()%>/sk_user/private_info.do"><%=session.getAttribute("worker_number")%></a>
</body>
</html>