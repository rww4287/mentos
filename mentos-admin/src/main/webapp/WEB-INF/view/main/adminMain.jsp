<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mentos-admin 메인페이지</title>
<link rel="stylesheet" type="text/css" href="/mentos-admin/css/main_layout.css" />
<link rel="stylesheet" type="text/css" href="/mentos-admin/css/main_default.css" />
</head>
<body>

	<div id="header" class="container">
		<div id="logo">
		<h1><a href="/mentos-admin/adminMain">M E N T O S - A D M I N</a></h1>
		</div>
		<c:choose>
			<c:when test="${isAdmin}">
			${admin.adminId} 님 환영합니다!:)<br />
				<a href="/mentos/user/common/logout">LOGOUT</a>
			</c:when>
		</c:choose>
	</div>
	
<div id="wrapper">
	<div id="welcome" class="wrapper-style1">
		<div class="title">
	<div class="div_wrap">
		<div id="button">
		
			<div id="userBtn">
			<a href="/mentos-admin/user/manageUser"><img src="/mentos-admin/img/intern_mento.jpg" id="userBtn"></a>
				<div class="userMiddle">
	    			<div class="userText">  Manage User  </div>
	  			</div>
			</div>
			<div id="categoryBtn">	
				<a href="/mentos-admin/category/manageCategory"><img src="/mentos-admin/img/intern_mentee.jpg" id="categoryBtn"> </a>
				<div class="categoryMiddle">
	    			<div class="categoryText">Manage Category</div>
	  			</div>
			</div>
			<div id="reviewBtn">	
				<a href="/mentos-admin/review/list"><img src="/mentos-admin/img/review.png" id="reviewBtn"></a>
				<div class="reviewMiddle">
	    			<div class="reviewText">Manage Review</div>
	  			</div>
			</div>
			<div id="authBtn">	
				<a href="/mentos-admin/auth/manageAuth"><img src="/mentos-admin/img/auth.png" id="authBtn"></a>
				<div class="authMiddle">
	    			<div class="authText">Manage Auth</div>
	  			</div>
			</div>

			
		</div>
	</div>
		</div>
	</div>
</div>
	<div id="footer" class="container">
	
	</div>
	
</body>
</html>