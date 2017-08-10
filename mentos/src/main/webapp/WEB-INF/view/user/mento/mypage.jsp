<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Open+Sans:300,600,700" rel="stylesheet" />
<link href="/mentos/css/mypage/mypage_default.css" rel="stylesheet" type="text/css" media="all" />

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Mento MyPage</title>
<script type="text/javascript" src="/mentos/static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	$().ready(function(){
		$("#modify").click(function(){
			location.href="/mentos/user/mento/modify?mentoId=${mento.mentoId}";
		});

		$("#table").find("input[type=button]").click(function(){
		
			var button = $(this);
			console.log(button);

			$.post("/mentos/user/mento/mypage",{
				"classId" : button.data("id"),
				"mentoId" : button.data("mentoid")
			},function(response){
				var res = JSON.parse(response);
				if (res.status == "success") {
					button.closest('tr').find("#status").text("요청완료");
					button.hide();
					alert("요청이 수락 되었습니다!");
					
				} else{
					alert("오류 발생!");
				}
			});
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
			<li><a href="/mentos/review/list" style="margin-right: 210px">Review</a></li>
		</ul>
	</div>
</div>

<div class="wrapper">
	<div class="wrapper-style1">
		<div class="title">
		
		 <div id="mentoContent"> 
		 	<h3 class="contentText">${mento.mentoName}님 환영합니다 :) </h3>
			<input type="button" class="w3-button w3-black w3-round-small" id="logoutBt" value="로그아웃"/>
			<input type="button" class="w3-button w3-black w3-round-small" id="modify" value="회원정보수정"/><br/><br/>
			<p class="contentText">나의 포인트: ${mento.point}</p><br/>
		 </div>
		</div>
	</div>
</div>

<div class="wrapper">

	<div id="welcome" class="wrapper-style1">
	<div id="requestList">
	<h3 id="listTitle" class="contentText"> 요청 목록 </h3>
		<div class="title">
				<table id="table" class="type04">
				       <tr>      
				       <th scope="row">No</th>
				       <th scope="row">ID</th>
				       <th scope="row">Name</th>
				       <th scope="row">Status</th>
				    </tr>
					<c:forEach items="${classList}" var="list" varStatus="index">
						<tr>
				 			<td>${index.index+1}</td>
							<td>${list.menteeVO.menteeId}</td>
							<td>${list.menteeVO.menteeName}</td>
							<td id="status">${list.status}</td>
							<c:if test="${list.status eq '요청중'}">
				
							<td><input type="button" class="w3-button w3-tiny w3-black w3-round-small" data-id="${list.classId}" data-mentoid="${list.mentoVO.mentoId}" value="요청수락"></td>
							</c:if>
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
