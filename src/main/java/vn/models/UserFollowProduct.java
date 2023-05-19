package vn.models;

import java.sql.Date;

public class UserFollowProduct {
	private int _id;
	private int userId;
	private int productId;
	private Date createdAt;
	private Date updatedAt;
	private _User _user;
	private Product product;
	
	public UserFollowProduct(int _id, int userId, int productId, Date createdAt, Date updatedAt, _User _user,
			Product product) {
		super();
		this._id = _id;
		this.userId = userId;
		this.productId = productId;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this._user = _user;
		this.product = product;
	}
	
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
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
	public _User get_user() {
		return _user;
	}
	public void set_user(_User _user) {
		this._user = _user;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}

}
