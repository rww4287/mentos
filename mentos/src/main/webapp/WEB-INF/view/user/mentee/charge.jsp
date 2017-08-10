<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Point Charge</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Open+Sans:300,600,700" rel="stylesheet" />
<link href="/mentos/css/mypage/main_default.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="/mentos/img/lib/w3.css">
<script type="text/javascript" src="/mentos/static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
$().ready(function(){
	$("#chargeBt").click(function(){
		$("#chargeFrm").attr({
			"method" : "post",
			"action" : "/mentos/user/mentee/charge?menteeId=${param.menteeId}"
		});
		$("#chargeFrm").submit();
	});
});
</script>
<title>payment</title>
</head>
<body>
	<div id="header" class="container">
		<div id="logo">
			<h1><a>POINT Charge</a></h1>
		</div>
	</div>
	<div id="wrapper">
		<div id="welcome" class="wrapper-style1">
			<div class="title">
				<form id="chargeFrm">
				<table id="modifyMentoTable" style="text-align:left;">
				<tr>
					<div class="p" style="width:20%; float:left;">
						<tr>
							<th> USER : </th>
						</tr>
						<tr></tr>
						<tr></tr>
						<tr>
							<th> Current Point : </th>
						</tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr>
							<th> Payment Point : </th>
						</tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
					</div>
				</tr>
				
		<div style="width:80%; margin-right:8%; float:right; text-align: left;">
					<div class="payContent"> ${mentee.menteeName} (${mentee.menteeId}) <br/> </div>
					<div class="payContent"> ${mentee.point} <br/> </div>
					<div class="payContent"> <input type="text" id="point" name="point" style="width: 280px;" placeholder="결제할 포인트를 입력해주세요."><br/> </div>
					</div>
					</table>
					<input type="button" class="w3-button w3-tiny w3-black w3-round-small" id="chargeBt" value="결제하기">
				</form>
			</div>
		</div>
	</div>
	
	<div id="footer" class="container">
	
	</div>

</body>
</html>