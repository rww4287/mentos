package com.ktds.mentos.user.mento.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ktds.mentos.user.mento.service.MentoService;
import com.ktds.mentos.user.mento.service.MentoServiceImpl;

public class CheckDuplicated extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MentoService mentoService;
	
    public CheckDuplicated() {
        mentoService = new MentoServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mentoId = request.getParameter("mentoId");
		//String mentoPassword = request.getParameter("mentoPassword");
		
		System.out.println(mentoId);
		//System.out.println(mentoPassword);
		
		boolean isDuplicated = mentoService.isDuplicated(mentoId);
		//boolean isPasswordCheck = mentoService.isPasswordCheck(mentoPassword);
		
//		Map<String, Object> map = new HashMap<String, Object>();
//		
//		map.put("status", "success");
//		map.put("duplicated", isDuplicated);
//		
//		map.put("status", "success");
//		map.put("passwordCheck", isPasswordCheck);
//		
//		Gson gson = new Gson();
//		String json = gson.toJson(map);
		
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
