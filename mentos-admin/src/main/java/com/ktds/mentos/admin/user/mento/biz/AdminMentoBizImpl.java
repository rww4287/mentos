package com.ktds.mentos.admin.user.mento.biz;

import com.ktds.mentos.admin.user.mento.dao.AdminMentoDao;
import com.ktds.mentos.admin.user.mento.dao.AdminMentoDaoImpl;
import com.ktds.mentos.user.mento.biz.MentoBizImpl;

public class AdminMentoBizImpl extends MentoBizImpl implements AdminMentoBiz{

	private AdminMentoDao adminMentoDao;
	public AdminMentoBizImpl(){
		adminMentoDao = new AdminMentoDaoImpl();
	}
	@Override
	public boolean deleteOneMento(String mentoId) {
		return adminMentoDao.deleteOneMento(mentoId) > 0;
	}

}
