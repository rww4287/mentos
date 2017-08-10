package com.ktds.mentos.admin.user.mento.dao;

import com.ktds.mentos.user.mento.dao.MentoDao;

public interface AdminMentoDao extends MentoDao{

	public int deleteOneMento(String mentoId);
}
