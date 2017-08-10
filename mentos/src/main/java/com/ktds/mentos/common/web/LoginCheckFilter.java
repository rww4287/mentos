package com.ktds.mentos.common.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.mentos.user.admin.vo.AdminVO;
import com.ktds.mentos.user.mentee.vo.MenteeVO;
import com.ktds.mentos.user.mento.vo.MentoVO;

public class LoginCheckFilter implements Filter {

	public LoginCheckFilter() {
	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest rq = (HttpServletRequest) request;
		MentoVO mento = (MentoVO) rq.getSession().getAttribute("_MENTO_");
		MenteeVO mentee = (MenteeVO) rq.getSession().getAttribute("_MENTEE_");
		AdminVO admin = (AdminVO) rq.getSession().getAttribute("_ADMIN_");

		if (mento == null && mentee == null) {
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			httpResponse.sendRedirect("/mentos/user/common/login");
			return;
		} else if (admin != null) {
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			httpResponse.sendRedirect("/mentos-admin/adminMain");
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
