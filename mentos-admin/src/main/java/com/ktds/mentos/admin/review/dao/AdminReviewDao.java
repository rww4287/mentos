package com.ktds.mentos.admin.review.dao;

import java.util.List;

import com.ktds.mentos.review.dao.ReviewDao;
import com.ktds.mentos.review.vo.ReviewSearchVO;
import com.ktds.mentos.review.vo.ReviewVO;

public interface AdminReviewDao extends ReviewDao{
	
	/**
	 * 관리자용: ORDER BY RTNG
	 */
	public List<ReviewVO> selectAllReviewsForAdmin(ReviewSearchVO reviewSearchVO);

	/**
	 * 관리자용: 공지사항 작성
	 */
	public int insertNewReviewForAdmin(ReviewVO reviewVO);
	
	public String generateNoticeId();
}
