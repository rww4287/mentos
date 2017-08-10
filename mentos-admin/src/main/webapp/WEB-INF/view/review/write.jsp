<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>공지사항 작성</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" type="text/css"
	href="/mentos-admin/css/default.css" />
<link rel="stylesheet" href="/mentos-admin/img/lib/w3.css">
<script type = "text/javascript" src = "/mentos/static/js/jquery-3.1.1.min.js"></script>
<script type = "text/javascript" src = "/mentos/static/rating/lib/jquery.raty.js"></script>
<script type="text/javascript">
	$().ready(function() {
		$("#WriteForm").find("input[type=button]").click(function() {
			$("#WriteForm").attr({
				"method" : "post",
				"action" : "/mentos-admin/view/review/write"
			});
			$("#WriteForm").submit();
		});
});

</script>
</head>
<body>
	<div id="header">
		<div id="logo">
		<h1><a href="/mentos-admin/adminMain">A D M I N - 공지 작성</a></h1>
		</div>
	</div>
<div id="wrapper">
	<div id="welcome" class="wrapper-style1">
	<!-- Ajax로 처리하는건 id / Jquery: name -->
	<form id="WriteForm">
		<input type="text" name="reviewTitle" placeholder="제목을 입력하세요." /> <br />
		<br />
		<textarea name="reviewContent" placeholder="내용을 입력하세요."></textarea>
		<br /> <input type="button" value="리뷰 등록 완료" />
	</form>
</div>
</div>
	<div id="footer" class="container">
	
	</div>
</body>
</html>