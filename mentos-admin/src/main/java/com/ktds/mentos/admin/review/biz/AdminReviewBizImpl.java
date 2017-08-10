package com.ktds.mentos.admin.review.biz;

import java.util.List;

import com.ktds.mentos.admin.review.dao.AdminReviewDao;
import com.ktds.mentos.admin.review.dao.AdminReviewDaoImpl;
import com.ktds.mentos.review.biz.ReviewBizImpl;
import com.ktds.mentos.review.vo.ReviewSearchVO;
import com.ktds.mentos.review.vo.ReviewVO;

public class AdminReviewBizImpl extends ReviewBizImpl implements AdminReviewBiz {

	private AdminReviewDao adminReviewDao;

	public AdminReviewBizImpl() {
		adminReviewDao = new AdminReviewDaoImpl();
	}

	@Override
	public List<ReviewVO> selectAllReviewsForAdmin(ReviewSearchVO reviewSearchVO) {
		return adminReviewDao.selectAllReviewsForAdmin(reviewSearchVO);
	}

	@Override
	public boolean insertNewReviewForAdmin(ReviewVO reviewVO) {
		String id = adminReviewDao.generateNoticeId();
		reviewVO.setReviewId(id);

		return adminReviewDao.insertNewReviewForAdmin(reviewVO) > 0;
	}

}
