<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:genericpage>
	<jsp:attribute name="head">
        <title>인사 관리 </title>
    </jsp:attribute>
	<jsp:attribute name="header">
        <!-- 머릿말 추가 -->
    </jsp:attribute>

	<jsp:body>
	<div class="container">
<h2>인사 관리 </h2>

<div class="navi">
<div>		<input type="text" name="name" id="searchName" /> <input
						type="button" value="검색" id="searchBtn" />
	</div>	
		

<table>
		<tr>
			<td class="right_txt1">사원번호</td>
			<td></td>
			<td class="right_txt2">이름</td>
		</tr>

	</table>
					<div class="result_box">
					<span id="memberList">
					
					
					</span>
					${requestScope.memberList }
	
		</div>
	</form>
</div>
<div>
	<input type="button"
					onclick="location.href='${pageContext.request.contextPath}/sk_user/managementRegisterForm.jsp'"
					value="사원등록" />
				${requsetScope.maeeage }
<%-- 	<%=request.getAttribute("message")%> --%>

</div>
<div>
	
		${requestScope.memberlist }
	<form action="${pageContext.request.contextPath}/sk_manager/update.do"
					method="post">
		<table id="table_box">
			<tr>
				<td>사번</td>
				<td><input type="text" name="worker_number" id="worker_number" /></td>
				<td>부서</td>
				<td><input type="text" name="division" id="division" }" /></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" id="name" /></td>
				<td>직책</td>
				<td><input type="text" name="position" id="position" /></td>
			</tr>
			<tr>
				<td>핸드폰</td>
				<td><input type="text" name="phone" id="phone" /></td>
				<td>입사일</td>
				<td><input type="text" name="join_date" id="join_date" /></td>
			</tr>
			<tr>
				<td>자택</td>
				<td><input type="text" name="phone2" id="phone2" /></td>
				<td>퇴사일</td>
				<td><input type="text" name="leave_date" id="leave_date" /></td>
			</tr>
			<tr>
				<td>e-mail</td>
				<td><input type="text" name="e_mail" id="e_mail" /></td>
								
								
				<td>재직여부</td>
				<td><input type="text" name="active" id="active" /></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="address" id="address" /></td>
				<td>관리자</td>
				<td><input type="text" name="authority" id="authority" /></td>
			</tr>
			<tr>
				<td>메모</td>
				<td><input type="text" name="memo" id="memo" /></td>
				<td></td>
				<td><input type="text" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="수정" /></td>
				<td><input type="reset" value="취소" /></td>
				<td></td>
				<td><input type="button" value="인사기록"
								onclick="location.href='${pageContext.request.contextPath}/sk_manager/management_list.do'" /><input
								type="button" value="개인기록"
								onclick="location.href='${pageContext.request.contextPath}/sk_manager/private_list.do'" /></td>
			</tr>
		</table>
	</form>
	${requsetScope.maeeage }
	</div>
</div>
 </jsp:body>
</t:genericpage>

