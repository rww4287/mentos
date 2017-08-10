package com.ktds.mentos.admin.user.mento.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.mentos.admin.user.mento.service.AdminMentoService;
import com.ktds.mentos.admin.user.mento.service.AdminMentoServiceImpl;
import com.ktds.mentos.user.mento.vo.MentoVO;

public class ViewMentoDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AdminMentoService adminMentoService;

	public ViewMentoDetailServlet() {
		adminMentoService = new AdminMentoServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mentoId = request.getParameter("mentoId");

		MentoVO mentoVO = adminMentoService.getOneMento(mentoId);

		request.setAttribute("mento", mentoVO);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/user/mento/detail.jsp");
		dispatcher.forward(request, response);

	}

}
