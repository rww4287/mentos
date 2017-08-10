package com.ktds.mentos.user.mentee.web;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ktds.mentos.user.mentee.service.MenteeService;
import com.ktds.mentos.user.mentee.service.MenteeServiceImpl;

public class CheckMenteeDuplicated extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MenteeService menteeService;
	
    public CheckMenteeDuplicated() {
        menteeService = new MenteeServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String menteeId = request.getParameter("menteeId");
		
		System.out.println(menteeId);
		
		boolean isDuplicated = menteeService.isDuplicated(menteeId);

		
		StringBuffer json = new StringBuffer();
		json.append(" { ");
		json.append(" \"status\" : \"success\",  ");
		json.append(" \"duplicated\" : " + isDuplicated);
		json.append(" } ");
		
		PrintWriter writer = response.getWriter();
		
		writer.write(json.toString());
		writer.flush();
		writer.close();
	}

}
