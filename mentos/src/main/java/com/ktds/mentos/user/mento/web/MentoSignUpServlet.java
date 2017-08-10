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
import com.ktds.mentos.common.web.MultipartHttpServletRequest;
import com.ktds.mentos.user.mento.service.MentoService;
import com.ktds.mentos.user.mento.service.MentoServiceImpl;
import com.ktds.mentos.user.mento.vo.MentoVO;

public class MentoSignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MentoService mentoService;
	private CategoryService categoryService;
	
    public MentoSignUpServlet() {
    	mentoService = new MentoServiceImpl();
    	categoryService = new CategoryServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("멘토signup");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/user/mento/signUp.jsp");
		
		List<CategoryVO> categoryList = categoryService.showAllCategoryList();
		request.setAttribute("categoryList", categoryList);
		
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request,response);
		MultipartHttpServletRequest multipart = new MultipartHttpServletRequest(request);
		String mentoId = multipart.getParameter("mentoId");
		String mentoPassword = multipart.getParameter("mentoPassword");
		String mentoName = multipart.getParameter("mentoName");
		String mentoBirth = multipart.getParameter("mentoBirth");
		String mentoAddress = multipart.getParameter("mentoAddress");
		String phone = multipart.getParameter("phone");
		String email = multipart.getParameter("email");
		String member = multipart.getParameter("member");
		String startDate = multipart.getParameter("startDate");
		String gender = multipart.getParameter("gender");
		String cost = multipart.getParameter("cost");
		String category = multipart.getParameter("category");
		String etc = multipart.getParameter("etc");
		
		System.out.println(mentoId);
		System.out.println(mentoPassword);
		System.out.println(mentoName);
		System.out.println(mentoBirth);
		System.out.println(mentoAddress);
		System.out.println(phone);
		System.out.println(email);
		System.out.println(member);
		System.out.println(startDate);
		System.out.println(gender);
		System.out.println(cost);
		System.out.println(category);
		System.out.println(etc);
		
		MentoVO mento = new MentoVO();
		
		mento.setMentoId(mentoId);
		mento.setMentoPassword(mentoPassword);
		mento.setMentoName(mentoName);
		mento.setMentoBirth(mentoBirth);
		mento.setMentoAddress(mentoAddress);
		mento.setPhone(phone);
		mento.setEmail(email);
		mento.setMember(Integer.parseInt(member));
		mento.setStartDate(startDate);
		mento.setGender(gender);
		mento.setCost(Integer.parseInt(cost));
		mento.getCategoryVO().setCategoryId(category);
		mento.setEtc(etc);
		
		//System.out.println("된거니"+mentoService.addMento(mento));
		
		if (mentoService.addMento(mento)) {
			System.out.println("dddd");
			response.sendRedirect("/mentos/user/common/login");
		}
		else {
			response.sendError(404);
		}
		
	}

}
