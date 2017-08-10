package com.ktds.mentos.admin.user.mentee.service;

import java.util.List;

import com.ktds.mentos.user.mentee.service.MenteeService;
import com.ktds.mentos.user.mentee.vo.MenteeVO;

public interface AdminMenteeService extends MenteeService{

	public List<MenteeVO> getAllMentees();

}
