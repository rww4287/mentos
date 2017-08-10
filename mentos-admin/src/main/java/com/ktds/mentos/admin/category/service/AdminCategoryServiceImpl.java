package com.ktds.mentos.admin.category.service;

import java.util.List;

import com.ktds.mentos.admin.category.biz.AdminCategoryBiz;
import com.ktds.mentos.admin.category.biz.AdminCategoryBizImpl;
import com.ktds.mentos.admin.category.vo.CategoryVO;

public class AdminCategoryServiceImpl implements AdminCategoryService {

	private AdminCategoryBiz categoryBiz;

	public AdminCategoryServiceImpl() {
		categoryBiz = new AdminCategoryBizImpl();
	}

	@Override
	public List<CategoryVO> showAllCategoryList() {
		return categoryBiz.showAllCategoryList();
	}

	@Override
	public CategoryVO showOneCategory(String categoryId) {
		return categoryBiz.showOneCategory(categoryId);
	}

	@Override
	public boolean insertNewCategory(CategoryVO categoryVO) {
		return categoryBiz.insertNewCategory(categoryVO);
	}

	@Override
	public boolean modifyCategoryInfo(CategoryVO categoryVO) {
		return categoryBiz.modifyCategoryInfo(categoryVO);
	}

	@Override
	public boolean deleteCategory(String categoryId) {
		return categoryBiz.deleteCategory(categoryId);
	}

}
