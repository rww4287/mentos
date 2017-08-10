package com.ktds.mentos.admin.user.mentee.service;

import java.util.List;

import com.ktds.mentos.admin.user.mentee.biz.AdminMenteeBiz;
import com.ktds.mentos.admin.user.mentee.biz.AdminMenteeBizImpl;
import com.ktds.mentos.user.mentee.service.MenteeServiceImpl;
import com.ktds.mentos.user.mentee.vo.MenteeVO;

public class AdminMenteeServiceImpl extends MenteeServiceImpl implements AdminMenteeService {

	private AdminMenteeBiz adminMenteeBiz;

	public AdminMenteeServiceImpl() {
		adminMenteeBiz = new AdminMenteeBizImpl();
	}

	@Override
	public List<MenteeVO> getAllMentees() {
		return adminMenteeBiz.getAllMentees();
	}

}
