package com.ktds.mentos.review.vo;

public class ReviewVO {
	private	String reviewId;
	private String reviewTitle;
	private String reviewContent;
	private String reviewRating;
	private String mentoName;
	private String menteeId;
	private String reviewWriteDate;
	

	/**
	 * 리뷰: 멘토 선택 select form에 필요한 VO
	 */
	private String mentoId;
	
	public String getMentoId() {
		return mentoId;
	}
	public void setMentoId(String mentoId) {
		this.mentoId = mentoId;
	}
	public String getMenteeId() {
		return menteeId;
	}
	public void setMenteeId(String menteeId) {
		this.menteeId = menteeId;
	}
	public String getReviewId() {
		return reviewId;
	}
	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}
	public String getReviewTitle() {
		return reviewTitle;
	}
	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public String getReviewRating() {
		return reviewRating;
	}
	public void setReviewRating(String reviewRating) {
		this.reviewRating = reviewRating;
	}
	public String getMentoName() {
		return mentoName;
	}
	public void setMentoName(String mentoName) {
		this.mentoName = mentoName;
	}
	public String getReviewWriteDate() {
		return reviewWriteDate;
	}
	public void setReviewWriteDate(String reviewWriteDate) {
		this.reviewWriteDate = reviewWriteDate;
	}
	
	
}
