package com.ktds.mentos.myClass.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.mentos.myClass.service.MyClassService;
import com.ktds.mentos.myClass.service.MyClassServiceImpl;
import com.ktds.mentos.myClass.vo.MyClassVO;
import com.ktds.mentos.user.mentee.vo.MenteeVO;

public class ViewRegistNewClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MyClassService myClassService;

	public ViewRegistNewClass() {
		myClassService = new MyClassServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendError(404);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String classId = request.getParameter("classId");

		MyClassVO myclassVO = new MyClassVO();
		myclassVO.setClassId(classId);

		boolean isSuccess = myClassService.addClass(myclassVO);

		if (isSuccess) {
			response.sendRedirect("/mentos/myclass/list");
		} else {
			response.sendRedirect("/mentos/myclass/list");
		}
	}

}
