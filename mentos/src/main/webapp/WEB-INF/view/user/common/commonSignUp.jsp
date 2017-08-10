<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/mentos/css/user/signUp_layout.css"/>
<title>회원가입</title>
<script type="text/javascript" src="/mentos/static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
$().ready(function() {
	$("#mentoSignUpBtn").click(function() {
		location.href="/mentos/user/mento/signUp";
	});
	
	$("#menteeSignUpBtn").click(function() {
		location.href="/mentos/user/mentee/signUp";
	});
	
	$(".mentoMiddle").click(function() {
		location.href="/mentos/user/mento/signUp";
	});
	
	$(".menteeMiddle").click(function() {
		location.href="/mentos/user/mentee/signUp";
	});
});
</script>
</head>
<body>
<div class="div_wrap">
	<div id="button">
		<div id="mentoBtn">
			<img src="/mentos/img/user/intern_mento.jpg" id="mentoSignUpBtn" value="멘토 회원가입">
			<div class="mentoMiddle">
    			<div class="mentoText">멘토 회원가입</div>
  			</div>
		</div>
		
		<div id="menteeBtn">	
			<img src="/mentos/img/user/intern_mentee.jpg" id="menteeSignUpBtn" value="멘티 회원가입">
			<div class="menteeMiddle">
    			<div class="menteeText">멘티 회원가입</div>
  			</div>
		</div>
	</div>
</div>
</body>
</html>