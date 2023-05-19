package vn.models;

import java.sql.Date;
import java.util.List;

import vn.service.ImageProductService;
import vn.service.impl.ImageProductServiceImpl;

public class Product {
	private int _id;
	private String name;
	private String slug;
	private String description;
	private double price;
	private double promotionalPrice;
	private int quantity;
	private int sold;
	private boolean isActive;
	private boolean isSelling;
	private int categoryId;
	private int storeId;
	private boolean isDeleted;
	private int rating;
	private Date createdAt;
	private Date updatedAt;
	private Category category;
	private Store store;
	public Product(int _id, String name, String slug, String description, double price, double promotionalPrice,
			int quantity, int sold, boolean isActive, boolean isSelling, int categoryId, int storeId, boolean isDeleted,
			int rating, Date createdAt, Date updatedAt, Category category, Store store) {
		super();
		this._id = _id;
		this.name = name;
		this.slug = slug;
		this.description = description;
		this.price = price;
		this.promotionalPrice = promotionalPrice;
		this.quantity = quantity;
		this.sold = sold;
		this.isActive = isActive;
		this.isSelling = isSelling;
		this.categoryId = categoryId;
		this.storeId = storeId;
		this.isDeleted = isDeleted;
		this.rating = rating;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.category = category;
		this.store = store;
	}
	
	
	public Product(int _id, String name, String slug, String description, double price, double promotionalPrice,
			int quantity, int sold, boolean isActive, boolean isSelling, int categoryId, int storeId, boolean isDeleted,
			int rating, Date createdAt, Date updatedAt) {
		super();
		this._id = _id;
		this.name = name;
		this.slug = slug;
		this.description = description;
		this.price = price;
		this.promotionalPrice = promotionalPrice;
		this.quantity = quantity;
		this.sold = sold;
		this.isActive = isActive;
		this.isSelling = isSelling;
		this.categoryId = categoryId;
		this.storeId = storeId;
		this.isDeleted = isDeleted;
		this.rating = rating;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}


	public Product() {
		super();
	}


	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getPromotionalPrice() {
		return promotionalPrice;
	}
	public void setPromotionalPrice(double promotionalPrice) {
		this.promotionalPrice = promotionalPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getSold() {
		return sold;
	}
	public void setSold(int sold) {
		this.sold = sold;
	}
	public boolean getisActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public boolean getisSelling() {
		return isSelling;
	}
	public void setSelling(boolean isSelling) {
		this.isSelling = isSelling;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public boolean getisDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
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
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	
	public String getImage()
	{
		try {
			ImageProductService sv = new ImageProductServiceImpl();
			List<ListImagesProduct> imgs = sv.findAllImage(this._id);
			
			return imgs.get(0).getImage();
		}
		catch(Exception e) {
			
		}
		return null;
	}
}
