package com.ktds.mentos.admin.review.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.mentos.review.service.ReviewService;
import com.ktds.mentos.review.service.ReviewServiceImpl;
import com.ktds.mentos.review.vo.ReviewVO;

public class ViewReviewDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReviewService reviewService;

	public ViewReviewDetailServlet() {
		reviewService = new ReviewServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String reviewId = request.getParameter("reviewId");

		ReviewVO reviewVO = reviewService.getOneReview(reviewId);
		request.setAttribute("review", reviewVO);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/review/detail.jsp");
		dispatcher.forward(request, response);
	}

}
