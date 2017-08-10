package com.ktds.mentos.review.service;

import java.util.List;

import com.ktds.mentos.comments.biz.CommentsBiz;
import com.ktds.mentos.comments.biz.CommentsBizImpl;
import com.ktds.mentos.comments.vo.CommentsVO;
import com.ktds.mentos.review.biz.ReviewBiz;
import com.ktds.mentos.review.biz.ReviewBizImpl;
import com.ktds.mentos.review.vo.ReviewSearchVO;
import com.ktds.mentos.review.vo.ReviewVO;
import com.ktds.mentos.user.mento.biz.MentoBiz;
import com.ktds.mentos.user.mento.biz.MentoBizImpl;
import com.ktds.mentos.user.mento.vo.MentoVO;

public class ReviewServiceImpl implements ReviewService{
	private ReviewBiz reviewBiz;
	private MentoBiz mentoBiz;
	private CommentsBiz commentsBiz;
	
	public ReviewServiceImpl() {
		reviewBiz = new ReviewBizImpl();
		mentoBiz = new MentoBizImpl();
		commentsBiz = new CommentsBizImpl();
	}
	
	@Override
	public boolean addNewReview(ReviewVO reviewVO) {
		return reviewBiz.addNewReview(reviewVO);
	}

	@Override
	public List<ReviewVO> getAllReviews(ReviewSearchVO reviewSearchVO) {
		return reviewBiz.getAllReviews(reviewSearchVO);
	}

	@Override
	public ReviewVO getOneReview(String reviewId) {
		return reviewBiz.getOneReview(reviewId);
	}

	@Override
	public boolean deleteOneReview(String reviewId) {
		return reviewBiz.deleteOneReview(reviewId);
	}

	@Override
	public boolean updateOneReview(ReviewVO reviewVO) {
		return reviewBiz.updateOneReview(reviewVO);
	}

	@Override
	public List<MentoVO> getAllMentoNames() {
		return mentoBiz.getAllMentos();
	}

	@Override
	public List<CommentsVO> getAllComments(String reviewId) {
		return commentsBiz.getAllComments(reviewId);
	}

	@Override
	public boolean addNewComments(CommentsVO commentsVO) {
		return commentsBiz.AddNewComment(commentsVO);
	}

	@Override
	public boolean deleteOneComment(String commentId) {
		return commentsBiz.deleteOneComment(commentId);
	}

	@Override
	public boolean updateOneComment(CommentsVO commentsVO) {
		return commentsBiz.updateOneComment(commentsVO);
	}

	@Override
	public CommentsVO getOneComment(String commentId) {
		return commentsBiz.getOneComment(commentId);
	}


}
