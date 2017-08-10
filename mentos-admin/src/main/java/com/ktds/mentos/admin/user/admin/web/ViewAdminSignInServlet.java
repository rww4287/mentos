package com.ktds.mentos.admin.user.admin.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.mentos.admin.user.admin.service.AdminAdminService;
import com.ktds.mentos.admin.user.admin.service.AdminAdminServiceImpl;
import com.ktds.mentos.user.admin.vo.AdminVO;

public class ViewAdminSignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AdminAdminService adminService;

	public ViewAdminSignInServlet() {
		adminService = new AdminAdminServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/user/admin/signIn.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/main/adminMain.jsp");
		rd.forward(request, response);

		String login = request.getParameter("login");

		if (login.equals("관리자")) {
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
				response.sendRedirect("/mentos-admin/signIn");
			}
		}
	}

}
