package com.ktds.mentos.comments.service;

import java.util.List;

import com.ktds.mentos.comments.vo.CommentsVO;

public interface CommentsService {
	public boolean AddNewComment(CommentsVO commentsVO);
	public boolean deleteOneComment(String commentId);
	public boolean updateOneComment(CommentsVO commentsVO);
	public List<CommentsVO> getAllComments(String reviewId);
	public CommentsVO getOneComment(String commentId);
}
