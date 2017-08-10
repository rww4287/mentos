package com.ktds.mentos.user.mento.service;

import java.util.List;

import com.ktds.mentos.user.mento.vo.MentoSearchVO;
import com.ktds.mentos.user.mento.vo.MentoVO;

public interface MentoService {

	public boolean addMento(MentoVO mentoVO);
	
	public List<MentoVO> getAllMentos(MentoSearchVO mentoSearchVO);
	
	public MentoVO getOneMento(String mentoId);
	
	public MentoVO getOneMento(MentoVO mentoVO);
	
	public boolean modifyMento(MentoVO mentoVO);
	
	public boolean isDuplicated(String mentoId);
	
	public boolean isPasswordCheck(String mentoPassword);

	public List<MentoVO> getMentosByCategoryId(String categoryId);
	// 로그인을 위한 
	public boolean sucessMento(MentoVO mentoVO);
	
	public boolean updatePoint(String mentoId);
	
	//윤민:review 게시판을 위한 메서드
	public List<MentoVO> getAllMentos();
}
