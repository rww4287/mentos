package com.ktds.mentos.user.mento.biz;

import java.util.List;

import com.ktds.mentos.user.mento.vo.MentoSearchVO;
import com.ktds.mentos.user.mento.vo.MentoVO;

public interface MentoBiz {

	public boolean addMento(MentoVO mentoVO);
	
	public MentoVO getOneMento(String mentoId);
	
	public MentoVO getOneMento(MentoVO mentoVO);
	
	public List<MentoVO> getAllMentos(MentoSearchVO mentoSearchVO);

	public boolean modifyMento(MentoVO mentoVO);
	
	public boolean isDuplicated(String mentoId);
	
	public List<MentoVO> getMentosByCategoryId(String categoryId);

	// 로그인을 위한 
	public boolean sucessMento(MentoVO mentoVO);
	
	public boolean updatePoint(String mentoId);
	
	public List<MentoVO> getAllMentos();

}
