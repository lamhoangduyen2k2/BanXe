package vn.models;

public class UserFollowStore {
	private int _id;
	private int userId;
	private int storeId;
	private int createdAt;
	private int updatedAt;
	private _User _user;
	private Store store;
	public UserFollowStore(int _id, int userId, int storeId, int createdAt, int updatedAt, _User _user, Store store) {
		super();
		this._id = _id;
		this.userId = userId;
		this.storeId = storeId;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
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
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public int getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(int createdAt) {
		this.createdAt = createdAt;
	}
	public int getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(int updatedAt) {
		this.updatedAt = updatedAt;
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
