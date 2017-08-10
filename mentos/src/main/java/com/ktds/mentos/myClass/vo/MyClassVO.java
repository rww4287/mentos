package com.ktds.mentos.myClass.vo;

import com.ktds.mentos.user.mentee.vo.MenteeVO;
import com.ktds.mentos.user.mento.vo.MentoVO;

public class MyClassVO {
	
	private String classId;
	private String status;
	private int count;
	private MentoVO mentoVO;
	private MenteeVO menteeVO;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	
	public MentoVO getMentoVO() {
		if (mentoVO == null) {
			mentoVO = new MentoVO();
		}
		return mentoVO;
	}
	public void setMentoVO(MentoVO mentoVO) {
		this.mentoVO = mentoVO;
	}
	public MenteeVO getMenteeVO() {
		if ( menteeVO == null) {
			menteeVO = new MenteeVO();
		}
		return menteeVO;
	}
	public void setMenteeVO(MenteeVO menteeVO) {
		this.menteeVO = menteeVO;
	}
	

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
