<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<title>제목없음</title>
</head>
<body>


관리자 페이지 메인 !!
<form action="${pageContext.request.contextPath}/sk_manager/search.do" method="post">
<input type="text" name="name" />
<input type="submit" value ="검색"/>

</form>
<input type="button" onclick="location.href='${pageContext.request.contextPath}/sk_user/managementRegisterForm.jsp'" value="사원등록" />
<%=request.getAttribute("message") %>
<table>
<tr><td>사원번호</td><td>   </td><td>이름</td></tr>

<%= request.getAttribute("memberList") %>
</table>
<form action="${pageContext.request.contextPath}/sk_manager/update.do" method="post">
<table>
<tr><td>사번</td><td><input type="text" value="${sessionScope.management.worker_number }" /></td><td>부서</td><td><input type="text" value="${sessionScope.management.division }" /></td></tr> 
<tr><td>이름</td><td><input type="text" value="${sessionScope.management.name }" /></td><td>직책</td><td><input type="text" value="${sessionScope.management.position }" /></td></tr> 
<tr><td>핸드폰</td><td><input type="text" value="${sessionScope.privacy.phone }" /></td><td>입사일</td><td><input type="text" value="${sessionScope.management.join_date }" /></td></tr> 
<tr><td>자택</td><td><input type="text" value="${sessionScope.privacy.phone2 }"/></td><td>퇴사일</td><td><input type="text" value="${sessionScope.management.leave_date }" /></td></tr> 
<tr><td>e-mail</td><td><input type="text" value="${sessionScope.privacy.e_mail }" /></td><td>재직여부</td><td><input type="text" value="${sessionScope.management.active }"/></td></tr> 
<tr><td>주소</td><td><input type="text" value="${sessionScope.privacy.address }" /></td><td>관리자</td><td><input type="text" value="${sessionScope.management.authority }"/></td></tr> 
<tr><td>메모</td><td><input type="text" value="${sessionScope.management.memo }" /></td><td></td><td><input type="text" /></td></tr>
<tr><td><input type="submit" value="수정"  /></td><td><input type="reset" value="취소"  /></td></tr>
</table> 
</form>

</body>
</html>