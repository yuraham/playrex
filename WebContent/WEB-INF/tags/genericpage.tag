<%@tag description="Common Page Template" pageEncoding="UTF-8"%>
<%@attribute name="head" fragment="true"%>
<%@attribute name="header" fragment="true"%>
<%@attribute name="footer" fragment="true"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<!-- 반응형 메타태그 - 부트스트랩은 Mobile First -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/bootstrap/4.1.3/css/bootstrap.min.css">
<!-- 개별 페이지의 head -->
<jsp:invoke fragment="head" />
</head>
<body>
	<div class="container">
		<header>
			<jsp:include page="/common/top.jsp" flush="false" />
			<!-- 개별 페이지의 header -->
			<jsp:invoke fragment="header" />
		</header>
		<div id="body"><jsp:doBody /></div>

		<!-- 옵션: jQuery, Popper.js, Bootstrap JS 순으로 추가 -->
		<script
			src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.slim.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/static/js/popper.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/static/bootstrap/4.1.3/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/static/sk_js/sk_js.js"></script>
		<link
			href="${pageContext.request.contextPath}/static/sk_css/sk_css.css"
			rel="stylesheet" type="text/css" >
		<link href="${pageContext.request.contextPath}/static/topBot_css/topBot_css.css"
			rel="stylesheet" type="text/css" >
		<script src="${pageContext.request.contextPath}/static/yr_js/yr_js.js"></script>
		<link href="${pageContext.request.contextPath}/static/yr_css/yr_css.css"
			rel="stylesheet" type="text/css" >
	</div>
	<footer>
	<!-- 개별 페이지의 footer -->
	<jsp:invoke fragment="footer" />
	<jsp:include page="/common/bottom.jsp" flush="false" />
	</footer>
</body>
</html>