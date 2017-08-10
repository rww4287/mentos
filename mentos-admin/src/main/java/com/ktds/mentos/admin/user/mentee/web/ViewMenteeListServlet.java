package com.ktds.mentos.admin.user.mentee.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.mentos.admin.user.mentee.service.AdminMenteeService;
import com.ktds.mentos.admin.user.mentee.service.AdminMenteeServiceImpl;
import com.ktds.mentos.user.mentee.vo.MenteeVO;

public class ViewMenteeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AdminMenteeService adminMenteeService;

	public ViewMenteeListServlet() {
		adminMenteeService = new AdminMenteeServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<MenteeVO> menteeList = adminMenteeService.getAllMentees();

		request.setAttribute("menteeList", menteeList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/user/mentee/menteeList.jsp");
		dispatcher.forward(request, response);
	}

}
