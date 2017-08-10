package com.ktds.mentos.user.mentee.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.mentos.myClass.service.MyClassService;
import com.ktds.mentos.myClass.service.MyClassServiceImpl;
import com.ktds.mentos.myClass.vo.MyClassVO;
import com.ktds.mentos.user.mentee.service.MenteeService;
import com.ktds.mentos.user.mentee.service.MenteeServiceImpl;
import com.ktds.mentos.user.mentee.vo.MenteeVO;

public class MenteeMypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MenteeService menteeService;
	private MyClassService myClassService;
	
    public MenteeMypageServlet() {
    	menteeService = new MenteeServiceImpl();
        myClassService = new MyClassServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/user/mentee/mypage.jsp");
		HttpSession session = request.getSession();
		MenteeVO menteeVO = (MenteeVO) session.getAttribute("_MENTEE_");
		MenteeVO mentee = menteeService.getOneMentee(menteeVO);
		
		List<MyClassVO> classList = myClassService.getMenteeClass(menteeVO.getMenteeId());
		
		request.setAttribute("mentee", mentee);
		request.setAttribute("classList", classList);
		
		dispatcher.forward(request, response);
		
	}

}
