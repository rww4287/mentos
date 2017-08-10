package com.ktds.mentos.admin.user.mentee.biz;

import java.util.List;

import com.ktds.mentos.admin.user.mentee.dao.AdminMenteeDao;
import com.ktds.mentos.admin.user.mentee.dao.AdminMenteeDaoImpl;
import com.ktds.mentos.user.mentee.biz.MenteeBizImpl;
import com.ktds.mentos.user.mentee.vo.MenteeVO;

public class AdminMenteeBizImpl extends MenteeBizImpl implements AdminMenteeBiz{

	private AdminMenteeDao adminMenteeDao;
	public AdminMenteeBizImpl(){
		adminMenteeDao = new AdminMenteeDaoImpl();
	}
	@Override
	public List<MenteeVO> getAllMentees() {
		return adminMenteeDao.getAllMentees();
	}

}
