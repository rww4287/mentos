package com.ktds.mentos.user.mento.dao;

import java.util.List;

import com.ktds.mentos.user.mentee.vo.MenteeVO;
import com.ktds.mentos.user.mento.vo.MentoSearchVO;
import com.ktds.mentos.user.mento.vo.MentoVO;

public interface MentoDao {

	public int insertMento(MentoVO mentoVO);
	
	public MentoVO selectOneMento(String mentoId);

	public MentoVO selectOneMento(MentoVO mentoVO);
	
	public int loginMento(MentoVO mentoVO);
	
	public List<MentoVO> selectAllMentos(MentoSearchVO mentoSearchVO);
	
	public int updateMento(MentoVO mentoVO);
	
	public int selectCountByMentoId(String mentoId);
	
	public List<MentoVO> selectMentosByCategoryId(String categoryId);
	
	public int updatePoint(String mentoId);
	
	public int selectAllMentoCount(MentoSearchVO mentoSearchVO);
	
	//윤민: review 할때, 멘토이름 selectAll을 위한 메서드
	public List<MentoVO> selectAllMentees();
	
	public int selectMentoCount();
	
}
