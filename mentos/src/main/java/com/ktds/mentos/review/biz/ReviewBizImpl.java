package com.ktds.mentos.review.biz;

import java.util.ArrayList;
import java.util.List;

import com.ktds.mentos.common.web.pager.Pager;
import com.ktds.mentos.review.dao.ReviewDao;
import com.ktds.mentos.review.dao.ReviewDaoImpl;
import com.ktds.mentos.review.vo.ReviewSearchVO;
import com.ktds.mentos.review.vo.ReviewVO;


public class ReviewBizImpl implements ReviewBiz {
	private ReviewDao reviewDao;

	public ReviewBizImpl() {
		reviewDao = new ReviewDaoImpl();
	}

	@Override
	public boolean addNewReview(ReviewVO reviewVO) {
		return reviewDao.insertNewReview(reviewVO) > 0;
	}

	@Override
	public List<ReviewVO> getAllReviews(ReviewSearchVO reviewSearchVO) {
		int artistCount = reviewDao.selectAllReviewCount(reviewSearchVO);

		Pager pager = reviewSearchVO.getPager();
		pager.setTotalArticleCount(artistCount);

		if (artistCount == 0) {
			return new ArrayList<ReviewVO>();
		}

		return reviewDao.selectAllReviews(reviewSearchVO);
	}

	@Override
	public ReviewVO getOneReview(String reviewId) {
		return reviewDao.selectOneReview(reviewId);
	}

	@Override
	public boolean deleteOneReview(String reviewId) {
		return reviewDao.deleteOneReview(reviewId) > 0;
	}

	@Override
	public boolean updateOneReview(ReviewVO reviewVO) {
		return reviewDao.updateOneReview(reviewVO) > 0;
	}

	

}
