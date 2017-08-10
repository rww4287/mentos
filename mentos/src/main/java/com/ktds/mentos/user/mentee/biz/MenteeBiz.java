package com.ktds.mentos.user.mentee.biz;

import java.util.List;

import com.ktds.mentos.user.mentee.vo.MenteeSearchVO;
import com.ktds.mentos.user.mentee.vo.MenteeVO;

public interface MenteeBiz {

	public boolean addNewMentee(MenteeVO menteeVO);

	public List<MenteeVO> getAllMentees(MenteeSearchVO menteeSearchVO);

	public MenteeVO getOneMentee(String menteeId);

	public MenteeVO getOneMentee(MenteeVO menteeVO);
	
	// 로그인을 위한 
	public boolean sucessMentee(MenteeVO menteeVO);

	public boolean deleteOneMentee(String menteeId);

	public boolean modifyMentee(MenteeVO menteeVO);

	public boolean updatePoint(String menteeId, int point);

	public boolean isDuplicated(String menteeId);

}
