package com.ktds.mentos.comments.biz;

import java.util.List;

import com.ktds.mentos.comments.dao.CommentsDao;
import com.ktds.mentos.comments.dao.CommentsDaoImpl;
import com.ktds.mentos.comments.vo.CommentsVO;

public class CommentsBizImpl implements CommentsBiz{
	private CommentsDao commentsDao;
	public CommentsBizImpl() {
		commentsDao = new CommentsDaoImpl();
	}
	@Override
	public boolean AddNewComment(CommentsVO commentsVO) {
		return commentsDao.insertNewComment(commentsVO)>0;
	}
	@Override
	public boolean deleteOneComment(String commentId) {
		return commentsDao.deleteOneComment(commentId)>0;
	}
	@Override
	public boolean updateOneComment(CommentsVO commentsVO) {
		return commentsDao.updateOneComment(commentsVO)>0;
	}
	@Override
	public List<CommentsVO> getAllComments(String reviewId) {
		return commentsDao.selectAllComments(reviewId);
	}

	@Override
	public CommentsVO getOneComment(String commentId) {
		return commentsDao.selectOneComment(commentId);
	}
	


}
