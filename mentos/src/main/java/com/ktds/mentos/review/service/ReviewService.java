package com.ktds.mentos.review.service;

import java.util.List;

import com.ktds.mentos.comments.vo.CommentsVO;
import com.ktds.mentos.review.vo.ReviewSearchVO;
import com.ktds.mentos.review.vo.ReviewVO;
import com.ktds.mentos.user.mento.vo.MentoVO;

public interface ReviewService {
	public boolean addNewReview(ReviewVO reviewVO);
	public List<ReviewVO> getAllReviews(ReviewSearchVO reviewSearchVO);
	public ReviewVO	getOneReview(String reviewId);
	public boolean deleteOneReview(String reviewId);
	public boolean updateOneReview(ReviewVO reviewVO);
	
	/**
	 * mentoService + reviewService
	 * @return
	 */
	public List<MentoVO> getAllMentoNames();
	
	/**
	 * commentService + reviewService
	 * @return
	 */
	public boolean deleteOneComment(String commentId);
	public boolean updateOneComment(CommentsVO commentsVO);
	public List<CommentsVO> getAllComments(String reviewId);
	public boolean addNewComments(CommentsVO commentsVO);
	public CommentsVO getOneComment(String commentId);
}
