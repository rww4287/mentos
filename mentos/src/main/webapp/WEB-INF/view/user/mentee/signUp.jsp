<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/mentos/css/user/menteeSignUp_layout.css"/>
<link rel="stylesheet" type="text/css" href="/mentos/css/user/default.css"/>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>멘티 회원가입</title>
<script type="text/javascript" src="/mentos/static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
$().ready(function() {

	
	$("#menteeId").keyup(function() {
		console.log($("#menteeId").val());
		
		$.post("/mentos/user/mentee/check",
		{
			"menteeId" : $("#menteeId").val()
		}, function(response) {
			console.log(response);
			var jsonObj = JSON.parse(response);

			
			if (jsonObj.duplicated) {
				$("#duplicateState").text("중복된 아이디 입니다.");
			} else {
				$("#duplicateState").text("사용 가능한 아이디 입니다.");
			}
		});
	});
	
	$("#signUpForm").find("input[type=button]").click(function() {
		console.log("aaaa");
		
		if ( $("#menteeId").val() == "" ) {
			alert("아이디를 입력하세요!!");
			$("#menteeId").focus();
			return;
		}
		
		if ( $("#menteePassword").val().length <= 7 ) {
			alert("비밀번호는 8자리 이상으로 입력하세요.");
			$("#menteePassword").focus();
			return;
		}
		
		$.post("/mentos/user/mentee/check", {
			"menteeId" : $("#menteeId").val()
		}, function(response) {
			
			var jsonObj = JSON.parse(response);
			console.log(JSON);
			console.log(jsonObj);
			
			if ( jsonObj.duplicated ) {
				alert("입력한 ID는 이미 사용 중입니다.\n다른 ID를 사용해 주세요.");
				return;
			}
			else {
				$("#signUpForm").attr({
					"action": "/mentos/user/mentee/signUp",
					"method": "post"
				});
				$("#signUpForm").submit();
			}
		});
	});
	
	$("input:radio[value=남자]:input[value=' + 남자 + ']").attr("checked", true);
	$("input:radio[value=여자]:input[value=' + 여자 + ']").attr("checked", true);
		
});
</script>
</head>

<body bgcolor="black">

<div id="header" class="container">
	<div id="logo">
		<h1><a href="/mentos/main">M E N T O S</a></h1>
	</div>
	<div id="menu">
		<ul>
			<li class="current_page_item"><a href="/mentos/main">Homepage</a></li>
			<li><a href="/mentos/user/mento/mypage">Logout</a></li>
			<li><a href="">MentoList</a></li>
			<li><a style="margin-right: 200px" href="">Review</a></li>
		</ul>
	</div>
</div>

<div class="menteeHeader">

	<div class="image">
		<img src="/mentos/img/user/mentee2.jpg" id="menteeImage">
		<div class="menteeSignUpTitle">멘티 회원가입</div>
	</div>

	<div class="menteeInput">
		<form id="signUpForm">
			<table style="text-align:left;">
				<tr>
					<div class="p" style="width:17%; float:left;">
						<tr></tr>
						<tr></tr>
						<tr>
							<th>ID : </th>
						</tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr>
							<th>Password : </th>
						</tr>
						<tr></tr>
						<tr></tr>
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
						<tr></tr>
						<tr>
							<th>Phone : </th>
						</tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr>
							<th>Email : </th>
						</tr>
						<tr></tr>
						<tr></tr>
						<tr>
							<th>Gender :</th>
						</tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr>
							<th>Birthday : </th>
						</tr>
					</div>
				</tr>
			
				<tr>
					<div style="width:70%; margin-right:12%; float:right; text-align: left;">
						
							<input style="width: 270px; margin-top: 5px;" type="text" id="menteeId" name="menteeId" placeholder="아이디를 입력하세요.">
							<span id="duplicateState"></span>
							<br/>
							<input style="width: 270px; margin-top: 5px;" type="password" id="menteePassword" name="menteePassword" placeholder="비밀번호를 입력하세요.(8자 이상)"><br/>
							<input style="width: 270px; margin-top: 5px;" type="text" id="menteeName" name="menteeName" placeholder="이름을 입력하세요."><br/>
							<input style="width: 270px; margin-top: 5px;" type="text" id="menteeAddress" name="menteeAddress" placeholder="주소를 입력하세요. (지역명 (예 : 서초구))"><br/>
							<input style="width: 270px; margin-top: 5px;" type="text" id="phone" name="phone" placeholder="연락 가능한 연락처를 입력하세요."><br/>
							<input style="width: 270px; margin-top: 5px;" type="text" id="email" name="email" placeholder="자주 사용하는 이메일을 입력하세요."><br/>
							<input style="margin-top: 5px;" type="radio" id="gender" name="gender" value="남자">남자
							<input type="radio" id="gender" name="gender" value="여자">여자<br/>
							<fmt:formatDate value="${menteeBirthday}" pattern="yyyy/MM/dd"/>
							<input style="width: 270px; margin-top: 5px;" type="date" id="menteeBirthday" name="menteeBirthday"><br/>
							<c:forEach var="studySpinner" items="${categoryName}" varStatus="status">
								${studySpinner.categoryName}
							</c:forEach>
							<input style="margin-top: 5px; float:right; margin-right: 60px;" type="button" class="w3-button w3-black w3-round-small" value="멘티 가입하기">  
						
					</div>
				</tr>
				
			</table>
		</form>
	</div>
</div>
</body>

</html>