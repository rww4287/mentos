package com.ktds.mentos.category.biz;

import java.util.List;

import com.ktds.mentos.category.dao.CategoryDao;
import com.ktds.mentos.category.dao.CategoryDaoImpl;
import com.ktds.mentos.category.vo.CategoryVO;

public class CategoryBizImpl implements CategoryBiz {

	private CategoryDao categoryDao;

	public CategoryBizImpl() {
		categoryDao = new CategoryDaoImpl();
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
	public boolean deleteCategory(String categroyId) {
		return categoryDao.deleteCategory(categroyId) > 0;
	}

}
