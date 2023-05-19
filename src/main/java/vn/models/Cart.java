package vn.models;

public class Cart {
	private int _id;
	private int userId;
	private int storetId;
	private int createdAt;
	private int updatedAT;
	private _User _user;
	private Store store;
	
	public Cart(int _id, int userId, int storetId, int createdAt, int updatedAT, _User _user, Store store) {
		super();
		this._id = _id;
		this.userId = userId;
		this.storetId = storetId;
		this.createdAt = createdAt;
		this.updatedAT = updatedAT;
		this._user = _user;
		this.store = store;
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

	public int getStoretId() {
		return storetId;
	}

	public void setStoretId(int storetId) {
		this.storetId = storetId;
	}

	public int getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(int createdAt) {
		this.createdAt = createdAt;
	}

	public int getUpdatedAT() {
		return updatedAT;
	}

	public void setUpdatedAT(int updatedAT) {
		this.updatedAT = updatedAT;
	}

	public _User get_user() {
		return _user;
	}

	public void set_user(_User _user) {
		this._user = _user;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}
	
}
