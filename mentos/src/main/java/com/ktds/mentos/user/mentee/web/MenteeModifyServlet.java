package com.ktds.mentos.user.mentee.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.mentos.user.mentee.service.MenteeService;
import com.ktds.mentos.user.mentee.service.MenteeServiceImpl;
import com.ktds.mentos.user.mentee.vo.MenteeVO;

public class MenteeModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MenteeService menteeService;
    public MenteeModifyServlet() {
    	menteeService = new MenteeServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String menteeId = request.getParameter("menteeId");
	
		MenteeVO mentee = menteeService.getOneMentee(menteeId);
		
		request.setAttribute("mentee",mentee);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/user/mentee/modify.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String menteeId = request.getParameter("menteeId");
		String menteePassword = request.getParameter("menteePassword");
		String menteeAddress = request.getParameter("menteeAddress");
		String phone = request.getParameter("phone");
		String email= request.getParameter("email");

		
		MenteeVO mentee = new MenteeVO();
		
		mentee.setMenteeId(menteeId);
		mentee.setMenteePassword(menteePassword);
		mentee.setMenteeAddress(menteeAddress);
		mentee.setPhone(phone);
		mentee.setEmail(email);

		boolean isSuccess = menteeService.modifyMentee(mentee);
		
		if (isSuccess){
			response.sendRedirect("/mentos/user/mentee/mypage");
		}else{
			response.sendError(404);
		}
		
	}

}
