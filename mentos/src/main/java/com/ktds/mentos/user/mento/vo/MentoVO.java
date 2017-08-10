package com.ktds.mentos.user.mento.vo;

import com.ktds.mentos.authorization.vo.AuthVO;
import com.ktds.mentos.category.vo.CategoryVO;

public class MentoVO {
	
	private String mentoId;
	private String mentoPassword;
	private String mentoName;
	private String mentoBirth;
	private String mentoAddress;
	private String phone;
	private String email;
	private int member;
	private String startDate;
	private String gender;
	private int point;
	private String etc;
	
	private AuthVO authVO;
	private CategoryVO categoryVO;
	
	private String comment;
	private int cost;
	
	public String getMentoId() {
		return mentoId;
	}
	public void setMentoId(String mentoId) {
		this.mentoId = mentoId;
	}
	public String getMentoPassword() {
		return mentoPassword;
	}
	public void setMentoPassword(String mentoPassword) {
		this.mentoPassword = mentoPassword;
	}
	public String getMentoName() {
		return mentoName;
	}
	public void setMentoName(String mentoName) {
		this.mentoName = mentoName;
	}
	public String getMentoBirth() {
		return mentoBirth;
	}
	public void setMentoBirth(String mentoBirth) {
		this.mentoBirth = mentoBirth;
	}
	public String getMentoAddress() {
		return mentoAddress;
	}
	public void setMentoAddress(String mentoAddress) {
		this.mentoAddress = mentoAddress;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getMember() {
		return member;
	}
	public void setMember(int member) {
		this.member = member;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public AuthVO getAuthVO() {
		if ( authVO == null) {
			authVO = new AuthVO();
		}
		return authVO;
	}
	public void setAuthVO(AuthVO authVO) {
		this.authVO = authVO;
	}
	
	public CategoryVO getCategoryVO() {
		if ( categoryVO == null) {
			categoryVO = new CategoryVO();
		}
		return categoryVO;
	}
	public void setCategoryVO(CategoryVO categoryVO) {
		this.categoryVO = categoryVO;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}

	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getEtc() {
		return etc;
	}
	public void setEtc(String etc) {
		this.etc = etc;
	}
	
	
}
