package com.ktds.mentos.myClass.biz;

import java.util.List;

import com.ktds.mentos.myClass.vo.MyClassVO;

public interface MyClassBiz {

	public boolean addClass(MyClassVO myClassVO);
	
	public MyClassVO getOneClass(String classId);
	
	public List<MyClassVO> getAllClass();

	public boolean requestClass(String classId);

	public boolean deleteClass(String classId);
	
	public List<MyClassVO> getMentoClass(String mentoId);
	
	public List<MyClassVO> getMenteeClass(String menteeId);

	public List<MyClassVO> checkCount(MyClassVO myClassVO);
	
	public int getAcceptedCount(String mentoId);
	
	public List<MyClassVO> getAllClassByST();
 }
