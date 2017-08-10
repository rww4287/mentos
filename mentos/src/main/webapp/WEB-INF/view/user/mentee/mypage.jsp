<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mentee MyPage</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Open+Sans:300,600,700" rel="stylesheet" />
<link href="/mentos/css/mypage/mypage_default.css" rel="stylesheet" type="text/css" media="all" />

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script type="text/javascript" src="/mentos/static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	$().ready(function(){
		var menteeId = $("#menteeId").val();
		console.log(menteeId);
		$("#modify").click(function(){
			location.href="/mentos/user/mentee/modify?menteeId=${mentee.menteeId}";
		});
		$("#charge").click(function(){
			window.open("/mentos/user/mentee/charge?menteeId="+menteeId,"포인트결제");
		});
		$("#logoutBt").click(function(){
			location.href="/mentos/user/common/logout";
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
			<li><a style="margin-right: 210px" href="/mentos/review/list">Review</a></li>
		</ul>
	</div>
</div>
<div class="wrapper">
	<div class="wrapper-style1">
		<div class="title">
		
	<div id="menteeContent"> 
	<input type="hidden" id="menteeId" value="${mentee.menteeId}">
    <h3 class="contentText"> ${mentee.menteeName}님 환영합니다 :) </h3><br/>
     <input type="button" class="w3-button w3-black w3-round-small" id="logoutBt" value="로그아웃"/>
     <input type="button" class="w3-button w3-black w3-round-small" id="modify" value="회원정보수정"/>
     <input type="button" class="w3-button w3-black w3-round-small" id="charge" value="포인트결제"/><br/><br/>
   	 <p class="contentText">  나의 포인트 : ${mentee.point} </p>
		 </div>
		</div>
	</div>
</div>


<div class="wrapper">
	<div id="welcome" class="wrapper-style1">
	<div id="requestList">
	<h3 id="listTitle" class="contentText"> 신청 목록 </h3>
		<div class="title">
			<table id="table" class="type04">
		        <tr>
		          <th scope="row">No</th>
		          <th scope="row">ID</th>
		          <th scope="row">Name</th>
		          <th scope="row">Category</th>
		          <th scope="row">Status</th>
		          <th> </th>
		        </tr>
		        <c:forEach items="${classList}" var="list" varStatus="index">
		          <tr>
		            <td>${index.index+1}</td>
		            <td>${list.mentoVO.mentoId}</td>
		            <td>${list.mentoVO.mentoName}</td>
		            <td>${list.mentoVO.categoryVO.categoryName}</td>
		            <td>${list.status}</td>
		          </tr>
		        </c:forEach>
		      </table>
			</div>
		</div>
</div>
</div>
<div id="footer" class="container">

</div>
</body>
</html>