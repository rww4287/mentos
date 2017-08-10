package com.ktds.mentos.admin.review.biz;

import java.util.List;

import com.ktds.mentos.review.biz.ReviewBiz;
import com.ktds.mentos.review.vo.ReviewSearchVO;
import com.ktds.mentos.review.vo.ReviewVO;

public interface AdminReviewBiz extends ReviewBiz{

	public List<ReviewVO> selectAllReviewsForAdmin(ReviewSearchVO reviewSearchVO);

	public boolean insertNewReviewForAdmin(ReviewVO reviewVO);
	
}
