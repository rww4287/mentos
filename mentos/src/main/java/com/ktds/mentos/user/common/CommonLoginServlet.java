package com.ktds.mentos.user.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.mentos.user.admin.service.AdminService;
import com.ktds.mentos.user.admin.service.AdminServiceImpl;
import com.ktds.mentos.user.admin.vo.AdminVO;
import com.ktds.mentos.user.mentee.service.MenteeService;
import com.ktds.mentos.user.mentee.service.MenteeServiceImpl;
import com.ktds.mentos.user.mentee.vo.MenteeVO;
import com.ktds.mentos.user.mento.service.MentoService;
import com.ktds.mentos.user.mento.service.MentoServiceImpl;
import com.ktds.mentos.user.mento.vo.MentoVO;

public class CommonLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MentoService mentoService;
	private MenteeService menteeService;
	private AdminService adminService;

	public CommonLoginServlet() {
		mentoService = new MentoServiceImpl();
		menteeService = new MenteeServiceImpl();
		adminService = new AdminServiceImpl();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/user/common/commonSignIn.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/main/main.jsp");

		String login = request.getParameter("login");

		if (login.equals("멘토")) {
			String mentoId = request.getParameter("id");
			String mentoPassword = request.getParameter("password");

			MentoVO mento = new MentoVO();

			mento.setMentoId(mentoId);
			mento.setMentoPassword(mentoPassword);

			MentoVO mentoVO = mentoService.getOneMento(mento);

			if (mentoService.sucessMento(mentoVO)) {
				HttpSession session = request.getSession();
				session.setAttribute("_MENTO_", mento);
				request.setAttribute("ismento", true);
				request.setAttribute("mento", mentoVO);
				rd.forward(request, response);
			} else {
				System.out.println("로그인에 실패하였습니다.");
				response.sendRedirect("/mentos/user/common/signUp");
			}
		} else if (login.equals("멘티")) {
			String menteeId = request.getParameter("id");
			String menteePassword = request.getParameter("password");

			MenteeVO mentee = new MenteeVO();
			mentee.setMenteeId(menteeId);
			mentee.setMenteePassword(menteePassword);

			MenteeVO menteeVO = menteeService.getOneMentee(mentee);

			if (menteeService.sucessMentee(menteeVO)) {

				HttpSession session = request.getSession();
				session.setAttribute("_MENTEE_", mentee);
				request.setAttribute("ismentee", true);
				request.setAttribute("mentee", menteeVO);
				rd.forward(request, response);
			} else {
				System.out.println("로그인에 실패하였습니다.");
				response.sendRedirect("/mentos/user/common/signUp");
			}

		} else if (login.equals("관리자")) {
			String adminId = request.getParameter("id");
			String adminPassword = request.getParameter("password");

			AdminVO admin = new AdminVO();
			admin.setAdminId(adminId);
			admin.setAdminPassword(adminPassword);

			AdminVO adminVO = adminService.getOneAdmin(admin);

			if (adminService.loginAdmin(adminVO)) {

				HttpSession session = request.getSession();
				session.setAttribute("_ADMIN_", admin);
				request.setAttribute("isAdmin", true);
				request.setAttribute("admin", adminVO);
				rd.forward(request, response);
				
			} else {
				System.out.println("로그인 실패.");
				response.sendRedirect("/mentos/user/common/signUp");
			}

		}

	}

}
