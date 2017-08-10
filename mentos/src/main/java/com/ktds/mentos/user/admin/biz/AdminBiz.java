package com.ktds.mentos.user.admin.biz;

import com.ktds.mentos.user.admin.vo.AdminVO;

public interface AdminBiz {

	public AdminVO selectOneAdmin(AdminVO adminVO);

	public boolean loginAdmin(AdminVO adminVO);

}
