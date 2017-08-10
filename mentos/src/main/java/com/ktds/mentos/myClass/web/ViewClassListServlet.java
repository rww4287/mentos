package com.ktds.mentos.myClass.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.mentos.myClass.biz.MyClassBiz;
import com.ktds.mentos.myClass.biz.MyClassBizImpl;
import com.ktds.mentos.myClass.vo.MyClassVO;
import com.ktds.mentos.user.mentee.vo.MenteeVO;
import com.ktds.mentos.user.mento.vo.MentoVO;


public class ViewClassListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private MyClassBiz myClassBiz;
       
    public ViewClassListServlet() {
    	myClassBiz = new MyClassBizImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpServletRequest rq = (HttpServletRequest)request;
		MentoVO mento = (MentoVO) rq.getSession().getAttribute("_MENTO_");
		MenteeVO mentee = (MenteeVO) rq.getSession().getAttribute("_MENTEE_");
		
		if(mento != null){
			request.setAttribute("ismento", true);
		}
		if(mentee != null){
			request.setAttribute("ismentee", true);
		}
		
		List<MyClassVO> classList = myClassBiz.getAllClass();
		request.setAttribute("classList", classList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/myClass/list.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}
