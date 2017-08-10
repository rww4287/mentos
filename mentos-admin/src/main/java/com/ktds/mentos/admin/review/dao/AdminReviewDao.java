package com.ktds.mentos.admin.review.dao;

import java.util.List;

import com.ktds.mentos.review.dao.ReviewDao;
import com.ktds.mentos.review.vo.ReviewSearchVO;
import com.ktds.mentos.review.vo.ReviewVO;

public interface AdminReviewDao extends ReviewDao{
	
	/**
	 * �����ڿ�: ORDER BY RTNG
	 */
	public List<ReviewVO> selectAllReviewsForAdmin(ReviewSearchVO reviewSearchVO);

	/**
	 * �����ڿ�: �������� �ۼ�
	 */
	public int insertNewReviewForAdmin(ReviewVO reviewVO);
	
	public String generateNoticeId();
}
