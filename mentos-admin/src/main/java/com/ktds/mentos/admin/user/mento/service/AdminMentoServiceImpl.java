package com.ktds.mentos.admin.user.mento.service;

import com.ktds.mentos.admin.user.mento.dao.AdminMentoDao;
import com.ktds.mentos.admin.user.mento.dao.AdminMentoDaoImpl;
import com.ktds.mentos.user.mento.service.MentoServiceImpl;

public class AdminMentoServiceImpl extends MentoServiceImpl implements AdminMentoService{

	private AdminMentoDao adminMentoDao;
	public AdminMentoServiceImpl(){
		adminMentoDao = new AdminMentoDaoImpl();
	}
	@Override
	public boolean deleteOneMento(String mentoId) {
		return adminMentoDao.deleteOneMento(mentoId) > 0;
	}

}
