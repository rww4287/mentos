package com.ktds.mentos.admin.category.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.mentos.admin.category.service.AdminCategoryService;
import com.ktds.mentos.admin.category.service.AdminCategoryServiceImpl;
import com.ktds.mentos.admin.category.vo.CategoryVO;


public class ViewCategoryManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AdminCategoryService categoryService;
	public ViewCategoryManageServlet() {
		categoryService = new AdminCategoryServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<CategoryVO> categoryList = categoryService.showAllCategoryList();

		request.setAttribute("categoryList", categoryList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/category/manageCategory.jsp");
		dispatcher.forward(request, response);
	}

}
