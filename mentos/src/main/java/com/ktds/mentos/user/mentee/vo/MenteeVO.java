package com.ktds.mentos.user.mentee.vo;

import com.ktds.mentos.authorization.vo.AuthVO;

public class MenteeVO {

	private String menteeId;
	private String menteeName;
	private String menteePassword;
	private String menteeAddress;
	private String phone;
	private String email;
	private String gender;
	private String menteeBirthday;
	private int point;

	private AuthVO authVO;

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public AuthVO getAuthVO() {
		if (authVO == null) {
			authVO = new AuthVO();
		}
		return authVO;
	}

	public void setAuthVO(AuthVO authVO) {
		this.authVO = authVO;
	}

	public String getMenteeId() {
		return menteeId;
	}
	
	public void setMenteeId(String menteeId) {
		this.menteeId = menteeId;
	}
	
	public String getMenteeName() {
		return menteeName;
	}
	
	public void setMenteeName(String menteeName) {
		this.menteeName = menteeName;
	}
	
	public String getMenteePassword() {
		return menteePassword;
	}
	
	public void setMenteePassword(String menteePassword) {
		this.menteePassword = menteePassword;
	}
	
	public String getMenteeAddress() {
		return menteeAddress;
	}
	
	public void setMenteeAddress(String menteeAddress) {
		this.menteeAddress = menteeAddress;
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
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getMenteeBirthday() {
		return menteeBirthday;
	}
	
	public void setMenteeBirthday(String menteeBirthday) {
		this.menteeBirthday = menteeBirthday;
	}
	
}
