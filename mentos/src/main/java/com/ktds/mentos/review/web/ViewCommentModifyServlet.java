package com.ktds.mentos.review.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.mentos.comments.vo.CommentsVO;
import com.ktds.mentos.review.service.ReviewService;
import com.ktds.mentos.review.service.ReviewServiceImpl;


public class ViewCommentModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ReviewService reviewService;
    public ViewCommentModifyServlet() {
        reviewService = new ReviewServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String commentId = request.getParameter("commentId"); //이거를 detail페이지에서 수정 버튼 눌렀을때 보내줘야지.
		CommentsVO comment = reviewService.getOneComment(commentId);
		request.setAttribute("comment", comment);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/review/comment/modify.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reviewId = request.getParameter("reviewId");
		String commentId = request.getParameter("commentId");
		String commentContent = request.getParameter("commentContent");
		String menteeId = request.getParameter("menteeId");
		
		CommentsVO commentsVO = new CommentsVO();
		commentsVO.setCommentContent(commentContent);
		commentsVO.setCommentId(commentId);
		commentsVO.setMenteeId(menteeId);
		commentsVO.setReviewId(reviewId);
		
		if(reviewService.updateOneComment(commentsVO)){
			StringBuffer script = new StringBuffer();
			script.append("<script type='text/javascript'>");
			script.append("    alert('댓글 수정 성공');");
			script.append("    opener.location.reload();");
			script.append("    self.close();"); 
			script.append("</script>");
			
			PrintWriter writer = response.getWriter();
			writer.write(script.toString());
			writer.flush();
			writer.close();
		}else{
			StringBuffer script = new StringBuffer();
			script.append("<script type='text/javascript'>");
			script.append("    alert('댓글 수정 실패');");
			script.append("    opener.location.reload();");
			script.append("    self.close();");
			script.append("</script>");
			
			PrintWriter writer = response.getWriter();
			writer.write(script.toString());
			writer.flush();
			writer.close();
		}
	}

}
