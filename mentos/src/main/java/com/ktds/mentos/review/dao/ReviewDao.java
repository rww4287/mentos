package com.ktds.mentos.review.dao;

import java.util.List;

import com.ktds.mentos.review.vo.ReviewSearchVO;
import com.ktds.mentos.review.vo.ReviewVO;

public interface ReviewDao {
	/**
	 * 모든 리뷰 select
	 * @param reviewSearchVO
	 * @return 모든 리뷰의 제목, 내용, 멘토아이디
	 */
	public List<ReviewVO> selectAllReviews(ReviewSearchVO reviewSearchVO);
	
	/**
	 * 전체 페이지 설정
	 * @param ReivewSearchVO
	 * @return 총 리뷰의 갯 수
	 */
	public int selectAllReviewCount(ReviewSearchVO ReivewSearchVO);
	
	/**
	 * 리뷰 삽입
	 * @param reviewVO
	 * @return 삽입된 행의 갯수 (1 리턴)
	 */
	public int insertNewReview(ReviewVO reviewVO);
	/**
	 * 리뷰 하나만 가져오기
	 * 궁금한 점? 내가 등록한 글은 여러개 인데?
	 * @param reviewId
	 * @return 제목, 내용, 멘토 아이디
	 */
	public ReviewVO selectOneReview(String reviewId);
	
	/**
	 * 리뷰 삭제
	 * @param reviewId
	 * @return 삭제된 행의 갯수(1 리턴)
	 */
	public int deleteOneReview(String reviewId);
	/**
	 * 리뷰 수정
	 * @param reviewId
	 * @return	제목, 내용, 멘토 아이디
	 */
	public int updateOneReview(ReviewVO reviewVO);
	
	
}
