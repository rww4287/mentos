package com.ktds.mentos.admin.category.biz;

import java.util.List;

import com.ktds.mentos.admin.category.vo.CategoryVO;

public interface AdminCategoryBiz {

	public List<CategoryVO> showAllCategoryList();

	public CategoryVO showOneCategory(String categoryId);

	public boolean insertNewCategory(CategoryVO categoryVO);

	public boolean modifyCategoryInfo(CategoryVO categoryVO);

	public boolean deleteCategory(String categoryId);
}
