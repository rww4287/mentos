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

public class CheckMentoDuplicated extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MentoService mentoService;
	
    public CheckMentoDuplicated() {
        mentoService = new MentoServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mentoId = request.getParameter("mentoId");
		
		System.out.println(mentoId);
		
		boolean isDuplicated = mentoService.isDuplicated(mentoId);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("status", "success");
		map.put("duplicated", isDuplicated);
		
		Gson gson = new Gson();
		String json = gson.toJson(map);
		
		PrintWriter writer = response.getWriter();
		
		writer.write(json.toString());
		writer.flush();
		writer.close();
	}

}
