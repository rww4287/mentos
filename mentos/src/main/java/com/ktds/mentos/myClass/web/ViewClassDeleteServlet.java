package com.ktds.mentos.myClass.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.mentos.myClass.biz.MyClassBiz;
import com.ktds.mentos.myClass.biz.MyClassBizImpl;
import com.ktds.mentos.user.admin.vo.AdminVO;
import com.ktds.mentos.user.mentee.vo.MenteeVO;
import com.ktds.mentos.user.mento.vo.MentoVO;

public class ViewClassDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MyClassBiz myClassBiz;

	public ViewClassDeleteServlet() {
		myClassBiz = new MyClassBizImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String classId = null;

		// try{
		classId = request.getParameter("classId");
		// }
		// catch(NumberFormatException e) {
		// throw new RuntimeException("존재하지 않는 게시물 입니다 ");
		// }

		HttpServletRequest rq = (HttpServletRequest) request;
		MentoVO mento = (MentoVO) rq.getSession().getAttribute("_MENTO_");
		MenteeVO mentee = (MenteeVO) rq.getSession().getAttribute("_MENTEE_");

		if (mento != null) {
			request.setAttribute("ismento", true);
		}
		if (mentee != null) {
			request.setAttribute("ismentee", true);
		}
		
		if (myClassBiz.deleteClass(classId)) {
			response.sendRedirect("/myClass/list");
		} else {
			response.sendRedirect("/myClass/classlist");
		}

	}

}
