<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>mentos: 리뷰 수정</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" type="text/css"
	href="/mentos-admin/css/default.css" />
<link rel="stylesheet" href="/mentos-admin/img/lib/w3.css">
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
	<div id="header">
		<div id="logo">
		<h1><a href="/mentos-admin/adminMain">A D M I N - 리뷰 수정</a></h1>
		</div>
	</div>
<div id="wrapper">
	<div id="welcome" class="wrapper-style1">
	<form id="modifyForm">
		<select>
			<c:forEach items="${mentoNameList}" var="mento">
				<option value="${mento.mentoName}">${mento.mentoName}</option>
				<input name="mentoId" type="hidden" value="${mento.mentoId}" />
				<input name="mentoName" type="hidden" value="${mento.mentoName}" />
			</c:forEach>
		</select> 
		<div id="star" ></div>
        <div style="padding-top:20px;">
            <input type="hidden" name ="reviewRating" id="starRating" value="${review.reviewRating}"/>
        </div>
        
		<input type="text" name="reviewTitle" value="${review.reviewTitle}" /> <br />
		<textarea name="reviewContent" >${review.reviewContent}</textarea>
		<input type="hidden" name="reviewId" value="${review.reviewId}"/>
		<br /> <input type="button" value="리뷰 수정 완료" />
	</form>
</div>
</div>
	<div id="footer" class="container">
	
	</div>

</body>
</html>