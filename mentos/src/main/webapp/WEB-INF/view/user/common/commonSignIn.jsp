<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
<script type="text/javascript" src="/mentos/static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
$().ready(function() {
	$("#signInBtn").click(function() {
		$("#signInForm").attr({
			/*
			 * 나중에 action 수정. (로그인 되면 메인페이지로 이동 (버튼 상태 : 로그아웃 / 마이페이지))
			 */
			 "action" : "/mentos/user/common/login",
			 "method" : "post"
			 
		});
		$("#signInForm").submit();
	});
	
	$("#SignUpBtn").click(function() {
		$("#signInForm").attr({
			/*
			 * 회원 가입하는 페이지로 이동
			 */
			 "action" : "/mentos/user/common/signUp",
			 "method" : "post"
			 
		});
		$("#signInForm").submit();
	});
	
	
});
</script>
</head>
<body>

	<form id="signInForm">
    <div class="w3-container">
      <div class="w3-section">
        <label><b>ID</b></label>
        <input class="w3-input w3-border w3-hover-border-black w3-margin-bottom" type="text" 
        name="id" placeholder="Enter Username">

        <label><b>Password</b></label>
        <input class="w3-input w3-border w3-hover-border-black" type="password"
        name="password" placeholder="Enter Password">
        
        <button class="w3-btn w3-btn-block w3-gray w3-section" id="signInBtn">Login</button>
        <input class="w3-check" name="login" value="멘토" type="checkbox"> 멘토로 로그인하기
        <input class="w3-check" name="login" value="멘티" type="checkbox"> 멘티로 로그인하기
        <input class="w3-check" name="login" value="관리자" type="checkbox"> 관리자로 로그인하기
        

      </div>
    </div>
    </form>


	
</body>
</html>