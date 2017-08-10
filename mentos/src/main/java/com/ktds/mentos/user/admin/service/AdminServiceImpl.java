package com.ktds.mentos.user.admin.service;

import com.ktds.mentos.user.admin.biz.AdminBiz;
import com.ktds.mentos.user.admin.biz.AdminBizImpl;
import com.ktds.mentos.user.admin.vo.AdminVO;

public class AdminServiceImpl implements AdminService{

	private AdminBiz adminBiz;
	public AdminServiceImpl(){
		adminBiz = new AdminBizImpl();
	}
	@Override
	public AdminVO getOneAdmin(AdminVO adminVO) {
		return adminBiz.selectOneAdmin(adminVO);
	}
	@Override
	public boolean loginAdmin(AdminVO adminVO) {
		return adminBiz.loginAdmin(adminVO);
	}

}
