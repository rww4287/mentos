package com.ktds.mentos.admin.review.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.mentos.review.service.ReviewService;
import com.ktds.mentos.review.service.ReviewServiceImpl;

public class DoDeleteReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReviewService reviewService;

	public DoDeleteReviewServlet() {
		reviewService = new ReviewServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String reviewId = request.getParameter("reviewId");
		boolean isState = reviewService.deleteOneReview(reviewId);

		if (isState) {
			System.out.println("Success to Delete");
			response.sendRedirect("/mentos-admin/review/list");
		} else {
			System.out.println("Fail to Delete");
			response.sendRedirect("/mentos-admin/review/list");
		}
	}

}
