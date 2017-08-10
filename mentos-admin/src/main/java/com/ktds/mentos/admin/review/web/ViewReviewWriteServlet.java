package com.ktds.mentos.admin.review.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.mentos.admin.review.service.AdminReviewService;
import com.ktds.mentos.admin.review.service.AdminReviewServiceImpl;
import com.ktds.mentos.common.web.pager.Pager;
import com.ktds.mentos.common.web.pager.PagerFactory;
import com.ktds.mentos.review.vo.ReviewVO;
import com.ktds.mentos.user.mento.vo.MentoSearchVO;
import com.ktds.mentos.user.mento.vo.MentoVO;

public class ViewReviewWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AdminReviewService adminReviewService;

	public ViewReviewWriteServlet() {
		adminReviewService = new AdminReviewServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pageNo = request.getParameter("pageNo");
		Pager pager = PagerFactory.getPager(Pager.ORACLE);
		pager.setPageNumber(pageNo);

		MentoSearchVO searchVO = new MentoSearchVO();
		searchVO.setPager(pager);
		List<MentoVO> mentoNameList = adminReviewService.getAllMentoNames();
		request.setAttribute("mentoNameList", mentoNameList);
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

		ReviewVO reviewVO = new ReviewVO();
		reviewVO.setReviewTitle(reviewTitle);
		reviewVO.setReviewContent(reviewContent);
		reviewVO.setReviewWriteDate(reviewWriteDate);
		reviewVO.setMentoName(mentoName);
		reviewVO.setMentoId(mentoId);
		reviewVO.setReviewRating(reviewRating);

		boolean isSuccess = adminReviewService.insertNewReviewForAdmin(reviewVO);
		System.out.println(isSuccess);
		if (isSuccess) {
			System.out.println("Success to Write");
			response.sendRedirect("/mentos-admin/view/review/list");
		} else {
			System.out.println("Fail to Write");
			response.sendRedirect("/mentos-admin/view/review/list");
		}
	}
}
