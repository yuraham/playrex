<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page session="true" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 회원정보
 인사정보 ${sessionScope.management.name }
 <form action="${pageContext.request.contextPath}/sk_user/update.do" method="post">
<input type="text" name="worker_number" value="${sessionScope.management.worker_number}" />
<input type="text" name="name" value="${sessionScope.management.name }" />
<input type="hidden" name="pass" value="${sessionScope.privacy.pass }" />
<input type="text" name="division" value="${sessionScope.management.division }" />
<input type="text" name="position" value="${sessionScope.management.position }" />
<input type="text" name="phone" value="${sessionScope.privacy.phone }" />
<input type="text" name="phone2" value="${sessionScope.privacy.phone2 }" />
<input type="text" name="e_mail" value="${sessionScope.privacy.e_mail }" />
<input type="text" name="address" value="${sessionScope.privacy.address }" />
<input type="text" name="join_date" value="${sessionScope.management.join_date }" />


</form>
*수정버튼 클릭으로 입력활성화 

</body>
</html>