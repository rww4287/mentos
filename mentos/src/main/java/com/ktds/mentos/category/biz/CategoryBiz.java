package com.ktds.mentos.category.biz;

import java.util.List;

import com.ktds.mentos.category.vo.CategoryVO;

public interface CategoryBiz {

	public List<CategoryVO> showAllCategoryList();

	public CategoryVO showOneCategory(String categoryId);

	public boolean insertNewCategory(CategoryVO categoryVO);

	public boolean modifyCategoryInfo(CategoryVO categoryVO);

	public boolean deleteCategory(String categroyId);
}
