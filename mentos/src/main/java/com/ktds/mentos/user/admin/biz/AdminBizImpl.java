package com.ktds.mentos.user.admin.biz;

import com.ktds.mentos.user.admin.dao.AdminDao;
import com.ktds.mentos.user.admin.dao.AdminDaoImpl;
import com.ktds.mentos.user.admin.vo.AdminVO;

public class AdminBizImpl implements AdminBiz{

	private AdminDao adminDao;
	public AdminBizImpl(){
		adminDao = new AdminDaoImpl();
	}
	@Override
	public AdminVO selectOneAdmin(AdminVO adminVO) {
		return adminDao.selectOneAdmin(adminVO);
	}
	@Override
	public boolean loginAdmin(AdminVO adminVO) {
		return adminDao.loginAdmin(adminVO) > 0;
	}

}
