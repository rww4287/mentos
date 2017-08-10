package com.ktds.mentos.review.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.mentos.review.service.ReviewService;
import com.ktds.mentos.review.service.ReviewServiceImpl;
import com.ktds.mentos.review.vo.ReviewVO;
import com.ktds.mentos.user.mentee.vo.MenteeVO;
import com.ktds.mentos.user.mento.vo.MentoVO;

public class ViewReviewWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ReviewService reviewService;

	public ViewReviewWriteServlet() {
		reviewService = new ReviewServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<MentoVO> mentoNameList = reviewService.getAllMentoNames();
		request.setAttribute("mentoNameList", mentoNameList);
		System.out.println(mentoNameList.get(1).getMentoName());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/review/write.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String reviewTitle = request.getParameter("reviewTitle");
		String reviewContent = request.getParameter("reviewContent");
		String reviewWriteDate = request.getParameter("reviewWriteDate");
		String mentoName = request.getParameter("mentoName");
		String mentoId = request.getParameter("mentoId");
		String reviewRating = request.getParameter("reviewRating");
		
	
	
		
		HttpSession session = request.getSession();
		MenteeVO menteeVO = (MenteeVO) session.getAttribute("_MENTEE_");
		request.setAttribute("ismentee", true);
		request.setAttribute("mentee", menteeVO);
		
		ReviewVO reviewVO = new ReviewVO();
		reviewVO.setReviewTitle(reviewTitle);
		reviewVO.setReviewContent(reviewContent);
		reviewVO.setReviewWriteDate(reviewWriteDate);
		reviewVO.setMentoName(mentoName);
		reviewVO.setMentoId(mentoId);
		reviewVO.setReviewRating(reviewRating);
		reviewVO.setMenteeId(menteeVO.getMenteeId());
		
		System.out.println(menteeVO.getMenteeId());

		boolean isStatus = reviewService.addNewReview(reviewVO);
		System.out.println(isStatus);
		if (isStatus) {
			System.out.println("Success to Write");
			response.sendRedirect("/mentos/review/list");
		} else {
			System.out.println("Fail to Write");
			response.sendRedirect("/mentos/review/list");
		}
	}
}