package com.ktds.mentos.admin.authorization.dao;

import java.util.List;

import com.ktds.mentos.admin.authorization.vo.AuthVO;

public interface AdminAuthDao {

	public String generateNewAuthId();
	
	public int insertNewAuth(AuthVO authVO);
	
	public List<AuthVO> getAllAuthList(AuthVO authVO);
}
