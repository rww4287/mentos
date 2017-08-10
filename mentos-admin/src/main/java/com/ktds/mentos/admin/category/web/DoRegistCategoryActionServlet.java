package com.ktds.mentos.admin.category.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.mentos.admin.category.service.AdminCategoryService;
import com.ktds.mentos.admin.category.service.AdminCategoryServiceImpl;
import com.ktds.mentos.admin.category.vo.CategoryVO;

public class DoRegistCategoryActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AdminCategoryService categoryService;

	public DoRegistCategoryActionServlet() {
		categoryService = new AdminCategoryServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendError(404);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String categoryName = request.getParameter("categoryName");

		CategoryVO categoryVO = new CategoryVO();
		categoryVO.setCategoryName(categoryName);

		boolean isSuccess = categoryService.insertNewCategory(categoryVO);

		if (isSuccess) {
			response.sendRedirect("/mentos-admin/category/manageCategory");
		} else {
			response.sendRedirect("/mentos-admin/category/manageCategory");

		}
	}

}
