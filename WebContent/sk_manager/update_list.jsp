<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

수정기록 리스트 테스트 <br>
<table>
<tr><td>사원번호</td><td>수정내역</td><td>수정 전</td><td>수정후</td><td>수정날짜</td></tr>
<%=session.getAttribute("changeList") %>
</table>



</body>
</html>