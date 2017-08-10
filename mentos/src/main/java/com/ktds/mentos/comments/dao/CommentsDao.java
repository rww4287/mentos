package com.ktds.mentos.comments.dao;

import java.util.List;

import com.ktds.mentos.comments.vo.CommentsVO;

public interface CommentsDao {
	public int insertNewComment(CommentsVO commentsVO);

	public int deleteOneComment(String commentId);

	public int updateOneComment(CommentsVO commentsVO);

	public List<CommentsVO> selectAllComments(String reviewId);

	public CommentsVO selectOneComment(String commentId);
}
