package vn.models;

public class ListImagesProduct {
	private int _id;
	private String image;
	private Product product;
	public ListImagesProduct(int _id, String image, Product product) {
		super();
		this._id = _id;
		this.image = image;
		this.product = product;
	}
	
	public ListImagesProduct() {
		super();
	}

	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
