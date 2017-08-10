package com.ktds.mentos.user.mento.biz;

import java.util.ArrayList;
import java.util.List;

import com.ktds.mentos.common.web.pager.Pager;
import com.ktds.mentos.user.mento.dao.MentoDao;
import com.ktds.mentos.user.mento.dao.MentoDaoImpl;
import com.ktds.mentos.user.mento.vo.MentoSearchVO;
import com.ktds.mentos.user.mento.vo.MentoVO;

public class MentoBizImpl implements MentoBiz {

	private MentoDao mentoDao;

	public MentoBizImpl() {
		mentoDao = new MentoDaoImpl();
	}

	@Override
	public boolean addMento(MentoVO mentoVO) {
		return mentoDao.insertMento(mentoVO) > 0;
	}

	@Override
	public MentoVO getOneMento(String mentoId) {
		return mentoDao.selectOneMento(mentoId);
	}

	@Override
	public MentoVO getOneMento(MentoVO mentoVO) {
		return mentoDao.selectOneMento(mentoVO);
	}

	@Override
	public List<MentoVO> getAllMentos(MentoSearchVO mentoSearchVO) {
		int artistCount = mentoDao.selectAllMentoCount(mentoSearchVO);

		Pager pager = mentoSearchVO.getPager();
		pager.setTotalArticleCount(artistCount);

		if (artistCount == 0) {
			return new ArrayList<MentoVO>();
		}
		return mentoDao.selectAllMentos(mentoSearchVO);
	}

	@Override
	public boolean modifyMento(MentoVO mentoVO) {
		return mentoDao.updateMento(mentoVO) > 0;
	}

	@Override
	public boolean isDuplicated(String mentoId) {
		return mentoDao.selectCountByMentoId(mentoId) > 0;
	}

	@Override
	public List<MentoVO> getMentosByCategoryId(String categoryId) {
		return mentoDao.selectMentosByCategoryId(categoryId);
	}

	@Override
	public boolean sucessMento(MentoVO mentoVO) {
		return mentoDao.loginMento(mentoVO) > 0;
	}

	@Override
	public boolean updatePoint(String mentoId) {
		return mentoDao.updatePoint(mentoId) > 0;
	}

	@Override
	public List<MentoVO> getAllMentos() {
		return mentoDao.selectAllMentees();
	}

}
