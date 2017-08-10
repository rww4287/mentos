package com.ktds.mentos.user.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.mentos.user.mentee.service.MenteeService;
import com.ktds.mentos.user.mentee.service.MenteeServiceImpl;
import com.ktds.mentos.user.mentee.vo.MenteeVO;
import com.ktds.mentos.user.mento.service.MentoService;
import com.ktds.mentos.user.mento.service.MentoServiceImpl;
import com.ktds.mentos.user.mento.vo.MentoVO;

public class CommonSignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MentoService mentoService;
	private MenteeService menteeService;
	
    public CommonSignUpServlet() {
    	mentoService = new MentoServiceImpl();
    	menteeService = new MenteeServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doPost(request, response);
/*		HttpSession session = request.getSession();
		MentoVO mento = (MentoVO) session.getAttribute("_MENTO_");
		MenteeVO mentee = (MenteeVO) session.getAttribute("_MENTEE_");*/
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("common sign up");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/user/common/commonSignUp.jsp");
		dispatcher.forward(request, response);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/user/common/signUp.jsp");
//		dispatcher.forward(request, response);
		
/*		String mentoId = request.getParameter("mentoId");
		String mentoPassword = request.getParameter("mentoPassword");
		String menteeId = request.getParameter("menteeId");
		String menteePassword = request.getParameter("menteePassword");
		
		System.out.println("mentoId = " + mentoId);
		System.out.println("mentoPassword = " + mentoPassword);
		System.out.println("menteeId = " + menteeId);
		System.out.println("menteePassword = " + menteePassword);
		
		MentoVO mento = new MentoVO();
		mento.setMentoId(mentoId);
		mento.setMentoPassword(mentoPassword);
		
		mento = mentoService.getOneMento(mento);
		
		MenteeVO mentee = new MenteeVO();
		mentee.setMenteeId(menteeId);
		mentee.setMenteePassword(menteePassword);
		
		mentee = menteeService.getOneMentee(mentee);
		
		if(mento != null){ 
			HttpSession session = request.getSession();
			
			session.setAttribute("_MENTO_", mento);
			
			response.sendRedirect("/mentos/user/mento/signUp"); //추후 메인으로 이동
		} else {
			response.sendRedirect("/mentos/user/common/signUp");
		}
		
		if(mentee != null){ 
			HttpSession session = request.getSession();
			
			session.setAttribute("_MENTEE_", mentee);
			
			response.sendRedirect("/mentos/user/mentee/signUp"); //추후 메인으로 이동
		} else {
			response.sendRedirect("/mentos/user/common/signUp");
		}*/
	}

}
