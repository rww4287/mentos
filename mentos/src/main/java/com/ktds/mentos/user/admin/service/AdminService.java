package com.ktds.mentos.user.admin.service;

import com.ktds.mentos.user.admin.vo.AdminVO;

public interface AdminService {

	public AdminVO getOneAdmin(AdminVO adminVO);
	
	public boolean loginAdmin(AdminVO adminVO);

}
