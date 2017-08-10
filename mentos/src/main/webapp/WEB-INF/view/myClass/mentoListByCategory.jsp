<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mento List By Category </title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Open+Sans:300,600,700" rel="stylesheet" />
<link href="/mentos/css/main_default.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="/mentos/img/lib/w3.css">

<link rel="stylesheet" href="/mentos/css/myClass/demo.css" type="text/css" media="all">
<link rel="stylesheet" href="/mentos/css/myClass/styles.css" type="text/css" media="all">
<link rel="stylesheet" href="/mentos/css/myClass/default.css" type="text/css" media="all">

<script type="text/javascript" src="/mentos/static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	$().ready(function(){
		
		$("#registForm").find("input[type=button]").click( function(){
			var button = $(this);
			$.post("/mentos/myclass/classlist",{
				"menteeId" : $("#menteeId").val(),
				"mentoName" : button.data("name"),
				"mentoId" : button.data("id")
				
			},function(response){
				console.log("ajax");
				var jsonObj = JSON.parse(response);
				if(jsonObj.status=="success"){
					button.remove();
				}
			});
			
		});
	});
	
</script>
</head>
<body>
<input type="hidden" id="menteeId" value="${mentee.menteeId}"/>
<div id="header" class="container">
<div id="logo">
         <h1>
            <a href="/mentos/main">M E N T O S</a>
         </h1>
      </div>
      <div id="menu">
         <ul>
            <li class="current_page_item"><a href="/mentos/main">Homepage</a></li>
            <li><a href="/mentos/user/mento/mypage">Logout</a></li>
	<li><a href="/mentos/myclass/classlist">MentoList</a></li>
	<li><a href="/mentos/review/list" style="margin-right: 100px">Review</a></li>
         </ul>
      </div>
</div>

<div class = "defaultLayout">
	<div class="container">

<header>
	<div class= "middlebar">
		<span>Class List</span>
		<h2>Choose Your Mentor And Regist Your Class</h2>
	</div>
</header>


<div class="promos">

    <form id="registForm">
<c:forEach items="${valiList}" var="myclass"> 
    <div class="floating-box">
	        <ul class="features">
		    	<li class="name">
		      		<span>${myclass.mentoName}</span>
		      	</li>
	        	<li class="id">
		      		<b>이름</b><br/>${myclass.mentoId}
		      	</li>
	            <li class="price">
	            	<b>가격</b><br/> ${myclass.cost}
	            </li>
	            <li class="startDate">
	            	<b>시작일</b><br/>${myclass.startDate}
	            </li>
	            <li class="email">
		      		<b>이메일</b><br/>${myclass.email}
		      	</li>
		      	<li class="phone">
		      		<b>모바일</b><br/>${myclass.phone}
		      	</li>
		      	<li class="address">
		      		<b>주소</b><br/>${myclass.mentoAddress}
		      	</li>
		      	<li class="etc">
		      		<b>소개</b><br/>${myclass.etc}
		      	</li>
	            
	            <li> <br/>
	            		<input type="button" class="w3-button w3-black w3-round-small" id="regiBt" 
	            		 data-name="${myclass.mentoName}"   data-id="${myclass.mentoId}" value="등록하기">
	            	<br/>
	            </li>   
	        </ul>
    </div>
	</c:forEach>  
	  </form>
	
</div>
		</div>
	</div>
</body>
</html>