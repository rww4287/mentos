package com.ktds.mentos.user.mento.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.ktds.mentos.myClass.service.MyClassService;
import com.ktds.mentos.myClass.service.MyClassServiceImpl;
import com.ktds.mentos.myClass.vo.MyClassVO;
import com.ktds.mentos.user.mento.service.MentoService;
import com.ktds.mentos.user.mento.service.MentoServiceImpl;
import com.ktds.mentos.user.mento.vo.MentoVO;

public class MentoMyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private MentoService mentoService;
    private MyClassService myClassService;
    public MentoMyPageServlet() {
        mentoService = new MentoServiceImpl();
        myClassService = new MyClassServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/user/mento/mypage.jsp");
		
		HttpSession session = request.getSession();
		MentoVO mentoVO = (MentoVO) session.getAttribute("_MENTO_");
		
		MentoVO mento = mentoService.getOneMento(mentoVO.getMentoId());

		List<MyClassVO> classList = myClassService.getMentoClass(mento.getMentoId());
		request.setAttribute("classList", classList);
		request.setAttribute("mento", mento);
		
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String classId = request.getParameter("classId");
		String mentoId = request.getParameter("mentoId");
		
		boolean isSuccess = myClassService.requestClass(classId);
		boolean isAccept = mentoService.updatePoint(mentoId);
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("status", (isSuccess && isAccept)? "success":"fail");
		map.put("classId", classId);
		
		Gson gson = new Gson();
		String json = gson.toJson(map);
		
		PrintWriter writer = response.getWriter();
		
		writer.write(json);
		writer.flush();
		writer.close();
	
	}

}
