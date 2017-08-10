package com.ktds.mentos.user.mentee.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.mentos.user.mentee.service.MenteeService;
import com.ktds.mentos.user.mentee.service.MenteeServiceImpl;
import com.ktds.mentos.user.mentee.vo.MenteeVO;

public class MenteeChargeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MenteeService menteeService;
    public MenteeChargeServlet() {
    	menteeService = new MenteeServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/user/mentee/charge.jsp");
		
		String menteeId = request.getParameter("menteeId");
		MenteeVO mentee = menteeService.getOneMentee(menteeId);
		
		request.setAttribute("mentee", mentee);
		rd.forward(request, response);
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("servlet");
		String menteeId = request.getParameter("menteeId");
		String pointString = request.getParameter("point");
		
		int point = 0;
		try {
			point = Integer.parseInt(pointString); 
		}catch(NumberFormatException e){
			throw new RuntimeException(e.getMessage(),e);
		}
		
		if (menteeService.updatePoint(menteeId, point)){
			PrintWriter writer = response.getWriter();
			StringBuffer sb = new StringBuffer();
			sb.append("<script type='text/javascript'>");
			sb.append("		opener.location.reload();");
			sb.append("		self.close();");
			sb.append("</script>");
			
			writer.write(sb.toString());
			writer.flush();
			writer.close();
		}else {
			response.sendError(404);
		}
		
		
	}

}
