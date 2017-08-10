<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/mentos/css/review/default.css" />
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<style type="text/css">
 @import url(http://fonts.googleapis.com/earlyaccess/hanna.css); .main {font-family: 'Hanna';}
 

.defaultLayout{
   font-size:10pt;
   margin-top:15px;
   padding-top:0px;
   width: 100%;
   background-color: #ffffff;
   text-align: center;
   font-size: 11pt;
   font-weight: normal;
   position: relative;

}


table.type04 {
    border-collapse: separate;
    border-spacing: 1px;
    text-align: left;
    line-height: 1.5;
    border-top: 1px solid #ccc;
  	margin : 20px 10px;
  	width: 75%;
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
    
}


</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>detail page</title>
<script type="text/javascript"
	src="/mentos/static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	//댓글처리하기(비동기)
	$().ready(function() {

		$("#commentWriteForm").find("input[type=button]").click(function() {
			$.post("/mentos/review/detail?reviewId=${param.reviewId}", {

				'commentContent' : $("#commentContent").val(),
				'menteeId' : $("#menteeId").val()

			}, function(response) {
				var reviewResponse = JSON.parse(response);
				if (reviewResponse.status == 'success') {
					location.reload();
					alert("리뷰가 등록되었습니다 :) ");
				} else {
					alert("리뷰 등록을 실패하셨습니다.\n관리자에게 문의하세요.");
				}
			});
		});

		

	});
</script>
</head>

<body>
<div id="header" class="container">
<div id="logo">
			<h1>
				<a href="/mentos/main">M E N T O S</a>
			</h1>
		</div>
		<div id="menu">
			<ul>
				<li class="current_page_item"><a href="/mentos/main">Homepage</a></li>
	<li><a href="">MentoList</a></li>
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

<div class = "defaultLayout">
	<!-- 후기 DETAIL 구현-->
	<br/>
	<br/>

	<span class ="main" style="font-size: 30px; padding: 50px">${review.reviewTitle}</span>
	<p style="margin-top: 50px">Writer : ${review.menteeId} | Mento Name : ${review.mentoName}</p>
	<span>Write Date : ${review.reviewWriteDate} | </span>
	<span>Rating : <c:choose>
			<c:when test="${review.reviewRating == '1'}">
					            Very Bad <img src = "/mentos/img/review/VeryBad.PNG"  width ="30px" height="30px"/>
					        </c:when>
			<c:when test="${review.reviewRating == '2'}">
					            Bad <img src = "/mentos/img/review/Bad.PNG"  width ="30px" height="30px"/>
					        </c:when>
			<c:when test="${review.reviewRating == '3'}">
					            OK <img src = "/mentos/img/review/Okay.PNG"  width ="30px" height="30px"/>
					        </c:when>
			<c:when test="${review.reviewRating == '4'}">
					            Good <img src = "/mentos/img/review/Goood.PNG"  width ="30px" height="30px"/>
					        </c:when>
			<c:otherwise>
					            Awesome <img src = "/mentos/img/review/Awesome.PNG"  width ="30px" height="30px"/>
					        </c:otherwise>
		</c:choose>
	</span>
	
	
	<p style="margin-top: 50px;"><img src = "/mentos/img/review/chat-1873536_1280.png"  width ="100px" height="100px"/> <br/>${review.reviewContent}</p>

	<br/>
	<c:choose>
			<c:when test="${isMine}">
				<div class = "controls">
					<a  class="w3-button w3-black w3-round-small" href="/mentos/review/modify?reviewId=${review.reviewId}">수정</a>  
					<a  class="w3-button w3-black w3-round-small" href="/mentos/review/doDeleteReview?reviewId=${review.reviewId}">삭제</a>  
					<a  class="w3-button w3-black w3-round-small" href="/mentos/review/list"> 목록으로 돌아가기 </a>
				</div>
			</c:when>
			<c:otherwise>
				<div class = "controls">
					<a href="/mentos/review/list"> 목록으로 돌아가기 </a> 
				</div>
			</c:otherwise>
	</c:choose>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	
	<h3 class="main" style="text-align:center; text-color:gray;">#댓글을 남겨주세요.</h3>
	<!-- 댓글달기 WRITE 구현 -->
	<form id="commentWriteForm" >
		<textarea id="commentContent" name="commentContent" 
			style="width: 50%; height: 200px" placeholder="이 글에대해 댓글을 남겨주세요.">${comments.commentContent}</textarea>
		<input type="hidden" name="menteeId" value="${review.menteeId}" />
		<br/>
		<input  class="w3-button w3-black w3-round-small" type="button" value="댓글 등록" />
 		<br/>
	</form>
	<br/>
	<br/>
	<br/>

	<!-- 댓글달기 LIST 구현 -->

		<div id="tableDiv" style="margin-left: 200px">
			<table class = "type04">
				<tr>
					<th scope="row">No</th>
					<th scope="row">ID</th>
					<th scope="row">Content</th>
					<th scope="row">WriteDate</th>
				</tr>


			<c:forEach items="${commentsList}" var="comments" varStatus="index">
				<tr>
					<td>${index.index+1}</td>
					<td>${comments.menteeId}</td>
					<td>${comments.commentContent}</td>
					<td>${comments.commentDate}</td>
					
				<td>
					<c:choose>
						<c:when test="${isMine}">
							<div class = "controls">
								<a class="w3-button w3-tiny w3-black w3-round-small" href="">수정</a>
								<a class="w3-button w3-tiny w3-black w3-round-small" href="/mentos/review/comment/doDelete?commentId=${comments.commentId}">삭제</a> 
							</div>
						</c:when>
					<c:otherwise>
							<div class = "controls">
							</div>
					</c:otherwise>
					</c:choose>
				</td>
						
				
				</tr>
			</c:forEach>
			</table>
		</div>
	<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
</div>



</body>
</html>