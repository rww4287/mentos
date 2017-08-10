package com.ktds.mentos.review.biz;

import java.util.List;

import com.ktds.mentos.review.vo.ReviewSearchVO;
import com.ktds.mentos.review.vo.ReviewVO;

public interface ReviewBiz {
	
	public boolean addNewReview(ReviewVO reviewVO);
	public List<ReviewVO> getAllReviews(ReviewSearchVO reviewSearchVO);
	public ReviewVO	getOneReview(String reviewId);
	public boolean deleteOneReview(String reviewId);
	public boolean updateOneReview(ReviewVO reviewVO);

}
