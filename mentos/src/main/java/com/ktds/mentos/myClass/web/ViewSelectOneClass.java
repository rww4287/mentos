package com.ktds.mentos.myClass.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.mentos.user.mentee.vo.MenteeVO;

public class ViewSelectOneClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewSelectOneClass() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		MenteeVO menteeVO = (MenteeVO) session.getAttribute("_MENTEE_");

	}

}
