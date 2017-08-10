package com.ktds.mentos.admin.category.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.mentos.admin.category.service.AdminCategoryService;
import com.ktds.mentos.admin.category.service.AdminCategoryServiceImpl;

public class DoDeleteActionServilet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AdminCategoryService categoryService;
    public DoDeleteActionServilet() {
    	categoryService = new AdminCategoryServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(404);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String categoryId = request.getParameter("categoryId");
		
		boolean isSuccess = categoryService.deleteCategory(categoryId);
		
		if(isSuccess){
			System.out.println("Success to Delete");
			response.sendRedirect("/mentos-admin/category/manageCategory");
		} else {
			System.out.println(categoryId);
			System.out.println("Fail to Delete");
			response.sendRedirect("/mentos-admin/category/manageCategory");
		}
	}

}
