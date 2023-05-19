package vn.models;

import java.sql.Date;

public class Transaction_SP {
	private int _id;
	private int userId;
	private int storeId;
	private boolean isUp;
	private int amount;
	private Date createdAt;
	private Date updatedAT;
	private _User _user;
	private Store store;
	
	public Transaction_SP(int _id, int userId, int storeId, boolean isUp, int amount, Date createdAt, Date updatedAT,
			_User _user, Store store) {
		super();
		this._id = _id;
		this.userId = userId;
		this.storeId = storeId;
		this.isUp = isUp;
		this.amount = amount;
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

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public boolean isUp() {
		return isUp;
	}

	public void setUp(boolean isUp) {
		this.isUp = isUp;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
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
