package com.ktds.mentos.admin.user.mentee.dao;

import java.util.List;

import com.ktds.mentos.user.mentee.dao.MenteeDao;
import com.ktds.mentos.user.mentee.vo.MenteeVO;

public interface AdminMenteeDao extends MenteeDao{

	public List<MenteeVO> getAllMentees();
}
