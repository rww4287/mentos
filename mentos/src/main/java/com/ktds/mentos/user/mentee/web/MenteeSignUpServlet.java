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

public class MenteeSignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MenteeService menteeService;
       
    public MenteeSignUpServlet() {
        menteeService = new MenteeServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/user/mentee/signUp.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String menteeId = request.getParameter("menteeId");
		String menteePassword = request.getParameter("menteePassword");
		String menteeName = request.getParameter("menteeName");
		String menteeAddress = request.getParameter("menteeAddress");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String menteeBirthday = request.getParameter("menteeBirthday");
		
		System.out.println(menteeId);
		System.out.println(menteePassword);
		System.out.println(menteeName);
		System.out.println(menteeAddress);
		System.out.println(phone);
		System.out.println(email);
		System.out.println(gender);
		System.out.println(menteeBirthday);
		
		MenteeVO mentee = new MenteeVO();
		
		mentee.setMenteeId(menteeId);
		mentee.setMenteePassword(menteePassword);
		mentee.setMenteeName(menteeName);
		mentee.setMenteeAddress(menteeAddress);
		mentee.setPhone(phone);
		mentee.setEmail(email);
		mentee.setGender(gender);
		mentee.setMenteeBirthday(menteeBirthday);
		
		if(menteeService.addNewMentee(mentee)) {
			response.sendRedirect("/mentos/user/common/login"); //  /mentos/login/signIn
		}
		else {
			response.sendError(404);
		}
	}

}
