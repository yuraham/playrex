<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<title>제목없음</title>
</head>
<body>
사원등록
<form action="m_register.do" method="post">

이름<input type="text" name='name' />
부서<input type="text" name='division' />
직책<input type="text" name='position' />
메모<input type="text" name='memo' />
<input type="submit" value='확인' />

</form>
</body>
</html>