<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mentos: 리뷰 게시판 입니다.</title>
<script type="text/javascript"
	src="/mentos/static/js/jquery-3.1.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="/mentos/css/review/default.css" />

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style type="text/css">
 @import url(http://fonts.googleapis.com/earlyaccess/hanna.css); .main {font-family: 'Hanna';}
 
 .defaultLayout{
   font-size:10pt;
   margin-top:15px;
   padding-top:0px;
   width: 100%;
   background-color: #ffffff;
   text-align: center;
   font-size: 11pt;
   font-weight: normal;
   position: relative;

}
#tableDiv{
	padding-left: 15%;
}
table.type04 {
    border-collapse: separate;
    border-spacing: 1px;
    text-align: left;
    line-height: 1.5;
    border-top: 1px solid #ccc;
  	margin : 20px 10px;
  	width: 80%;
}
table.type04 th {
    width: 150px;
    padding: 5px;
    font-weight: bold;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
    text-align: center;
    padding-bottom: 10px;
    padding-top: 10px;
}
table.type04 td {
    width: 350px;
    padding: 5px;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
    text-align: center;
    
}

</style>
</head>




<body>

	<div id="header" class="container">
		<div id="logo">
			<h1>
				<a href="/mentos/main">M E N T O S</a>
			</h1>
		</div>
		<div id="menu">
			<ul>
				<li class="current_page_item"><a href="/mentos/main">Homepage</a></li>
	<li><a href="">MentoList</a></li>
	<li><a href="/mentos/review/list">Review</a></li>
	<c:choose>
		<c:when test="${ismento}">
		
		<li><a href="/mentos/user/mento/mypage">MYPAGE</a></li>
		<li><a style="margin-right: 210px" href="/mentos/user/common/logout">LOGOUT</a><li>
		</c:when>
		<c:when test="${ismentee}">
		
			<li><a href="/mentos/user/mentee/mypage">MYPAGE</a></li>
			<li><a style="margin-right: 210px" href="/mentos/user/common/logout">LOGOUT</a></li>
		</c:when>
		<c:otherwise>
		<li><a href=# id="login">Login</a>
		</li>
		<li><a href=# id="join" style="margin-right: 210px">Join</a>
		</li>
		</c:otherwise>
	</c:choose>
			</ul>
		</div>
	</div>

	<div class = "defaultLayout">
				
				<br/>
				<img src = "/mentos/img/review/chat-1873536_1280.png"  width ="100px" height="100px"/>
				<h3 class ="main" style="text-align:center">멘토에 대한 후기를 남겨주세요</h3>
				
				<div id = "tableDiv">
				<table class="type04">
					<tr>
						<th scope="row">No</th>
						<th scope="row">ID</th>
						<th scope="row">MentoName</th>
						<th scope="row">Title</th>
						<th scope="row">Rating</th>
						<th scope="row">WriteDate</th>
	
					</tr>
						
					<c:forEach items="${reviewList}" var="review" varStatus="index">
	
						<tr>

							<td style="font-size: 15px; width: 5%;">${index.index+1}</td>
							<td style="font-size: 15px; width: 5%;">${review.menteeId}</td>
							<td style="font-size: 15px; width: 5%;">${review.mentoName}</td>
							<td style="font-size: 15px; width: 60%;"><a href="/mentos/review/detail?reviewId=${review.reviewId}">${review.reviewTitle}</a></td>
							<td style="font-size: 15px; width: 5%;"><c:choose>
									<c:when test="${review.reviewRating == '-1'}">Notice</c:when>
									<c:when test="${review.reviewRating == '1'}"><img src = "/mentos/img/review/VeryBad.PNG"  width ="20px" height="20px"/>VeryBad</c:when>
									<c:when test="${review.reviewRating == '2'}"><img src = "/mentos/img/review/Bad.PNG"  width ="20px" height="20px"/><br/>Bad</c:when>
									<c:when test="${review.reviewRating == '3'}"><img src = "/mentos/img/review/Okay.PNG"  width ="20px" height="20px"/><br/>OK</c:when>
									<c:when test="${review.reviewRating == '4'}"><img src = "/mentos/img/review/Goood.PNG"  width ="20px" height="20px"/><br/>Good</c:when>
									<c:otherwise><img src = "/mentos/img/review/Awesome.PNG"  width ="20px" height="20px"/>Awesome</c:otherwise></c:choose></td>
							<td style="font-size: 15px; width: 5%;">${review.reviewWriteDate}</td>
						</tr>
					</c:forEach>
				</table>
				</div>
				<form id="searchForm">${pager}</form>
				<div style="text-align: center; margin-top: 10px">
				<a href="/mentos/review/write" class="w3-button w3-black w3-round-small">후기 작성</a>
				</div>
				<br/>
			</div>

</body>
</html>