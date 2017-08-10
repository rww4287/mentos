package com.ktds.mentos.user.mentee.service;

import java.util.List;

import com.ktds.mentos.user.mentee.vo.MenteeSearchVO;
import com.ktds.mentos.user.mentee.vo.MenteeVO;

public interface MenteeService {

	public boolean addNewMentee(MenteeVO menteeVO);
	
	public List<MenteeVO> getAllMentees(MenteeSearchVO menteeSearchVO);
	
	public MenteeVO getOneMentee(String menteeId);
	
	public MenteeVO getOneMentee(MenteeVO menteeVO);
	
	public boolean isDuplicated(String menteeId);
	
	public boolean isPasswordCheck(String menteePassword);
	
	public boolean modifyMentee(MenteeVO menteeVO);
	
	public boolean updatePoint(String menteeId, int point);
	
	//로그인을 위한
	public boolean sucessMentee(MenteeVO menteeVO);
	
}
