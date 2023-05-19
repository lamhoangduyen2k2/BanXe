package vn.models;

import java.sql.Date;

public class Category {
	private int _id;
	private String _name;
	private String slug;
	private int categoryId;
	private String _image;
	private boolean isDeleted;
	private Date createdAt;
	private Date updatedAt;
	private Category category;
	
	
	public Category() {
		super();
	}

	public Category(int _id, String _name, String slug, int categoryId, String _image, boolean isDeleted,
			Date createdAt, Date updatedAt, Category category) {
		super();
		this._id = _id;
		this._name = _name;
		this.slug = slug;
		this.categoryId = categoryId;
		this._image = _image;
		this.isDeleted = isDeleted;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.category = category;
	}
	
	

	public Category(int _id, String _name, String slug, int categoryId, String _image, boolean isDeleted,
			Date createdAt, Date updatedAt) {
		super();
		this._id = _id;
		this._name = _name;
		this.slug = slug;
		this.categoryId = categoryId;
		this._image = _image;
		this.isDeleted = isDeleted;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String get_name() {
		return _name;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String get_image() {
		return _image;
	}

	public void set_image(String _image) {
		this._image = _image;
	}

	public boolean getisDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}
