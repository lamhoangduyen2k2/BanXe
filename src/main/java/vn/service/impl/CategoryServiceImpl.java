package vn.service.impl;

import java.util.List;

import vn.dao.CategoryDAO;
import vn.dao.impl.CategoryDaoImpl;
import vn.models.Category;
import vn.service.CategoryService;

public class CategoryServiceImpl implements CategoryService{
	CategoryDAO cateDao = new CategoryDaoImpl();

	@Override
	public List<Category> findAllCategory() {
		return cateDao.findAllCategory();
	}
	
	@Override
	public Category findCategoryByID(int _id) {
		return cateDao.findCategoryByID(_id);
	}

	@Override
	public void insert(Category category) {
		cateDao.insert(category);
	}

	@Override
	public void edit(Category category) {
		cateDao.edit(category);
	}

	@Override
	public void delete(int id) {
		cateDao.delete(id);
	}
}
