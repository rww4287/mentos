<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/mentos/css/user/mentoSignUp_layout.css"/>
<link rel="stylesheet" type="text/css" href="/mentos/css/user/default.css"/>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<title>멘토 회원가입</title>
<script type="text/javascript" src="/mentos/static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
$().ready(function() {
	
	 $("#mentoId").keyup(function() {
		 
		$.post("/mentos/user/mento/check", 
		{
			"mentoId" : $("#mentoId").val()
		},
		function(response) {
			var jsonObj = JSON.parse(response);
			if (jsonObj.duplicated) {
				$("#duplicateState").text("중복된 아이디 입니다.");
			} else {
				$("#duplicateState").text("사용 가능한 아이디 입니다.");
			}
		});
	 });
	
	$("#signUpForm").find("input[type=button]").click(function() {
		console.log("dddd");
		
		if ( $("#mentoId").val() == "" ) {
			alert("아이디를 입력하세요!!");
			$("#mentoId").focus();
			return;  //반환시킨다. return값이 없으면 종료시킨다.
		}
		
		if ( $("#mentoPassword").val().length <= 7 ) {
			alert("비밀번호는 8자리 이상으로 입력하세요.");
			$("#mentoPassword").focus();
			return;
		}
		
		// 마지막으로 아이디가 중복이 되는지 체크한다.
		$.post("/mentos/user/mento/check", {
			"mentoId" : $("#mentoId").val()
		}, 
		function(response) {
			var jsonObj = JSON.parse(response);
			if ( jsonObj.duplicated ) {
				alert("입력한 ID는 이미 사용 중입니다.\n다른 ID를 사용해 주세요.");
				return;
			}
			else {
				$("#signUpForm").attr({
					"action": "/mentos/user/mento/signUp",
					"method": "post"
				});
				$("#signUpForm").submit();
			}
		});
		
	});
	
	$("input:radio[value=남자]:input[value=' + 남자 + ']").attr("checked", true);
	$("input:radio[value=여자]:input[value=' + 여자 + ']").attr("checked", true);
/* 	if ( $("select:option[value=기타]:input[id=' + 기타 + ']").attr("selected", "selected") ) {
		$("#etc").show();
	} else {
		$("#etc").hide();
	} */
	
	
	
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

<div class="mentoHeader">

	<div class="image">
		<img src="/mentos/img/user/mento1.jpg" id="mentoImage">
		<div class="mentoSignUpTitle">멘토 회원가입</div>
	</div>
	
	<div class="mentoInput">
		<form id="signUpForm" method="post" enctype="multipart/form-data">
			<table style="text-align:left;">
				<tr>
					<div class="p" style="width:20%; float:left;">
						<tr></tr>
						<tr></tr>
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
						<tr>
							<th>Birthday : </th>
						</tr>
						<tr></tr>
						<tr></tr>
						<tr>
							<th>Cost : </th>
						</tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr>
							<th>ClassMember : </th>
						</tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr>
							<th>StartDate : </th>
						</tr>
						<tr></tr>
						<tr></tr>
						<tr>
							<th>Category : </th>
						</tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr>
							<th>Etc : </th>
						</tr>
					</div>
				</tr>
			
				<tr>
					<div style="width:75%; float:right; text-align: left;">
						
							<input style="width: 270px; margin-top: 4px;" type="text" id="mentoId" name="mentoId" placeholder="아이디를 입력하세요.">
							<span id="duplicateState"></span><br/>
							<input style="width: 270px; margin-top: 3px;" type="password" id="mentoPassword" name="mentoPassword" placeholder="비밀번호를 입력하세요.(8자 이상)"><br/>
							<input style="width: 270px; margin-top: 3px;" type="text" id="mentoName" name="mentoName" placeholder="이름을 입력하세요."><br/>
							<input style="width: 270px; margin-top: 3px;" type="text" id="mentoAddress" name="mentoAddress" placeholder="주소를 입력하세요. (지역명 (예 : 서초구))"><br/>
							<input style="width: 270px; margin-top: 3px;" type="text" id="phone" name="phone" placeholder="연락 가능한 연락처를 입력하세요."><br/>
							<input style="width: 270px; margin-top: 3px;" type="text" id="email" name="email" placeholder="자주 사용하는 이메일을 입력하세요."><br/>
							<input style="margin-top: 6px;" type="radio" id="gender" name="gender" value="남자">남자
							<input type="radio" id="gender" name="gender" value="여자">여자<br/>
							<fmt:formatDate value="${mentoBirth}" pattern="yyyy/MM/dd"/>
							<input style="width: 270px; margin-top: 3px;" type="date" id="mentoBirth" name="mentoBirth"><br/>
							<input style="width: 270px; margin-top: 3px;" type="text" id="cost" name="cost" value="${mento.cost}"><br/>
							<input style="width: 270px; margin-top: 3px;" type="text" id="member" name="member" value="${mento.member}"><br/>
							<input style="width: 270px; margin-top: 3px; margin-bottom: 3px;" type="date" id="startDate" name="startDate" value="${mento.startDate}"><br/>
							
							<select style="width: 270px;" id="category" name="category">
								<option value="${mento.categoryVO.categoryId}">${mento.categoryVO.categoryName}</option>
								<c:forEach items="${categoryList}" var="category" varStatus="index">
									<c:if test="${mento.categoryVO.categoryId ne category.categoryId}">
										<option value="${category.categoryId}">${category.categoryName}</option>
									</c:if>
								</c:forEach>
							</select><br/>
							
							<input style="width: 270px; margin-top: 3px;" type="text" id="etc" name="etc" value="${mento.etc}" ><br/>
							
							
							<input style="margin-top: 5px; float:right; margin-right: 50px;" type="button" class="w3-button w3-black w3-round-small" value="멘토 가입하기">  
						
					</div>
				</tr>
			</table>
		
		</form>
	</div>

</div>

</body>
</html>