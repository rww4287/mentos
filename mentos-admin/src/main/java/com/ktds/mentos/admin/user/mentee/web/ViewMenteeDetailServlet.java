package com.ktds.mentos.admin.user.mentee.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.mentos.admin.user.mentee.service.AdminMenteeService;
import com.ktds.mentos.admin.user.mentee.service.AdminMenteeServiceImpl;
import com.ktds.mentos.user.mentee.vo.MenteeVO;

public class ViewMenteeDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AdminMenteeService adminMenteeService;

	public ViewMenteeDetailServlet() {
		adminMenteeService = new AdminMenteeServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String menteeId = request.getParameter("menteeId");

		MenteeVO menteeVO = adminMenteeService.getOneMentee(menteeId);

		request.setAttribute("mentee", menteeVO);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/user/mentee/detail.jsp");
		dispatcher.forward(request, response);

	}

}
