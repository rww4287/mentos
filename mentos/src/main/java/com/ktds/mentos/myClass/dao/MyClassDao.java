package com.ktds.mentos.myClass.dao;

import java.util.List;

import com.ktds.mentos.myClass.vo.MyClassVO;

public interface MyClassDao {

	public int insertMyClass(MyClassVO myClassVO);
	
	public MyClassVO selectOneClass(String classId);
	
	public List<MyClassVO> selectAllClass();
	
	public int updateClassInfo(String classId);
	
	public int modifyClassInfo(MyClassVO myClassVO);
	
	public int deleteClass(String classId);
	
	public String generateNewClassId();
	
	public List<MyClassVO> selectMentoClass(String mentoId);
	
	public List<MyClassVO> selectMenteeClass(String menteeId);
	
	public List<MyClassVO> countMember();

	public int selectAcceptedMenteeCount(String mentoId);

	public List<MyClassVO> selectAllClassByStartDate();
	
	
}
