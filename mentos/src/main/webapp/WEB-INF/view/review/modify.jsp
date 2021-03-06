<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/mentos/css/review/default.css" />
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<style type="text/css">
 @import url(http://fonts.googleapis.com/earlyaccess/hanna.css); .main {font-family: 'Hanna';}
 
.write{
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

#star{
	margin-left: 400px;
}

</style>

<title>mentos: 리뷰 수정</title>
<!-- 수정하기 버튼이 아무 반응이 없음 <script type = "text/javascript>안써줘서" -->
<script type="text/javascript" src="/mentos/static/js/jquery-3.1.1.min.js"></script>
<script type = "text/javascript" src = "/mentos/static/rating/lib/jquery.raty.js"></script>
<script type="text/javascript">
	$().ready(function() {
		$("#modifyForm").find("input[type=button]").click(function() {
			$("#modifyForm").attr({
				"method" : "post",
				"action" : "/mentos/review/modify"
			});
			$("#modifyForm").submit();
		});
		
		$(function() {
            $('div#star').raty({
                score: 3
                ,path : "/mentos/static/rating/lib/images/"
                ,width : 200
                ,click: function(score, evt) {
                    $("#starRating").val(score);
                    $("#displayStarRating").html(score);
                }
            });
        });

	});
</script>
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
	<form class = "write" id="modifyForm" style ="padding-top:20px">
	<img src = "/mentos/img/review/coffee-1246511_1920.jpg"  width ="50%" height="300px"/>
	<h3 id="listTitle" style="text-align:left; margin-left: 100px;"> </h3>
	Title : <input style="margin-top: 10px; width:500px" type="text" name="reviewTitle" value="${review.reviewTitle}" /> <br />
		<br/>
		<br/>
		
		Mento Name : <select name = "mentoName" style="width:150px; ">
		<c:forEach items="${mentoNameList}" var="mento">
				<option value ="${mento.mentoName}">${mento.mentoName}</option>
		</c:forEach>
		</select>
			
		<div id="star">
	        <div style="padding-top:20px;">
	       	 <input style="margin-left: 230px;" type="hidden" name ="reviewRating" id="starRating" value="${review.reviewRating}"/>
	        </div>
 	 	</div>
        <textarea style="margin-top: 20px; width: 50%; height: 280px" name="reviewContent" >${review.reviewContent}</textarea>
		<input type="hidden" name="reviewId" value="${review.reviewId}"/>
		<br /> <input style="margin-top: 5px;" class="w3-button w3-black w3-round-small" type="button" value="수정 완료" />
		<br /> 
		<br/>
		<br/>
	
	</form>
	


</body>
</html>