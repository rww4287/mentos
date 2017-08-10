package com.ktds.mentos.admin.authorization.biz;

import java.util.List;

import com.ktds.mentos.admin.authorization.dao.AdminAuthDao;
import com.ktds.mentos.admin.authorization.dao.AdminAuthDaoImpl;
import com.ktds.mentos.admin.authorization.vo.AuthVO;

public class AdminAuthBizImpl implements AdminAuthBiz {

	private AdminAuthDao authDao;

	public AdminAuthBizImpl() {
		authDao = new AdminAuthDaoImpl();
	}

	@Override
	public boolean registNewAuth(AuthVO authVO) {
		String id = authDao.generateNewAuthId();
		authVO.setAuthId(id);
		return authDao.insertNewAuth(authVO) > 0;
	}

	@Override
	public List<AuthVO> getAllAuthList(AuthVO authVO) {
		return authDao.getAllAuthList(authVO);
	}

}
