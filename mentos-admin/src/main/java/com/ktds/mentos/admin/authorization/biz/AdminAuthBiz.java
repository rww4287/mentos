package com.ktds.mentos.admin.authorization.biz;

import java.util.List;

import com.ktds.mentos.admin.authorization.vo.AuthVO;

public interface AdminAuthBiz {

	public boolean registNewAuth(AuthVO authVO);

	public List<AuthVO> getAllAuthList(AuthVO authVO);

}
