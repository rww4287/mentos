<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mento Modify</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Open+Sans:280,600,700" rel="stylesheet" />
<link href="/mentos/css/mypage/main_default.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="/mentos/img/lib/w3.css">
<script type="text/javascript" src="/mentos/static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">

	$().ready(function(){
		
		console.log("ddd"+$("#mentoEtc").val());
		if($("#mentoEtc").val() ==""){
			$("#mentoEtc").hide();
		}
		$("#passwordBt").click(function(){
			
			$(this).hide();
			$("#mentoPassword").removeAttr("disabled");
		});
		$("#addressBt").click(function(){
			
			$(this).hide();
			$("#mentoAddress").removeAttr("disabled");
		});
		
		$("#phoneBt").click(function(){
			
			$(this).hide();
			$("#phone").removeAttr("disabled");
		});
		$("#emailBt").click(function(){
			
			$(this).hide();
			$("#email").removeAttr("disabled");
		});
		$("#startDateBt").click(function(){
			
			$(this).hide();
			$("#startDate").removeAttr("disabled");
		});
		$("#costBt").click(function(){

			$(this).hide();
			$("#cost").removeAttr("disabled");

		});
		$("#memberBt").click(function(){
			
			$(this).hide();
			$("#member").removeAttr("disabled");
			
		});
		$("#categoryBt").click(function(){

			$(this).hide();
			$("#category").removeAttr("disabled");
			
			
			$("#category").change(function(){
				
				var etcVal = $("#mentoEtc").val();
				var cat = $("#category").val();
				
				console.log(cat);
				
				if(cat == "CT-2017040415-000006"){
					$("#mentoEtc").show();
					$("#mentoEtc").val(etcVal);
					$("#mentoEtc").removeAttr("disabled");
				} else {
					$("#mentoEtc").hide();
					
				}
			
			});
			
		});
				
		$("#commentBt").click(function(){
			
			$(this).hide();
			$("#comment").removeAttr("disabled");

		
		});
		

		
		$("#modifyForm").find("input[type=submit]").click(function(){
			
			console.log($("#mentoEtc").val());

			if($("#mentoPassword").val().length <= 7){
				alert("비밀번호는 8자리 이상으로 입력해주세요!");
				$("#mentoPassword").focus();
				return;
			} 
			else { 
				$("#modifyForm").attr({
					"method" : "post",
					"action" :"/mentos/user/mento/modify"
				});
				if (confirm("수정 하시겠습니까?") == true){
					$("#modifyForm").submit();
				}else{ 
				    return;
				}
				
			}
			
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
<div id="wrapper">
	<div id="welcome" class="wrapper-style1">
		<div class="title">
<h3 id="modifytitle" class="contentText">멘토 회원 정보 수정 </h3><br/>
<div id=modifydiv>
 	<form id="modifyForm">
 		 	<table id="modifyMentoTable" style="text-align:left;">
				<tr>
					<div class="p" style="width:20%; float:left;">
						<tr>
							<th>ID : </th>
						</tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr>
							<th>Password : </th>
						</tr>
						<tr>
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
						<tr></tr>
						<tr></tr>
						<tr>
							<th>Address : </th>
						</tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
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
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr>
							<th>Email :</th>
						</tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr>
							<th>StartDate :</th>
						</tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr>
							<th>Cost :</th>
						</tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr>
							<th>MemberNumber :</th>
						</tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr>
							<th>Category :</th>
						</tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr>
							<th>Introduce :</th>
						</tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
					</div>
				</tr>
				
	<div style="width:80%; margin-right:8%; float:right; text-align: left;">
 	<input type="hidden" id="mentoId" name="mentoId" value="${mento.mentoId}">
 	<input type="hidden" id="etc" name="etc" value="">
		<div class="pmentoid"> ${mento.mentoId}<br/></div>
		
		<input style="width: 280px; margin-top: 10px; margin-right: 5px;" type="password" id="mentoPassword" name="mentoPassword"  value="${mento.mentoPassword}" disabled="disabled">
		<input type="button" class="w3-button w3-tiny w3-black w3-round-small"  id="passwordBt" value="수정하기"/><br/>
	
		<div class="pmentoid"> ${mento.mentoName}<br/> </div>
		
		<input style="width: 280px; margin-top: 10px; margin-right: 5px;" type="text"  id="mentoAddress" name="mentoAddress" value="${mento.mentoAddress}" disabled="disabled">
		<input type="button" class="w3-button w3-tiny w3-black w3-round-small"  id="addressBt" value="수정하기"/><br/>
		
		<input style="width: 280px; margin-top: 10px; margin-right: 5px;" type="text" id="phone" name="phone" value="${mento.phone}" disabled="disabled">
		<input type="button" class="w3-button w3-tiny w3-black w3-round-small"  id="phoneBt" value="수정하기"/><br/>
		
		<input style="width: 280px; margin-top: 10px; margin-right: 5px;" type="text"  id="email" name="email" value="${mento.email}" disabled="disabled">
		<input  type="button" class="w3-button w3-tiny w3-black w3-round-small"  id="emailBt" value="수정하기"/><br/>

		<input style="width: 280px; margin-top: 10px; margin-right: 5px;" type="date" id="startDate" name="startDate" value="${mento.startDate}" disabled="disabled">
		<input type="button" class="w3-button w3-tiny w3-black w3-round-small"   id="startDateBt" value="수정하기"/><br/>
		
		<input style="width: 280px; margin-top: 10px; margin-right: 5px;" type="text" name="cost" id="cost" value="${mento.cost}" disabled="disabled">
		<input type="button" class="w3-button w3-tiny w3-black w3-round-small"  id="costBt" value="수정하기"/><br/>
		
		<input style="width: 280px; margin-top: 10px; margin-right: 5px;" type="text" id="member" name="member" value="${mento.member}" disabled="disabled">
		<input type="button" class="w3-button w3-tiny w3-black w3-round-small"  id="memberBt" value="수정하기"/><br/>

			<select style="width: 280px; margin-top: 12px; margin-right: 5px;" id="category" name="category" disabled="disabled">
			<option value="${mento.categoryVO.categoryId}">${mento.categoryVO.categoryName}</option>
				<c:forEach items="${categoryList}" var="category" varStatus="index">
					<c:if test="${mento.categoryVO.categoryId ne category.categoryId}">
					<option value="${category.categoryId}">${category.categoryName}</option>
					</c:if>
				</c:forEach>
			</select>
			
	
		<input style="width: 280px; margin-top: 10px; margin-right: 5px;" type="text" id="mentoEtc" name="mentoEtc" value="${mento.etc}" disabled="disabled">
		<input type="button" class="w3-button w3-tiny w3-black w3-round-small"  id="categoryBt" value="수정하기"/><br/>
		
		<br/><textarea rows="5" cols="33" id="comment" name="comment" disabled="disabled" >${mento.comment}</textarea>
 		<input type="button"  class="w3-button w3-tiny w3-black w3-round-small"  id="commentBt" value="수정하기"> <br/>
	</table><br/>
	<input type="submit" class="w3-button w3-tiny w3-black w3-round-small" value="모두 수정하기">
</form>
</div>
</div>
</div>
</div>

<div id="footer" class="container">

</div>
</body>
</html>