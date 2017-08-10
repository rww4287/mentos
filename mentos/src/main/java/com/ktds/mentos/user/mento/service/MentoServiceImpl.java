package com.ktds.mentos.user.mento.service;

import java.util.List;

import com.ktds.mentos.user.mento.biz.MentoBiz;
import com.ktds.mentos.user.mento.biz.MentoBizImpl;
import com.ktds.mentos.user.mento.vo.MentoSearchVO;
import com.ktds.mentos.user.mento.vo.MentoVO;

public class MentoServiceImpl implements MentoService {

	private MentoBiz mentoBiz;
	
	public MentoServiceImpl() {
		mentoBiz = new MentoBizImpl();
	}
	
	@Override
	public boolean addMento(MentoVO mentoVO) {
		return mentoBiz.addMento(mentoVO);
	}

	@Override
	public List<MentoVO> getAllMentos(MentoSearchVO mentoSearchVO) {
		return mentoBiz.getAllMentos(mentoSearchVO);
	}

	@Override
	public MentoVO getOneMento(String mentoId) {
		return mentoBiz.getOneMento(mentoId);
	}

	@Override
	public MentoVO getOneMento(MentoVO mentoVO) {
		return mentoBiz.getOneMento(mentoVO);
	}

	@Override
	public boolean modifyMento(MentoVO mentoVO) {
		MentoVO tempMentoVO = getOneMento(mentoVO.getMentoId());
		
	
		if ( mentoVO.getMentoPassword() == null || mentoVO.getMentoPassword().length() < 0){
			mentoVO.setMentoPassword(tempMentoVO.getMentoPassword());
		} 

		if ( mentoVO.getMentoAddress() == null ||  mentoVO.getMentoAddress().length() <0) {
			mentoVO.setMentoAddress(tempMentoVO.getMentoAddress());
		}

		if (mentoVO.getPhone() == null || mentoVO.getPhone().length() < 0 ){
			mentoVO.setPhone(tempMentoVO.getPhone());
		}
		
		if (mentoVO.getEmail() == null || mentoVO.getEmail().length() < 0 ){
			mentoVO.setEmail(tempMentoVO.getEmail());
		}
		if (mentoVO.getStartDate() == null || mentoVO.getStartDate().length() < 0 ){
			mentoVO.setStartDate(tempMentoVO.getStartDate());
	
		}

		if (mentoVO.getCost() == 0 ) {
			mentoVO.setCost(tempMentoVO.getCost());
		}
		
		if (mentoVO.getMember() == 0){
			mentoVO.setMember(tempMentoVO.getMember());
		}
		
		if (mentoVO.getCategoryVO().getCategoryId() == null ||mentoVO.getCategoryVO().getCategoryId().length() < 0 ){
			mentoVO.getCategoryVO().setCategoryId(tempMentoVO.getCategoryVO().getCategoryId());
		}
		
		if (mentoVO.getComment() == null ||mentoVO.getComment().length() < 0 ){
			mentoVO.setComment(tempMentoVO.getComment());
		}

		return mentoBiz.modifyMento(mentoVO);
	}

	@Override
	public boolean isDuplicated(String mentoId) {

		return mentoBiz.isDuplicated(mentoId);
	}

	@Override
	public boolean isPasswordCheck(String mentoPassword) {
		if (mentoPassword.length() < 8) {
			return true;
		}
		return false;
	}

	@Override
	public List<MentoVO> getMentosByCategoryId(String categoryId) {
		return mentoBiz.getMentosByCategoryId(categoryId);
	}
	@Override
	public boolean sucessMento(MentoVO mentoVO) {
		return mentoBiz.sucessMento(mentoVO);
	}
	@Override
	public boolean updatePoint(String mentoId) {
		return mentoBiz.updatePoint(mentoId);
	}

	@Override
	public List<MentoVO> getAllMentos() {
		return mentoBiz.getAllMentos();
	}
}
