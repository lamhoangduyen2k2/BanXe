package vn.dao;

import java.util.List;

import vn.models.Category;

public interface CategoryDAO {
	List<Category> findAllCategory();
	Category findCategoryByID(int _id);
	void insert(Category category);
	void edit(Category category);
	void delete(int id);
}
