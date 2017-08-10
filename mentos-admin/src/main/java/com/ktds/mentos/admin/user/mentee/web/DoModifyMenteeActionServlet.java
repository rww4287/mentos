package com.ktds.mentos.admin.user.mentee.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.mentos.admin.user.mentee.service.AdminMenteeService;
import com.ktds.mentos.admin.user.mentee.service.AdminMenteeServiceImpl;
import com.ktds.mentos.user.mentee.vo.MenteeVO;

public class DoModifyMenteeActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminMenteeService adminMenteeService;

	public DoModifyMenteeActionServlet() {
		adminMenteeService = new AdminMenteeServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendError(404);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String menteeId = request.getParameter("menteeId");
		String menteePassword = request.getParameter("menteePassword");
		String menteeAddress = request.getParameter("menteeAddress");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");

		MenteeVO menteeVO = new MenteeVO();
		menteeVO.setMenteeId(menteeId);
		menteeVO.setMenteePassword(menteePassword);
		menteeVO.setMenteeAddress(menteeAddress);
		menteeVO.setPhone(phone);
		menteeVO.setEmail(email);

		boolean isSuccess = adminMenteeService.modifyMentee(menteeVO);

		if (isSuccess) {
			System.out.println("Success to modify");
			response.sendRedirect("/mentos-admin/user/mentee/detail");
		} else {
			System.out.println("Fail to modify");
			response.sendRedirect("/mentos-admin/user/mentee/detail");
		}

	}
}
