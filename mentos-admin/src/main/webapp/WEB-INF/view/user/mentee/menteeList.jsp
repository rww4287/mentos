<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>멘티 관리</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" type="text/css" href="/mentos-admin/css/main_layout.css" />
<link rel="stylesheet" type="text/css" href="/mentos-admin/css/main_default.css" />
<style type="text/css">

table.type04 {
    border-collapse: separate;
    border-spacing: 1px;
    text-align: left;
    line-height: 1.5;
    border-top: 1px solid #ccc;
  	margin : 20px 10px;
  	width: 50%;
}
table.type04 th {
    width: 150px;
    padding: 5px;
    font-weight: bold;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
    text-align: center;
    padding-bottom: 10px;
    padding-top: 10px;
}
table.type04 td {
    width: 350px;
    padding: 5px;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
    text-align: center;
    
}</style>
</head>
<body>
	<div id="header">
		<div id="logo">
		<h1><a href="/mentos-admin/adminMain">A D M I N - 멘티 리스트</a></h1>
		</div>
	</div>
<div id="wrapper">
	<div id="welcome" class="wrapper-style1">
	<div style="margin-left: 300px">
	<table class = "type04" >
		<tr>
			<th scope="row">아이디</th>
			<th scope="row">이름</th>
		</tr>
		<c:forEach items="${menteeList}" var="mentee">
			<tr>
				<td>${mentee.menteeId}</td>
				<td>
					<a href="/mentos-admin/user/mentee/detail?menteeId=${mentee.menteeId}">${mentee.menteeName}</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	</div>
</div>
</div>
		<div id="footer" class="container">
	
	</div>
</body>
</html>