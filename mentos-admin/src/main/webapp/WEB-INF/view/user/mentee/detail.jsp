<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>멘티 상세정보 보기</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" type="text/css" href="/mentos-admin/css/main_layout.css" />
<link rel="stylesheet" type="text/css" href="/mentos-admin/css/main_default.css" />

<script type="text/javascript" src="/mentos/static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	$().ready(function(){
		
		$("#passwordBt").click(function(){
			$(this).hide();
			$("#menteePassword").removeAttr("disabled");
		});
		$("#addressBt").click(function(){
			$(this).hide();
			$("#menteeAddress").removeAttr("disabled");
		});
		
		$("#phoneBt").click(function(){
			$(this).hide();
			$("#phone").removeAttr("disabled");
		});
		$("#emailBt").click(function(){
			$(this).hide();
			$("#email").removeAttr("disabled");
		});
		
		$("#modifyForm").find("input[type=submit]").click(function(){
			if($("#menteePassword").val().length <= 7){
				alert("비밀번호는 8자리 이상으로 입력해주세요!");
				$("#menteePassword").focus();
				return;
			} 
			else { 
				$("#modifyForm").attr({
					"method" : "post",
					"action" :"/mentos-admin/user/mentee/doModify"
				});
				if (confirm("수정 하시겠습니까?") == true){
					$("#modifyForm").submit();
				}else{ 
				    return;
				}
			}
		});
	});
</script>
</head>
<body>
	<div id="header">
		<div id="logo">
		<h1><a href="/mentos-admin/adminMain">A D M I N - 멘티 정보 수정</a></h1>
		</div>
	</div>
<div id="wrapper">
	<div id="welcome" class="wrapper-style1">

 	<form id="modifyForm">
 	<input type="hidden" id="menteeId" name="menteeId" value="${mentee.menteeId}">
		ID : ${mentee.menteeId}<br/>
		
		Password : 
		<input type="password" id="menteePassword" name="menteePassword"  value="${mentee.menteePassword}" disabled="disabled">
		<input type="button" id="passwordBt" value="수정하기"/><br/>
	
		Name :  ${mentee.menteeName}<br/>
		
		Address : 
		<input type="text"  id="menteeAddress" name="menteeAddress" value="${mentee.menteeAddress}" disabled="disabled">
		<input type="button" id="addressBt" value="수정하기"/><br/>
		
		Phone : 
		<input type="text" id="phone" name="phone" value="${mentee.phone}" disabled="disabled">
		<input type="button" id="phoneBt" value="수정하기"/><br/>
		
		Email : 
		<input type="text"  id="email" name="email" value="${mentee.email}" disabled="disabled">
		<input type="button" id="emailBt" value="수정하기"/><br/>

		<input type="submit" value="수정하기">
	</form>
</div>
</div>
		<div id="footer" class="container">
	
		</div>
</body>
</html>