package com.ktds.mentos.myClass.biz;

import java.util.List;

import com.ktds.mentos.myClass.dao.MyClassDao;
import com.ktds.mentos.myClass.dao.MyClassDaoImpl;
import com.ktds.mentos.myClass.vo.MyClassVO;

public class MyClassBizImpl implements MyClassBiz{

	private MyClassDao myClassDao;
	
	public MyClassBizImpl() {
		myClassDao = new MyClassDaoImpl();
	}
	
	@Override
	public boolean addClass(MyClassVO myClassVO) {
		String id = myClassDao.generateNewClassId();
		myClassVO.setClassId(id);
		return myClassDao.insertMyClass(myClassVO) > 0;
	}

	@Override
	public MyClassVO getOneClass(String classId) {
		return myClassDao.selectOneClass(classId);
	}

	@Override
	public List<MyClassVO> getAllClass() {
		return myClassDao.selectAllClass();
	}

	@Override
	public boolean requestClass(String classId) {
		return myClassDao.updateClassInfo(classId) > 0;
	}

	@Override
	public boolean deleteClass(String classId) {
		return myClassDao.deleteClass(classId) >0;
	}

	@Override
	public List<MyClassVO> getMentoClass(String mentoId) {
		return myClassDao.selectMentoClass(mentoId);
	}

	@Override
	public List<MyClassVO> getMenteeClass(String menteeId) {
		return myClassDao.selectMenteeClass(menteeId);
	}
	
	@Override
	public List<MyClassVO> checkCount(MyClassVO myClassVO) {
		return myClassDao.countMember();
	}

	@Override
	public int getAcceptedCount(String mentoId) {
		return myClassDao.selectAcceptedMenteeCount(mentoId);
	}

	@Override
	public List<MyClassVO> getAllClassByST() {
		return myClassDao.selectAllClassByStartDate();
	}
	
	

	
	
}
