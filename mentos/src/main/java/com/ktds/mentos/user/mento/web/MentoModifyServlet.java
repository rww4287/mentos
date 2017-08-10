package com.ktds.mentos.user.mento.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.mentos.category.service.CategoryService;
import com.ktds.mentos.category.service.CategoryServiceImpl;
import com.ktds.mentos.category.vo.CategoryVO;
import com.ktds.mentos.user.mento.service.MentoService;
import com.ktds.mentos.user.mento.service.MentoServiceImpl;
import com.ktds.mentos.user.mento.vo.MentoVO;

public class MentoModifyServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private MentoService mentoService;
    private CategoryService categoryService;
    
    public MentoModifyServlet() {
    	mentoService = new MentoServiceImpl();
    	categoryService = new CategoryServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mentoId = request.getParameter("mentoId");
		
		MentoVO mento = mentoService.getOneMento(mentoId);
		List<CategoryVO> categoryList = categoryService.showAllCategoryList(); 
		
		request.setAttribute("mento",mento);
		request.setAttribute("categoryList",categoryList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/user/mento/modify.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String mentoId = request.getParameter("mentoId");
		String mentoPassword = request.getParameter("mentoPassword");
		String mentoAddress = request.getParameter("mentoAddress");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String startDate = request.getParameter("startDate");
		String costString = request.getParameter("cost");
		String memberString = request.getParameter("member");
		String categoryId = request.getParameter("category");
		String comment = request.getParameter("comment");
		String etc = request.getParameter("mentoEtc");
		
		int cost = 0;
		int member = 0;
		
		if( costString == null ){
			cost = 0;
		} else {
			try {
				cost = Integer.parseInt(costString);
			} catch(NumberFormatException e){
				throw new RuntimeException(e.getMessage(),e);
			}
		}
		
		if( memberString == null ){
			member = 0;
		} else {
			try {
				member = Integer.parseInt(memberString);
			}catch(NumberFormatException e){
				throw new RuntimeException(e.getMessage(),e);
			}
		}
		
	
		
		MentoVO mento = new MentoVO();
		
		mento.setMentoId(mentoId);
		mento.setMentoPassword(mentoPassword);
		mento.setMentoAddress(mentoAddress);
		mento.setPhone(phone);
		mento.setEmail(email);
		mento.setStartDate(startDate);
		mento.setCost(cost);
		mento.setMember(member);
		mento.getCategoryVO().setCategoryId(categoryId);
		mento.setComment(comment);
		mento.setEtc(etc);
		
		
		if (mentoService.modifyMento(mento)){
			response.sendRedirect("/mentos/user/mento/mypage");
		} else {
			response.sendError(404);
		}
		
	}

}
