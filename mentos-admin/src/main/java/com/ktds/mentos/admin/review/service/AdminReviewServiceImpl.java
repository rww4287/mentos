package com.ktds.mentos.admin.review.service;

import java.util.List;

import com.ktds.mentos.admin.review.biz.AdminReviewBiz;
import com.ktds.mentos.admin.review.biz.AdminReviewBizImpl;
import com.ktds.mentos.review.service.ReviewServiceImpl;
import com.ktds.mentos.review.vo.ReviewSearchVO;
import com.ktds.mentos.review.vo.ReviewVO;

public class AdminReviewServiceImpl extends ReviewServiceImpl implements AdminReviewService {

	private AdminReviewBiz adminReviewBiz;
	public AdminReviewServiceImpl(){
		adminReviewBiz = new AdminReviewBizImpl();
	}
	@Override
	public List<ReviewVO> selectAllReviewsForAdmin(ReviewSearchVO reviewSearchVO) {
		return adminReviewBiz.selectAllReviewsForAdmin(reviewSearchVO);
	}
	@Override
	public boolean insertNewReviewForAdmin(ReviewVO reviewVO) {
		return adminReviewBiz.insertNewReviewForAdmin(reviewVO);
	}
}
