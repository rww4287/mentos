<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>카테고리 관리</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" type="text/css" href="/mentos-admin/css/default.css" />
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
<script type="text/javascript" src="/mentos-admin/static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	$().ready(function(){
		$("#registCategoryForm").find("input[type=button]").click(function(){
			$("#registCategoryForm").attr({
				"method" : "post",
				"action" : "/mentos-admin/category/doRegist"
			});
			$("#registCategoryForm").submit();
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
	
	<div style="margin-left: 300px">
	<table class = "type04" >
		<tr>
			<th scope="row">카테고리ID</th>
			<th scope="row">카테고리명</th>
		</tr>
		<c:forEach items="${categoryList}" var="category">			
			<tr>
				<td>
					${category.categoryId}
				</td>
				<td>
					<a href="/mentos-admin/category/detail?categoryId=${category.categoryId}&categoryName=${category.categoryName}">${category.categoryName}</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	</div>
	<hr>
	<form id="registCategoryForm"  style="margin-left: 300px">
		<input style="margin-left: 100px" type="text" name="categoryName" />
		<input class="w3-button w3-tiny w3-black w3-round-small" type="button" value="카테고리 등록" />
	</form>
	</div>
</div>
	<div id="footer" class="container">
	
	</div>
</body>
</html>