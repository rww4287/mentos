package com.ktds.mentos.admin.category.biz;

import java.util.List;

import com.ktds.mentos.admin.category.dao.AdminCategoryDao;
import com.ktds.mentos.admin.category.dao.AdminCategoryDaoImpl;
import com.ktds.mentos.admin.category.vo.CategoryVO;

public class AdminCategoryBizImpl implements AdminCategoryBiz {

	private AdminCategoryDao categoryDao;

	public AdminCategoryBizImpl() {
		categoryDao = new AdminCategoryDaoImpl();
	}

	@Override
	public List<CategoryVO> showAllCategoryList() {
		return categoryDao.getAllCategoryList();
	}

	@Override
	public CategoryVO showOneCategory(String categoryId) {
		return categoryDao.getOneCategory(categoryId);
	}

	@Override
	public boolean insertNewCategory(CategoryVO categoryVO) {
		String id = categoryDao.generateNewCategoryId();
		categoryVO.setCategoryId(id);
		return categoryDao.insertNewCategory(categoryVO) > 0;
	}

	@Override
	public boolean modifyCategoryInfo(CategoryVO categoryVO) {
		return categoryDao.modifyCategoryInfo(categoryVO) > 0;
	}

	@Override
	public boolean deleteCategory(String categoryId) {
		return categoryDao.deleteCategory(categoryId) > 0;
	}

}
