package com.ktds.mentos.user.admin.dao;

import com.ktds.mentos.user.admin.vo.AdminVO;

public interface AdminDao {

	public AdminVO selectOneAdmin(AdminVO adminVO);
	
	public int loginAdmin(AdminVO adminVO);
}
