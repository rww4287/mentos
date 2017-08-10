package com.ktds.mentos.review.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.mentos.review.service.ReviewService;
import com.ktds.mentos.review.service.ReviewServiceImpl;

public class DoDeleteCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReviewService reviewService;

	public DoDeleteCommentServlet() {
		reviewService = new ReviewServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String commentId = request.getParameter("commentId");
		boolean isStatus = reviewService.deleteOneComment(commentId);
		System.out.println(commentId);
		if (isStatus) {
			PrintWriter out = response.getWriter();
			out.println("<script language='javascript'>");
			out.println("alert('Success To Delete');");
			out.println("location.href = '/mentos/review/list';");
			out.println("</script>");
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script language='javascript'>");
			out.println("alert('Fail To Delete');");
			out.println("location.href = '/mentos/review/list';");
			out.println("</script>");
		}
	}

}
