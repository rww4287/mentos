<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Open+Sans:300,600,700" rel="stylesheet" />
<link href="/mentos/css/mypage/main_default.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" type="text/css"
	href="/mentos/css/mypage/main_layout.css" />
<link rel="stylesheet" href="/mentos/img/lib/w3.css">

<style>
.mySlides {
	display: none;
}
</style>
<script type="text/javascript" src="/mentos/static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	$().ready(function() {
		carousel();
		
		$("#login").click(function(){
			$('#id01').css('display','block');
		});
		$("#join").click(function(){
			$('#id02').css('display','block');
		});
		
	});

	var myIndex = 0;

	function carousel() {
		var slide = $(".mySlides");
		slide.hide();
		myIndex++;
		if (myIndex > slide.length) {
			myIndex = 1;
		}
		$(slide).each(function(index, data) {
			if (index == myIndex - 1) {
				$(data).show();
			}
		});

		setTimeout(carousel, 1500); // Change image every 2 seconds
	}
	
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
	<li><a href="/mentos/myclass/classlist">MentoList</a></li>
	<li><a href="/mentos/review/list">Review</a></li>
	<c:choose>
		<c:when test="${ismento}">
		
		<li><a href="/mentos/user/mento/mypage">MYPAGE</a></li>
		<li><a style="margin-right: 210px" href="/mentos/user/common/logout">LOGOUT</a><li>
		</c:when>
		<c:when test="${ismentee}">
			<li><a href="/mentos/user/mentee/mypage">MYPAGE</a></li>
			<li><a style="margin-right: 210px" href="/mentos/user/common/logout">LOGOUT</a></li>
		</c:when>
		<c:when test="${isAdmin}">
			<li><a href="/mentos-admin/adminMain">ADMIN PAGE</a></li>
			<li><a href="/mentos/user/common/logout">LOGOUT</a></li>
		</c:when>
		<c:otherwise>
		<li><a href=# id="login">Login</a>
		</li>
		<li><a href=# id="join" style="margin-right: 210px">Join</a>
		</li>
		</c:otherwise>
	</c:choose>
		</ul>
	</div>
</div>
<div id="wrapper">
	<div id="welcome" class="wrapper-style1">
		<div class="title">

			<div id="img" class="w3-content w3-section" style="margin-right: 200px">
				<img class="mySlides" src="/mentos/img/main_img/4.jpg"> <img
					class="mySlides" src="/mentos/img/main_img/1.jpg"> <img
					class="mySlides" src="/mentos/img/main_img/6.jpg">
			</div>

			<div id="id01" class="w3-modal">
				<span onclick="document.getElementById('id01').style.display='none'"
					class="w3-closebtn w3-hover-red w3-container w3-padding-hor-16 w3-display-topright w3-xxlarge">×</span>
				<div class="w3-modal-content w3-card-8 w3-animate-zoom"
					style="max-width: 600px">
			
					<jsp:include page="/WEB-INF/view/user/common/commonSignIn.jsp" />
			
					<div
						class="w3-container w3-border-top w3-padding-hor-16 w3-light-grey">
						<button
							onclick="document.getElementById('id01').style.display='none'"
							type="button" class="w3-btn w3-red">Cancel</button>
					</div>
				</div>
			</div>
			
			
			<div id="id02" class="w3-modal" >
				<span onclick="document.getElementById('id02').style.display='none'"
					class="w3-closebtn w3-hover-red w3-container w3-padding-hor-16 w3-display-topright w3-xxlarge">×</span>
				<div class="w3-modal-content w3-card-8 w3-animate-zoom"
					style="max-width: 600px">
			
					<jsp:include page="/WEB-INF/view/user/common/commonSignUp.jsp" />
			
					<div
						class="w3-container w3-border-top w3-padding-hor-16 w3-light-gray">
						<button
							onclick="document.getElementById('id02').style.display='none'"
							type="button" class="w3-btn w3-black">Cancel</button>
					</div>
				</div>
			</div>
			<div id="icons">
	<a href="/mentos/myclass/mentolistbycategory?categoryId=CT-2017040415-000004"><img src="/mentos/img/icon/business.png" class="icon"></a>
	<a href="/mentos/myclass/mentolistbycategory?categoryId=CT-2017040415-000005"><img src="/mentos/img/icon/developer.png" class="icon"> </a>
	<a href="/mentos/myclass/mentolistbycategory?categoryId=CT-2017040415-000003"><img src="/mentos/img/icon/event.png" class="icon"> </a>
	<a href="/mentos/myclass/mentolistbycategory?categoryId=CT-2017040415-000001"><img src="/mentos/img/icon/lesson.png" class="icon"></a>
	<a href="/mentos/myclass/mentolistbycategory?categoryId=CT-2017040415-000002"><img src="/mentos/img/icon/living.png" class="icon"> </a>
	<a style="margin-right: 160px" href="/mentos/myclass/mentolistbycategory?categoryId=CT-2017040415-000006"><img src="/mentos/img/icon/etc.png" class="icon"></a>
</div>
	</div>
</div>
</div>

<div id="footer" class="container">

</div>
</body>
</html>

