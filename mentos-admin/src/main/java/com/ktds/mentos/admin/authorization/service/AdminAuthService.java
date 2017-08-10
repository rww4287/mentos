package com.ktds.mentos.admin.authorization.service;

import java.util.List;

import com.ktds.mentos.admin.authorization.vo.AuthVO;

public interface AdminAuthService {

	public boolean insertNewAuth(AuthVO authVO);

	public List<AuthVO> getAllAuthList(AuthVO authVO);

}
