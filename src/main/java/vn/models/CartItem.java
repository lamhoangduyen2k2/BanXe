package vn.models;

import java.sql.Date;

public class CartItem {
	private int _id;
	private int cartId;
	private int productId;
	private int count_SP;
	private Date createdAt;
	private Date updatedAT;
	private Cart cart;
	private Product product;
	
	public CartItem(int _id, int cartId, int productId, int count_SP, Date createdAt, Date updatedAT, Cart cart,
			Product product) {
		super();
		this._id = _id;
		this.cartId = cartId;
		this.productId = productId;
		this.count_SP = count_SP;
		this.createdAt = createdAt;
		this.updatedAT = updatedAT;
		this.cart = cart;
		this.product = product;
	}
	
	

	public CartItem() {
		super();
	}



	public CartItem(int count_SP, Product product) {
		super();
		this.count_SP = count_SP;
		this.product = product;
	}



	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAT() {
		return updatedAT;
	}

	public void setUpdatedAT(Date updatedAT) {
		this.updatedAT = updatedAT;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}
