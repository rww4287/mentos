package com.ktds.mentos.review.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.mentos.common.web.pager.ClassicPageExplorer;
import com.ktds.mentos.common.web.pager.PageExplorer;
import com.ktds.mentos.review.service.ReviewService;
import com.ktds.mentos.review.service.ReviewServiceImpl;
import com.ktds.mentos.review.vo.ReviewSearchVO;
import com.ktds.mentos.review.vo.ReviewVO;
import com.ktds.mentos.user.admin.service.AdminService;
import com.ktds.mentos.user.admin.service.AdminServiceImpl;
import com.ktds.mentos.user.mentee.service.MenteeService;
import com.ktds.mentos.user.mentee.service.MenteeServiceImpl;
import com.ktds.mentos.user.mentee.vo.MenteeVO;
import com.ktds.mentos.user.mento.service.MentoService;
import com.ktds.mentos.user.mento.service.MentoServiceImpl;
import com.ktds.mentos.user.mento.vo.MentoVO;


public class VeiwReviewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReviewService reviewService;

	
    public VeiwReviewListServlet() {
        reviewService = new ReviewServiceImpl();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 로그아웃 처리
		 */
		HttpSession session = request.getSession();
		MenteeVO menteeVO = (MenteeVO) session.getAttribute("_MENTEE_");
		request.setAttribute("ismentee", true);
		request.setAttribute("mentee", menteeVO);
		
		
		
		/**
		 * 페이지 처리
		 */
		String pageNo = request.getParameter("pageNo");
		
		ReviewSearchVO reviewSearchVO = new ReviewSearchVO();
		reviewSearchVO.getPager().setPageNumber(pageNo);
		
		List<ReviewVO> reviewList = reviewService.getAllReviews(reviewSearchVO);
		
		
		PageExplorer pager = new ClassicPageExplorer(reviewSearchVO.getPager());
		
		/**
		 * JSP로 보내기
		 */
		request.setAttribute("reviewList", reviewList);
		request.setAttribute("reviewCount", reviewSearchVO.getPager().getTotalArticleCount());
		request.setAttribute("pager", pager.getPagingList("pageNo", "[@]", "prev", "next", "searchForm"));
		
		/**
		 * 로그인 기능 추가 시 작성 코드 & 권한?
		 */
//		HttpSession session = request.getSession();
		//로그인한 사용자의 정보를 가져오기
//		MenteeVO userVO = (MenteeVO) session.getAttribute("_USER_");
//		request.setAttribute("isNormalUser", userVO.getAuthorizationId().equals(AuthConst.NORMAL_USER));
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/review/list.jsp");
		dispatcher.forward(request, response);
	}

	}

