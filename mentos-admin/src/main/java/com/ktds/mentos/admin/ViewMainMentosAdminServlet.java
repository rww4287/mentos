package com.ktds.mentos.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.mentos.user.admin.vo.AdminVO;
import com.ktds.mentos.user.mentee.vo.MenteeVO;
import com.ktds.mentos.user.mento.vo.MentoVO;

public class ViewMainMentosAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewMainMentosAdminServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/main/adminMain.jsp");
		
		AdminVO admin = (AdminVO) request.getSession().getAttribute("_ADMIN_");

		if(admin != null){
			request.setAttribute("isAdmin", true);
		}
		
		dispatcher.forward(request, response);
	}

}
