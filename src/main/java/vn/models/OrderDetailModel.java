package vn.models;

public class OrderDetailModel {
	private int _id;
	private int orderId;
	private int productId;
	private int count_SP;
	private String name;
	private int quantity;
	private String image;
	public OrderDetailModel() {
		super();
	}
	public OrderDetailModel(int _id, int orderId, int productId, int count_SP, String name, int quantity,
			String image) {
		super();
		this._id = _id;
		this.orderId = orderId;
		this.productId = productId;
		this.count_SP = count_SP;
		this.name = name;
		this.quantity = quantity;
		this.image = image;
	}
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getCount_SP() {
		return count_SP;
	}
	public void setCount_SP(int count_SP) {
		this.count_SP = count_SP;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
}
