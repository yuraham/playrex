<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
	
	
	
	<div>
			<h1>회원가입</h1>
		</div>
	<div>
	<form action="p_register.do" method="post">
			<table>
				<tr class="test">
					<td class="text-center">사번</td>
					<td><input type="text" name='worker_number' id="ID" /></td>
						<td></td>
				</tr>
				<tr>
					<td class="text-center">이름</td>
					<td><input type="text" name='name' id="NAME" /><input
							type="button" value="조회" id="checkBtn" /></td>
						<td></td>
				</tr>
				<tr><span class="checkText"></span></tr>
				<tr>
					<td class="text-center">비밀번호</td>
					<td><input type="text" name='pass' id="PASS" /></td>
						<td></td>
				</tr>
				<tr>
					<td class="text-center">비밀번호 확인</td>
					<td><input type="text" id="PASS2" /></td>
						<td></td>
				</tr>
				<tr>
					<td class="text-center">전화</td>
					<td><input type="text" name='phone' id="PHONE" /></td>
						<td></td>
				</tr>
				<tr>
					<td class="text-center">자택</td>
					<td><input type="text" name='phone2' id="PHONE2" /></td>
						<td></td>
				</tr>
				<tr>
					<td class="text-center">e-mail</td>
					<td><input type="text" name='e_mail' id="EMAIL" /></td>
						<td></td>
				</tr>
				<tr>
					<td class="text-center">주소</td>
					<td><input type="text" name='address' id="ADDR" /></td>
						<td></td>
				</tr>
				<tr>
					<td></td>
						<td class="text-center"><input type="button" value='확인'
							id="sBtn" /><input type="button" value='취소' id="rbtn"
							onClick="history.back();" /></td>
						<td></td>
					</tr>
			</table>
		</form>
		</div>
	
	</jsp:body>
</t:genericpage>






