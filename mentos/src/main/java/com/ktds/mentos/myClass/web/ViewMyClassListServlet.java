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
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.ktds.mentos.common.web.pager.ClassicPageExplorer;
import com.ktds.mentos.common.web.pager.PageExplorer;
import com.ktds.mentos.myClass.biz.MyClassBiz;
import com.ktds.mentos.myClass.service.MyClassService;
import com.ktds.mentos.myClass.service.MyClassServiceImpl;
import com.ktds.mentos.myClass.vo.MyClassVO;
import com.ktds.mentos.user.admin.vo.AdminVO;
import com.ktds.mentos.user.mentee.vo.MenteeVO;
import com.ktds.mentos.user.mento.service.MentoService;
import com.ktds.mentos.user.mento.service.MentoServiceImpl;
import com.ktds.mentos.user.mento.vo.MentoSearchVO;
import com.ktds.mentos.user.mento.vo.MentoVO;

public class ViewMyClassListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MyClassService myClassService;
    private MentoService mentoService;

    public ViewMyClassListServlet() {
    	myClassService = new MyClassServiceImpl();
    	mentoService = new MentoServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String pageNo = request.getParameter("pageNo");
		
		MentoSearchVO searchVO = new MentoSearchVO();
		searchVO.getPager().setPageNumber(pageNo);
		
		HttpServletRequest rq = (HttpServletRequest)request;
		MentoVO mento = (MentoVO) rq.getSession().getAttribute("_MENTO_");
		MenteeVO mentee = (MenteeVO) rq.getSession().getAttribute("_MENTEE_");
		
		if(mento != null){
			request.setAttribute("mento", mento);
		}
		if(mentee != null){
			request.setAttribute("mentee", mentee);
		}		
		
		List<MentoVO> valiList = mentoService.getAllMentos(searchVO);
        request.setAttribute("valiList", valiList);
        
        PageExplorer pager = new ClassicPageExplorer(searchVO.getPager());
        
        request.setAttribute("mentoCount", searchVO.getPager().getTotalArticleCount());
        request.setAttribute("pager", pager.getPagingList("pageNo", "[@]", "prev", "next", "searchForm"));
        System.out.println(pager.getPagingList("pageNo", "[@]", "prev", "next", "searchForm"));
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/myClass/classlist.jsp");
        dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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