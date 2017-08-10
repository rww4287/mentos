<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mentee Modify</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Open+Sans:300,600,700" rel="stylesheet" />
<link href="/mentos/css/mypage/main_default.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="/mentos/img/lib/w3.css">
<script type="text/javascript" src="/mentos/static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	$().ready(function(){
		
		$("#pointBt").click(function(){
			$(this).hide();
			$("#point").removeAttr("disabled");
		});
		
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
					"action" :"/mentos/user/mentee/modify"
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
<div id="header" class="container">
	<div id="logo">
		<h1><a href="/mentos/main">M E N T O S</a></h1>
	</div>
<div id="menu">
		<ul>
			<li class="current_page_item"><a href="/mentos/main">Homepage</a></li>
			<li><a href="/mentos/user/common/logout">Logout</a></li>
			<li><a href="">MentoList</a></li>
			<li><a href="/mentos/review/list" style="margin-right: 210px">Review</a></li>
		</ul>
	</div>
</div>
<div id="wrapper">
	<div id="welcome" class="wrapper-style1">
		<div class="title">
<h3 id="modifytitle" class="contentText">멘티 회원 정보 수정 </h3><br/>
<div id=modifydiv>
 	<form id="modifyForm">
 				<table style="text-align:left;">
				<tr>
					<div class="p" style="width:18%; float:left;">
						<tr>
							<th>ID : </th>
						</tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr>
							<th>Password : </th>
						</tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr>
							<th>Name : </th>
						</tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr>
							<th>Address : </th>
						</tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr>
							<th>Phone : </th>
						</tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr>
							<th>Email :</th>
						</tr>
					</div>
				</tr>

	
	<div style="width:80%; margin-right:12%; float:right; text-align: left;">
	<input type="hidden" id="menteeId" name="menteeId" value="${mentee.menteeId}">	
	<div id="pmenteeid"> ${mentee.menteeId}<br/></div>
	
	<input style="width: 280px; margin-top: 10px;" type="password" id="menteePassword" name="menteePassword"  value="${mentee.menteePassword}" disabled="disabled">
	<input type="button"  class="w3-button w3-tiny w3-black w3-round-small"  id="passwordBt" value="수정하기"/><br/>

	${mentee.menteeName}<br/>
	
	
	<input style="width: 280px; margin-top: 5px;" type="text"  id="menteeAddress" name="menteeAddress" value="${mentee.menteeAddress}" disabled="disabled">
	<input type="button"  class="w3-button w3-tiny w3-black w3-round-small"  id="addressBt" value="수정하기"/><br/>
	
	<input style="width: 280px; margin-top: 5px;" type="text" id="phone" name="phone" value="${mentee.phone}" disabled="disabled">
	<input type="button"  class="w3-button w3-tiny w3-black w3-round-small"  id="phoneBt" value="수정하기"/><br/>
	
	<input style="width: 280px; margin-top: 5px;" type="text"  id="email" name="email" value="${mentee.email}" disabled="disabled">
	<input type="button"  class="w3-button w3-tiny w3-black w3-round-small"  id="emailBt" value="수정하기"/><br/>

	
</div>
</table><br/>
<input type="submit" class="w3-button w3-tiny w3-black w3-round-small" value="수정하기">
</form>
</div>
</div>
</div>
</div>

<div id="footer" class="container">

</div>
</body>
</html>

