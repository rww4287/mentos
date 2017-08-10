package com.ktds.mentos.admin.authorization.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.mentos.admin.authorization.service.AdminAuthService;
import com.ktds.mentos.admin.authorization.service.AdminAuthServiceImpl;
import com.ktds.mentos.admin.authorization.vo.AuthVO;

public class DoRegistNewAuthActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AdminAuthService authService;

	public DoRegistNewAuthActionServlet() {
		authService = new AdminAuthServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendError(404);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String authName = request.getParameter("authName");

		AuthVO authVO = new AuthVO();
		authVO.setAuthName(authName);

		
		boolean isSuccess = authService.insertNewAuth(authVO);
		
		if (isSuccess) {
			response.sendRedirect("/mentos-admin/auth/manageAuth");
		} else {
			response.sendRedirect("/mentos-admin/auth/manageAuth");
		}
	}

}
