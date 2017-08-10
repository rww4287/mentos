package com.ktds.mentos.category.dao;

import java.util.List;

import com.ktds.mentos.category.vo.CategoryVO;


public interface CategoryDao {
	
	public List<CategoryVO> getAllCategoryList();
	
	public CategoryVO getOneCategory(String categoryId);
	
	public String generateNewCategoryId();
	
	public int insertNewCategory(CategoryVO categoryVO);
	
	public int modifyCategoryInfo(CategoryVO categoryVO);
	
	public int deleteCategory(String categroyId);
}
