<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
회원가입
<form action="p_register.do" method="post">

사번<input type="text" name='worker_number' />
이름<input type="text" name='name' />
비번<input type="text" name='pass' />
전화<input type="text" name='phone' id="phone" />
자택<input type="text" name='phone2' />
이멜<input type="text" name='e_mail' id = "em"/>
주소<input type="text" name='address' />
<input type="submit" value='확인' />
</form>
</body>
</html>