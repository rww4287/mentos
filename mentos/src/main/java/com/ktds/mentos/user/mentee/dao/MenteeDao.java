package com.ktds.mentos.user.mentee.dao;

import java.util.List;

import com.ktds.mentos.user.mentee.vo.MenteeSearchVO;
import com.ktds.mentos.user.mentee.vo.MenteeVO;

public interface MenteeDao {

	public int insertNewMentee(MenteeVO menteeVO);
	
	public int selectAllMenteesCount(MenteeSearchVO menteeSearchVO);
	
	public List<MenteeVO> selectAllMentees(MenteeSearchVO menteeSearchVO);
	
	//로그인을 위한 매서드 
	public int loginMentee(MenteeVO menteeVO);
	
	public MenteeVO selectOneMentee(String menteeId);
	
	public MenteeVO selectOneMentee(MenteeVO menteeVO);
	
	public int updateMentee(MenteeVO menteeVO);
	
	public int deleteOneMentee(String menteeId);
	
	public int selectCountByMentoId(String menteeId);

	public int updatePointUsedCharge(String menteeId, int point);
	
	public int updatePointUsedPayment(String menteeId, int cost);

	
}
