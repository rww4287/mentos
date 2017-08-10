<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>멘토 상세정보 조회</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" type="text/css" href="/mentos-admin/css/default.css" />
<link rel="stylesheet" type="text/css" href="/mentos-admin/css/main_default.css" />
<script type="text/javascript" src="/mentos/static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">

	$().ready(function(){
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
				var cat = $("#category").val();
				console.log(cat);
				if(cat == "CT-2017032909-000006"){
					var pcategory = $("<input type='text' id='input' >");
					$("#category").after(pcategory);
				}
			});
		});
				
		$("#commentBt").click(function(){
			$(this).hide();
			$("#comment").removeAttr("disabled");
		});
		
		$("#modifyForm").find("input[type=submit]").click(function(){
			console.log($("#input").val());
			$("#etc").val($("#input").val());
			if($("#mentoPassword").val().length <= 7){
				alert("비밀번호는 8자리 이상으로 입력해주세요!");
				$("#mentoPassword").focus();
				return;
			} else { 
				$("#modifyForm").attr({
					"method" : "post",
					"action" :"/mentos-admin/user/mento/doModify"
				});
				if (confirm("수정 하시겠습니까?") == true){
					$("#modifyForm").submit();
				} else { 
				    return;
				}
			}
		});
	});
</script>
</head>
<body>
	<div id="header">
		<div id="logo">
		<h1><a href="/mentos-admin/adminMain">A D M I N - 멘토 정보 수정</a></h1>
		</div>
	</div>
<div id="wrapper">
	<div id="welcome" class="wrapper-style1">

 	<form id="modifyForm">
 	<input type="hidden" id="mentoId" name="mentoId" value="${mento.mentoId}">
 	<input type="hidden" id="etc" name="etc" value="">
		ID : ${mento.mentoId}<br/>
		
		Password : 
		<input type="password" id="mentoPassword" name="mentoPassword" value="${mento.mentoPassword}" disabled="disabled">
		<input type="button" id="passwordBt" value="수정하기"/><br/>
	
		Name :  ${mento.mentoName}<br/>
		
		Address : 
		<input type="text"  id="mentoAddress" name="mentoAddress" value="${mento.mentoAddress}" disabled="disabled">
		<input type="button" id="addressBt" value="수정하기"/><br/>
		
		Phone : 
		<input type="text" id="phone" name="phone" value="${mento.phone}" disabled="disabled">
		<input type="button" id="phoneBt" value="수정하기"/><br/>
		
		Email : 
		<input type="text"  id="email" name="email" value="${mento.email}" disabled="disabled">
		<input type="button" id="emailBt" value="수정하기"/><br/>

		수업 시작 날짜 : 
		<input type="date" id="startDate" name="startDate" value="${mento.startDate}" disabled="disabled">
		<input type="button" id="startDateBt" value="수정하기"/><br/>
		
		수업료 : 
		<input type="text" name="cost" id="cost" value="${mento.cost}" disabled="disabled">
		<input type="button" id="costBt" value="수정하기"/><br/>
		
		수강 인원 :  
		<input type="text" id="member" name="member" value="${mento.member}" disabled="disabled">
		<input type="button" id="memberBt" value="수정하기"/><br/>
		
		카테고리 : 
			<select  id="category" name="category" disabled="disabled">
			<option value="${mento.categoryVO.categoryId}">${mento.categoryVO.categoryName}</option>
				<c:forEach items="${categoryList}" var="category" varStatus="index">
					<c:if test="${mento.categoryVO.categoryId ne category.categoryId}">
						<option value="${category.categoryId}">${category.categoryName}</option>
					</c:if>
				</c:forEach>
			</select>
			<input type="button" id="categoryBt" value="수정하기"/><br/>
			
		나의 소개 : <br/>
		<textarea rows="5" cols="30" id="comment" name="comment" disabled="disabled" >${mento.comment}</textarea>
 		<input type="button"  id="commentBt" value="수정하기"> <br/>
		<input type="submit" value="모두 수정하기">
	</form>
</div>
</div>
		<div id="footer" class="container">
	
	</div>
</body>
</html>