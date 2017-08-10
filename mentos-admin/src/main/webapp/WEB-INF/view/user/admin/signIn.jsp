<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
<link rel="stylesheet" type="text/css" href="/mentos-admin/css/main_layout.css" />
<link rel="stylesheet" type="text/css" href="/mentos-admin/css/main_default.css" />
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script type="text/javascript" src="/mentos/static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
$().ready(function() {
	$("#signInBtn").click(function() {
		$("#signInForm").attr({
			 "action" : "/mentos-admin/signIn",
			 "method" : "post"
			 
		});
		$("#signInForm").submit();
	});
});
</script>
</head>
<body>
	<div id="header">
		<div id="logo">
		<h1><a href="/mentos-admin/adminMain">A D M I N - Sign In</a></h1>
		</div>
	</div>
<div id="wrapper">
	<div id="welcome" class="wrapper-style1">
	<form id="signInForm">
    <div class="w3-container">
      <div class="w3-section" style="text-align: center">
      	<br/>
      	<br/>
        <br/>
        <label><b>ID</b></label>
        
        <input  type="text" 
        name="id" placeholder="Enter Username">
<br/>
<br/>
        <label ><b>Password</b></label>
        <input type="password" style="margin-right: 60px"
        name="password" placeholder="Enter Password"><br/>
        
        <input class="w3-check" name="login" value="관리자" type="checkbox"> 관리자로 로그인하기 <br/>
        <button class="w3-btn w3-btn-block w3-gray w3-section" id="signInBtn">Login</button>
        	
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
		<br/>
			<br/>
		<br/>
		<br/>
		<br/>

      </div>
    </div>
    </form>
    </div>
    		</div>
	

    

		
</body>
</html>