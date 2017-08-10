package com.ktds.mentos.user.mentee.biz;

import java.util.ArrayList;
import java.util.List;

import com.ktds.mentos.common.web.pager.Pager;
import com.ktds.mentos.user.mentee.dao.MenteeDao;
import com.ktds.mentos.user.mentee.dao.MenteeDaoImpl;
import com.ktds.mentos.user.mentee.vo.MenteeSearchVO;
import com.ktds.mentos.user.mentee.vo.MenteeVO;

public class MenteeBizImpl implements MenteeBiz {

	private MenteeDao menteeDao;

	public MenteeBizImpl() {
		menteeDao = new MenteeDaoImpl();
	}

	@Override
	public boolean addNewMentee(MenteeVO menteeVO) {
		return menteeDao.insertNewMentee(menteeVO) > 0;
	}

	@Override
	public List<MenteeVO> getAllMentees(MenteeSearchVO menteeSearchVO) {

		int menteeCount = menteeDao.selectAllMenteesCount(menteeSearchVO);

		Pager pager = menteeSearchVO.getPager();
		pager.setTotalArticleCount(menteeCount);

		if (menteeCount == 0) {
			return new ArrayList<MenteeVO>();
		}

		return menteeDao.selectAllMentees(menteeSearchVO);
	}

	@Override
	public MenteeVO getOneMentee(String menteeId) {
		return menteeDao.selectOneMentee(menteeId);
	}

	@Override
	public boolean deleteOneMentee(String menteeId) {
		return menteeDao.deleteOneMentee(menteeId) > 0;
	}

	@Override
	public boolean modifyMentee(MenteeVO menteeVO) {
		return menteeDao.updateMentee(menteeVO) > 0;
	}

	@Override
	public boolean updatePoint(String menteeId, int point) {
		if (point < 0) {
			return menteeDao.updatePointUsedPayment(menteeId, point) > 0;
		} else {
			return menteeDao.updatePointUsedCharge(menteeId, point) > 0;
		}
	}

	@Override
	public MenteeVO getOneMentee(MenteeVO menteeVO) {

		return menteeDao.selectOneMentee(menteeVO);
	}

	@Override
	public boolean isDuplicated(String menteeId) {
		return menteeDao.selectCountByMentoId(menteeId) > 0;
	}

	@Override
	public boolean sucessMentee(MenteeVO menteeVO) {
		return menteeDao.loginMentee(menteeVO)>0;
	}

}
