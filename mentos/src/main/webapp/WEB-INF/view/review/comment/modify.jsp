<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>후기게시판: 댓글 수정</title>
<script type="text/javascript" src="/mentos/static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	$().ready(function() {
		$("#commentModifyForm").find("input[type=button]").click(function() {
			$("#writeForm").attr({
				"action": "/mentos/review/comment/modify?commentId=${param.commentId}",
				"method": "post"
			});
		$("#commentModifyForm").submit();	
		});
	});
</script>
</head>
<body>
	<!-- Servlet에서 받은걸 뿌려야지 -->
	<form id="commentModifyForm" > 
		<input type="text" name="commentContent" value ="${comment.commentContent}"/><br/>
		<input type="button" value="등록"/>
	</form>

</body>
</html>