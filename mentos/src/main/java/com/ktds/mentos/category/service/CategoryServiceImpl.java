package com.ktds.mentos.category.service;

import java.util.List;

import com.ktds.mentos.category.biz.CategoryBiz;
import com.ktds.mentos.category.biz.CategoryBizImpl;
import com.ktds.mentos.category.vo.CategoryVO;

public class CategoryServiceImpl implements CategoryService {

	private CategoryBiz categoryBiz;

	public CategoryServiceImpl() {
		categoryBiz = new CategoryBizImpl();
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
	public boolean deleteCategory(String categroyId) {
		return categoryBiz.deleteCategory(categroyId);
	}

}
