<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>detail page</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" type="text/css"
	href="/mentos-admin/css/default.css" />
<link rel="stylesheet" href="/mentos-admin/img/lib/w3.css">
<script type = "text/javascript" src = "/mentos-admin/static/js/jquery-3.1.1.min.js"></script>
<script>

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
		<h1>${review.reviewTitle}</h1>
		<p>${review.menteeId}</p><hr/>
		<span>${review.mentoName} |</span>
		
		<span>
			<c:choose>
		        <c:when test="${review.reviewRating == '1'}">
		            Bad |
		        </c:when>
		        <c:when test="${review.reviewRating == '2'}">
		            Not bad |
		        </c:when>
		        <c:when test="${review.reviewRating == '3'}">
		            OK |
		        </c:when>
		         <c:when test="${review.reviewRating == '4'}">
		            Good |
		        </c:when>
		        <c:otherwise>
		            Awesome |
		        </c:otherwise>
			</c:choose>
		</span>
		<span>${review.reviewWriteDate}</span>
		<p>${review.reviewContent}</p>
		
		<button type="button" onclick="location.href='/mentos-admin/review/list' ">목록으로가기</button>
		<button type ="button" onclick ="location.href='/mentos-admin/review/doDelete?reviewId=${review.reviewId}'">삭제하기</button>
</div>
</div>
	<div id="footer" class="container">
	
	</div>
</body>
</html>