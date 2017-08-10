package com.ktds.mentos.comments.service;

import java.util.List;

import com.ktds.mentos.comments.biz.CommentsBiz;
import com.ktds.mentos.comments.biz.CommentsBizImpl;
import com.ktds.mentos.comments.vo.CommentsVO;

public class CommentsServiceImpl implements CommentsService {
	private CommentsBiz commentsBiz;
	public CommentsServiceImpl() {
		commentsBiz = new CommentsBizImpl();
	}
	
	@Override
	public boolean AddNewComment(CommentsVO commentsVO) {
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
	public List<CommentsVO> getAllComments(String reviewId) {
		return commentsBiz.getAllComments(reviewId);
	}

	@Override
	public CommentsVO getOneComment(String commentId) {
		return commentsBiz.getOneComment(commentId);
	}

}
