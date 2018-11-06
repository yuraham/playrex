<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<title>제목없음</title>
</head>
<body>
	사원등록
	<form action="m_register.do" method="post">
		<table>


			<tr>
				<td>이름:</td>
				<td><input type="text" name='name' /></td>
			</tr>
			<tr>
				<td>부서</td>
				<td><input type="text" name='division' /></td>
			</tr>
			<tr>

				<td>직책</td>
				<td><input type="text" name='position' /></td>
			</tr>
			<tr>

				<td>메모</td>
				<td><input type="text" name='memo' /></td>
			</tr>
			<tr>

				<td><input type="submit" value='확인' /><input type="button" value="취소" onClick="history.back();" /></td>
			</tr>
		</table>






	</form>
</body>
</html>