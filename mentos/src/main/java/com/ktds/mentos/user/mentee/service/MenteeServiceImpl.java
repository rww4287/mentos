package com.ktds.mentos.user.mentee.service;

import java.util.List;

import com.ktds.mentos.user.mentee.biz.MenteeBiz;
import com.ktds.mentos.user.mentee.biz.MenteeBizImpl;
import com.ktds.mentos.user.mentee.vo.MenteeSearchVO;
import com.ktds.mentos.user.mentee.vo.MenteeVO;

public class MenteeServiceImpl implements MenteeService {

	private MenteeBiz menteeBiz;

	public MenteeServiceImpl() {
		menteeBiz = new MenteeBizImpl();
	}

	@Override
	public boolean addNewMentee(MenteeVO menteeVO) {
		return menteeBiz.addNewMentee(menteeVO);
	}

	@Override
	public List<MenteeVO> getAllMentees(MenteeSearchVO menteeSearchVO) {
		return menteeBiz.getAllMentees(menteeSearchVO);
	}

	@Override
	public MenteeVO getOneMentee(String menteeId) {
		return menteeBiz.getOneMentee(menteeId);
	}

	@Override
	public boolean isDuplicated(String menteeId) {
		return menteeBiz.isDuplicated(menteeId);
//		if (menteeBiz.getOneMentee(menteeId) != null) {
//			return true;
//		}
//		return false;
	}

	@Override
	public boolean isPasswordCheck(String menteePassword) {
		if (menteePassword.length() < 8) {
			return true;
		}
		return false;
	}

	@Override
	public boolean modifyMentee(MenteeVO menteeVO) {
		MenteeVO tempMenteeVO = getOneMentee(menteeVO.getMenteeId());

		if (menteeVO.getPhone() == null || menteeVO.getPhone().length() < 0) {
			menteeVO.setPhone(tempMenteeVO.getPhone());
		}
		if (menteeVO.getEmail() == null || menteeVO.getEmail().length() < 0) {
			menteeVO.setEmail(tempMenteeVO.getEmail());
		}
		if (menteeVO.getMenteePassword() == null || menteeVO.getMenteePassword().length() < 0) {
			menteeVO.setMenteePassword(tempMenteeVO.getMenteePassword());
		}
		if (menteeVO.getMenteeAddress() == null || menteeVO.getMenteeAddress().length() < 0) {
			menteeVO.setMenteeAddress(tempMenteeVO.getMenteeAddress());
		}
		return menteeBiz.modifyMentee(menteeVO);
	}

	@Override
	public boolean updatePoint(String menteeId, int point) {
		return menteeBiz.updatePoint(menteeId, point);
	}

	@Override
	public MenteeVO getOneMentee(MenteeVO menteeVO) {
		return menteeBiz.getOneMentee(menteeVO);
	}
	
	@Override
	public boolean sucessMentee(MenteeVO menteeVO) {

		return menteeBiz.sucessMentee(menteeVO);
	}
	

}
