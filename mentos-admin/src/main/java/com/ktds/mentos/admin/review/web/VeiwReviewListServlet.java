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
import com.ktds.mentos.common.web.pager.ClassicPageExplorer;
import com.ktds.mentos.common.web.pager.PageExplorer;
import com.ktds.mentos.review.vo.ReviewSearchVO;
import com.ktds.mentos.review.vo.ReviewVO;

public class VeiwReviewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AdminReviewService adminReviewService;
	public VeiwReviewListServlet() {
		adminReviewService = new AdminReviewServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pageNo = request.getParameter("pageNo");

		ReviewSearchVO reviewSearchVO = new ReviewSearchVO();
		reviewSearchVO.getPager().setPageNumber(pageNo);

		List<ReviewVO> reviewList = adminReviewService.selectAllReviewsForAdmin(reviewSearchVO);

		PageExplorer pager = new ClassicPageExplorer(reviewSearchVO.getPager());

		request.setAttribute("reviewList", reviewList);
		request.setAttribute("reviewCount", reviewSearchVO.getPager().getTotalArticleCount());
		request.setAttribute("pager", pager.getPagingList("pageNo", "[@]", "prev", "next", "searchForm"));

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/review/list.jsp");
		dispatcher.forward(request, response);
	}

}
