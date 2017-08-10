package com.ktds.mentos.admin.authorization.service;

import java.util.List;

import com.ktds.mentos.admin.authorization.biz.AdminAuthBiz;
import com.ktds.mentos.admin.authorization.biz.AdminAuthBizImpl;
import com.ktds.mentos.admin.authorization.vo.AuthVO;

public class AdminAuthServiceImpl implements AdminAuthService{

	private AdminAuthBiz authBiz;
	public AdminAuthServiceImpl(){
		authBiz = new AdminAuthBizImpl();
	}
	@Override
	public boolean insertNewAuth(AuthVO authVO) {
		return authBiz.registNewAuth(authVO);
	}
	@Override
	public List<AuthVO> getAllAuthList(AuthVO authVO) {
		return authBiz.getAllAuthList(authVO);
	}
	
	

}
