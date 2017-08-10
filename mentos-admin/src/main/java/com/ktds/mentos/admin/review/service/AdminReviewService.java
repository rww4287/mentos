package com.ktds.mentos.admin.review.service;

import java.util.List;

import com.ktds.mentos.review.service.ReviewService;
import com.ktds.mentos.review.vo.ReviewSearchVO;
import com.ktds.mentos.review.vo.ReviewVO;

public interface AdminReviewService extends ReviewService{

	public List<ReviewVO> selectAllReviewsForAdmin(ReviewSearchVO reviewSearchVO);

	public boolean insertNewReviewForAdmin(ReviewVO reviewVO);

}
