<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>리뷰 게시판 관리</title>
<script type="text/javascript" src="/mentos-admin/static/js/jquery-3.1.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="/mentos-admin/css/main_default.css" />
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="/mentos-admin/img/lib/w3.css">
<style type="text/css">

table.type04 {
    border-collapse: separate;
    border-spacing: 1px;
    text-align: left;
    line-height: 1.5;
    border-top: 1px solid #ccc;
  	margin : 20px 10px;
  	width: 100%;
}
table.type04 th {
    width: 150px;
    padding: 5px;
    font-weight: bold;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
 
    padding-bottom: 10px;
    padding-top: 10px;
}
table.type04 td {
    width: 350px;
    padding: 5px;
    vertical-align: top;
    border-bottom: 1px solid #ccc;

    
}</style>
</head>
<body>
	<div id="header">
		<div id="logo">
		<h1><a href="/mentos-admin/adminMain">A D M I N - 리뷰 관리</a></h1>
		</div>
	</div>
<div id="wrapper">
	<div id="welcome" class="wrapper-style1">

	<div>
	<table class = "type04" >
		<tr>
			<th scope="row">번호</th>
			<th scope="row">멘티ID</th>
			<th scope="row">제목</th>
			<th scope="row">별점</th>
			<th scope="row">등록 일자</th>
		</tr>
		<c:forEach items="${reviewList}" var="review">
			<tr>
				<td><fmt:parseNumber>
						${fn:split(review.reviewId, '-')[2]}
					</fmt:parseNumber></td>
				<td>${review.menteeId}</td>
				<!-- class="member" data-name="${review.reviewId}" -->
				<td><a href="/mentos-admin/review/detail?reviewId=${review.reviewId}">${review.reviewTitle}</a></td>
				<!-- <td>${review.reviewContent}</td> -->
				<td>	
						<c:choose>
					        <c:when test="${review.reviewRating == '1'}">
					            Bad
					        </c:when>
					        <c:when test="${review.reviewRating == '2'}">
					            Not bad
					        </c:when>
					        <c:when test="${review.reviewRating == '3'}">
					            OK
					        </c:when>
					         <c:when test="${review.reviewRating == '4'}">
					            Good
					        </c:when>
					        <c:otherwise>
					            Awesome
					        </c:otherwise>
						</c:choose>
				</td>
				
				<td>${review.reviewWriteDate}</td>
			
			</tr>
		</c:forEach>
	</table>
	</div>
	<a style="margin-left: 450px; margin-bottom: 30px" class="w3-button w3-black w3-round-small" href="/mentos-admin/view/review/write">공지사항 작성하기</a>

	<div>
		<form id="searchForm">${pager}</form>
	</div>
	</div>
</div>
	<div id="footer" class="container">
	
	</div>
</body>
</html>