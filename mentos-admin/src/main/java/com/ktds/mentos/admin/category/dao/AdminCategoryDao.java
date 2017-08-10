package com.ktds.mentos.admin.category.dao;

import java.util.List;

import com.ktds.mentos.admin.category.vo.CategoryVO;

public interface AdminCategoryDao {
	
	public List<CategoryVO> getAllCategoryList();
	
	public CategoryVO getOneCategory(String categoryId);
	
	public String generateNewCategoryId();
	
	public int insertNewCategory(CategoryVO categoryVO);
	
	public int modifyCategoryInfo(CategoryVO categoryVO);
	
	public int deleteCategory(String categoryId);
}
