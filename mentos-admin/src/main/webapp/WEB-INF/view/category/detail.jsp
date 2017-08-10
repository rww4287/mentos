<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>카테고리 보기</title>
<link rel="stylesheet" type="text/css" href="/mentos-admin/css/main_default.css" />

<script type="text/javascript" src="/mentos-admin/static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	$().ready(function(){
		$("#modifyCategoryForm").find("input[type=button]").click(function(){
			$("#modifyCategoryForm").attr({
				"method" : "post",
				"action" : "/mentos-admin/category/doModify"
			});
			$("#modifyCategoryForm").submit();
		});
		$("#deleteCategoryForm").find("input[type=button]").click(function(){
			$("#deleteCategoryForm").attr({
				"method" : "post",
				"action" : "/mentos-admin/category/doDelete"
			});
			$("#deleteCategoryForm").submit();
		});
	});
</script>
</head>
<body>
	<div id="header">
		<div id="logo">
		<h1><a href="/mentos-admin/adminMain">A D M I N - 카테고리 등록</a></h1>
		</div>
	</div>
<div id="wrapper">
	<div id="welcome" class="wrapper-style1">
	<form id="modifyCategoryForm">
		<input type="text" name="categoryName" value="${param.categoryName}"/>
		<input type="button" value="카테고리 수정">
	</form>

	<form id="deleteCategoryForm">
		<input type="hidden" name="categoryId" value="${param.categoryId}"/>
		<input type="button" value="카테고리 삭제" />
	</form>
</div>
</div>
	<div id="footer" class="container">
	</div>
</body>
</html>