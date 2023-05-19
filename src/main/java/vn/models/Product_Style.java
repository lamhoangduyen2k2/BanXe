package vn.models;

public class Product_Style {
	private int StyleId;
	private int ProductId;
	private Style style;
	private Product product;
	public Product_Style(int styleId, int productId, Style style, Product product) {
		super();
		StyleId = styleId;
		ProductId = productId;
		this.style = style;
		this.product = product;
	}
	public int getStyleId() {
		return StyleId;
	}
	public void setStyleId(int styleId) {
		StyleId = styleId;
	}
	public int getProductId() {
		return ProductId;
	}
	public void setProductId(int productId) {
		ProductId = productId;
	}
	public Style getStyle() {
		return style;
	}
	public void setStyle(Style style) {
		this.style = style;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
