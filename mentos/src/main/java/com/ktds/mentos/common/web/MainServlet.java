package com.ktds.mentos.common.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.mentos.user.admin.vo.AdminVO;
import com.ktds.mentos.user.mentee.vo.MenteeVO;
import com.ktds.mentos.user.mento.vo.MentoVO;

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MainServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/main/main.jsp");

		HttpServletRequest rq = (HttpServletRequest)request;
		MentoVO mento = (MentoVO) rq.getSession().getAttribute("_MENTO_");
		MenteeVO mentee = (MenteeVO) rq.getSession().getAttribute("_MENTEE_");
		AdminVO admin = (AdminVO) rq.getSession().getAttribute("_ADMIN_");
		
		if(mento != null){
			request.setAttribute("ismento", true);
		}
		if(mentee != null){
			request.setAttribute("ismentee", true);
		}
		if(admin != null){
			request.setAttribute("isAdmin", true);
		}
		rd.forward(request, response);
	}

}
