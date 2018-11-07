<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

수정기록 리스트 테스트 <br>
${sessionScope.changeList.worker_number }
${sessionScope.changeList.category }
${sessionScope.changeList.filed_name }
${sessionScope.changeList.old_data }
${sessionScope.changeList.new_data }
${sessionScope.changeList.update_date }

</body>
</html>