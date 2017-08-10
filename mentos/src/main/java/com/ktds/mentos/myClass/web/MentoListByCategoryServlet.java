package com.ktds.mentos.myClass.web;

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

import com.google.gson.Gson;
import com.ktds.mentos.myClass.service.MyClassService;
import com.ktds.mentos.myClass.service.MyClassServiceImpl;
import com.ktds.mentos.myClass.vo.MyClassVO;
import com.ktds.mentos.user.mentee.vo.MenteeVO;
import com.ktds.mentos.user.mento.service.MentoService;
import com.ktds.mentos.user.mento.service.MentoServiceImpl;
import com.ktds.mentos.user.mento.vo.MentoVO;

public class MentoListByCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MentoService mentoService;
	private MyClassService myClassService;
	public MentoListByCategoryServlet() {
		mentoService = new MentoServiceImpl();
		myClassService = new MyClassServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String categoryId = request.getParameter("categoryId");

		HttpServletRequest rq = (HttpServletRequest) request;
		MentoVO mento = (MentoVO) rq.getSession().getAttribute("_MENTO_");
		MenteeVO mentee = (MenteeVO) rq.getSession().getAttribute("_MENTEE_");

		if (mento != null) {
			request.setAttribute("mento", mento);
		}
		if (mentee != null) {
			request.setAttribute("mentee", mentee);
		}

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/myClass/mentoListByCategory.jsp");
		List<MentoVO> mentoList = mentoService.getMentosByCategoryId(categoryId);

		request.setAttribute("valiList", mentoList);
		request.setAttribute("categoryId", categoryId);

		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("서블릿");
		String menteeId = request.getParameter("menteeId");
		String mentoName = request.getParameter("mentoName");
		String mentoId = request.getParameter("mentoId");
		System.out.println(menteeId);
		System.out.println(mentoName);
		System.out.println(mentoId);
		MyClassVO myClassVO = new MyClassVO();
		myClassVO.getMenteeVO().setMenteeId(menteeId);
		myClassVO.getMentoVO().setMentoId(mentoId);
		myClassVO.getMentoVO().setMentoName(mentoName);
		
		boolean isStatus = myClassService.addClass(myClassVO);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", isStatus ? "success" : "fail");

		Gson gson = new Gson();
		String json = gson.toJson(map);

		PrintWriter writer = response.getWriter();
		System.out.println(isStatus);
		writer.write(json);
		writer.flush();
		writer.close();
	}

}
