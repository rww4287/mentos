package com.ktds.mentos.admin.user.mentee.biz;

import java.util.List;

import com.ktds.mentos.user.mentee.biz.MenteeBiz;
import com.ktds.mentos.user.mentee.vo.MenteeVO;

public interface AdminMenteeBiz extends MenteeBiz {

	public List<MenteeVO> getAllMentees();

}
