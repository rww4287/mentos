package com.ktds.mentos.myClass.service;

import java.util.List;

import com.ktds.mentos.myClass.biz.MyClassBiz;
import com.ktds.mentos.myClass.biz.MyClassBizImpl;
import com.ktds.mentos.myClass.vo.MyClassVO;

public class MyClassServiceImpl implements MyClassService{

	private MyClassBiz myClassBiz;
	
	public MyClassServiceImpl() {
		myClassBiz = new MyClassBizImpl();
	}
	
	@Override
	public boolean addClass(MyClassVO myClassVO) {
		return myClassBiz.addClass(myClassVO);
	}

	@Override
	public MyClassVO getOneClass(String classId) {
		return myClassBiz.getOneClass(classId);
	}

	@Override
	public List<MyClassVO> getAllClass() {
		return myClassBiz.getAllClass();
	}

	@Override
	public boolean requestClass(String classId) {
		return myClassBiz.requestClass(classId);
	}

	@Override
	public boolean deleteClass(String classId) {
		return myClassBiz.deleteClass(classId);
	}

	@Override
	public List<MyClassVO> getMentoClass(String mentoId) {
		return myClassBiz.getMentoClass(mentoId);
	}

	@Override
	public List<MyClassVO> getMenteeClass(String menteeId) {
		return myClassBiz.getMenteeClass(menteeId);
	}

}
