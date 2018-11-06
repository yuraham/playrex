<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="center-block "
		style="background-color: #dddddd; height: 30px; width: 400px;">
		<form action="${pageContext.request.contextPath}/sk_user/update.do"
			method="post">
			<table>
				<caption>회원정보</caption>
				<tr>
					<td>사원번호 :</td>
					<td><input type="text" name="worker_number"
						value="${sessionScope.management.worker_number}" /></td>
				</tr>
				<tr>
					<td>이름 :</td>
					<td><input type="text" name="name"
						value="${sessionScope.management.name }" /></td>
				</tr>
				<tr>
					<td>부서:</td>
					<td><input type="text" name="division"
						value="${sessionScope.management.division }" /></td>
				</tr>
				<tr>
				</tr>
				<tr>
					<td>직책:</td>
					<td><input type="text" name="position"
						value="${sessionScope.management.position }" /></td>
				</tr>
				 <tr>
					<td>비밀번호 :</td>
					<td><input type="password" name="pass"
						value="${sessionScope.privacy.pass }" /></td>
				</tr>
				 <tr>
					<td>비밀번호 확인 :</td>
					<td><input type="password" name="pass"
						value="${sessionScope.privacy.pass }" /></td>
				</tr>
				<tr>
					<td>전화번호:</td>
					<td><input type="text" name="phone"
						value="${sessionScope.privacy.phone }" /></td>
				</tr>
				<tr>
					<td>자택:</td>
					<td><input type="text" name="phone2"
						value="${sessionScope.privacy.phone2 }" /></td>
				</tr>
				<tr>
					<td>e_mail:</td>
					<td><input type="text" name="e_mail"
						value="${sessionScope.privacy.e_mail }" /></td>
				</tr>

				<tr>
					<td>주소 :</td>
					<td><input type="text" name="address"
						value="${sessionScope.privacy.address }" /></td>
				</tr>
				<tr>
					<td>입사일:</td>
					<td><input type="text" name="join_date"
						value="${sessionScope.management.join_date }" /></td>
				</tr>
				<tr><td></td><td><%=request.getAttribute("message")%></td></tr>
				<tr>
					<td></td>

					<td><input type="submit" value="정보수정" /><input type="reset" value="초기화 "/></td>
				</tr>
			</table>

			<br>





		</form>
	</div>

</body>
</html>