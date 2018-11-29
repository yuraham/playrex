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
	<c:if test="${not empty author}">
            

<div class="container big_box">
<h2>인사 관리 </h2>

<p class="msg container"></p>
<div class="navi">

<div>
		<input type="text" name="name" id="searchName" /> <input
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
					<p id="memberList">
					
					
					</p>
					${requestScope.memberList }
	
		</div>
</div>
<div class="container">
	<input type="button" id="memRegForm" value="사원등록" />
				${requsetScope.maeeage }
<%-- 	<%=request.getAttribute("message")%> --%>

</div>
<div class="mem_box">
<%-- <form id="imgForm"
						action="${pageContext.request.contextPath}/sk_manager/insert_pic.do"
						method="post" enctype="multipart/form-data">
						<input type="file" value="첨부" name="datefile" class="input_file" />
					</form> --%>
	
	<form action="${pageContext.request.contextPath}/sk_manager/update.do"
						method="post">
					
		<table id="table_box">
		<tr>
								<%-- <td>사진</td>
								<td></td> --%>
							</tr>
			<tr>
				<td>사번</td>
				<td><input type="text" name="worker_number" id="worker_number"
									class="input_box" readonly /></td>
				<td class="input_move">부서</td>
				<td class="changeSel1 input_move"><select name="division"
									id="division" class="sel input_box update_box" disabled>
				<option value="신입">신입</option>
				<option value="개발">개발</option>
				<option value="디자인">디자인</option>
				<option value="기획">기획</option>
				<option value="인사">인사</option>
				</select>
				<!-- <input type='text' name='division' id='division'
								class='input_box update_box' readonly /> -->
								</td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" id="name" class="input_box"
									readonly /></td>
				<td class="input_move">직책</td>
				<td class="changeSel2 input_move">
				<select name="position" id="position"
									class="sel input_box update_box" disabled>
				<option value="신입">신입</option>
				<option value="팀원">팀원</option>
				<option value="팀장">팀장</option>
				<option value="실장">실장</option>
				<option value="본부장">본부장</option>
				</select>
				<!-- <input type="text" name="position" id="position"
								class="input_box  update_box" readonly /> -->
								</td>
			</tr>
			<tr>
				<td>핸드폰</td>
				<td><input type="text" name="phone" id="phone"
									class="input_box  update_box" readonly /></td>
				<td class="input_move">입사일</td>
				<td class="input_move"><input type="date" name="join_date"
									id="join_date" class="input_box " readonly /></td>
			</tr>
			<tr>
				<td>자택</td>
				<td><input type="text" name="phone2" id="phone2"
									class="input_box update_box" readonly /></td>
				<td class="input_move">퇴사일</td>
				<td class="input_move"><input type="date" name="leave_date"
									id="leave_date" class="input_box  update_box" readonly /></td>
			</tr>
			<tr>
				<td>e-mail</td>
				<td><input type="text" name="e_mail" id="e_mail"
									class="input_box update_box" readonly /></td>
								
								
				<td class="input_move">재직여부</td>
				<td class="changeSel3 input_move"><select name="active"
									id="active" class="sel input_box update_box" disabled>
				<option selected value="1">재직중</option>
				<option value="0">퇴 사</option>
				</select>
				<!-- <input type="text" name="active" id="active"
								class="input_box  update_box" readonly /> --></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="address" id="address"
									class="input_box update_box" readonly /></td>
				<td class="input_move">관리자</td>
				<td class="input_move"><input type="text" name="authority"
									id="authority" class="input_box" readonly /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="text" name="memo" id="memo"
									class="input_box  update_box" readonly /></td>
				<td>메모</td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td class="changeBtn"><input type="button" value="수정"
									id="updateBtn" /></td>
				<td class="plusBtn"></td>
				<td><input id="mangementList" type="button" value="인사기록"
									onClick="managementNull()" />
								<input id="privateList" type="button" value="개인기록"
									onClick="privateNull()" /></td>

			</tr>
		</table>
		
	</form>
	</div>
	
</div>


        </c:if>
	        <c:if test="${empty author }">
	        관리자 권한이 없습니다.
	         </c:if>
	         <c:if test="${empty worker_number }">
        
        로그인을 해주세요 
	 </c:if>
	
 </jsp:body>
</t:genericpage>

