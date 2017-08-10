<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>권한 관리(등록)</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" type="text/css" href="/mentos-admin/css/default.css" />
<link rel="stylesheet" type="text/css" href="/mentos-admin/css/main_default.css" />

</head>
<body>
	<div id="header">
		<div id="logo">
			<h1><a href="/mentos-admin/adminMain">A D M I N - 권한 등록</a></h1>
		</div>
	</div>
<div id="wrapper">
	<div id="welcome" class="wrapper-style1">
	<form method="post" action="/mentos-admin/auth/doRegist">
		<span>권한 명</span><br /> 
		<input type="text" name="authName" /><br />
		<input type="submit" value="권한등록"></input>
	</form>
</div>
</div>
	<div id="footer" class="container">
	
	</div>
</body>
</html>