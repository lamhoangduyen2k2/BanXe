package vn.models;

public class Style_Category {
	private int StyleId;
	private int CategoryId;
	private Style style;
	private Category category;
	
	public Style_Category(int styleId, int categoryId, Style style, Category category) {
		super();
		StyleId = styleId;
		CategoryId = categoryId;
		this.style = style;
		this.category = category;
	}

	public int getStyleId() {
		return StyleId;
	}

	public void setStyleId(int styleId) {
		StyleId = styleId;
	}

	public int getCategoryId() {
		return CategoryId;
	}

	public void setCategoryId(int categoryId) {
		CategoryId = categoryId;
	}

	public Style getStyle() {
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}
