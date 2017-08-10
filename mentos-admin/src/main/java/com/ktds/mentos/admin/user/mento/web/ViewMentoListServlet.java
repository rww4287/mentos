package com.ktds.mentos.admin.user.mento.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.mentos.admin.user.mento.service.AdminMentoService;
import com.ktds.mentos.admin.user.mento.service.AdminMentoServiceImpl;
import com.ktds.mentos.common.web.pager.Pager;
import com.ktds.mentos.common.web.pager.PagerFactory;
import com.ktds.mentos.user.mento.vo.MentoSearchVO;
import com.ktds.mentos.user.mento.vo.MentoVO;

public class ViewMentoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AdminMentoService adminMentoService;

	public ViewMentoListServlet() {
		adminMentoService = new AdminMentoServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pageNo = request.getParameter("pageNo");
		Pager pager = PagerFactory.getPager(Pager.ORACLE);
		pager.setPageNumber(pageNo);

		MentoSearchVO searchVO = new MentoSearchVO();
		searchVO.setPager(pager);

		List<MentoVO> mentoList = adminMentoService.getAllMentos(searchVO);

		request.setAttribute("mentoList", mentoList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/user/mento/mentoList.jsp");
		dispatcher.forward(request, response);
	}

}
