<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:genericpage>
	<jsp:attribute name="head">
        <title>회원가입</title>
    </jsp:attribute>
	<jsp:attribute name="header">
    </jsp:attribute>
	<jsp:attribute name="footer">
    </jsp:attribute>
	<jsp:body>
	<h2>회원 정보 </h2>
	
	<form action="${pageContext.request.contextPath}/sk_user/update.do"
			method="post">
			<table>
				<caption>회원정보</caption>
				<tr>
					<td>사원번호 :</td>
					<td><input type="text" name="worker_number"
						value="${sessionScope.management.worker_number}" readonly id="ID" class="input_box"/></td>
						
						
				</tr>
				<tr>
					<td>이름 :</td>
					<td><input type="text" name="name"
						value="${sessionScope.management.name }" readonly id="NAME" class="input_box"/></td>
				</tr>
				<tr>
					<td>부서:</td>
					<td><input type="text" name="division"
						value="${sessionScope.management.division }"  readonly class="input_box" /></td>
				</tr>
				<tr>
				</tr>
				<tr>
					<td>직책:</td>
					<td><input type="text" name="position"
						value="${sessionScope.management.position }" readonly class="input_box" /></td>
				</tr>
				 <tr>
					<td>비밀번호 :</td>
					<td><input type="password" name="pass"
						value="${sessionScope.privacy.pass }" id="PASS" /></td>
				</tr>
				 <tr>
					<td>비밀번호 확인 :</td>
					<td><input type="password" name="pass"
						value="${sessionScope.privacy.pass }" id="PASS2"/></td>
				</tr>
				<tr>
					<td>전화번호:</td>
					<td><input type="text" name="phone"
						value="${sessionScope.privacy.phone }" id="PHONE" /></td>
				</tr>
				<tr>
					<td>자택:</td>
					<td><input type="text" name="phone2"
						value="${sessionScope.privacy.phone2 }" id="PHONE2" /></td>
				</tr>
				<tr>
					<td>e_mail:</td>
					<td><input type="text" name="e_mail"
						value="${sessionScope.privacy.e_mail }" id="EMAIL"/></td>
				</tr>

				<tr>
					<td>주소 :</td>
					<td><input type="text" name="address"
						value="${sessionScope.privacy.address }"  id="ADDR"/></td>
				</tr>
				<tr>
					<td>입사일:</td>
					<td><input type="text" name="join_date"
						value="${sessionScope.management.join_date }" readonly class="input_box" /></td>
				</tr>
				<tr>
					<td></td>
					<td> ${responseScope.message }</td>
				</tr>
				<tr>
					<td></td>

					<td><input type="button" value="정보수정" id="sBtn"/><input type="button"
						value="취소 " onclick="history.back(-1)" /></td>
				</tr>
			</table>

			<br>





		</form>
	
	
	
		</jsp:body>
</t:genericpage>
