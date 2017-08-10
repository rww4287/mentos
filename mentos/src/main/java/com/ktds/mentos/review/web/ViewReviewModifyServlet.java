package com.ktds.mentos.review.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.mentos.user.mentee.vo.MenteeVO;
import com.ktds.mentos.user.mento.vo.MentoSearchVO;
import com.ktds.mentos.user.mento.vo.MentoVO;
import com.ktds.mentos.review.service.ReviewService;
import com.ktds.mentos.review.service.ReviewServiceImpl;
import com.ktds.mentos.review.vo.ReviewVO;


public class ViewReviewModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ReviewService reviewService;

    public ViewReviewModifyServlet() {
    	reviewService = new ReviewServiceImpl();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 로그아웃 처리
		 */
		HttpSession session = request.getSession();
		MenteeVO menteeVO = (MenteeVO) session.getAttribute("_MENTEE_");
		request.setAttribute("ismentee", true);
		request.setAttribute("mentee", menteeVO);
		
		List<MentoVO> mentoNameList = reviewService.getAllMentoNames();
		request.setAttribute("mentoNameList", mentoNameList);
	
		String reviewId = request.getParameter("reviewId");
	
		ReviewVO reviewVO = reviewService.getOneReview(reviewId);
		System.out.println(reviewVO.getReviewContent());
		String content = reviewVO.getReviewContent();
		content = content.replaceAll("<br/>", "\n");
		reviewVO.setReviewContent(content);
		request.setAttribute("review", reviewVO);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/review/modify.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reviewId = request.getParameter("reviewId");
		String reviewTitle = request.getParameter("reviewTitle");
		String reviewContent = request.getParameter("reviewContent");
		String mentoName = request.getParameter("mentoName");
		String reviewRating	= request.getParameter("reviewRating");

		
		reviewContent = reviewContent.replaceAll("\n", "<br/>");
		reviewContent = reviewContent.replaceAll("\r", "");
		
//		HttpSession session = request.getSession();
//		UsersVO user = (UsersVO) session.getAttribute("_USER_");

		ReviewVO reviewVO = new ReviewVO();
//		reviewVO.setWriter(user.getUserId());
		reviewVO.setReviewTitle(reviewTitle);
		reviewVO.setReviewContent(reviewContent);
		reviewVO.setMentoName(mentoName);
		reviewVO.setReviewId(reviewId);
		reviewVO.setReviewRating(reviewRating);

		if (reviewService.updateOneReview(reviewVO)) {
			System.out.println("�닔�젙�쓣 �셿猷뚰뻽�뒿�땲�떎.");
			response.sendRedirect("/mentos/review/list");
		}else{
			System.out.println("�닔�젙�쓣 �떎�뙣�뻽�뒿�땲�떎.");
			response.sendRedirect("/mentos/review/list");
		}
		
	}
		
		
	}


