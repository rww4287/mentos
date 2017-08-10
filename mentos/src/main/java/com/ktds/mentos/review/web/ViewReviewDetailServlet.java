package com.ktds.mentos.review.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.ktds.mentos.comments.vo.CommentsVO;
import com.ktds.mentos.review.service.ReviewService;
import com.ktds.mentos.review.service.ReviewServiceImpl;
import com.ktds.mentos.review.vo.ReviewVO;
import com.ktds.mentos.user.mentee.vo.MenteeVO;

public class ViewReviewDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReviewService reviewService;

	public ViewReviewDetailServlet() {
		reviewService = new ReviewServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 로그아웃 처리
		 */
		HttpSession session = request.getSession();
		MenteeVO menteeVO = (MenteeVO) session.getAttribute("_MENTEE_");
		request.setAttribute("ismentee", true);
		request.setAttribute("mentee", menteeVO);
		

		String reviewId = request.getParameter("reviewId");
		ReviewVO reviewVO = reviewService.getOneReview(reviewId);
		request.setAttribute("review", reviewVO);
		request.setAttribute("isMine", menteeVO.getMenteeId().equals(reviewVO.getMenteeId()));
		
		
		
		List<CommentsVO> CommentsList = reviewService.getAllComments(reviewId);
		request.setAttribute("commentsList", CommentsList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/review/detail.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// doGet(url��)���� �޾ƿ� ��
		String reviewId = request.getParameter("reviewId");
		String commentId = request.getParameter("commentId");

		String commentContent = request.getParameter("commentContent");
		
		HttpSession session = request.getSession();
		MenteeVO menteeVO = (MenteeVO) session.getAttribute("_MENTEE_");
		
		CommentsVO commentsVO = new CommentsVO();
		commentsVO.setCommentContent(commentContent);
		commentsVO.setCommentId(commentId);
		commentsVO.setMenteeId(menteeVO.getMenteeId());
		commentsVO.setReviewId(reviewId);

		boolean isStatus = reviewService.addNewComments(commentsVO);

		// �񵿱� ���
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", isStatus ? "success" : "fail");

		Gson gson = new Gson();
		String json = gson.toJson(map);

		PrintWriter writer = response.getWriter();
		System.out.println(isStatus);
		writer.write(json);
		writer.flush();
		writer.close();

	}

}
