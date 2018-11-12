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
	
	
	
			<table>
				<caption>회원정보</caption>
				<tr>
					<td>사원번호 :</td>
					<td>${sessionScope.management.worker_number} </td>
				</tr>
				<tr>
					<td>이름 :</td>
					<td>
						${sessionScope.management.name } </td>
				</tr>
				<tr>
					<td>부서:</td>
					<td>
						${sessionScope.management.division }</td>
				</tr>
				<tr>
				</tr>
				<tr>
					<td>직책:</td>
					<td>${sessionScope.management.position }</td>
				</tr>
				 <tr>
					<td>비밀번호 :</td>
					<td>${sessionScope.privacy.pass }</td>
				</tr>
				 <tr>
					<td>비밀번호 확인 :</td>
					<td>${sessionScope.privacy.pass }</td>
				</tr>
				<tr>
					<td>전화번호:</td>
					<td>${sessionScope.privacy.phone }</td>
				</tr>
				<tr>
					<td>자택:</td>
					<td>${sessionScope.privacy.phone2 }</td>
				</tr>
				<tr>
					<td>e_mail:</td>
					<td>
						${sessionScope.privacy.e_mail }</td>
				</tr>

				<tr>
					<td>주소 :</td>
					<td>${sessionScope.privacy.address }</td>
				</tr>
				<tr>
					<td>입사일:</td>
					<td>
						${sessionScope.management.join_date }</td>
				</tr>
				<tr>
					<td></td>
					<td> ${sessionScope.message }</td>
				</tr>
				<tr>
					<td></td>

					<td><input type="button" value="정보수정" onclick="location.href='${pageContext.request.contextPath}/sk_user/member_info_update.jsp'"/></td>
				</tr>
			</table>

			<br>





		</form>
	
	
	
		</jsp:body>
</t:genericpage>
